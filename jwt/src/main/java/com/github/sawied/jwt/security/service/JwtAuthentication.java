package com.github.sawied.jwt.security.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicator for JWT request param extract 
 * @author DANAN
 *
 */

@Target(ElementType.PARAMETER)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface JwtAuthentication {

}