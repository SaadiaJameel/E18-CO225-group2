package com.example.StudentResultManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.StudentResultManagement.model.CourseModel;
import com.example.StudentResultManagement.model.GradesModel;
import com.example.StudentResultManagement.model.SemesterModel;
import com.example.StudentResultManagement.model.StudentModel;
import com.example.StudentResultManagement.controller.StudentController;
import com.example.StudentResultManagement.repository.CourseRepo;
import com.example.StudentResultManagement.repository.GradeRepo;
import com.example.StudentResultManagement.repository.StudentRepository;


@RestController
@RequestMapping("/course")

public class CourseController {
	@Autowired
	CourseRepo cosrepo;
	
	@Autowired
	GradeRepo gradeRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/get")
	public List<CourseModel> getAllPost() {
		return	cosrepo.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<CourseModel> createPost(@RequestBody CourseModel post) {
		try {
			
			CourseModel _tutorial = cosrepo
					.save(new CourseModel(post.getSemid(), post.getCoursecode(), post.getCoursename(),post.getCredits(), 
							post.getQuizp() , post.getAssignmentp() , post.getProjectp() , post.getFieldgroup()));	
			
			List<StudentModel> std1 = studentRepository.findByFieldgroup(post.getFieldgroup());
			
//			(long studentid, String finalgrade, boolean isfinalized, long courseid)
			
			for(int i=0;i<std1.size();i++) {
				
				GradesModel _tutorial1 = gradeRepository
						.save(new GradesModel(std1.get(i).getId(), null, false, _tutorial.getId(),_tutorial.getCoursename(),
								_tutorial.getCredits(),_tutorial.getCoursecode()));
				
			}
			
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	public int addGrades(int feildgroup) {
//		
//		grademodel.setStudentid(1);
//		grademodel.setIsfinalized(true);
//		grademodel.setFinalgrade(null);
//		
//		gradecontroller.createPost2(grademodel);
//		
//		return 0;
//	}
	
	
	
	@GetMapping("/get/getSem/{semid}")
	public ResponseEntity<List<CourseModel>> getsemid(@RequestParam long semid) {
		try {
			return new ResponseEntity<List<CourseModel>>(cosrepo.findBySemid(semid), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	

	@GetMapping("/get/{id}")
	public ResponseEntity<CourseModel> getbyid(@PathVariable("id") long id) {
		Optional<CourseModel> post = cosrepo.findById(id);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
