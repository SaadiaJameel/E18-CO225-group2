package com.example.StudentResultManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentResultManagement.model.SemesterModel;
import com.example.StudentResultManagement.repository.SemRepo;



@RestController
@RequestMapping("/semester")

public class SemesterController {
	
	@Autowired
	SemRepo postRepository;
	
	@PostMapping("/save")
	public ResponseEntity<SemesterModel> createPost(@RequestBody SemesterModel post) {
		try {
			
			
			SemesterModel _tutorial = postRepository
					.save(new SemesterModel(post.getFieldgroup(),post.getSemnumber(), post.isIscommited()));
				
			
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
