package com.filecrypto.gui;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPage {
    private JButton btnUploadFile;
    private JPanel mainPageView;
    private static JFrame frame;
    private static JFileChooser fileChooser;
    private static File file;
    private static Icon icon;

    public MainPage() {
        btnUploadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });
    }

    private static void openFileChooser() {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            openEncryptPage();
        }
    }

    public String getFileEncoded() {
        return Base64File.encoder(file);
    }

//    public String getFileDecoded() {
//        return Base64File.decoder(file);
//    }

    public String getName() {
        return fileChooser.getSelectedFile().getName();
    }

    public long getSize() {
        long fileSize = fileChooser.getSelectedFile().length();
        return fileSize;
    }

    public Icon getIcon() {
        file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        icon = fileChooser.getIcon(file);
        return icon;
    }

    private static void openEncryptPage() {
        frame.dispose();
        new EncryptPage().showEncryptPage();
    }

    public void showMainPage() {
        frame = new JFrame("FileCrypto");
        frame.setContentPane(new MainPage().mainPageView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
