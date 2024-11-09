package com.example.redactor;

import java.io.IOException;
import java.sql.Connection;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SceneRegistrationController {

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
    private TextField RegistrationSceneFirstNameTextField;

    @FXML
    private TextField RegistrationSceneSecondNameTextField;

    @FXML
    private TextField RegistrationScenePatronymicTextField;

    @FXML
    private TextField RegistrationSceneLoginTextField;

    @FXML
    private Label RegistrationSceneRegistrationLabel;

    @FXML
    private Button RegistrationSceneToMenuButton;

    @FXML
    private BorderPane RegistrationSceneBorderPane;

    @FXML
    private HBox RegistrationSceneTopHBox;

    @FXML
    private Stage currentStage;

    @FXML
    private Scene newScene;

    private boolean isRegistrationSceneRegistrationLabelRed;

    @FXML
    private void switchingToTheMainMenuForButton(ActionEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-without-acc.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheMainMenuForNotButton(MouseEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-without-acc.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheLoginWindow(MouseEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-login.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

        private void changingRegistrationSceneRegistrationLabel() {
        if(RegistrationSceneFirstNameTextField.getText().isEmpty() || RegistrationSceneSecondNameTextField.getText().isEmpty() || RegistrationScenePatronymicTextField.getText().isEmpty() || RegistrationSceneLoginTextField.getText().isEmpty() || RegistrationSceneEmailTextField.getText().isEmpty() || RegistrationScenePasswordTextField.getText().isEmpty()) {
            RegistrationSceneRegistrationLabel.getStyleClass().clear();
            RegistrationSceneRegistrationLabel.getStyleClass().add("gray");
            RegistrationSceneRegistrationLabel.setCursor(Cursor.DEFAULT);
            isRegistrationSceneRegistrationLabelRed = false;
        } else {
            RegistrationSceneRegistrationLabel.getStyleClass().clear();
            RegistrationSceneRegistrationLabel.getStyleClass().add("red");
            RegistrationSceneRegistrationLabel.setCursor(Cursor.HAND);
            isRegistrationSceneRegistrationLabelRed = true;
        }
    }

    @FXML
    private void registerNewAccount(MouseEvent event) throws IOException {
        if(isRegistrationSceneRegistrationLabelRed) {
            UserSession.addUser(RegistrationSceneLoginTextField.getText(), RegistrationSceneEmailTextField.getText(), RegistrationScenePasswordTextField.getText().hashCode(), RegistrationSceneFirstNameTextField.getText(), RegistrationSceneSecondNameTextField.getText(), RegistrationScenePatronymicTextField.getText());

            currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
            newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
            currentStage.setScene(newScene);
        }
    }

    @FXML
    void initialize() {
        RegistrationSceneBorderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() < 610) {
                RegistrationSceneIconImageView.setFitHeight(30);
                RegistrationSceneIconImageView.setFitWidth(51);

                RegistrationSceneNameOfProjectLabel.setPrefHeight(30);
                RegistrationSceneNameOfProjectLabel.setPrefWidth(56);
                RegistrationSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

                RegistrationSceneToMenuButton.setPrefHeight(30);
                RegistrationSceneToMenuButton.setPrefWidth(150);
                RegistrationSceneToMenuButton.setFont(Font.font("Arial Black", 10));

                RegistrationSceneTopHBox.setPrefHeight(37);

                RegistrationSceneCenterLabel.setPrefWidth(367);
                RegistrationSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,29));

                RegistrationSceneFirstNameTextField.setPrefHeight(30);
                RegistrationSceneFirstNameTextField.setPrefWidth(367);
                RegistrationSceneFirstNameTextField.setFont(Font.font("System",12));

                RegistrationSceneSecondNameTextField.setPrefHeight(30);
                RegistrationSceneSecondNameTextField.setPrefWidth(367);
                RegistrationSceneSecondNameTextField.setFont(Font.font("System",12));

                RegistrationScenePatronymicTextField.setPrefHeight(30);
                RegistrationScenePatronymicTextField.setPrefWidth(367);
                RegistrationScenePatronymicTextField.setFont(Font.font("System",12));

                RegistrationSceneLoginTextField.setPrefHeight(30);
                RegistrationSceneLoginTextField.setPrefWidth(367);
                RegistrationSceneLoginTextField.setFont(Font.font("System",12));

                RegistrationSceneEmailTextField.setPrefHeight(30);
                RegistrationSceneEmailTextField.setPrefWidth(367);
                RegistrationSceneEmailTextField.setFont(Font.font("System",12));

                RegistrationScenePasswordTextField.setPrefHeight(30);
                RegistrationScenePasswordTextField.setPrefWidth(367);
                RegistrationScenePasswordTextField.setFont(Font.font("System",12));

                RegistrationSceneRegistrationLabel.setPrefHeight(37);
                RegistrationSceneRegistrationLabel.setPrefWidth(192);
                RegistrationSceneRegistrationLabel.setFont(Font.font("Arial", FontWeight.BOLD,15));

                RegistrationSceneCenterLeftLabel.setFont(Font.font("Calibri",16));

                RegistrationSceneCenterRightLabel.setFont(Font.font("Calibri",16));
            } else if (newValue.intValue() < 720) {
                RegistrationSceneIconImageView.setFitHeight(33);
                RegistrationSceneIconImageView.setFitWidth(56);

                RegistrationSceneNameOfProjectLabel.setPrefHeight(33);
                RegistrationSceneNameOfProjectLabel.setPrefWidth(61);
                RegistrationSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

                RegistrationSceneToMenuButton.setPrefHeight(33);
                RegistrationSceneToMenuButton.setPrefWidth(160);
                RegistrationSceneToMenuButton.setFont(Font.font("Arial Black", 10.5));

                RegistrationSceneTopHBox.setPrefHeight(40);

                RegistrationSceneCenterLabel.setPrefWidth(439.2);
                RegistrationSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,30));

                RegistrationSceneFirstNameTextField.setPrefHeight(31);
                RegistrationSceneFirstNameTextField.setPrefWidth(439.2);
                RegistrationSceneFirstNameTextField.setFont(Font.font("System",12.5));

                RegistrationSceneSecondNameTextField.setPrefHeight(31);
                RegistrationSceneSecondNameTextField.setPrefWidth(439.2);
                RegistrationSceneSecondNameTextField.setFont(Font.font("System",12.5));

                RegistrationScenePatronymicTextField.setPrefHeight(31);
                RegistrationScenePatronymicTextField.setPrefWidth(439.2);
                RegistrationScenePatronymicTextField.setFont(Font.font("System",12.5));

                RegistrationSceneLoginTextField.setPrefHeight(31);
                RegistrationSceneLoginTextField.setPrefWidth(439.2);
                RegistrationSceneLoginTextField.setFont(Font.font("System",12.5));

                RegistrationSceneEmailTextField.setPrefHeight(31);
                RegistrationSceneEmailTextField.setPrefWidth(439.2);
                RegistrationSceneEmailTextField.setFont(Font.font("System",12.5));

                RegistrationScenePasswordTextField.setPrefHeight(31);
                RegistrationScenePasswordTextField.setPrefWidth(439.2);
                RegistrationScenePasswordTextField.setFont(Font.font("System",12.5));

                RegistrationSceneRegistrationLabel.setPrefHeight(38);
                RegistrationSceneRegistrationLabel.setPrefWidth(218.6);
                RegistrationSceneRegistrationLabel.setFont(Font.font("Arial", FontWeight.BOLD,15.5));

                RegistrationSceneCenterLeftLabel.setFont(Font.font("Calibri",16.5));

                RegistrationSceneCenterRightLabel.setFont(Font.font("Calibri",16.5));
            } else if (newValue.intValue() < 830) {
                RegistrationSceneIconImageView.setFitHeight(36);
                RegistrationSceneIconImageView.setFitWidth(61);

                RegistrationSceneNameOfProjectLabel.setPrefHeight(36);
                RegistrationSceneNameOfProjectLabel.setPrefWidth(66);
                RegistrationSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

                RegistrationSceneToMenuButton.setPrefHeight(36);
                RegistrationSceneToMenuButton.setPrefWidth(170);
                RegistrationSceneToMenuButton.setFont(Font.font("Arial Black", 11));

                RegistrationSceneTopHBox.setPrefHeight(43);

                RegistrationSceneCenterLabel.setPrefWidth(511.4);
                RegistrationSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,31));

                RegistrationSceneFirstNameTextField.setPrefHeight(32);
                RegistrationSceneFirstNameTextField.setPrefWidth(511.4);
                RegistrationSceneFirstNameTextField.setFont(Font.font("System",13));

                RegistrationSceneSecondNameTextField.setPrefHeight(32);
                RegistrationSceneSecondNameTextField.setPrefWidth(511.4);
                RegistrationSceneSecondNameTextField.setFont(Font.font("System",13));

                RegistrationScenePatronymicTextField.setPrefHeight(32);
                RegistrationScenePatronymicTextField.setPrefWidth(511.4);
                RegistrationScenePatronymicTextField.setFont(Font.font("System",13));

                RegistrationSceneLoginTextField.setPrefHeight(32);
                RegistrationSceneLoginTextField.setPrefWidth(511.4);
                RegistrationSceneLoginTextField.setFont(Font.font("System",13));

                RegistrationSceneEmailTextField.setPrefHeight(32);
                RegistrationSceneEmailTextField.setPrefWidth(511.4);
                RegistrationSceneEmailTextField.setFont(Font.font("System",13));

                RegistrationScenePasswordTextField.setPrefHeight(32);
                RegistrationScenePasswordTextField.setPrefWidth(511.4);
                RegistrationScenePasswordTextField.setFont(Font.font("System",13));

                RegistrationSceneRegistrationLabel.setPrefHeight(39);
                RegistrationSceneRegistrationLabel.setPrefWidth(245.2);
                RegistrationSceneRegistrationLabel.setFont(Font.font("Arial", FontWeight.BOLD,16));

                RegistrationSceneCenterLeftLabel.setFont(Font.font("Calibri",17));

                RegistrationSceneCenterRightLabel.setFont(Font.font("Calibri",17));
            } else if (newValue.intValue() < 940) {
                RegistrationSceneIconImageView.setFitHeight(39);
                RegistrationSceneIconImageView.setFitWidth(66);

                RegistrationSceneNameOfProjectLabel.setPrefHeight(39);
                RegistrationSceneNameOfProjectLabel.setPrefWidth(71);
                RegistrationSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

                RegistrationSceneToMenuButton.setPrefHeight(39);
                RegistrationSceneToMenuButton.setPrefWidth(180);
                RegistrationSceneToMenuButton.setFont(Font.font("Arial Black", 11.5));

                RegistrationSceneTopHBox.setPrefHeight(46);

                RegistrationSceneCenterLabel.setPrefWidth(583.6);
                RegistrationSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,32));

                RegistrationSceneFirstNameTextField.setPrefHeight(33);
                RegistrationSceneFirstNameTextField.setPrefWidth(583.6);
                RegistrationSceneFirstNameTextField.setFont(Font.font("System",13.5));

                RegistrationSceneSecondNameTextField.setPrefHeight(33);
                RegistrationSceneSecondNameTextField.setPrefWidth(583.6);
                RegistrationSceneSecondNameTextField.setFont(Font.font("System",13.5));

                RegistrationScenePatronymicTextField.setPrefHeight(33);
                RegistrationScenePatronymicTextField.setPrefWidth(583.6);
                RegistrationScenePatronymicTextField.setFont(Font.font("System",13.5));

                RegistrationSceneLoginTextField.setPrefHeight(33);
                RegistrationSceneLoginTextField.setPrefWidth(583.6);
                RegistrationSceneLoginTextField.setFont(Font.font("System",13.5));

                RegistrationSceneEmailTextField.setPrefHeight(33);
                RegistrationSceneEmailTextField.setPrefWidth(583.6);
                RegistrationSceneEmailTextField.setFont(Font.font("System",13.5));

                RegistrationScenePasswordTextField.setPrefHeight(33);
                RegistrationScenePasswordTextField.setPrefWidth(583.6);
                RegistrationScenePasswordTextField.setFont(Font.font("System",13.5));

                RegistrationSceneRegistrationLabel.setPrefHeight(40);
                RegistrationSceneRegistrationLabel.setPrefWidth(271.8);
                RegistrationSceneRegistrationLabel.setFont(Font.font("Arial", FontWeight.BOLD,16.5));

                RegistrationSceneCenterLeftLabel.setFont(Font.font("Calibri",17.5));

                RegistrationSceneCenterRightLabel.setFont(Font.font("Calibri",17.5));
            } else {
                RegistrationSceneIconImageView.setFitHeight(42);
                RegistrationSceneIconImageView.setFitWidth(71);

                RegistrationSceneNameOfProjectLabel.setPrefHeight(42);
                RegistrationSceneNameOfProjectLabel.setPrefWidth(76);
                RegistrationSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

                RegistrationSceneToMenuButton.setPrefHeight(42);
                RegistrationSceneToMenuButton.setPrefWidth(190);
                RegistrationSceneToMenuButton.setFont(Font.font("Arial Black", 12));

                RegistrationSceneTopHBox.setPrefHeight(49);

                RegistrationSceneCenterLabel.setPrefWidth(655.8);
                RegistrationSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,33));

                RegistrationSceneFirstNameTextField.setPrefHeight(34);
                RegistrationSceneFirstNameTextField.setPrefWidth(655.8);
                RegistrationSceneFirstNameTextField.setFont(Font.font("System",14));

                RegistrationSceneSecondNameTextField.setPrefHeight(34);
                RegistrationSceneSecondNameTextField.setPrefWidth(655.8);
                RegistrationSceneSecondNameTextField.setFont(Font.font("System",14));

                RegistrationScenePatronymicTextField.setPrefHeight(34);
                RegistrationScenePatronymicTextField.setPrefWidth(655.8);
                RegistrationScenePatronymicTextField.setFont(Font.font("System",14));

                RegistrationSceneLoginTextField.setPrefHeight(34);
                RegistrationSceneLoginTextField.setPrefWidth(655.8);
                RegistrationSceneLoginTextField.setFont(Font.font("System",14));

                RegistrationSceneEmailTextField.setPrefHeight(34);
                RegistrationSceneEmailTextField.setPrefWidth(655.8);
                RegistrationSceneEmailTextField.setFont(Font.font("System",14));

                RegistrationScenePasswordTextField.setPrefHeight(34);
                RegistrationScenePasswordTextField.setPrefWidth(655.8);
                RegistrationScenePasswordTextField.setFont(Font.font("System",14));

                RegistrationSceneRegistrationLabel.setPrefHeight(41);
                RegistrationSceneRegistrationLabel.setPrefWidth(298.4);
                RegistrationSceneRegistrationLabel.setFont(Font.font("Arial", FontWeight.BOLD,17));

                RegistrationSceneCenterLeftLabel.setFont(Font.font("Calibri",18));

                RegistrationSceneCenterRightLabel.setFont(Font.font("Calibri",18));
            }
        });
        RegistrationSceneFirstNameTextField.textProperty().addListener((observable, oldValue, newValue) -> changingRegistrationSceneRegistrationLabel());
        RegistrationSceneSecondNameTextField.textProperty().addListener((observable, oldValue, newValue) -> changingRegistrationSceneRegistrationLabel());
        RegistrationScenePatronymicTextField.textProperty().addListener((observable, oldValue, newValue) -> changingRegistrationSceneRegistrationLabel());
        RegistrationSceneLoginTextField.textProperty().addListener((observable, oldValue, newValue) -> changingRegistrationSceneRegistrationLabel());
        RegistrationSceneEmailTextField.textProperty().addListener((observable, oldValue, newValue) -> changingRegistrationSceneRegistrationLabel());
        RegistrationScenePasswordTextField.textProperty().addListener((observable, oldValue, newValue) -> changingRegistrationSceneRegistrationLabel());
    }

}
