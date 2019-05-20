package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{


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
