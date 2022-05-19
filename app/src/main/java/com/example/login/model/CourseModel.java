package com.example.login.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CourseModel implements Parcelable{

    @SerializedName("id")
    private long id;

    @SerializedName("semId")
    private int semId;

    @SerializedName("coursecode")
    private int coursecode;
    //
    @SerializedName( "coursename")
    private String coursename;

    @SerializedName( "credits")
    private int credits;

    @SerializedName( "quizp")
    private int quizp;

    @SerializedName( "assignmentp")
    private int assignmentp;

    @SerializedName( "projectp")
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

    protected CourseModel(Parcel in) {
        id = in.readLong();
        semId = in.readInt();
        coursecode = in.readInt();
        coursename = in.readString();
        credits = in.readInt();
        quizp = in.readInt();
        assignmentp = in.readInt();
        projectp = in.readInt();
    }

    public static final Creator<CourseModel> CREATOR = new Creator<CourseModel>() {
        @Override
        public CourseModel createFromParcel(Parcel in) {
            return new CourseModel(in);
        }

        @Override
        public CourseModel[] newArray(int size) {
            return new CourseModel[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(semId);
        dest.writeInt(coursecode);
        dest.writeString(coursename);
        dest.writeInt(credits);
        dest.writeInt(quizp);
        dest.writeInt(assignmentp);
        dest.writeInt(projectp);
    }
}
