package com.sachin.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_details_tb", uniqueConstraints = @UniqueConstraint(name = "emailId_constraint", columnNames = "email_address"))
@JsonPropertyOrder({ "studentId", "firstName", "lastName", "emailId","listCourses","guardian" })

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@Column(name = "email_address")
	@NotNull
	private String emailId;

	private Guardian guardian;
	
	@ManyToMany
	@JoinTable(
			name = "student_course_link",
			joinColumns = @JoinColumn(
					name="student_Id",
					referencedColumnName = "studentId"),
			inverseJoinColumns = @JoinColumn(
					name="course_Id",
					referencedColumnName = "courseId"
					)
			)
	private List<Course> listCourses;
	
}
