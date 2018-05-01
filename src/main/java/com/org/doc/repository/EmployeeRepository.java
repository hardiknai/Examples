package com.org.doc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.doc.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

}
