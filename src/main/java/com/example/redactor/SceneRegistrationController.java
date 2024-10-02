package com.example.redactor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class SceneRegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label RegistrationSceneCenterLabel;

    @FXML
    private Label RegistrationSceneCenterLeftLabel;

    @FXML
    private Label RegistrationSceneCenterRightLabel;

    @FXML
    private TextField RegistrationSceneEmailTextField;

    @FXML
    private ImageView RegistrationSceneIconImageView;

    @FXML
    private Label RegistrationSceneNameOfProjectLabel;

    @FXML
    private TextField RegistrationScenePasswordTextField;

    @FXML
    private Label RegistrationSceneRegistrationLabel;

    @FXML
    private Button RegistrationSceneToMenuButton;

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

    @FXML
    void initialize() {

    }

}
