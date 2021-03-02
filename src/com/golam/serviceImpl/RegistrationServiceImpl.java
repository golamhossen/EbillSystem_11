/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.serviceImpl;

import com.golam.connection.DbConnection;
import com.golam.pojo.Registration;
import com.golam.service.CommonService;
import java.sql.Connection;
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
public class RegistrationServiceImpl implements CommonService<Registration> {

    static Connection con = DbConnection.getInstance();

    @Override
    public void createTable() {
        String sql = "create table registration(customerId int(5) primary key auto_increment,"
                + "customerName varchar(250) not null,"
                + "meterNo int(10) not null unique,"
                + "mobile varchar(100),"
                + "email varchar(100),"
                + "address varchar(100),"
                + "userName varchar(100),"
                + "pass varchar(100))";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            System.out.println("::::: Table Created :::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Registration t) {
        String sql = "insert into registration(customerName, meterNo, mobile, email, address, userName, pass) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setInt(2, t.getMeterNo());
            ps.setString(3, t.getMobile());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getAddress());
            ps.setString(6, t.getUserName());
            ps.setString(7, t.getPass());
            ps.executeUpdate();
            System.out.println("::::: Data Inserted Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from registration where customerId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("::::: Data Deleted Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Registration t) {
        String sql = "update registration set customerName=?,mobile=?,email=?, address=? where customerId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());

            ps.setString(2, t.getMobile());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getAddress());

            ps.setInt(5, t.getCustomerId());
            ps.executeUpdate();
            System.out.println("::::: Data Updated Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Registration get(int id) {
        Registration reg = null;
        String sql = "select * from registration where customerId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reg = new Registration(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("mobile"), rs.getString("email"), rs.getString("address"), rs.getString("userName"), rs.getString("pass"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reg;
    }

    @Override
    public List<Registration> getList() {
        List<Registration> regs = new ArrayList<>();
        String sql = "select * from registration";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Registration reg = new Registration(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("mobile"), rs.getString("email"), rs.getString("address"), rs.getString("userName"), rs.getString("pass"));
                regs.add(reg);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return regs;
    }

    @Override
    public Registration getCustomerDetails(String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Registration getMeterNo(int meterNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Registration getUserByUsernameAndPassword(String username, String password) {
         Registration reg = null;
        String sql = "select * from registration where userName=? and pass=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reg = new Registration(rs.getInt("customerId"), rs.getString("customerName"), rs.getInt("meterNo"),
                        rs.getString("mobile"), rs.getString("email"), rs.getString("address"), rs.getString("userName"), rs.getString("pass"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reg;
    }

}
