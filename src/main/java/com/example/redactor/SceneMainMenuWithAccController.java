package com.example.redactor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SceneMainMenuWithAccController {

    @FXML
    private BorderPane mainMenuBorderPane;

    @FXML
    private Button mainMenuCenterButton;

    @FXML
    private HBox mainMenuCenterHBox;

    @FXML
    private Label mainMenuCenterTopLabel;

    @FXML
    private AnchorPane mainMenuGeneralAnchorPane;

    @FXML
    private Button mainMenuMyDocumentsButton;

    @FXML
    private ImageView mainMenuIconImageView;

    @FXML
    private Button mainMenuInfoButton;

    @FXML
    private TextField mainMenuNameOfPatientTextField;

    @FXML
    private Label mainMenuNameOfProjectLabel;

    @FXML
    private TextField mainMenuNameOfReportTextField;

    @FXML
    private AnchorPane mainMenuPlusAnchorPane;

    @FXML
    private Circle mainMenuPlusCircle;

    @FXML
    private Line mainMenuPlusVLine;

    @FXML
    private Line mainMenuPlusHLine;

    @FXML
    private Button mainMenuStartAnalysisButton;

    @FXML
    private HBox mainMenuTopHBox;

    private Stage currentStage;

    private Scene newScene;

    @FXML
    public void switchingToTheAnalysisStartWindowForNotButton(MouseEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите изображение");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*gif")
        );

        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if(selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-start-analysis-with-acc.fxml"));
            newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
            SceneStartAnalysisWithAccController sceneStartAnalysisWithAccountController = fxmlLoader.getController();
            sceneStartAnalysisWithAccountController.getBeforeAnalysisGeneralImageView().setImage(image);
            sceneStartAnalysisWithAccountController.getBeforeAnalysisGeneralAnchorPane().prefWidthProperty().bind(sceneStartAnalysisWithAccountController.getBeforeAnalysisBorderPane().widthProperty());
            sceneStartAnalysisWithAccountController.getBeforeAnalysisGeneralImageView().fitWidthProperty().bind(sceneStartAnalysisWithAccountController.getBeforeAnalysisBorderPane().widthProperty());
            currentStage.setScene(newScene);
        }
    }

    @FXML
    public void switchingToTheAnalysisStartWindowForButton(ActionEvent event) throws IOException{
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите изображение");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png")
        );

        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if(selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-start-analysis-with-acc.fxml"));
            Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
            SceneStartAnalysisWithAccController sceneStartAnalysisWithAccountController = fxmlLoader.getController();
            sceneStartAnalysisWithAccountController.getBeforeAnalysisGeneralImageView().setImage(image);
            sceneStartAnalysisWithAccountController.getBeforeAnalysisGeneralAnchorPane().prefWidthProperty().bind(sceneStartAnalysisWithAccountController.getBeforeAnalysisBorderPane().widthProperty());
            sceneStartAnalysisWithAccountController.getBeforeAnalysisGeneralImageView().fitWidthProperty().bind(sceneStartAnalysisWithAccountController.getBeforeAnalysisBorderPane().widthProperty());
            currentStage.setScene(newScene);
        }
    }

    @FXML
    public void switchingToTheMyDocumentsWindow(ActionEvent event) throws  IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-my-documents.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        UserSession.getResearches();
        SceneMyDocumentsController.createHBox();
        SceneMyDocumentsController.currentSceneMyDocumentsController = fxmlLoader.getController();
        ((SceneMyDocumentsController)(fxmlLoader.getController())).displayHBox();
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheInformationWindow(ActionEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-information-about-program.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    void initialize() {
        mainMenuBorderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() < 610) {
                mainMenuPlusCircle.setRadius(16);
                mainMenuPlusVLine.setEndX(16);
                mainMenuPlusHLine.setEndY(16);

                mainMenuCenterButton.setPrefHeight(40);
                mainMenuCenterButton.setPrefWidth(100);
                mainMenuCenterButton.setFont(new Font("Arial Black", 11));

                mainMenuCenterHBox.setPrefHeight(48);
                mainMenuCenterHBox.setPrefWidth(140);

                mainMenuTopHBox.setPrefHeight(37);
                mainMenuTopHBox.setPrefWidth(743);

                mainMenuPlusAnchorPane.setPrefHeight(32);
                mainMenuPlusAnchorPane.setPrefWidth(32);

                mainMenuCenterTopLabel.setPrefHeight(13);
                mainMenuCenterTopLabel.setPrefWidth(320);
                mainMenuCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

                mainMenuGeneralAnchorPane.setPrefHeight(320);
                mainMenuGeneralAnchorPane.setPrefWidth(320);

                mainMenuIconImageView.setFitHeight(30);
                mainMenuIconImageView.setFitWidth(51);

                mainMenuInfoButton.setPrefHeight(30);
                mainMenuInfoButton.setPrefWidth(30);
                mainMenuInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));

                mainMenuMyDocumentsButton.setPrefHeight(30);
                mainMenuMyDocumentsButton.setPrefWidth(110);
                mainMenuMyDocumentsButton.setFont(Font.font("Arial Black", 10));

                mainMenuNameOfPatientTextField.setPrefHeight(24);
                mainMenuNameOfPatientTextField.setPrefWidth(320);
                mainMenuNameOfPatientTextField.setFont(Font.font("System", 10));

                mainMenuNameOfProjectLabel.setPrefHeight(30);
                mainMenuNameOfProjectLabel.setPrefWidth(56);
                mainMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

                mainMenuNameOfReportTextField.setPrefHeight(24);
                mainMenuNameOfReportTextField.setPrefWidth(320);
                mainMenuNameOfReportTextField.setFont(Font.font("System", 10));

                mainMenuStartAnalysisButton.setPrefHeight(24);
                mainMenuStartAnalysisButton.setPrefWidth(140);
                mainMenuStartAnalysisButton.setFont(Font.font("Arial Black", 10));
            } else if (newValue.intValue() < 720) {
                mainMenuPlusCircle.setRadius(20);
                mainMenuPlusVLine.setEndX(20);
                mainMenuPlusHLine.setEndY(20);

                mainMenuCenterButton.setPrefHeight(50);
                mainMenuCenterButton.setPrefWidth(124);
                mainMenuCenterButton.setFont(new Font("Arial Black", 13));

                mainMenuCenterHBox.setPrefHeight(60);
                mainMenuCenterHBox.setPrefWidth(175);

                mainMenuTopHBox.setPrefHeight(40);
                mainMenuTopHBox.setPrefWidth(743);

                mainMenuMyDocumentsButton.setPrefHeight(33);
                mainMenuMyDocumentsButton.setPrefWidth(120);
                mainMenuMyDocumentsButton.setFont(Font.font("Arial Black", 10.5));

                mainMenuPlusAnchorPane.setPrefHeight(40);
                mainMenuPlusAnchorPane.setPrefWidth(40);

                mainMenuCenterTopLabel.setPrefHeight(13);
                mainMenuCenterTopLabel.setPrefWidth(420);
                mainMenuCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 15));

                mainMenuGeneralAnchorPane.setPrefHeight(420);
                mainMenuGeneralAnchorPane.setPrefWidth(420);

                mainMenuIconImageView.setFitHeight(33);
                mainMenuIconImageView.setFitWidth(56);

                mainMenuInfoButton.setPrefHeight(33);
                mainMenuInfoButton.setPrefWidth(33);
                mainMenuInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 15.5));

                mainMenuNameOfPatientTextField.setPrefHeight(25);
                mainMenuNameOfPatientTextField.setPrefWidth(420);
                mainMenuNameOfPatientTextField.setFont(Font.font("System", 10.5));

                mainMenuNameOfProjectLabel.setPrefHeight(33);
                mainMenuNameOfProjectLabel.setPrefWidth(61);
                mainMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

                mainMenuNameOfReportTextField.setPrefHeight(25);
                mainMenuNameOfReportTextField.setPrefWidth(420);
                mainMenuNameOfReportTextField.setFont(Font.font("System", 10.5));

                mainMenuStartAnalysisButton.setPrefHeight(25);
                mainMenuStartAnalysisButton.setPrefWidth(187);
                mainMenuStartAnalysisButton.setFont(Font.font("Arial Black", 10.5));
            } else if (newValue.intValue() < 830) {
                mainMenuPlusCircle.setRadius(22);
                mainMenuPlusCircle.setStrokeWidth(2.5);

                mainMenuPlusVLine.setEndX(22);
                mainMenuPlusVLine.setStrokeWidth(2.5);

                mainMenuPlusHLine.setEndY(22);
                mainMenuPlusHLine.setStrokeWidth(2.5);

                mainMenuCenterButton.setPrefHeight(57);
                mainMenuCenterButton.setPrefWidth(140);
                mainMenuCenterButton.setFont(new Font("Arial Black", 15));

                mainMenuCenterHBox.setPrefHeight(66);
                mainMenuCenterHBox.setPrefWidth(232);

                mainMenuMyDocumentsButton.setPrefHeight(36);
                mainMenuMyDocumentsButton.setPrefWidth(130);
                mainMenuMyDocumentsButton.setFont(Font.font("Arial Black", 11));

                mainMenuTopHBox.setPrefHeight(43);
                mainMenuTopHBox.setPrefWidth(743);

                mainMenuPlusAnchorPane.setPrefHeight(44);
                mainMenuPlusAnchorPane.setPrefWidth(44);

                mainMenuCenterTopLabel.setPrefHeight(13);
                mainMenuCenterTopLabel.setPrefWidth(520);
                mainMenuCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                mainMenuGeneralAnchorPane.setPrefHeight(520);
                mainMenuGeneralAnchorPane.setPrefWidth(520);

                mainMenuIconImageView.setFitHeight(36);
                mainMenuIconImageView.setFitWidth(61);

                mainMenuInfoButton.setPrefHeight(36);
                mainMenuInfoButton.setPrefWidth(36);
                mainMenuInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

                mainMenuNameOfPatientTextField.setPrefHeight(26);
                mainMenuNameOfPatientTextField.setPrefWidth(520);
                mainMenuNameOfPatientTextField.setFont(Font.font("System", 11));

                mainMenuNameOfProjectLabel.setPrefHeight(36);
                mainMenuNameOfProjectLabel.setPrefWidth(66);
                mainMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

                mainMenuNameOfReportTextField.setPrefHeight(26);
                mainMenuNameOfReportTextField.setPrefWidth(520);
                mainMenuNameOfReportTextField.setFont(Font.font("System", 11));

                mainMenuStartAnalysisButton.setPrefHeight(26);
                mainMenuStartAnalysisButton.setPrefWidth(232);
                mainMenuStartAnalysisButton.setFont(Font.font("Arial Black", 11));
            } else if (newValue.intValue() < 940) {
                mainMenuPlusCircle.setRadius(26);
                mainMenuPlusCircle.setStrokeWidth(3);

                mainMenuPlusVLine.setEndX(26);
                mainMenuPlusVLine.setStrokeWidth(3);

                mainMenuPlusHLine.setEndY(26);
                mainMenuPlusHLine.setStrokeWidth(3);

                mainMenuMyDocumentsButton.setPrefHeight(39);
                mainMenuMyDocumentsButton.setPrefWidth(140);
                mainMenuMyDocumentsButton.setFont(Font.font("Arial Black", 11.5));

                mainMenuCenterButton.setPrefHeight(70);
                mainMenuCenterButton.setPrefWidth(213);
                mainMenuCenterButton.setFont(new Font("Arial Black", 17));

                mainMenuCenterHBox.setPrefHeight(75);
                mainMenuCenterHBox.setPrefWidth(279);

                mainMenuTopHBox.setPrefHeight(46);
                mainMenuTopHBox.setPrefWidth(743);

                mainMenuPlusAnchorPane.setPrefHeight(52);
                mainMenuPlusAnchorPane.setPrefWidth(52);

                mainMenuCenterTopLabel.setPrefHeight(13);
                mainMenuCenterTopLabel.setPrefWidth(625);
                mainMenuCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                mainMenuGeneralAnchorPane.setPrefHeight(625);
                mainMenuGeneralAnchorPane.setPrefWidth(625);

                mainMenuIconImageView.setFitHeight(39);
                mainMenuIconImageView.setFitWidth(66);

                mainMenuInfoButton.setPrefHeight(39);
                mainMenuInfoButton.setPrefWidth(39);
                mainMenuInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 16.5));

                mainMenuNameOfPatientTextField.setPrefHeight(27);
                mainMenuNameOfPatientTextField.setPrefWidth(625);
                mainMenuNameOfPatientTextField.setFont(Font.font("System", 11.5));

                mainMenuNameOfProjectLabel.setPrefHeight(39);
                mainMenuNameOfProjectLabel.setPrefWidth(71);
                mainMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

                mainMenuNameOfReportTextField.setPrefHeight(27);
                mainMenuNameOfReportTextField.setPrefWidth(625);
                mainMenuNameOfReportTextField.setFont(Font.font("System", 11.5));

                mainMenuStartAnalysisButton.setPrefHeight(27);
                mainMenuStartAnalysisButton.setPrefWidth(279);
                mainMenuStartAnalysisButton.setFont(Font.font("Arial Black", 11.5));
            } else {
                mainMenuPlusCircle.setRadius(30);
                mainMenuPlusVLine.setEndX(30);
                mainMenuPlusHLine.setEndY(30);

                mainMenuCenterButton.setPrefHeight(70);
                mainMenuCenterButton.setPrefWidth(254);
                mainMenuCenterButton.setFont(new Font("Arial Black", 18));

                mainMenuCenterHBox.setPrefHeight(80);
                mainMenuCenterHBox.setPrefWidth(325);

                mainMenuMyDocumentsButton.setPrefHeight(42);
                mainMenuMyDocumentsButton.setPrefWidth(150);
                mainMenuMyDocumentsButton.setFont(Font.font("Arial Black", 12));

                mainMenuTopHBox.setPrefHeight(49);
                mainMenuTopHBox.setPrefWidth(743);

                mainMenuPlusAnchorPane.setPrefHeight(60);
                mainMenuPlusAnchorPane.setPrefWidth(60);

                mainMenuCenterTopLabel.setPrefHeight(13);
                mainMenuCenterTopLabel.setPrefWidth(728);
                mainMenuCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                mainMenuGeneralAnchorPane.setPrefHeight(728);
                mainMenuGeneralAnchorPane.setPrefWidth(728);

                mainMenuIconImageView.setFitHeight(42);
                mainMenuIconImageView.setFitWidth(71);

                mainMenuInfoButton.setPrefHeight(42);
                mainMenuInfoButton.setPrefWidth(42);
                mainMenuInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 17));

                mainMenuNameOfPatientTextField.setPrefHeight(28);
                mainMenuNameOfPatientTextField.setPrefWidth(728);
                mainMenuNameOfPatientTextField.setFont(Font.font("System", 12));

                mainMenuNameOfProjectLabel.setPrefHeight(42);
                mainMenuNameOfProjectLabel.setPrefWidth(76);
                mainMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

                mainMenuNameOfReportTextField.setPrefHeight(28);
                mainMenuNameOfReportTextField.setPrefWidth(728);
                mainMenuNameOfReportTextField.setFont(Font.font("System", 12));

                mainMenuStartAnalysisButton.setPrefHeight(28);
                mainMenuStartAnalysisButton.setPrefWidth(325);
                mainMenuStartAnalysisButton.setFont(Font.font("Arial Black", 12));
            }
        });

    }

}
