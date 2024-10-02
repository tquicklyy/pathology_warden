package com.example.redactor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SceneLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label LoginSceneCenterLabel;

    @FXML
    private Label LoginSceneCenterRightLabel;

    @FXML
    private TextField LoginSceneEmailTextField;

    @FXML
    private ImageView LoginSceneIconImageView;

    @FXML
    private Label LoginSceneLoginLabel;

    @FXML
    private Label LoginSceneNameOfProjectLabel;

    @FXML
    private TextField LoginScenePasswordTextField;

    @FXML
    private Button LoginSceneToMenuButton;

    @FXML
    private BorderPane infoMenuBorderPane;

    @FXML
    private HBox infoMenuTopHBox;

    @FXML
    private Stage currentStage;

    @FXML
    private Scene newScene;

    @FXML
    private void switchingToTheMainMenuForButton(ActionEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheMainMenuForNotButton(MouseEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

//    private void changingTheAnalysisStartButton() {
//        if(LoginScenePasswordTextField.getText().isEmpty() || LoginSceneEmailTextField.getText().isEmpty()) {
//            LoginSceneLoginLabel.getStyleClass().clear();
//            LoginSceneLoginLabel.getStyleClass().add("gray");
//            LoginSceneLoginLabel.setCursor(Cursor.DEFAULT);
//            isBeforeAnalysisStartAnalysisButtonRed = false;
//        } else {
//            LoginSceneLoginLabel.getStyleClass().clear();
//            LoginSceneLoginLabel.getStyleClass().add("red");
//            LoginSceneLoginLabel.setCursor(Cursor.HAND);
//            isBeforeAnalysisStartAnalysisButtonRed = true;
//        }
//    }

    @FXML
    void initialize() {

    }

}
