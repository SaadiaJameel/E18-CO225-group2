package com.example.StudentResultManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "semester")
public class SemesterModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "fieldgroup")
	private int fieldgroup;
	
	@Column(name = "semnumber")
	private int semnumber;
	
	@Column(name = "iscommited")
	private boolean iscommited;
	
	
	public SemesterModel() {
		
	}


	public SemesterModel(int fieldgroup, int semnumber, boolean iscommited) {
		
		this.fieldgroup = fieldgroup;
		this.semnumber = semnumber;
		this.iscommited = iscommited;
	}



	public boolean isIscommited() {
		return iscommited;
	}

	public void setIscommited(boolean iscommited) {
		this.iscommited = iscommited;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFieldgroup() {
		return fieldgroup;
	}

	public void setFieldgroup(int fieldgroup) {
		this.fieldgroup = fieldgroup;
	}

	public int getSemnumber() {
		return semnumber;
	}

	public void setSemnumber(int semnumber) {
		this.semnumber = semnumber;
	}

	@Override
	public String toString() {
		return "SemesterModel [id=" + id + ", fieldgroup=" + fieldgroup + ", semnumber=" + semnumber + ", iscommited="
				+ iscommited + "]";
	}
	
}