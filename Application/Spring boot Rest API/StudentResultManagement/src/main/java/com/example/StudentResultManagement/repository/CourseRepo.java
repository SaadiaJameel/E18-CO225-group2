package com.example.StudentResultManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentResultManagement.model.CourseModel;

public interface CourseRepo extends JpaRepository<CourseModel, Long> {

}
