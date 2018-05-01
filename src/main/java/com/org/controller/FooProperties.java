//package com.org.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.org.model.MyPojo;
//
//@RestController
//@RequestMapping("properties")
//@ConfigurationProperties("foo")
//public class FooProperties {
//
//	private final List<MyPojo> list = new  ArrayList<>();
//		
//	public List<MyPojo> getList() {
//		return list;
//	}
//	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@GetMapping("/get")
//	public String getPropertiesList() {
//		return "FooProperties [list=" + list + "]";
//	}
//	
//}
