package com.sachin.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sachin.demo.entity.Course;
import com.sachin.demo.error.NoDataFoundException;
import com.sachin.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);
	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void saveCourse(Course course) {
		LOGGER.info("inside CourseServiceImpl.saveCourse method");
		courseRepository.save(course);

	}

	@Override
	public List<Course> getAllCourses() {
		LOGGER.info("inside CourseServiceImpl.getAllCourses method");
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		LOGGER.info("inside CourseServiceImpl.getCourseById method");
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if (!optionalCourse.isEmpty()) {
			return optionalCourse.get();
		} else {
			throw new NoDataFoundException("No such data present");

		}
	}

	@Override
	public List<Course> getAllCoursesSortedByField(String field) {
		LOGGER.info("inside CourseServiceImpl.getAllCoursesSortedByField method");
		return courseRepository.findAll(Sort.by(Sort.Direction.DESC, field));
	}

	@Override
	public Page<Course> getAllCoursesPagination(int offset, int pagesize) {
		LOGGER.info("inside CourseServiceImpl.getAllCoursesPagination method");
		 Page<Course> pageCourse= courseRepository.findAll(PageRequest.of(offset, pagesize));
		return pageCourse;
	}

}
