package com.org.service;

import java.util.List;

import org.springframework.security.access.prepost.PreFilter;

import com.org.model.School;

public interface SchoolService {

	@PreFilter("hasAuthority('USER')")
	public School getSchool(Long id);

	@PreFilter("hasAuthority('USER')")
	public List<School> getSchools();

	public void deleteSchool(Long id);

	public School updateSchool(Long id, School school);
	
	public School createSchool(School school);

}
