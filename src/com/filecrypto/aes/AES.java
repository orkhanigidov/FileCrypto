package com.filecrypto.aes;

import com.filecrypto.mainpage.Controller;
import javafx.scene.control.Alert;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AES {
    public static void encrypt(String myKey, String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(Controller.getSelectedFile().getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".secret");
            byte[] key = myKey.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(new byte[16]));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            byte[] buf = new byte[1024];
            int read;
            while ((read = fileInputStream.read(buf)) != -1) {
                cipherOutputStream.write(buf, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            cipherOutputStream.close();
            alertMessage("Encryption", "Your file has been successfully encrypted");
        } catch (Exception ex) {}
    }

    public static void decrypt(String myKey, String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(Controller.getSelectedFile().getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            byte[] key = myKey.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(new byte[16]));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            byte[] buf = new byte[1024];
            int read;
            while ((read = fileInputStream.read(buf)) != -1) {
                cipherOutputStream.write(buf, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            cipherOutputStream.close();
            alertMessage("Decryption", "Your file has been successfully decrypted");
        } catch (Exception ex) {}
    }

    private static void alertMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
