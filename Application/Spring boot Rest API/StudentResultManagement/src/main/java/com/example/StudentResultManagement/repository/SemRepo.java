package com.example.StudentResultManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.StudentResultManagement.model.SemesterModel;

@Repository
public interface SemRepo extends JpaRepository<SemesterModel, Long> {
	
	List<SemesterModel> findByIscommited(boolean iscommited);
	
	List<SemesterModel> findByFieldgroup(int fieldgroup);
	
	List<SemesterModel> findByFieldgroupAndSemnumber(int fieldgroup, int semnumber);
	
}
