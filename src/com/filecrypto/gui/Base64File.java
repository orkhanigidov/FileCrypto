package com.filecrypto.gui;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class Base64File {
    public static String encoder(File file) {
        String base64File = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] fileData = new byte[(int) file.length()];
            fileInputStream.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
            fileInputStream.close();
        } catch (Exception ex) {}
        return base64File;
    }

//    public static void decoder(File file) {
//
//    }
}
