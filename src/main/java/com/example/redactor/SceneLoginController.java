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
import javafx.scene.control.Alert;
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

public class SceneLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label LoginSceneCenterLabel;

    @FXML
    private Label LoginSceneCenterLeftLabel;

    @FXML
    private Label LoginSceneCenterRightLabel;

    @FXML
    private TextField LoginSceneUserNameOrEmailTextField;

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
    private BorderPane LoginSceneBorderPane;

    @FXML
    private HBox LoginSceneTopHBox;

    @FXML
    private Stage currentStage;

    @FXML
    private Scene newScene;

    private boolean isLoginSceneRegistrationLabelRed;

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
    private void switchingToTheRegistrationWindow(MouseEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-registration.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void loginIntoAccount(MouseEvent event) throws IOException {
        if(isLoginSceneRegistrationLabelRed) {
            if(UserSession.getUserIdByLoginEmailPassword(LoginSceneUserNameOrEmailTextField.getText(), LoginScenePasswordTextField.getText())) {
                currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
                newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
                currentStage.setScene(newScene);
                System.out.println(UserSession.getUserId());
            } else {
                Alert alertOfLogin = new Alert(Alert.AlertType.ERROR);
                alertOfLogin.setTitle("Ошибка");
                alertOfLogin.setHeaderText("Ошибка входа в аккаунт");
                alertOfLogin.setContentText("Такой пользователь не найден или введены некорректные данные");
                alertOfLogin.showAndWait();
            }
        }
    }

    private void changingLoginSceneRegistrationLabel() {
        if(LoginSceneUserNameOrEmailTextField.getText().isEmpty() || LoginScenePasswordTextField.getText().isEmpty()) {
            LoginSceneLoginLabel.getStyleClass().clear();
            LoginSceneLoginLabel.getStyleClass().add("gray");
            LoginSceneLoginLabel.setCursor(Cursor.DEFAULT);
            isLoginSceneRegistrationLabelRed = false;
        } else {
            LoginSceneLoginLabel.getStyleClass().clear();
            LoginSceneLoginLabel.getStyleClass().add("red");
            LoginSceneLoginLabel.setCursor(Cursor.HAND);
            isLoginSceneRegistrationLabelRed = true;
        }
    }

    @FXML
    void initialize() {
        LoginSceneBorderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() < 610) {
                LoginSceneIconImageView.setFitHeight(30);
                LoginSceneIconImageView.setFitWidth(51);

                LoginSceneNameOfProjectLabel.setPrefHeight(30);
                LoginSceneNameOfProjectLabel.setPrefWidth(56);
                LoginSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

                LoginSceneToMenuButton.setPrefHeight(30);
                LoginSceneToMenuButton.setPrefWidth(150);
                LoginSceneToMenuButton.setFont(Font.font("Arial Black", 10));

                LoginSceneTopHBox.setPrefHeight(37);

                LoginSceneCenterLabel.setPrefWidth(367);
                LoginSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,29));

                LoginSceneUserNameOrEmailTextField.setPrefHeight(30);
                LoginSceneUserNameOrEmailTextField.setPrefWidth(367);
                LoginSceneUserNameOrEmailTextField.setFont(Font.font("System",12));

                LoginScenePasswordTextField.setPrefHeight(30);
                LoginScenePasswordTextField.setPrefWidth(367);
                LoginScenePasswordTextField.setFont(Font.font("System",12));

                LoginSceneLoginLabel.setPrefHeight(37);
                LoginSceneLoginLabel.setPrefWidth(192);
                LoginSceneLoginLabel.setFont(Font.font("Arial", FontWeight.BOLD,15));

                LoginSceneCenterLeftLabel.setFont(Font.font("Calibri",16));

                LoginSceneCenterRightLabel.setFont(Font.font("Calibri",16));
            } else if (newValue.intValue() < 720) {
                LoginSceneIconImageView.setFitHeight(33);
                LoginSceneIconImageView.setFitWidth(56);

                LoginSceneNameOfProjectLabel.setPrefHeight(33);
                LoginSceneNameOfProjectLabel.setPrefWidth(61);
                LoginSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

                LoginSceneToMenuButton.setPrefHeight(33);
                LoginSceneToMenuButton.setPrefWidth(160);
                LoginSceneToMenuButton.setFont(Font.font("Arial Black", 10.5));

                LoginSceneTopHBox.setPrefHeight(40);

                LoginSceneCenterLabel.setPrefWidth(439.2);
                LoginSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,30));

                LoginSceneUserNameOrEmailTextField.setPrefHeight(31);
                LoginSceneUserNameOrEmailTextField.setPrefWidth(439.2);
                LoginSceneUserNameOrEmailTextField.setFont(Font.font("System",12.5));

                LoginScenePasswordTextField.setPrefHeight(31);
                LoginScenePasswordTextField.setPrefWidth(439.2);
                LoginScenePasswordTextField.setFont(Font.font("System",12.5));

                LoginSceneLoginLabel.setPrefHeight(38);
                LoginSceneLoginLabel.setPrefWidth(218.6);
                LoginSceneLoginLabel.setFont(Font.font("Arial", FontWeight.BOLD,15.5));

                LoginSceneCenterLeftLabel.setFont(Font.font("Calibri",16.5));

                LoginSceneCenterRightLabel.setFont(Font.font("Calibri",16.5));
            } else if (newValue.intValue() < 830) {
                LoginSceneIconImageView.setFitHeight(36);
                LoginSceneIconImageView.setFitWidth(61);

                LoginSceneNameOfProjectLabel.setPrefHeight(36);
                LoginSceneNameOfProjectLabel.setPrefWidth(66);
                LoginSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

                LoginSceneToMenuButton.setPrefHeight(36);
                LoginSceneToMenuButton.setPrefWidth(170);
                LoginSceneToMenuButton.setFont(Font.font("Arial Black", 11));

                LoginSceneTopHBox.setPrefHeight(43);

                LoginSceneCenterLabel.setPrefWidth(511.4);
                LoginSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,31));

                LoginSceneUserNameOrEmailTextField.setPrefHeight(32);
                LoginSceneUserNameOrEmailTextField.setPrefWidth(511.4);
                LoginSceneUserNameOrEmailTextField.setFont(Font.font("System",13));

                LoginScenePasswordTextField.setPrefHeight(32);
                LoginScenePasswordTextField.setPrefWidth(511.4);
                LoginScenePasswordTextField.setFont(Font.font("System",13));

                LoginSceneLoginLabel.setPrefHeight(39);
                LoginSceneLoginLabel.setPrefWidth(245.2);
                LoginSceneLoginLabel.setFont(Font.font("Arial", FontWeight.BOLD,16));

                LoginSceneCenterLeftLabel.setFont(Font.font("Calibri",17));

                LoginSceneCenterRightLabel.setFont(Font.font("Calibri",17));
            } else if (newValue.intValue() < 940) {
                LoginSceneIconImageView.setFitHeight(39);
                LoginSceneIconImageView.setFitWidth(66);

                LoginSceneNameOfProjectLabel.setPrefHeight(39);
                LoginSceneNameOfProjectLabel.setPrefWidth(71);
                LoginSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

                LoginSceneToMenuButton.setPrefHeight(39);
                LoginSceneToMenuButton.setPrefWidth(180);
                LoginSceneToMenuButton.setFont(Font.font("Arial Black", 11.5));

                LoginSceneTopHBox.setPrefHeight(46);

                LoginSceneCenterLabel.setPrefWidth(583.6);
                LoginSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,32));

                LoginSceneUserNameOrEmailTextField.setPrefHeight(33);
                LoginSceneUserNameOrEmailTextField.setPrefWidth(583.6);
                LoginSceneUserNameOrEmailTextField.setFont(Font.font("System",13.5));

                LoginScenePasswordTextField.setPrefHeight(33);
                LoginScenePasswordTextField.setPrefWidth(583.6);
                LoginScenePasswordTextField.setFont(Font.font("System",13.5));

                LoginSceneLoginLabel.setPrefHeight(40);
                LoginSceneLoginLabel.setPrefWidth(271.8);
                LoginSceneLoginLabel.setFont(Font.font("Arial", FontWeight.BOLD,16.5));

                LoginSceneCenterLeftLabel.setFont(Font.font("Calibri",17.5));

                LoginSceneCenterRightLabel.setFont(Font.font("Calibri",17.5));
            } else {
                LoginSceneIconImageView.setFitHeight(42);
                LoginSceneIconImageView.setFitWidth(71);

                LoginSceneNameOfProjectLabel.setPrefHeight(42);
                LoginSceneNameOfProjectLabel.setPrefWidth(76);
                LoginSceneNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

                LoginSceneToMenuButton.setPrefHeight(42);
                LoginSceneToMenuButton.setPrefWidth(190);
                LoginSceneToMenuButton.setFont(Font.font("Arial Black", 12));

                LoginSceneTopHBox.setPrefHeight(49);

                LoginSceneCenterLabel.setPrefWidth(655.8);
                LoginSceneCenterLabel.setFont(Font.font("Arial", FontWeight.BOLD,33));

                LoginSceneUserNameOrEmailTextField.setPrefHeight(34);
                LoginSceneUserNameOrEmailTextField.setPrefWidth(655.8);
                LoginSceneUserNameOrEmailTextField.setFont(Font.font("System",14));

                LoginScenePasswordTextField.setPrefHeight(34);
                LoginScenePasswordTextField.setPrefWidth(655.8);
                LoginScenePasswordTextField.setFont(Font.font("System",14));

                LoginSceneLoginLabel.setPrefHeight(41);
                LoginSceneLoginLabel.setPrefWidth(298.4);
                LoginSceneLoginLabel.setFont(Font.font("Arial", FontWeight.BOLD,17));

                LoginSceneCenterLeftLabel.setFont(Font.font("Calibri",18));

                LoginSceneCenterRightLabel.setFont(Font.font("Calibri",18));
            }
        });

        LoginSceneUserNameOrEmailTextField.textProperty().addListener((observable, oldValue, newValue) -> changingLoginSceneRegistrationLabel());
        LoginScenePasswordTextField.textProperty().addListener((observable, oldValue, newValue) -> changingLoginSceneRegistrationLabel());
    }

}
