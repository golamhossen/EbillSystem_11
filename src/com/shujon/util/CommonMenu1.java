package com.shujon.util;

import com.golam.view.CalculateBill;
import com.golam.view.CustomerView;
import com.golam.view.FeedbackCustomer;
import com.golam.view.RegiView;
import com.golam.view.UpdatePerUnitCost;
import com.golam.view.ViewBill;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CommonMenu1 {

    public void getCommonMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu billPayment = new JMenu("Bill Payment");
        JMenuItem reg = new JMenuItem("Calculate Bill");
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CalculateBill().setVisible(true);
            }
        });

        JMenuItem viewBill = new JMenuItem("View Bill");
        viewBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ViewBill().setVisible(true);
            }
        });
        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ViewBill().setVisible(true);
            }
        });

        billPayment.add(reg);
        billPayment.add(viewBill);
        billPayment.add(billDetails);

        JMenu feed = new JMenu("Feedback");
        JMenuItem feedback = new JMenuItem("Customer Feedback");
        feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new FeedbackCustomer().setVisible(true);
            }
        });

        feed.add(feedback);

        menuBar.add(billPayment);
        menuBar.add(feed);
        f.setJMenuBar(menuBar);

    }
}
