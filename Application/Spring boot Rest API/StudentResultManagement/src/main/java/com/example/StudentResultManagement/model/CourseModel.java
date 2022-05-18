package com.example.StudentResultManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "course")
public class CourseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "semid")
	private long semid;
	
	@Column(name = "coursecode")
	private String coursecode;
	
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
	
	
	public CourseModel() {
		
	}

	public CourseModel(long semid, String coursecode, String coursename, int credits, int quizp, int assignmentp,
			int projectp) {
		super();
		this.semid = semid;
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

	public long getSemId() {
		return semid;
	}

	public void setSemId(long semId) {
		this.semid = semId;
	}

	public String getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(String coursecode) {
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

	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", semId=" + semid + ", coursecode=" + coursecode + ", coursename="
				+ coursename + ", credits=" + credits + ", quizp=" + quizp + ", assignmentp=" + assignmentp
				+ ", projectp=" + projectp + "]";
	}
}