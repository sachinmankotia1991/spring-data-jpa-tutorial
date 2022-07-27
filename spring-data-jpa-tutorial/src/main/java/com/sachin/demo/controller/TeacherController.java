package com.sachin.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.demo.entity.Teacher;
import com.sachin.demo.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);
	private TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	@GetMapping
	public List<Teacher> getAllTeachers() {
		LOGGER.info("inside TeacherController.getAllTeachers method");
		return teacherService.getAllTeachers();

	}

	@GetMapping("/{id}")
	public Teacher getTeacherById(@PathVariable("id") Long id) {
		LOGGER.info("inside TeacherController.getTeacherById method");
		return teacherService.getTeacherById(id);

	}
}
