package com.danan.business.smot.web.exception;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

public class DefaultExceptionErrorResolver implements ExceptionErrorResolver,InitializingBean {
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionErrorResolver.class);
	
	 public static final String DEFAULT_EXCEPTION_MESSAGE_VALUE = "unknow";
	 
	 public static final String DEFAULT_EXCEPTION_CODE ="550";
	 
	 public static final String DEFAULT_MESSAGE_VALUE = "unknow";
	
	private Map<String,ServiceError> exceptionMappings =  Collections.emptyMap();
	
	private Map<String, String> exceptionMappingDefinitions = Collections.emptyMap();

	@Override
	public ServiceError resolveError(ServletWebRequest request, Object handler, Exception ex) {
		
		ServiceError serviceError = getServiceErrorByMapping(ex);
		//clone the service Error
		ServiceError.Builder builder= new ServiceError.Builder();
		builder.setStatus(serviceError.getStatus());
		builder.setCode(serviceError.getCode());
		builder.setMessage(serviceError.getMessage());
		builder.setDeveloperMessage(ex.getMessage());
		builder.setMoreInfoUrl(null);
		builder.setThrowable(ex);
		return builder.build();
	}
	


	/**
	 * get Service Error by exception type from mapping
	 * if the passed exception can be found in mapping ,then return the service Error,
	 * else find the supper class of exception of mapping until throwable.
	 * @param ex
	 * @return
	 */
	private ServiceError getServiceErrorByMapping(Exception ex) {
		if(CollectionUtils.isEmpty(this.exceptionMappings)){
			return null;
		}
		String dominantMapping = null;
		ServiceError serviceError =null;
		 int deepest = Integer.MAX_VALUE;
	        for (Map.Entry<String, ServiceError> entry : this.exceptionMappings.entrySet()) {
	            String key = entry.getKey();
	            int depth = getDepth(key, ex);
	            if (depth >= 0 && depth < deepest) {
	                deepest = depth;
	                dominantMapping = key;
	                serviceError = entry.getValue();
	            }
	        }
	        if (serviceError != null ) {
	        	LOG.debug("Resolving to ServiceError  '" + serviceError + "' for exception of type [" + ex.getClass().getName() +
	                    "], based on exception mapping [" + dominantMapping + "]");
	        }
	        return serviceError;
	}
	

    /**
     * Return the depth to the superclass matching.
     * <p>0 means ex matches exactly. Returns -1 if there's no match.
     * Otherwise, returns depth. Lowest depth wins.
     */
    protected int getDepth(String exceptionMapping, Exception ex) {
        return getDepth(exceptionMapping, ex.getClass(), 0);
    }

    private int getDepth(String exceptionMapping, Class<?> exceptionClass, int depth) {
        if (exceptionClass.getName().contains(exceptionMapping)) {
            // Found it!
            return depth;
        }
        // If we've gone as far as we can go and haven't found it...
        if (exceptionClass.equals(Throwable.class)) {
            return -1;
        }
        return getDepth(exceptionMapping, exceptionClass.getSuperclass(), depth + 1);
    }


	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, String> definitions = createDefaultExceptionMappingDefinitions();
		
		  //add in user-specified mappings (will override defaults as necessary):
        if (this.exceptionMappingDefinitions != null && !this.exceptionMappingDefinitions.isEmpty()) {
            definitions.putAll(this.exceptionMappingDefinitions);
        }
        
       this.exceptionMappings = toServiceErrors(definitions);
		
	}
	
	
	protected final Map<String,String> createDefaultExceptionMappingDefinitions() {

        Map<String,String> m = new LinkedHashMap<String, String>();

        // 400
        applyDef(m, HttpMessageNotReadableException.class, HttpStatus.BAD_REQUEST);
        applyDef(m, MissingServletRequestParameterException.class, HttpStatus.BAD_REQUEST);
        applyDef(m, TypeMismatchException.class, HttpStatus.BAD_REQUEST);
        applyDef(m, "javax.validation.ValidationException", HttpStatus.BAD_REQUEST);

        // 404
        applyDef(m, NoSuchRequestHandlingMethodException.class, HttpStatus.NOT_FOUND);
        applyDef(m, "org.hibernate.ObjectNotFoundException", HttpStatus.NOT_FOUND);

        // 405
        applyDef(m, HttpRequestMethodNotSupportedException.class, HttpStatus.METHOD_NOT_ALLOWED);

        // 406
        applyDef(m, HttpMediaTypeNotAcceptableException.class, HttpStatus.NOT_ACCEPTABLE);

        // 409
        //can't use the class directly here as it may not be an available dependency:
        applyDef(m, "org.springframework.dao.DataIntegrityViolationException", HttpStatus.CONFLICT);

        // 415
        applyDef(m, HttpMediaTypeNotSupportedException.class, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

        return m;
    }
	
	private void applyDef(Map<String, String> m, Class<?> clazz, HttpStatus status) {
		applyDef(m, clazz.getName(), status);
	}

	private void applyDef(Map<String, String> m, String key, HttpStatus status) {
		m.put(key, status.value() + ","+DEFAULT_EXCEPTION_CODE+"," + DEFAULT_EXCEPTION_MESSAGE_VALUE);
	}
	
	
	private Map<String,ServiceError> toServiceErrors(Map<String,String> mapping){
		if(CollectionUtils.isEmpty(mapping)){
			return Collections.emptyMap();
		}
		
		 Map<String, ServiceError> map = new LinkedHashMap<String, ServiceError>(mapping.size());
		 
		 for(Map.Entry<String,String> entry : mapping.entrySet()){
			 String key = entry.getKey();
			 String value = entry.getValue();
			 map.put(key, toServiceError(value));
		 }
		
		return map;
		
	}

	/**
	 * make sure the exception config following the specification below:
	 * the parameters order by status,code,message,
	 * if the parameters contains ",",please wrap with '"',that following CSV standard
	 * devMessage,moreInfoUrl will be fill with exception information
	 * @param exceptionConfig
	 * @return
	 */
	private ServiceError toServiceError(String exceptionConfig) {
		 String[] values = StringUtils.commaDelimitedListToStringArray(exceptionConfig);
	        if (values == null || values.length != 3) {
	            throw new IllegalStateException("Invalid config mapping.  Exception names must map to a string configuration.");
	        }
	        
	        ServiceError.Builder builder =new ServiceError.Builder();
	        
	        builder.setStatus(getHttpStatus(values[0].trim()));
	        builder.setCode(Integer.parseInt(values[1].trim()));
	        builder.setMessage(values[2]);
		return builder.build();
	}

	/**
	 * get Http Status
	 * @param string
	 * @return
	 */
	private HttpStatus getHttpStatus(String code) {
		int status =Integer.parseInt(code);
		return HttpStatus.valueOf(status);
	}



	public void setExceptionMappingDefinitions(
		Map<String, String> exceptionMappingDefinitions) {
	    this.exceptionMappingDefinitions = exceptionMappingDefinitions;
	}



	
	
	
	
}
