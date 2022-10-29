package com.example.emergencyhospitalfinder;

public class adminadapterModel {
    String name,address,seat,phone,icuSeat,district,thana,website;

    public adminadapterModel() {
    }

    public adminadapterModel(String name, String address, String seat, String phone, String icuSeat, String district, String thana, String website) {
        this.name = name;
        this.address = address;
        this.seat = seat;
        this.phone = phone;
        this.icuSeat = icuSeat;
        this.district = district;
        this.thana = thana;
        this.website = website;
    }

    public String getName() {
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIcuSeat() {
        return icuSeat;
    }

    public void setIcuSeat(String icuSeat) {
        this.icuSeat = icuSeat;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
