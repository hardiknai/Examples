package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.School;
import com.org.repository.SchoolRepository;
import com.org.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public void deleteSchool(Long id) {
		schoolRepository.delete(id);
	}

	@Override
	public School updateSchool(Long id, School newSchool) {
		School oldSchool = schoolRepository.findOne(id);
		oldSchool.setName(newSchool.getName());
		return schoolRepository.save(oldSchool);
	}

	@Override
	public School createSchool(School school) {
		return schoolRepository.save(school);
	}

	@Override
	public School getSchool(Long id) {
		return schoolRepository.findOne(id);
				//.orElseThrow(() -> new ResourceNotFoundException("School", "id", id));
	}

	@Override
	public List<School> getSchools() {
		return schoolRepository.findAll();
	}


	
}