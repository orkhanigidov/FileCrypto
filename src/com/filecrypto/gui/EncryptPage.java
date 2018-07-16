package com.filecrypto.gui;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
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
    private JPasswordField txtPassword;
    private JTextField txtHint;
    private static JFrame frame;
    private static MainPage mainPage;
    private static JFileChooser fileChooser;

    public EncryptPage() {
        mainPage = new MainPage();

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        btnEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                saveFileChooser();
                encrypt();
            }
        });
        showInfo();
    }

    private static void cancel() {
        frame.dispose();
        new MainPage().showMainPage();
    }

    private static void encrypt() {
        System.out.println(mainPage.getFileEncoded());
    }

    private static void saveFileChooser() {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            encrypt();
        }
    }

    private char[] getPassword() {
        return txtPassword.getPassword();
    }

    public void showInfo() {
        lblName.setText(mainPage.getName());
        lblSize.setText(mainPage.getSize() + "");
        lblIcon.setIcon(mainPage.getIcon());
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
