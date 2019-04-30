package com.example.testbishe.QianDao;

public class ItemQiandao {

    private String address;
    private String classname;
    private String teachername;

//    private double latitude ;
//    private double longitude;

//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }








    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }



    public ItemQiandao(String address,String classname,String teachername){

        this.address = address;
        this.classname =classname;
        this.teachername = teachername;
//        this.latitude = latitude;
//        this.longitude = longitude;


    }








}
