package com.sachin.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.demo.entity.Student;
import com.sachin.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping()
	public void saveStudent(@RequestBody @Valid Student student) {
		LOGGER.info("inside StudentController.saveStudent method");
		studentService.saveStudent(student);

	}

	@GetMapping("/")
	public List<Student> getAllStudents() {
		LOGGER.info("inside StudentController.getAllStudents method");
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getStudenyById(@PathVariable("id") long id) {
		LOGGER.info("inside StudentController.getStudenyById method");
		return studentService.getAllStudentById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteStudentbyId(@PathVariable("id") long id) {
		LOGGER.info("inside StudentController.deleteStudentById method");
		studentService.deleteStudentById(id);
	}

	@GetMapping("getByFirstName/{firstName}")
	public List<Student> getStudentByFirstName(@PathVariable("firstName") String firstName) {
		LOGGER.info("inside StudentController.getStudentByFirstName method");
		return studentService.getStudentByFirstName(firstName);
	}

	// Below 2 methods are for @Query
	@GetMapping("getByLastName/{lastName}")
	public List<Student> getStudentByLastName(@PathVariable("lastName") String lastName) {
		LOGGER.info("inside StudentController.getStudentByLastName method");
		return studentService.getStudentByLastName(lastName);
	}

	@GetMapping("getStudentByLastNameQuery/{lastNameLike}")
	public List<Student> getStudentByLastNameQuery(@PathVariable("lastNameLike") String lastNameLike) {
		LOGGER.info("inside StudentController.getStudentByLastNameQuery method");
		return studentService.getStudentByLastNameQuery(lastNameLike);
	}

	// Below method is example for Native SQL query
	@GetMapping("getByLastNameLikeNativeQuery/{lastNameLike}")
	public List<Student> getByLastNameLikeNativeQuery(@PathVariable("lastNameLike") String lastNameLike) {
		LOGGER.info("inside StudentController.getByLastNameLikeNativeQuery method");
		return studentService.getByLastNameLikeNativeQuery(lastNameLike);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		LOGGER.info("inside StudentController.updateStudent method");
		return studentService.updateStudent(id,student);

		
	}
}
