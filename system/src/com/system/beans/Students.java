package com.system.beans;

public class Students {
    //初始化学生成绩
  private  String sName;
  private  int sAge;
   private String sNumber;
   private String sSex;
    public Students() { }
    public Students(String sname,int age,String snumber,String sex,int sscore){
        this.sName =sName;
        this.sAge =sAge;
        this.sNumber =sNumber;
        this.sSex =sSex;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getsSex() {
        return sSex;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", sNumber='" + sNumber + '\'' +
                ", sSex='" + sSex + '\'' +
                '}';
    }
}
