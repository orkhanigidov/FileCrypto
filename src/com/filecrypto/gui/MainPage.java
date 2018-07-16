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
        fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        file = fileChooser.getSelectedFile();
        openEncryptPage();
    }

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        MainPage.file = file;
    }

    public String getName() {
        return fileChooser.getSelectedFile().getName();
    }

    public long getSize() {
        return fileChooser.getSelectedFile().length();
    }

    public Icon getIcon() {
        return fileChooser.getIcon(file);
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
