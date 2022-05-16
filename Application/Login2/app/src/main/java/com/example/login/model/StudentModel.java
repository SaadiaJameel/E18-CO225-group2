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

    public StudentModel() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public StudentModel(String username, String password) {

        this.username = username;
        this.password = password;
    }

    protected StudentModel(Parcel in) {
        id = in.readInt();
        username = in.readString();
        password = in.readString();
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
