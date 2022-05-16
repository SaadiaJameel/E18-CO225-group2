package com.example.StudentResultManagement.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CourseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "semId")
	private int semId;
	
	@Column(name = "coursecode")
	private int coursecode;
	
	@Column(name = "coursename")
	private String coursename;
	
	@Column(name = "credits")
	private int credits;
	
	@Column(name = "quizp")
	private int quizp;
	
	@Column(name = "assignmentp")
	private int assignmentp;
	
	@Column(name = "projectp")
	private int projectp;

	
	
	
	public CourseModel(int semId, int coursecode, String coursename, int credits, int quizp, int assignmentp,
			int projectp) {
		
		this.semId = semId;
		this.coursecode = coursecode;
		this.coursename = coursename;
		this.credits = credits;
		this.quizp = quizp;
		this.assignmentp = assignmentp;
		this.projectp = projectp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSemId() {
		return semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}

	public int getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(int coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getQuizp() {
		return quizp;
	}

	public void setQuizp(int quizp) {
		this.quizp = quizp;
	}

	public int getAssignmentp() {
		return assignmentp;
	}

	public void setAssignmentp(int assignmentp) {
		this.assignmentp = assignmentp;
	}

	public int getProjectp() {
		return projectp;
	}

	public void setProjectp(int projectp) {
		this.projectp = projectp;
	}
	
	
	
	
}
