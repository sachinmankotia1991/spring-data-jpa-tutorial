package com.sachin.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher_details_tb")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@JsonPropertyOrder({"teacherId", "teacherFirstName", "teacherLastName","listCourse"})
public class Teacher {
	@Id
	private Long teacherId;

	private String teacherFirstName;

	private String teacherLastName;

	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Course> listCourse;

}
