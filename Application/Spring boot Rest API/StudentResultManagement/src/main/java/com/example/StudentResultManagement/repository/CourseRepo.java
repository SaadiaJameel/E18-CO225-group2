//package com.example.StudentResultManagement.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.StudentResultManagement.model.CourseModel;
//
//public interface CourseRepo extends JpaRepository<CourseModel, Long> {
//	
////	List<CourseModel> findBySemid(long semid);
//
//}

package com.example.StudentResultManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentResultManagement.model.CourseModel;
import com.example.StudentResultManagement.model.SemesterModel;

@Repository
public interface CourseRepo extends JpaRepository<CourseModel, Long> {
	
	List<CourseModel> findBySemid(long semid);
	
}

