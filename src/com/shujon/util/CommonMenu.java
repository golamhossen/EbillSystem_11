
package com.shujon.util;


import com.golam.view.CalculateBill;
import com.golam.view.CustomerView;
import com.golam.view.FeedbackCustomer;
import com.golam.view.HomePage1;
import com.golam.view.RegiView;
import com.golam.view.UpdatePerUnitCost;
import com.golam.view.ViewBill;
import com.golam.view.ViewDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;




public class CommonMenu {
    public void getCommonMenu(JFrame f){
        JMenuBar menuBar= new JMenuBar();
        JMenu customer = new JMenu("Customer");
         JMenuItem reg = new JMenuItem("Registration");
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new RegiView().setVisible(true);
            }
        });

          JMenuItem customerView = new JMenuItem("Customer View");
        customerView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CustomerView().setVisible(true);
            }
        });
        
         JMenuItem feedback = new JMenuItem("Customer Feedback");
        feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new FeedbackCustomer().setVisible(true);
            }
        });
        customer.add(reg);
        customer.add(customerView);
        customer.add(feedback);
        
        
        
         JMenu bill = new JMenu("Bill");
         JMenuItem cbil = new JMenuItem("Calculate Bill");
        cbil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CalculateBill().setVisible(true);
            }
        });

         
          JMenuItem vBill = new JMenuItem("View  Bill");
        vBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ViewBill().setVisible(true);
            }
        });
        
         
          JMenuItem unit = new JMenuItem("Update Bill");
        unit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdatePerUnitCost().setVisible(true);
            }
        });
        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ViewDetails().setVisible(true);
            }
        });
        
                bill.add(cbil);
                bill.add(vBill);
                bill.add(unit);
                bill.add(billDetails);
                
                
       
   
        
       menuBar.add(customer);
       menuBar.add(bill);
       f.setJMenuBar(menuBar);
       
    }
}
