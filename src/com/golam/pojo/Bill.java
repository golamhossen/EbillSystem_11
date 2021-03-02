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
public class Bill {
    private int customerId;
    private String customerName;
    private int meterNo;
    private String month;
    private String expireDate;
    private int costUnit;
    private Double totalBill;

    public Bill(int customerId, String customerName, int meterNo, String month, String expireDate, int costUnit, Double totalBill) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.meterNo = meterNo;
        this.month = month;
        this.expireDate = expireDate;
        this.costUnit = costUnit;
        this.totalBill = totalBill;
    }

    public Bill(String customerName, int meterNo, String month, String expireDate, int costUnit, Double totalBill) {
        this.customerName = customerName;
        this.meterNo = meterNo;
        this.month = month;
        this.expireDate = expireDate;
        this.costUnit = costUnit;
        this.totalBill = totalBill;
    }

    public Bill(int customerId) {
        this.customerId = customerId;
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

    public String getMonth() {
        return month;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public int getCostUnit() {
        return costUnit;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    
    
}
