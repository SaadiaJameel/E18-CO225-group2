package com.example.StudentResultManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentModel {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@Column(name = "username")
		private String username;
		@Column(name = "password")
		private String password;
//		@Column(name = "author")
//		private String author;
//		@Column(name = "published")
//		private boolean published;
		
		public StudentModel() {
			
		}
		
		
		
		public StudentModel(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}



		public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		@Override
		public String toString() {
			return "StudentModel [id=" + id + ", username=" + username + ", password=" + password + "]";
		}



		
}
