package com.example.emergencyhospitalfinder;

public class amulancemodel {
    String name,address,phone,district,thana;
    amulancemodel()
    {

    }

    public amulancemodel(String name, String address, String phone,String district,String thana) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.district=district;
        this.thana=thana;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public  String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }
}
