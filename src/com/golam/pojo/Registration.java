/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.pojo;

/**
 *
 * @author HP
 */
public class Registration {
    private int customerId;
    private String customerName;
    private int meterNo;
    private String mobile;
    private String email;
    private String address;
    private String userName;
    private String pass;

    public Registration() {
    }

    public Registration(int customerId, String customerName, String mobile, String email, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    
    
    public Registration(int customerId, String customerName, int meterNo, String mobile, String email, String address, String userName, String pass) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.meterNo = meterNo;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.userName = userName;
        this.pass = pass;
    }

    public Registration(String customerName, int meterNo, String mobile, String email, String address, String userName, String pass) {
        this.customerName = customerName;
        this.meterNo = meterNo;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.userName = userName;
        this.pass = pass;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getMeterNo() {
        return meterNo;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public Registration(int meterNo) {
        this.meterNo = meterNo;
    }

   
    
    
}
