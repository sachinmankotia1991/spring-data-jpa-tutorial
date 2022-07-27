package com.sachin.demo.service;

import java.util.List;

import com.sachin.demo.entity.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeachers();

	Teacher getTeacherById(Long id);

}
