/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.serviceImpl;

import com.golam.pojo.Bill;
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
public class BillServiceImpl implements CommonService<Bill> {

    @Override
    public void createTable() {
        String sql = "create table bill(customerId int(5) primary key auto_increment,"
                + "customerName varchar(250)  not null,"
                + "meterNo int (10) not null unique,"
                + "month varchar(100),"
                + "expireDate varchar(100),"
                + "costUnit int(5),"
                + "totalBill Double)";
//    String sql = "create table bill(customerId int(5) primary key auto_increment,"
//                + "customerName varchar(250) not null,"
//                + "meterNo int(10) not null unique,"
//                + "month varchar(100),"
//                + "expireDate varchar(100),"
//                + "costUnit int(5),"
//                + "totalBill Double)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            System.out.println("::::: Table Created :::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Bill t) {
        String sql = "insert into bill(customerName, meterNo, month, expireDate, costUnit, totalBill)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setInt(2, t.getMeterNo());
            ps.setString(3, t.getMonth());
            ps.setString(4, t.getExpireDate());
            ps.setInt(5, t.getCostUnit());
            ps.setDouble(6, t.getTotalBill());
            ps.executeUpdate();
            System.out.println("Data insert successfully");
        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from bill where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("::::: Data Deleted Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Bill t) {
        String sql = "update registration set customerName=?, meterNo=?,month=?,expireDate=?, costUnit=?,totalBill=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setInt(2, t.getMeterNo());
            ps.setString(3, t.getMonth());
            ps.setString(4, t.getExpireDate());
            ps.setInt(5, t.getCostUnit());
            ps.setDouble(6, t.getTotalBill());
            ps.executeUpdate();
            System.out.println("::::: Data Updated Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Bill get(int id) {
        Bill bil = null;
        String sql = "select * from bill where customerId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bil = new Bill(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("month"), rs.getString("expireDate"), rs.getInt("costUnit"), rs.getDouble("totalBill"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bil;
    }

    @Override
    public List<Bill> getList() {
        List<Bill> bils = new ArrayList<>();
        String sql = "select * from bill";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bil = new Bill(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("month"), rs.getString("expireDate"), rs.getInt("costUnit"), rs.getDouble("totalBill"));
                bils.add(bil);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bils;
    }

    @Override
    public Bill getCustomerDetails(String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill getMeterNo(int meterNo) {
        Bill bil = null;
        String sql = "select * from bill where meterNo=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, meterNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bil = new Bill(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("month"), rs.getString("expireDate"), rs.getInt("costUnit"), rs.getDouble("totalBill"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BillServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bil;
    }

    @Override
    public Bill getUserByUsernameAndPassword(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
