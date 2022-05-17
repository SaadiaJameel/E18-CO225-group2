package com.example.login.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class StudentModel implements Parcelable{



    @SerializedName("id")
    private long id;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    //
    @SerializedName( "email")
    private String email;

    @SerializedName( "batchgroup")
    private int batchgroup;

    @SerializedName( "fieldgroup")
    private int fieldgroup;

    @SerializedName("isRep")
    private boolean isRep;

    @SerializedName("gpa")
    private float gpa;

    @SerializedName( "batchrank")
    private int batchrank;

    @SerializedName( "fieldrank")
    private int fieldrank;

    @SerializedName( "uni")
    private String uni;

    @SerializedName( "batch")
    private String batch;

    @SerializedName( "faculty")
    private String faculty;

    @SerializedName("field")
    private String field;

    protected StudentModel(Parcel in) {
        id = in.readInt();
        username = in.readString();
        password = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }


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
        this.isRep = isRep;
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
        this.isRep = isRep;
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


    public boolean isRep() {
        return isRep;
    }


    public void setRep(boolean isRep) {
        this.isRep = isRep;
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
                + ", batchgroup=" + batchgroup + ", fieldgroup=" + fieldgroup + ", isRep=" + isRep + ", gpa=" + gpa
                + ", batchrank=" + batchrank + ", fieldrank=" + fieldrank + ", uni=" + uni + ", batch=" + batch
                + ", faculty=" + faculty + ", field=" + field + "]";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(username);
        dest.writeString(password);
    }

    public static final Creator<StudentModel> CREATOR = new Creator<StudentModel>() {
        @Override
        public StudentModel createFromParcel(Parcel in) {
            return new StudentModel(in);
        }

        @Override
        public StudentModel[] newArray(int size) {
            return new StudentModel[size];
        }
    };

}
