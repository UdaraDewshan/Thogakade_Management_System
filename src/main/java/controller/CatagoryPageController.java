package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class CatagoryPageController {

    @FXML
    private Button btnCusManagement;

    @FXML
    private Button btnEmployeeManagement;

    @FXML
    private Button btnItemManagement;

    @FXML
    private Button btnSupManagement;

    @FXML
    private void onHover(javafx.scene.input.MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: white; -fx-text-fill: #2c5364; -fx-font-size: 14px; -fx-background-radius: 12;");
    }

    @FXML
    private void onExit(javafx.scene.input.MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: rgba(255,255,255,0.2); -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 12;");
    }

    @FXML
    void cusManagement(ActionEvent event) {
        
    }

    @FXML
    void employeeManagement(ActionEvent event) {

    }

    @FXML
    void itemManagement(ActionEvent event) {

    }

    @FXML
    void supManagement(ActionEvent event) {

    }

}


