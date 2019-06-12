package com.coll.config;

import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.Registration;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	protected void customizeRegistration(ServletRegistration.Dynamic registration)
	{
		System.out.println("Customize Registration");
		registration.setInitParameter("dispatchOptionsRrequest","true");
		registration.setAsyncSupported(true);
	}
	protected Filter[] getServletFilters()
	{
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding(StandardCharsets.UTF_8.name());
		return new Filter[] {encodingFilter};
	}
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("--Root Config--");
		return new Class[] {WebResolver.class,DBConfig.class};
	}


	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("--Servlet Config--");
		return null;
	}


	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("--Servlet Mappings--");
		return new String[] {"/"};
	}

}
