package com.github.sawied.persistent;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public abstract class AbstractSearchableJpaRepository<T,ID extends Serializable> implements JpaRepository<T, ID>, JpaSpecificationExecutor<T>
, SearchableRepository<T>{

	protected final Class<T> domainClass;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected AbstractSearchableJpaRepository() {
		 Type genericSuperclass = this.getClass().getGenericSuperclass();
	        while(!(genericSuperclass instanceof ParameterizedType))
	        {
	            if(!(genericSuperclass instanceof Class))
	                throw new IllegalStateException("Unable to determine type " +
	                        "arguments because generic superclass neither " +
	                        "parameterized type nor class.");
	            if(genericSuperclass == AbstractSearchableJpaRepository.class)
	                throw new IllegalStateException("Unable to determine type " +
	                        "arguments because no parameterized generic superclass " +
	                        "found.");
	            genericSuperclass = ((Class)genericSuperclass).getGenericSuperclass();
	        }

	        ParameterizedType type = (ParameterizedType)genericSuperclass;
	        Type[] arguments = type.getActualTypeArguments();
	        this.domainClass = (Class<T>)arguments[0];
	}



	public Page<T> search(SearchCriteria searchCriteria, Pageable pageable){
		return null;
	}
	
}
