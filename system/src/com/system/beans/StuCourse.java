package com.system.beans;

public class StuCourse {
    private String stuID;
    private String couID;

    public StuCourse() {}
    public StuCourse(String stuID){
        this.stuID=stuID;
    }
    public StuCourse(String stuID, String couID){
        this.stuID=stuID;
        this.couID=couID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCouID() {
        return couID;
    }

    public void setCouID(String couID) {
        this.couID = couID;
    }
    @Override
    public String toString() {
        return "StuCourse{" +
                "stuID='" + stuID + '\'' +
                ", couID='" + couID + '\'' +
                '}';
    }
}
