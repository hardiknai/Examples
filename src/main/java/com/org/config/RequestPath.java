package com.org.config;

public interface RequestPath {


	String HELLO = "/hello";
	String DETAIL = "/detail";
	String PERSON = "/person";
	String BOOK = "/book";
	String AUTHOR = "/author";
	String GRAPH = "graph";
	String SEARCH = "/search";
	String UPLOAD = "/upload";
	String USER = "/user";
	String EMPLOYEE = "/employee";
	
	interface User{
		String CURRENT = USER + "/current";
	}
	interface Upload{
		String GET = UPLOAD + "/get";
	}
		
	interface Search{
		String NAME = SEARCH + "/name/{text}";
		String SALARY = SEARCH + "/salary/{salary}";
		String All = SEARCH + "/all" ;
	}
	interface Person{
		String GET = PERSON + "/get";
	}
	interface Author{
		String BY_ID = AUTHOR + "/{id}";
	}
	interface Book{
		String BY_ID = BOOK + "/{id}";
	}
	interface Employee{
		String BY_ID = EMPLOYEE + "/{id}";
	}
	interface Graph{
		String DEAL_STATUS = GRAPH + "/v1/deal-status";
	}
}
