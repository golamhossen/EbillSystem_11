/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.test;

import com.golam.connection.DbConnection;
import com.golam.service.CommonService;
import com.golam.serviceImpl.BillServiceImpl;
import com.golam.serviceImpl.FeedbackServiceImp;
import com.golam.serviceImpl.PaymentServiceImpl;
import com.golam.serviceImpl.RegistrationServiceImpl;
import java.sql.Connection;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        Connection con = DbConnection.getInstance();
      //  CommonService inService = new RegistrationServiceImpl();
        CommonService inService = new BillServiceImpl();
     CommonService inService1 = new PaymentServiceImpl();
  //    CommonService inService = new FeedbackServiceImp();
        inService.createTable();
        
    }
}
