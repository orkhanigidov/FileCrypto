package com.filecrypto.gui;

import javax.swing.*;

public class MainPage {
    private JButton btnUploadFile;
    private JPanel mainPageView;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FileCrypto");
        frame.setContentPane(new MainPage().mainPageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
