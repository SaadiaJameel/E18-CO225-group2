package com.example.StudentResultManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentResultManagement.model.CourseModel;
import com.example.StudentResultManagement.model.GradesModel;
import com.example.StudentResultManagement.model.SemesterModel;

@Repository
public interface GradeRepo extends JpaRepository<GradesModel, Long> {
	
	List<GradesModel> findByStudentid(long studentid);
	
	Optional<GradesModel> findByStudentidAndCourseid(long studentid, long courseid);
}	