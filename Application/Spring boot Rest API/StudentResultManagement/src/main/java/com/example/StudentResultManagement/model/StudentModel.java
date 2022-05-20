//package com.example.StudentResultManagement.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "student")
//public class StudentModel {
//		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
//		private long id;
//		@Column(name = "username")
//		private String username;
//		@Column(name = "password")
//		private String password;
////		@Column(name = "author")
////		private String author;
////		@Column(name = "published")
////		private boolean published;
//		
//		public StudentModel() {
//			
//		}
//		
//		
//		
//		public StudentModel(String username, String password) {
//			super();
//			this.username = username;
//			this.password = password;
//		}
//
//
//
//		public long getId() {
//			return id;
//		}
//
//
//
//		public void setId(long id) {
//			this.id = id;
//		}
//
//
//
//		public String getUsername() {
//			return username;
//		}
//
//
//
//		public void setUsername(String username) {
//			this.username = username;
//		}
//
//
//
//		public String getPassword() {
//			return password;
//		}
//
//
//
//		public void setPassword(String password) {
//			this.password = password;
//		}
//
//
//
//		@Override
//		public String toString() {
//			return "StudentModel [id=" + id + ", username=" + username + ", password=" + password + "]";
//		}
//
//
//
//		
//}

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
//		
		@Column(name = "email")
		private String email;
		
		@Column(name = "batchgroup")
		private int batchgroup;
		
		@Column(name = "fieldgroup")
		private int fieldgroup;
		
		@Column(name = "isrep")
		private boolean isrep;
		
		@Column(name = "gpa")
		private float gpa;
		
		@Column(name = "batchrank")
		private int batchrank;
		
		@Column(name = "fieldrank")
		private int fieldrank;
		
		@Column(name = "uni")
		private String uni;
		
		@Column(name = "batch")
		private String batch;
		
		@Column(name = "faculty")
		private String faculty;
		
		@Column(name = "field")
		private String field;
		
		
		public StudentModel() {
			
		}
		
		
		public StudentModel(String username, String password, String email, int batchgroup, int fieldgroup,
				boolean isRep, float gpa, int batchrank, int fieldrank, String uni, String batch, String faculty,
				String field) {
			this.username = username;
			this.password = password;
			this.email = email;
			this.batchgroup = batchgroup;
			this.fieldgroup = fieldgroup;
			this.isrep = isRep;
			this.gpa = gpa;
			this.batchrank = batchrank;
			this.fieldrank = fieldrank;
			this.uni = uni;
			this.batch = batch;
			this.faculty = faculty;
			this.field = field;
		}

		public StudentModel(String username, String password, String email, int batchgroup, int fieldgroup,
				boolean isRep, String uni, String batch, String faculty, String field) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.batchgroup = batchgroup;
			this.fieldgroup = fieldgroup;
			this.isrep = isRep;
			this.uni = uni;
			this.batch = batch;
			this.faculty = faculty;
			this.field = field;
		}

		public String getUni() {
			return uni;
		}


		public void setUni(String uni) {
			this.uni = uni;
		}


		public String getBatch() {
			return batch;
		}


		public void setBatch(String batch) {
			this.batch = batch;
		}


		public String getFaculty() {
			return faculty;
		}


		public void setFaculty(String faculty) {
			this.faculty = faculty;
		}


		public String getField() {
			return field;
		}


		public void setField(String field) {
			this.field = field;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public int getBatchgroup() {
			return batchgroup;
		}


		public void setBatchgroup(int batchgroup) {
			this.batchgroup = batchgroup;
		}


		public int getFieldgroup() {
			return fieldgroup;
		}


		public void setFieldgroup(int fieldgroup) {
			this.fieldgroup = fieldgroup;
		}


		public boolean isIsrep() {
			return isrep;
		}


		public void setIsrep(boolean isrep) {
			this.isrep = isrep;
		}


		public float getGpa() {
			return gpa;
		}


		public void setGpa(float gpa) {
			this.gpa = gpa;
		}


		public int getBatchrank() {
			return batchrank;
		}


		public void setBatchrank(int batchrank) {
			this.batchrank = batchrank;
		}


		public int getFieldrank() {
			return fieldrank;
		}


		public void setFieldrank(int fieldrank) {
			this.fieldrank = fieldrank;
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
			return "StudentModel [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", batchgroup=" + batchgroup + ", fieldgroup=" + fieldgroup + ", isRep=" + isrep + ", gpa=" + gpa
					+ ", batchrank=" + batchrank + ", fieldrank=" + fieldrank + ", uni=" + uni + ", batch=" + batch
					+ ", faculty=" + faculty + ", field=" + field + "]";
		}
}
