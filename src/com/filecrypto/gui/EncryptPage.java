package com.filecrypto.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptPage {
    private JPanel encryptPageView;
    private JButton btnCancel;
    private JButton btnEncrypt;
    private JLabel lblIcon;
    private JLabel lblName;
    private JLabel lblSize;
    private JLabel lblPassword;
    private JLabel lblHint;

    public EncryptPage() {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private static void cancel() {

    }

    private static void encrypt() {

    }

    public void showEncryptPage() {
        JFrame frame = new JFrame("FileCrypto");
        frame.setContentPane(new EncryptPage().encryptPageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
