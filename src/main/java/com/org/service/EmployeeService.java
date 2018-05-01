package com.org.service;

import java.util.List;

import org.springframework.security.access.prepost.PreFilter;

import com.org.doc.model.Employee;


public interface EmployeeService {

	public Employee getEmployee(Long id);

	public List<Employee> getEmployees();

	public void deleteEmployee(Long id);

	public Employee updateEmployee(Long id, Employee Employee);
	
	public Employee createEmployee(Employee Employee);
}
