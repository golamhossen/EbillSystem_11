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
public class Feedback {
    private int customerId;
    private String customerName;
    private String feedback;

    public Feedback() {
    }

    public Feedback(int customerId, String customerName, String feedback) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.feedback = feedback;
    }

    public Feedback(String customerName, String feedback) {
        this.customerName = customerName;
        this.feedback = feedback;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getFeedback() {
        return feedback;
    }
    
    
}
