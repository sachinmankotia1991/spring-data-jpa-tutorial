package com.sachin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.demo.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
