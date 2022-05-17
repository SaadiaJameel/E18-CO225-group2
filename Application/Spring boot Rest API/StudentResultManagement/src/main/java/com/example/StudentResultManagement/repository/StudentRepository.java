package com.example.StudentResultManagement.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentResultManagement.model.StudentModel;


public interface StudentRepository extends JpaRepository<StudentModel, Long> {

	Optional<StudentModel> findByUsername(String username);

}
