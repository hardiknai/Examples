//package com.org.controller;
//
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/property")
//@TestPropertySource("classpath:config/test.properties")
//public class PropertyController {
//
//	@Autowired
//	private ServletConfig servletConfig;
//	
//	@Autowired
//	private ServletContext servletContext; 
//	
//	@Value("${name}")
//	private String name;
//	
//	@Value("${address}")
//	private String address;
//	
//	@Value("${company}")
//	private String company;
//	
//	@Value("${random.value}")
//	private String mySecret;
//	
//	@Value("${random.int}")
//	private String myNumber;
//	
//	@Value("${my.bignumber}")
//	private String myBigNumber;
//	
//	@Value("${my.uuid}")
//	private String myUuid;
//	
//	@Value("${my.number.less.than.ten}")
//	private String myNumberLessThanTen;
//	
//	@Value("${my.number.in.range}}")
//	private String mynumberinrange;
//	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@GetMapping("/get")
//	public String getProperty() {
//	
//		return "servletContext.getContextPath: " + servletContext.getContextPath() 
//		+ "\nservletConfig.getServletName: " + servletConfig.getServletName() 
//		+ "\nName: " + name 
//		+ "\nAddress: "+  address 
//		+ "\nCompany: " + company
//		+ "\nmySecret: " + mySecret
//		+ "\nmyNumber: " + myNumber
//		+ "\nmyBigNumber: " + myBigNumber
//		+ "\nmyUuid: " + myUuid
//		+ "\nmyNumberLessThanTen: " + myNumberLessThanTen 
//		+ "\nmynumberinrange: " + mynumberinrange;
//	}
//	
//	
//}
