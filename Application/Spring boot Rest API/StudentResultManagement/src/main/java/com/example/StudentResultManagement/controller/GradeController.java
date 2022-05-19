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

import com.example.StudentResultManagement.model.GradesModel;
import com.example.StudentResultManagement.model.SemesterModel;
import com.example.StudentResultManagement.model.StudentModel;
import com.example.StudentResultManagement.repository.GradeRepo;
import com.example.StudentResultManagement.repository.StudentRepository;

@RestController
@RequestMapping("/grade")
public class GradeController {
	

	@Autowired
	GradeRepo postRepository;
	
	@GetMapping("/get")
	public List<GradesModel> getAllPost() {
		return	postRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<GradesModel> getPostbyName(@PathVariable("id") long id) {
		Optional<GradesModel> post = postRepository.findById(id);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/get/bystudent/{studentid}")
	public ResponseEntity<List<GradesModel>> getbystudedd(@RequestParam long studentid) {
		try {
			return new ResponseEntity<List<GradesModel>>(postRepository.findByStudentid(studentid), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<GradesModel> createPost(@RequestBody GradesModel post) {
		try {
			
			GradesModel _tutorial = postRepository
					.save(new GradesModel(post.getStudentid(), post.getFinalgrade(), post.isIsfinalized(), post.getCourseid()));
				
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/put/studentidandcourseid")
	public ResponseEntity<GradesModel> setGradeByStudentidAndCOurseid(@RequestParam long studentid
			, @RequestParam long courseid, @RequestBody GradesModel tutorial) {
		Optional<GradesModel> postData = postRepository.findByStudentidAndCourseid(studentid,courseid);
		if (postData.isPresent()) {
			GradesModel _post = postData.get();
			_post.setIsfinalized(true);
			_post.setFinalgrade(tutorial.getFinalgrade());
			return new ResponseEntity<>(postRepository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}