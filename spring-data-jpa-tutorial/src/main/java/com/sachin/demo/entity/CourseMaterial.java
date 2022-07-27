package com.sachin.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "course_material_details_tb")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@JsonPropertyOrder({"courseMaterialId", "url", "course"})

public class CourseMaterial {
	@Id
	private Long courseMaterialId;

	private String url;

	@OneToOne(mappedBy = "courseMaterial", fetch = FetchType.EAGER)
	@JsonBackReference
	private Course course;
}
