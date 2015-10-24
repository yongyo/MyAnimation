package com.example.bean;

/**
 * Created by Administrator on 2015/10/7.
 */
public class People {
    private String name;
    private String phoneNumber;
    private String address;
    String sort_key;
    public People() {
    }

    public People(String address, String name, String phoneNumber) {
        this.address = address;
        this.name = name;

        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSort_key() {
        return sort_key;
    }

    public void setSort_key(String sort_key) {
        this.sort_key = sort_key;
    }
}
