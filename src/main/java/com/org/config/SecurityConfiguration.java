package com.org.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.org.filter.CustomFilter;

@EnableWebSecurity
@EnableAuthorizationServer
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	 private static final String[] AUTH_WHITELIST = {

	            // -- swagger ui
	            "/swagger-resources/**",
	            "/swagger-ui.html",
	            "/v2/api-docs",
	            "/webjars/**"
	    };
	
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService);
	 }
	 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//			.withUser("manager").password("manager").roles("USER")
//			.and().withUser("admin").password("admin").roles("ADMIN")
//			.and().withUser("actuator").password("actuator").roles("ACTUATOR");
//	}	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated()
				.and()
				//.addFilterBefore(CustomFilter(), BasicAuthenticationFilter.class)
				.httpBasic()
				//.formLogin()
				;
		httpSecurity
			.csrf()
			.disable();

		httpSecurity
			.logout()
			.logoutUrl("/logout");
	}

	public CustomFilter CustomFilter() {
		// TODO Auto-generated method stub
		return new CustomFilter();
	}
	
	
}
	