package com.filecrypto.mainpage;

import com.filecrypto.decryptpage.DecryptMain;
import com.filecrypto.encryptpage.EncryptMain;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    private static FileChooser fileChooser;
    private static File selectedFile;
    private static Stage stage = new Stage();

    public void onUploadFile() {
        openFileChooser();
    }

    private void openFileChooser() {
        fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            if (getExtension()) {
                openDecryptPage();
            } else {
                openEncryptPage();
            }
        }
    }

    private static boolean getExtension() {
        return selectedFile.getName().contains(".secret");
    }

    public static File getSelectedFile() {
        return selectedFile;
    }

    public static String getName() {
        return selectedFile.getName();
    }

    public static long getSize() {
        return selectedFile.length();
    }

    private void openEncryptPage() {
        try {
            new EncryptMain().start(stage);
        } catch (Exception e) {}
    }

    private void openDecryptPage() {
        try {
            new DecryptMain().start(stage);
        } catch (Exception ex) {}
    }
}
