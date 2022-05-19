package com.example.StudentResultManagement.controller;

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
import com.example.StudentResultManagement.model.SemesterModel;
import com.example.StudentResultManagement.model.StudentModel;
import com.example.StudentResultManagement.repository.CourseRepo;


@RestController
@RequestMapping("/course")

public class CourseController {
	@Autowired
	CourseRepo cosrepo;
	
	@GetMapping("/get")
	public List<CourseModel> getAllPost() {
		return	cosrepo.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<CourseModel> createPost(@RequestBody CourseModel post) {
		try {
			
			CourseModel _tutorial = cosrepo
					.save(new CourseModel(post.getSemid(), post.getCoursecode(), post.getCoursename(), post.getCredits(),
							post.getQuizp() , post.getAssignmentp() ,post.getProjectp()));
			
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
