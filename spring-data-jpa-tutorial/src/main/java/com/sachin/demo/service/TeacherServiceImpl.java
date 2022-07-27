package com.sachin.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sachin.demo.entity.Teacher;
import com.sachin.demo.error.NoDataFoundException;
import com.sachin.demo.repository.TeacherRepository;
@Service
public class TeacherServiceImpl implements TeacherService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);
	private TeacherRepository teacherRepository;

	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		LOGGER.info("inside TeacherRepository.getAllTeachers method");
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		LOGGER.info("inside TeacherRepository.getTeacherById method");
		Optional<Teacher> optionalTeacher= teacherRepository.findById(id);
		if (!optionalTeacher.isEmpty()) {
			return optionalTeacher.get();
		} else {
			throw new NoDataFoundException("No such data present");

		}
	}

}
