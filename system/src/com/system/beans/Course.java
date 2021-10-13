package com.system.beans;

public class Course {
    private String cCourse;
    private String cID;
  private  int cCredit;
   public Course(){}
    public Course(String cCourse, String cid, int ccredit){
        this.cCourse =cCourse;
        this.cID = cid;
        this.cCredit =ccredit;
    }

    public String getcCourse() {
        return cCourse;
    }

    public void setcCourse(String cCourse) {
        this.cCourse = cCourse;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public int getcCredit() {
        return cCredit;
    }

    public void setcCredit(int cCredit) {
        this.cCredit = cCredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cCourse='" + cCourse + '\'' +
                ", cID='" + cID + '\'' +
                ", cCredit=" + cCredit +
                '}';
    }
}
