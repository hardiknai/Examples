package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.doc.model.Employee;
import com.org.doc.repository.EmployeeRepository;
import com.org.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee updateEmployee(Long id, Employee newEmployee) {
		Employee oldEmployee = employeeRepository.findOne(id);
		oldEmployee.setName(newEmployee.getName()!= null ? newEmployee.getName() :oldEmployee.getName());
		oldEmployee.setEmail(newEmployee.getEmail()!= null ? newEmployee.getEmail() :oldEmployee.getEmail());
		return employeeRepository.save(oldEmployee);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findOne(id);
				//.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}


	
}