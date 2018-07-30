package com.filecrypto.encryptpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EncryptMain {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../encryptpage/encryptpage.fxml"));
        primaryStage.setTitle("Encrypt Page");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}
