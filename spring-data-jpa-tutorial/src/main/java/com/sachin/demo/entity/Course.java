package com.sachin.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_details_tb")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@JsonPropertyOrder({"courseId", "title", "credit","courseMaterial","teacher"})

public class Course {

	@Id
	private Long courseId;

	private String title;

	private Integer credit;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	// by this default joining column name will be
	// course_material_course_material_id. you can give it more meaningful name
	// using @JoinColumn
	// CascadeType.ALL means all actions happening on parent class will be
	// propagated to child class as well
	// FetchType.LAZY means when you are fetching parent object, it wont return
	// child object. If you need child object, you either need to fetch it or you
	// can use FetchType.EAGER or no type at all.
	// FetchType.EAGER is there by default, means you don't need to specify anything
	@JoinColumn(name = "fk_course_id", referencedColumnName = "courseMaterialId")
	@JsonManagedReference
	private CourseMaterial courseMaterial;

	@ManyToOne(cascade = CascadeType.ALL) // default loading type id EAGER loading
	@JoinColumn(name = "fk_teacher_id", referencedColumnName = "teacherId")
	@JsonManagedReference
	private Teacher teacher;
}
