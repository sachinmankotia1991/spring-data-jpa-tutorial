package com.sachin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
