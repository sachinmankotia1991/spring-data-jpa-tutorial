package com.sachin.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.demo.entity.CourseMaterial;
import com.sachin.demo.service.CourseMaterialService;

@RestController
@RequestMapping("/api/v1/coursematerial")
public class CourseMaterialController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseMaterialController.class);
	private CourseMaterialService courseMaterialService;

	public CourseMaterialController(CourseMaterialService courseMaterialService) {
		super();
		this.courseMaterialService = courseMaterialService;
	}

	@PostMapping()
	public void saveCourseMaterial(@RequestBody CourseMaterial courseMaterial) {
		LOGGER.info("inside CourseMaterialService.saveCourseMaterial method");
		courseMaterialService.saveCourseMaterial(courseMaterial);

	}

	@GetMapping
	public List<CourseMaterial> getAllCourseMaterial() {
		LOGGER.info("inside CourseController.getAllCourseMaterial method");
		return courseMaterialService.getAllCourseMaterial();

	}

	@GetMapping("/{id}")
	public CourseMaterial getCourseMaterialById(@PathVariable("id") Long id) {
		LOGGER.info("inside CourseController.getCourseById method");
		return courseMaterialService.getCourseMaterialById(id);

	}
}
