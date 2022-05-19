

package com.example.StudentResultManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentResultManagement.model.CourseModel;
import com.example.StudentResultManagement.model.SemesterModel;
import com.example.StudentResultManagement.model.StudentModel;
import com.example.StudentResultManagement.repository.StudentRepository;


@RestController
@RequestMapping("/student")
public class StudentController {
	

	@Autowired
	StudentRepository postRepository;
	
	@GetMapping("/get")
	public List<StudentModel> getAllPost() {
		return	postRepository.findAll();
	}
	
	
	@GetMapping("/get/{username}")
	public ResponseEntity<StudentModel> getPostbyName(@PathVariable("username") String username) {
		Optional<StudentModel> post = postRepository.findByUsername(username);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<StudentModel> getPostbyName(@PathVariable("id") long id) {
		Optional<StudentModel> post = postRepository.findById(id);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getfield/{fieldgroup}")
	public ResponseEntity<List<StudentModel>> getbyfieldgroup(@RequestParam int fieldgroup) {
		try {
			return new ResponseEntity<List<StudentModel>>(postRepository.findByFieldgroup(fieldgroup), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
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
	
	@PutMapping("/put/{id}")
	public ResponseEntity<StudentModel> updatestudent(@PathVariable("id") long id, @RequestBody StudentModel tutorial) {
		Optional<StudentModel> postData = postRepository.findById(id);
		if (postData.isPresent()) {
			StudentModel _post = postData.get();
			_post.setBatch(tutorial.getBatch());
			_post.setGpa(tutorial.getGpa());
			return new ResponseEntity<>(postRepository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}