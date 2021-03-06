package com.example.StudentResultManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.StudentResultManagement.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	
	Optional<StudentModel> findByUsername(String username);
	List<StudentModel> findByFieldgroup(int fieldgroup);
	List<StudentModel> findByFieldgroupOrderByGpaDesc(int fieldgroup);
	List<StudentModel> findByBatchgroupOrderByGpaDesc(int batchgroup);
}

