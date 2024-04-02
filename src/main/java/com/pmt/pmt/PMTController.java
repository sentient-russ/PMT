package com.pmt.pmt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PMTController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}