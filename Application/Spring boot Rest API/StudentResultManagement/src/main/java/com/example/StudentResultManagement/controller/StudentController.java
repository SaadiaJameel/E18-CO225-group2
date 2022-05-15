package com.example.StudentResultManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentResultManagement.model.StudentModel;
import com.example.StudentResultManagement.repository.StudentRepository;


@RestController
@RequestMapping("/api")
public class StudentController {
	

	@Autowired
	StudentRepository postRepository;
	
	@PostMapping("/posts")
	public ResponseEntity<StudentModel> createPost(@RequestBody StudentModel post) {
		try {
			StudentModel _tutorial = postRepository
					.save(new StudentModel(post.getUsername(), post.getPassword()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
