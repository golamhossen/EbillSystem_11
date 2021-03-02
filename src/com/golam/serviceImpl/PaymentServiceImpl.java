/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.serviceImpl;

import com.golam.pojo.Bill;
import com.golam.pojo.Payment;
import com.golam.pojo.Registration;
import com.golam.service.CommonService;
import static com.golam.serviceImpl.RegistrationServiceImpl.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class PaymentServiceImpl implements CommonService<Payment> {

    @Override
    public void createTable() {
        
        String sql = "create table payment(customerId int(5) primary key auto_increment,"
                + "customerName varchar(250) not null,"
                + "meterNo int(10) not null unique,"
                + "month varchar(100),"
                + "totalBill Double,"
                + "status varchar(100))";
//        String sql = "create table payment(customerId int(5) primary key auto_increment,"
//                + "customerName varchar(250) not null,"
//                + "meterNo int(10) not null,"
//                + "month varchar(100),"
//                + "totalBill Double(100),"
//                + "status varchar(100)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            System.out.println("::::: Table Created :::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Payment t) {
        String sql = "insert into payment(customerName, meterNo, month, totalBill, status) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setInt(2, t.getMeterNo());
            ps.setString(3, t.getMonth());
            ps.setDouble(4, t.getTotalBill());
            ps.setString(5, t.getStatus());

            ps.executeUpdate();
            System.out.println("::::: Data Inserted Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from payment where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("::::: Data Deleted Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Payment t) {
        String sql = "update payment set customerName=?, meterNo=?,month=?,totalBill=?, status=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setInt(2, t.getMeterNo());
            ps.setString(3, t.getMonth());
            ps.setDouble(4, t.getTotalBill());
            ps.setString(5, t.getStatus());

            ps.executeUpdate();
            System.out.println("::::: Data Updated Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Payment get(int id) {
  Payment pay = null;
        String sql = "select * from registration where customerId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pay = new Payment(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("month"), rs.getDouble("totalBill"), rs.getString("status"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pay;  }

    @Override
    public List<Payment> getList() {
   List<Payment> pays = new ArrayList<>();
        String sql = "select * from payment";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Payment pay = new Payment(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("month"), rs.getDouble("totalBill"), rs.getString("status"));
                pays.add(pay);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pays;
    }

    @Override
    public Payment getCustomerDetails(String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment getMeterNo(int meterNo) {
    Payment pay = null;
        String sql = "select * from bill where meterNo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, meterNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pay = new Payment(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("month"), rs.getDouble("totalBill"), rs.getString("status"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pay;
    }

    @Override
    public Payment getUserByUsernameAndPassword(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
