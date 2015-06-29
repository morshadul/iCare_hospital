package com.basis.rakib.icare_hospital;

/**
 * Created by Mobile App Develop on 27-6-15.
 */
public class Hospital {

    int id;
    String Name;
    String Address;
    String Number;

    public Hospital(int id, String Name, String Address, String Number) {
        this.id = id;
        this.Name = Name;
        this.Address = Address;
        this.Number = Number;
}

    public Hospital(String name, String address, String number) {
        Name = name;
        Address = address;
        Number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }}