package com.example.emergencyhospitalfinder;

public class model {

    String name,address,seat,phone,icuSeat;
     model()
     {

     }
    public model(String name, String address, String seat,String phone,String icuSeat) {
        this.name = name;
        this.address = address;
        this.seat = seat;
        this.phone = phone;
        this.icuSeat = icuSeat;
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
}
