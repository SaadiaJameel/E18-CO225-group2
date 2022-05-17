package com.example.StudentResultManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentResultManagement.model.CourseModel;
import com.example.StudentResultManagement.repository.CourseRepo;


@RestController
@RequestMapping("/course")

public class CourseContoller {
	@Autowired
	CourseRepo postRepository;
	
	@PostMapping("/save")
	public ResponseEntity<CourseModel> createPost(@RequestBody CourseModel post) {
		try {
			
			
			CourseModel _tutorial = postRepository
					.save(new CourseModel(post.getSemId(), post.getCoursecode(), post.getCoursename(), post.getCredits(),
							post.getQuizp() , post.getAssignmentp() ,post.getProjectp()));
							
			
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
