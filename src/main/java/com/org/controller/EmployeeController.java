package com.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.RequestPath;
import com.org.doc.model.Employee;
import com.org.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(RequestPath.EMPLOYEE)
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping(RequestPath.Employee.BY_ID)
	public Employee getEmployee(@PathVariable Long id){
		return employeeService.getEmployee(id);
	}
	

	@DeleteMapping(RequestPath.Employee.BY_ID)
	public void deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
	}	
	
	@PutMapping(RequestPath.Employee.BY_ID)
	public Employee updateEmployee(@PathVariable(name="id")  Long id,@Valid @RequestBody Employee employee){
		return employeeService.updateEmployee(id, employee);
	}

	@PostMapping(RequestPath.EMPLOYEE)
	public Employee createEmployee(@Valid @RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}

}
