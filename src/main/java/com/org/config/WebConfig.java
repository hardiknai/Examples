package com.org.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureContentNegotiation(configurer);
	}
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		
		List<ViewResolver> resolves = new ArrayList<>();
		resolves.add(csvViewResolver());
		resolves.add(excelViewResolver());
		resolves.add(pdfViewResolver());
		
		resolver.setViewResolvers(resolves);
		return resolver;
	}

	private ViewResolver pdfViewResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	private ViewResolver excelViewResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	private ViewResolver csvViewResolver() {
		// TODO Auto-generated method stub
		return null;
	}
}
