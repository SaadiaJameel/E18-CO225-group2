package com.example.StudentResultManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentResultManagement.model.SemesterModel;


public interface SemRepo extends JpaRepository<SemesterModel, Long>{

}
