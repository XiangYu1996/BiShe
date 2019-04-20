package com.example.testbishe;

public class ItemQiandao {

    private String address;
    private String classname;
    private String teachername;

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


    }








}
