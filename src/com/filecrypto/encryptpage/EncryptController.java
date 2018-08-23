package com.filecrypto.encryptpage;

import com.filecrypto.aes.AES;
import com.filecrypto.mainpage.Controller;
import com.filecrypto.mainpage.Main;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class EncryptController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label name;
    @FXML
    private Label size;
    @FXML
    private CheckBox check;
    @FXML
    private Label icon;
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

    public void onEncryptFile() {
        saveFileChooser();
    }

    public void onCheck() {
        if (check.isSelected()) {

        }
    }

    private void cancel() {
        try {
            new Main().start(stage);
        } catch (Exception e) {}
    }

    private void encrypt(String fileName) {
        AES.encrypt(passwordField.getText(), fileName);
    }

    private void saveFileChooser() {
        fileChooser = new FileChooser();
        fileChooser.setInitialFileName(com.filecrypto.mainpage.Controller.getName());
        selectedFile = fileChooser.showSaveDialog(gridPane.getScene().getWindow());
        if (selectedFile != null) {
            encrypt(selectedFile.getAbsolutePath());
        }
    }
}
