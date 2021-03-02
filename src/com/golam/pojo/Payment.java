/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.pojo;

import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Payment {
    private int customerId;
    private String customerName;
    private int meterNo;
    private String month;
    private Double totalBill;
    private String status;

    public Payment() {
    }

    public Payment(int customerId, String customerName, int meterNo, String month, Double totalBill, String status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.meterNo = meterNo;
        this.month = month;
        this.totalBill = totalBill;
        this.status = status;
    }

    public Payment(String customerName, int meterNo, String month, Double totalBill, String status) {
        this.customerName = customerName;
        this.meterNo = meterNo;
        this.month = month;
        this.totalBill = totalBill;
        this.status = status;
    }
    private static final Logger LOG = Logger.getLogger(Payment.class.getName());

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

    public Double getTotalBill() {
        return totalBill;
    }

    public String getStatus() {
        return status;
    }

    public static Logger getLOG() {
        return LOG;
    }

   
    
}
