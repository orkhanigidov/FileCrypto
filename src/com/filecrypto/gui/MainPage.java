package com.filecrypto.gui;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JButton btnUploadFile;
    private JPanel mainPageView;
    private static JFrame frame;

    public MainPage() {
        btnUploadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });
    }

    private static void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            openEncryptPage();
        }
    }

    private static void openEncryptPage() {
        frame.dispose();
        new EncryptPage().showEncryptPage();
    }

    public static void main(String[] args) {
        frame = new JFrame("FileCrypto");
        frame.setContentPane(new MainPage().mainPageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
