package com.sachin.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.demo.entity.Course;
import com.sachin.demo.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@PostMapping()
	public void saveStudent(@RequestBody Course course) {
		LOGGER.info("inside CourseController.saveStudent method");
		courseService.saveCourse(course);

	}

	@GetMapping
	public List<Course> getAllCourses() {
		LOGGER.info("inside CourseController.getAllCourses method");
		return courseService.getAllCourses();

	}

	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable("id") Long id) {
		LOGGER.info("inside CourseController.getCourseById method");
		return courseService.getCourseById(id);

	}
	
	@GetMapping("sortedbyfield/{field}")
	public List<Course> getAllCoursesSortedByField(@PathVariable("field") String field ) {
		LOGGER.info("inside CourseController.getAllCoursesSortedByField method");
		return courseService.getAllCoursesSortedByField(field);

	}
	
	@GetMapping("pagination/{offset}/{pagesize}")
	public Page<Course> getAllCoursesPagination(@PathVariable int offset,@PathVariable int pagesize ) {
		LOGGER.info("inside CourseController.getAllCoursesPagination method");
		return courseService.getAllCoursesPagination(offset,pagesize);

	}


}
