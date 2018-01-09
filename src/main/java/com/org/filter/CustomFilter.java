package com.org.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CustomFilter::init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CustomFilter::doFilter Called");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Principal principal = httpRequest.getUserPrincipal();
		System.out.println("principal" + principal);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("CustomFilter::destroy");
	}

}
