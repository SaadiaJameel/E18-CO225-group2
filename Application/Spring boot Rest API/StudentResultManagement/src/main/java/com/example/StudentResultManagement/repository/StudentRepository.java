package com.example.StudentResultManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentResultManagement.model.StudentModel;


public interface StudentRepository extends JpaRepository<StudentModel, Long> {

}
