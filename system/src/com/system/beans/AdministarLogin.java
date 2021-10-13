package com.system.beans;

public class AdministarLogin {
   private String aName;
   private int aAge;
   private String aSex;
    private String aID;
    private int Password=13579;
    public int getPassword(){
        return Password;
    }
    public AdministarLogin() {}
    public AdministarLogin(String aName,String aID){
        this.aName=aName;
        this.aID=aID;
    }
    public int getaAge() {
        return aAge;
    }

    public void setaAge(int aAge) {
        this.aAge = aAge;
    }

    public String getaSex() {
        return aSex;
    }

    public void setaSex(String aSex) {
        this.aSex = aSex;
    }
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    @Override
    public String toString() {
        return "AdministarLogin{" +
                "aName='" + aName + '\'' +
                ", aAge=" + aAge +
                ", aSex='" + aSex + '\'' +
                ", aID='" + aID + '\'' +
                ", Password=" + Password +
                '}';
    }
}

