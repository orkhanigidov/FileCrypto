package com.filecrypto.gui;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AES {
    public static void encrypt(String myKey, String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(MainPage.getFile().getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + ".secret");
            byte[] key = myKey.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(new byte[16]));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            byte[] buf = new byte[8];
            int read;
            while ((read = fileInputStream.read(buf)) != -1) {
                cipherOutputStream.write(buf, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            cipherOutputStream.close();
            JOptionPane.showMessageDialog(null,
                    "Your file has been successfully encrypted",
                    "Encryption", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {}
    }

    public static void decrypt(String myKey, String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(MainPage.getFile().getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + ".png");
            byte[] key = myKey.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(new byte[16]));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            byte[] buf = new byte[8];
            int read;
            while ((read = fileInputStream.read(buf)) != -1) {
                cipherOutputStream.write(buf, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            cipherOutputStream.close();
            JOptionPane.showMessageDialog(null,
                    "Your file has been successfully decrypted",
                    "Decryption", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
