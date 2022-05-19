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


    public GradesModel() {
    }

    public GradesModel(long studentid, String finalgrade, boolean isfinalized) {
        this.studentid = studentid;
        this.finalgrade = finalgrade;
        this.isfinalized = isfinalized;
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

    @Override
    public String toString() {
        return "GradesModel [id=" + id + ", studentid=" + studentid + ", finalgrade=" + finalgrade + ", isfinalized="
                + isfinalized + "]";
    }

}
