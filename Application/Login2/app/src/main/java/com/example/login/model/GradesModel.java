package com.example.login.model;

import com.google.gson.annotations.SerializedName;

public class GradesModel {

    @SerializedName("id")
    private long id;

    @SerializedName("studentid")
    private long studentid;

    @SerializedName("finalgrade")
    private String finalgrade;

    @SerializedName("isfinalized")
    private boolean isfinalized;

    @SerializedName("courseid")
    private long courseid;

    @SerializedName("coursename")
    private String coursename;

    @SerializedName("credits")
    private int credits;

    @SerializedName("coursecode")
    private String coursecode;


    public GradesModel() {
    }



    public GradesModel(long studentid, String finalgrade, boolean isfinalized, long courseid, String coursename,
                       int credits, String coursecode) {
        super();
        this.studentid = studentid;
        this.finalgrade = finalgrade;
        this.isfinalized = isfinalized;
        this.courseid = courseid;
        this.coursename = coursename;
        this.credits = credits;
        this.coursecode = coursecode;
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


    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    @Override
    public String toString() {
        return "GradesModel [id=" + id + ", studentid=" + studentid + ", finalgrade=" + finalgrade + ", isfinalized="
                + isfinalized + ", courseid=" + courseid + ", coursename=" + coursename + ", credits=" + credits
                + ", coursecode=" + coursecode + "]";
    }

}