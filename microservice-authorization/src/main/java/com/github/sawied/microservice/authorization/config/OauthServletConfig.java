package com.github.sawied.microservice.authorization.config;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import freemarker.template.TemplateExceptionHandler;

@Configuration
@EnableWebMvc
@ImportResource({ "classpath:github/sawied/microservice/authorization/security-context.xml",
"classpath:github/sawied/microservice/authorization/security-oauth-authorization.xml" })
@ComponentScan(basePackages= {"com.github.sawied.microservice.authorization.controller"})
public class OauthServletConfig extends WebMvcConfigurerAdapter{

	
	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
		contentNegotiationManager.addMediaType("html", MediaType.TEXT_HTML);
		
		
		MappingJackson2JsonView jsonview = new MappingJackson2JsonView();
		jsonview.setExtractValueFromSingleKeyModel(true);
		
		FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver("",".ftl");
		freeMarkerViewResolver.setExposeRequestAttributes(true);
		freeMarkerViewResolver.setExposeSessionAttributes(true);
		freeMarkerViewResolver.setRequestContextAttribute("request");
		
		
		ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
		contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
		contentViewResolver.setViewResolvers(Arrays.<ViewResolver> asList(freeMarkerViewResolver));
		contentViewResolver.setDefaultViews(Arrays.<View> asList(jsonview));
		return contentViewResolver;
	}
	
	

	


	/**
	 * the full configuration of freemarker see here 
	 * <a href="https://freemarker.apache.org/docs/api/freemarker/template/Configuration.html#setSetting-java.lang.String-java.lang.String-">freemaker settings</a>
	 * @return
	 */
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigure(){
		FreeMarkerConfigurer freeMarkerConfigure = new FreeMarkerConfigurer();
		freeMarkerConfigure.setTemplateLoaderPath("/WEB-INF/templates/");
		Properties p = new Properties();
		p.setProperty("template_exception_handler", "html_debug");
		freeMarkerConfigure.setFreemarkerSettings(p);
		return freeMarkerConfigure;
	}
	


}
