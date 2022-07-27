package com.sachin.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sachin.demo.entity.CourseMaterial;
import com.sachin.demo.error.NoDataFoundException;
import com.sachin.demo.repository.CourseMaterialRepository;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);
	private CourseMaterialRepository courseMaterialRepository;

	public CourseMaterialServiceImpl(CourseMaterialRepository courseMaterialRepository) {
		super();
		this.courseMaterialRepository = courseMaterialRepository;
	}

	@Override
	public List<CourseMaterial> getAllCourseMaterial() {
		LOGGER.info("inside CourseMaterialServiceImpl.getAllCourseMaterial method");
		return courseMaterialRepository.findAll();
	}

	@Override
	public CourseMaterial getCourseMaterialById(Long id) {
		LOGGER.info("inside CourseMaterialServiceImpl.getCourseMaterialById method");
		Optional<CourseMaterial> optionalMaterialCourse = courseMaterialRepository.findById(id);
		if (!optionalMaterialCourse.isEmpty()) {
			return optionalMaterialCourse.get();
		} else {
			throw new NoDataFoundException("No such data present");

		}
	}

	@Override
	public void saveCourseMaterial(CourseMaterial courseMaterial) {
		LOGGER.info("inside CourseMaterialServiceImpl.saveCourseMaterial method");
		courseMaterialRepository.save(courseMaterial);
	}

}
