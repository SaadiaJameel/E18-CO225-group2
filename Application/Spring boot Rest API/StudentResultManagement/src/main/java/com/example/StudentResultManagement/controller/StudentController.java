

package com.example.StudentResultManagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentResultManagement.model.StudentModel;
import com.example.StudentResultManagement.repository.StudentRepository;


@RestController
@RequestMapping("/student")
public class StudentController {
	

	@Autowired
	StudentRepository postRepository;
	
	
	@GetMapping("/get/{username}")
	public ResponseEntity<StudentModel> getPostbyName(@PathVariable("username") String username) {
		Optional<StudentModel> post = postRepository.findByUsername(username);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
		
	@PostMapping("/save")
	public ResponseEntity<StudentModel> createPost(@RequestBody StudentModel post) {
		try {
			
			if(post.getFaculty()=="Eng"&&post.getField()=="com"&&post.getUni()=="UOP"&&post.getBatch()=="E18") {
				post.setFieldgroup(0);
				post.setBatchgroup(0);
			}
			
			StudentModel _tutorial = postRepository
					.save(new StudentModel(post.getUsername(), post.getPassword(), post.getEmail(), post.getBatchgroup(), post.getFieldgroup(), 
							post.isRep(), post.getUni(), post.getBatch(), post.getFaculty(), post.getField()));
				
			
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}