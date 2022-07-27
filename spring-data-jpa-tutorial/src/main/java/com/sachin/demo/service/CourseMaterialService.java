package com.sachin.demo.service;

import java.util.List;

import com.sachin.demo.entity.CourseMaterial;

public interface CourseMaterialService {

	List<CourseMaterial> getAllCourseMaterial();

	CourseMaterial getCourseMaterialById(Long id);

	void saveCourseMaterial(CourseMaterial courseMaterial);

}
