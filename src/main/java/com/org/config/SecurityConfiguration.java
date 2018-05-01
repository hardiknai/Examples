package com.org.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.org.filter.CustomFilter;

@EnableWebSecurity
@Configuration
public class InMemorySecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("manager").password("manager").roles("USER")
			.and().withUser("admin").password("admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests()
				.anyRequest()
				.fullyAuthenticated()
				.and()
				//.addFilterBefore(CustomFilter(), BasicAuthenticationFilter.class)
				.httpBasic();
		
		httpSecurity.csrf().disable();
		
	}

	public CustomFilter CustomFilter() {
		// TODO Auto-generated method stub
		return new CustomFilter();
	}
}
