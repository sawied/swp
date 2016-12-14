package com.danan.business.smot.web.exception;

import org.springframework.core.convert.converter.Converter;

public interface ServiceErrorConverter<T> extends Converter<ServiceError,T>  {
	
	T convert(ServiceError serviceError);

}
