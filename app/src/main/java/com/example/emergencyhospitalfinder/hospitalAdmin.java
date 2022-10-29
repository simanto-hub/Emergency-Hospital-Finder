package com.example.emergencyhospitalfinder;

public class hospitalAdmin {
    String username,password,name,phone,seat,icuSeat,address,district,thana,website;

    public hospitalAdmin() {
    }

    public hospitalAdmin(String username, String password, String name, String phone, String seat, String icuSeat, String address,String district,String thana,String website) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.seat = seat;
        this.icuSeat = icuSeat;
        this.address = address;
        this.district=district;
        this.thana=thana;
        this.website=website;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getIcuSeat() {
        return icuSeat;
    }

    public void setIcuSeat(String icuSeat) {
        this.icuSeat = icuSeat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
