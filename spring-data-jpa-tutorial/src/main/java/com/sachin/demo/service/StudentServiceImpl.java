package com.sachin.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sachin.demo.controller.StudentController;
import com.sachin.demo.entity.Guardian;
import com.sachin.demo.entity.Student;
import com.sachin.demo.error.NoDataFoundException;
import com.sachin.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		LOGGER.info("inside StudentServiceImpl.getAllStudents method");
		return studentRepository.findAll();

	}

	@Override
	public Student getAllStudentById(long id) {
		LOGGER.info("inside StudentServiceImpl.getAllStudents method");
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (!optionalStudent.isEmpty()) {
			return optionalStudent.get();
		} else {
			throw new NoDataFoundException("No such data present");

		}
	}

	@Override
	public void saveStudent(Student student) {
		LOGGER.info("inside StudentServiceImpl.saveStudent method");
		studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		LOGGER.info("inside StudentServiceImpl.deleteStudentById method");
		studentRepository.deleteById(id);
	}

	// Below is the example for getBy<fieldname> method. Spring data JPA provides
	// implementation of this method. you only need to define this in your
	// repository
	// interface
	@Override
	public List<Student> getStudentByFirstName(String firstName) {
		LOGGER.info("inside StudentServiceImpl.getStudentByFirstName method");
		return studentRepository.getByFirstName(firstName);
	}

	// Below 2 methods are for @Query

	@Override
	public List<Student> getStudentByLastName(String lastName) {
		LOGGER.info("inside StudentServiceImpl.getStudentByLastName method");
		return studentRepository.getStudentByLastName(lastName);
	}

	@Override
	public List<Student> getStudentByLastNameQuery(String lastNameLike) {
		LOGGER.info("inside StudentServiceImpl.getStudentByLastNameQuery method");
		return studentRepository.getStudentByLastNameQuery(lastNameLike);
	}

	// Below method is example for Native SQL query
	@Override
	public List<Student> getByLastNameLikeNativeQuery(String lastNameLike) {
		LOGGER.info("inside StudentServiceImpl.getByLastNameLikeNativeQuery method");
		return studentRepository.getByLastNameLikeNativeQuery(lastNameLike);
	}

	@Override
	public Student updateStudent(long id, Student student) {
		LOGGER.info("inside StudentServiceImpl.updateStudent method");
		Student currentStudentData = null;
		Optional<Student> currentStudentDataOptional = studentRepository.findById(id);
		if (!currentStudentDataOptional.isEmpty()) {
			currentStudentData = currentStudentDataOptional.get();
			currentStudentData.setEmailId(student.getEmailId());
			currentStudentData.setFirstName(student.getFirstName());
			currentStudentData.setLastName(student.getLastName());
			Guardian guardian = currentStudentData.getGuardian();
			guardian.setGuardianEmail(student.getGuardian().getGuardianEmail());
			guardian.setGuardianMobile(student.getGuardian().getGuardianMobile());
			guardian.setGuardianName(student.getGuardian().getGuardianName());
			currentStudentData.setGuardian(guardian);
			studentRepository.save(currentStudentData);
		} else {
			throw new NoDataFoundException("No such data present");
		}
		return currentStudentData;

	}

}
