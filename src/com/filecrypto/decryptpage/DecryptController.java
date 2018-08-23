package com.filecrypto.decryptpage;

import com.filecrypto.aes.AES;
import com.filecrypto.mainpage.Controller;
import com.filecrypto.mainpage.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class DecryptController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label name;
    @FXML
    private Label size;
    @FXML
    private GridPane gridPane;
    private static FileChooser fileChooser;
    private static File selectedFile;
    private static Stage stage = new Stage();

    public void initialize() {
        passwordField.setPromptText("Your password");
        showInfo();
    }

    public void showInfo() {
        name.setText(Controller.getName());
        size.setText(Controller.getSize() + "");
    }

    public void onCancel() {
        cancel();
    }

    public void onDecryptFile() {
        saveFileChooser();
    }

    private void cancel() {
        try {
            new Main().start(stage);
        } catch (Exception e) {}
    }

    private void decrypt(String fileName) {
        AES.decrypt(passwordField.getText(), fileName);
    }

    private void saveFileChooser() {
        fileChooser = new FileChooser();
        fileChooser.setInitialFileName(com.filecrypto.mainpage.Controller.getName()
                .replace(".secret", ""));
        selectedFile = fileChooser.showSaveDialog(gridPane.getScene().getWindow());
        if (selectedFile != null) {
            decrypt(selectedFile.getAbsolutePath());
        }
    }
}
