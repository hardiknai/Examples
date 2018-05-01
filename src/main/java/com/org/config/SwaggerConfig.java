package com.org.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Profile("dev")
public class SwaggerConfig {

	//@Value("${sld.security.oauth.clientid}")
	private String clientId;

	//@Value("${sld.security.oauth.secret}")
	private String clientSecret;
	
	
	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.org.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo())
//				.securitySchemes(Arrays.asList(securitySchemes()))
//				.securityContexts(Arrays.asList(securityContexts()))
				;
	}
/*
	private SecurityContext securityContexts() {
		return SecurityContext
				.builder()
				.securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
				.forPaths(PathSelectors.regex("/api/*"))
				.build();
	}

	private SecurityScheme securitySchemes() {
		GrantType grantType = new AuthorizationCodeGrantBuilder()
				.tokenEndpoint(new  TokenEndpoint("http://10.10.10.124:8085/oauth", "/token"))
				.tokenRequestEndpoint(new TokenRequestEndpoint("http://10.10.10.124:8085/oauth", clientId, clientSecret))
				.build();
		
		SecurityScheme oauth = new OAuthBuilder()
				.name("first_token")
				.grantTypes(Arrays.asList(grantType))
				.scopes(Arrays.asList(scopes()))
				.build();
				
		return oauth;
	}

	private AuthorizationScope[] scopes() {
		AuthorizationScope[] scopes = {
				new AuthorizationScope("read","for read operation"),
				new AuthorizationScope("write","for write operation")
		};
		return scopes;
	}
*/
	@Bean
	ApiInfo metaInfo() {
	        return new ApiInfo(
	                "Spring Boot REST API",
	                "Spring Boot REST API for Online Store",
	                "1.0",
	                "Terms of service",
	                new Contact("Hardik Nai", "https://springframework.guru/about/", "hardik.nai92@gmail.com"),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
		
	}
}
