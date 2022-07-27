package com.sachin.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sachin.demo.entity.Course;

public interface CourseService {

	void saveCourse( Course course);

	List<Course> getAllCourses();

	Course getCourseById(Long id);

	List<Course> getAllCoursesSortedByField(String field);

	Page<Course> getAllCoursesPagination(int offset, int pagesize);

}
