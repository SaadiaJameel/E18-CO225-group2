package com.example.StudentResultManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class GradesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "studentid")
	private long studentid;
	
	@Column(name = "finalgrade")
	private String finalgrade;
	
	@Column(name = "isfinalized")
	private boolean isfinalized;
	
	@Column(name = "courseid")
	private long courseid;
	

	public GradesModel() {
	}


	public GradesModel(long studentid, String finalgrade, boolean isfinalized, long courseid) {
		
		this.studentid = studentid;
		this.finalgrade = finalgrade;
		this.isfinalized = isfinalized;
		this.courseid = courseid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getFinalgrade() {
		return finalgrade;
	}

	public void setFinalgrade(String finalgrade) {
		this.finalgrade = finalgrade;
	}

	public boolean isIsfinalized() {
		return isfinalized;
	}

	public void setIsfinalized(boolean isfinalized) {
		this.isfinalized = isfinalized;
	}
	
	public long getCourseid() {
		return courseid;
	}


	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}


	@Override
	public String toString() {
		return "GradesModel [id=" + id + ", studentid=" + studentid + ", finalgrade=" + finalgrade + ", isfinalized="
				+ isfinalized + ", courseid=" + courseid + "]";
	}

}