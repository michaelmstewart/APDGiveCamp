package org.apd.view;

import org.apd.model.domain.*;
import org.apd.view.container.APDTabContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;

public class GUI extends JFrame implements ActionListener {
    APDTabContainer tabContainer;
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }

    public GUI() {
        setTitle("ADP GUI");
        setSize(600, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        this.tabContainer = new APDTabContainer();

        getContentPane().add(submitButton, BorderLayout.SOUTH);
        getContentPane().add(this.tabContainer, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        IntakeForm intakeForm = this.tabContainer.intakePanel.OnSubmit();
        Customer customer = intakeForm.getCustomer();
        EligibilityForm eligibilityForm = this.tabContainer.eligibilityPanel.OnSubmit(customer);

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("apd_" + customer.getLastName() + "_" + customer.getFirstName() + "_" +
                            (new Date()).getTime() + ".csv"), "utf-8"));
            writer.write(intakeForm.toCsv() + "," + eligibilityForm.toCsv() + ",\"" + customer.getEmail() + "\"");
        } catch (IOException ex) {
            // report
            ex.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            this.tabContainer.intakePanel.Reset();
        }
    }
}