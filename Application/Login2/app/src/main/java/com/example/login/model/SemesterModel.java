package com.example.login.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SemesterModel{

    @SerializedName("id")
    private long id;

    @SerializedName("fieldgroup")
    private int fieldgroup;

    @SerializedName( "semnumber")
    private int semnumber;

    @SerializedName("iscommited")
    private boolean iscommited;



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

    //    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//
    public SemesterModel() {

    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeLong(id);
//        dest.writeInt(fieldgroup);
//        dest.writeInt(semnumber);
//    }
//
//    public static final Creator<SemesterModel> CREATOR = new Creator<SemesterModel>() {
//        @Override
//        public SemesterModel createFromParcel(Parcel in) {
//
//            return new SemesterModel(in);
//        }
//
//        @Override
//        public SemesterModel[] newArray(int size) {
//            return new SemesterModel[][size];
//        }
//    };
}
