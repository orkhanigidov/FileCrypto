package com.filecrypto.decryptpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DecryptMain {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../decryptpage/decryptpage.fxml"));
        primaryStage.setTitle("Decrypt Page");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}
