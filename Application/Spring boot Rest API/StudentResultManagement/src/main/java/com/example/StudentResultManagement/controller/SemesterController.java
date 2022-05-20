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

import com.example.StudentResultManagement.model.SemesterModel;
import com.example.StudentResultManagement.repository.SemRepo;



@RestController
@RequestMapping("/semester")

public class SemesterController {
	
	@Autowired
	SemRepo semRepository;
	
	@GetMapping("/get")
	public List<SemesterModel> getAllPost() {
		return	semRepository.findAll();

	}
	
	@PostMapping("/save")
	public ResponseEntity<SemesterModel> createPost(@RequestBody SemesterModel post) {
		try {
			
			SemesterModel _tutorial = semRepository
					.save(new SemesterModel(post.getFieldgroup(),post.getSemnumber(), post.isIscommited()));
				
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/save/{id}")
	public ResponseEntity<SemesterModel> getPostById(@PathVariable("id") long id) {
		Optional<SemesterModel> post = semRepository.findById(id);
		 
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@GetMapping("/get/{fieldgroup}/{semnumber}")
//	public ResponseEntity<List<SemesterModel>> getbyfieldgroupandsemnumber(@RequestParam int fieldgroup, int semnumber) {
//		try {
//			return new ResponseEntity<List<SemesterModel>>(semRepository.findByFieldgroupAndSemnumber(fieldgroup, semnumber), HttpStatus.OK);
//		}catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
//		}
//	}
//	
	
	@GetMapping("/get/{fieldgroup}")
	public ResponseEntity<List<SemesterModel>> getbyfieldgroup(@RequestParam int fieldgroup) {
		try {
			return new ResponseEntity<List<SemesterModel>>(semRepository.findByFieldgroup(fieldgroup), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}

}