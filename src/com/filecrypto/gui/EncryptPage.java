package com.filecrypto.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EncryptPage {
    private JPanel encryptPageView;
    private JButton btnCancel;
    private JButton btnEncrypt;
    private JLabel lblIcon;
    private JLabel lblName;
    private JLabel lblSize;
    private JPasswordField txtPassword;
    private JTextField txtHint;
    private static JFrame frame;
    private static JFileChooser fileChooser;

    public EncryptPage() {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        btnEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFileChooser();
            }
        });
        showInfo();
    }

    private static void cancel() {
        frame.dispose();
        new MainPage().showMainPage();
    }

    private void encrypt(String fileName) {
        AES.encrypt(String.valueOf(txtPassword.getPassword()), fileName);
    }

    private void saveFileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(MainPage.getFile().getName()));
        int returnVal = fileChooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            encrypt(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    public void showInfo() {
        lblName.setText(MainPage.getName());
        lblSize.setText(MainPage.getSize() + "");
        lblIcon.setIcon(MainPage.getIcon());
    }

    public void showEncryptPage() {
        frame = new JFrame("Encryption");
        frame.setContentPane(new EncryptPage().encryptPageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
