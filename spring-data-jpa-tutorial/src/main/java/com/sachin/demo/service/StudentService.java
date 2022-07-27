package com.sachin.demo.service;

import java.util.List;

import com.sachin.demo.entity.Student;


public interface StudentService {

	List<Student> getAllStudents();

	Student getAllStudentById(long id);

	void saveStudent(Student student);

	void deleteStudentById(long id);

	List<Student> getStudentByFirstName(String firstName);

	List<Student> getStudentByLastName(String lastName);

	List<Student> getStudentByLastNameQuery(String lastNameLike);

	List<Student> getByLastNameLikeNativeQuery(String lastNameLike);

	Student updateStudent(long id, Student student);

}
