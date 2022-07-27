package com.sachin.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sachin.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> getByFirstName(String firstName);

	// Below 2 methods are for @Query means JPQL
	@Query("select s from Student s where s.lastName = ?1")
	List<Student> getStudentByLastName(String lastName);

	@Query("select s from Student s where s.lastName like ?1%")
	List<Student> getStudentByLastNameQuery(String lastNameLike);
	
	// Below method is example for Native SQL query
	@Query(value = "select * from student_details_tb s where s.last_name like ?1%", nativeQuery = true)
	List<Student> getByLastNameLikeNativeQuery(String lastNameLike);

}
