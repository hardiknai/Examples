package com.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableJpaRepositories
@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication
public class Application {

	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class); 
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		try {
			System.out.print(""+ 10/0);
		}catch(Exception exception) {
			LOGGER.error("" + exception);
		}
	}
}
