/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.golam.serviceImpl;

import com.golam.service.CommonService;
import com.golam.pojo.Feedback;
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
public class FeedbackServiceImp implements CommonService<Feedback> {

    @Override
    public void createTable() {
        String sql = "create table feedback(customerId int(5) primary key auto_increment,"
                + "customerName varchar(250) not null,"
                + "feedback varchar(500))";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            System.out.println("::::: Table Created :::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Feedback t) {
        String sql = "insert into feedback(customerName, feedback)values(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setString(2, t.getFeedback());

            ps.executeUpdate();
            System.out.println("Data insert successfully");
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from feedback where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("::::: Data Deleted Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Feedback t) {
        String sql = "update feedback set customerName=?, feedback=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setString(2, t.getFeedback());
            ps.executeUpdate();
            System.out.println("::::: Data Updated Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Feedback get(int id) {
  Feedback feeds = null;
        String sql = "select * from feedback where customerId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                feeds = new Feedback(rs.getInt("customerId"), rs.getString("customerName"), rs.getString("feedback"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FeedbackServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feeds;
    }

    @Override
    public List<Feedback> getList() {
    List<Feedback> feeds = new ArrayList<>();
        String sql = "select * from bill";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback feed = new Feedback(rs.getInt("customerId"), rs.getString("customerName"), rs.getString("feedback"));
                feeds.add(feed);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FeedbackServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return feeds;
    }

    @Override
    public Feedback getCustomerDetails(String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Feedback getMeterNo(int meterNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    String sql = "create table bill(customerId int(5) primary key auto_increment,"
//                + "customerName varchar(250)  not null,"
//                +"meterNo int (10) not null unique"

    @Override
    public Feedback getUserByUsernameAndPassword(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
