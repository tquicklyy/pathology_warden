package com.example.redactor;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SceneStartAnalysisWithAccController {

    public BorderPane getBeforeAnalysisBorderPane() {
        return beforeAnalysisBorderPane;
    }

    @FXML
    private BorderPane beforeAnalysisBorderPane;

    @FXML
    private Button beforeAnalysisMyDocumentsButton;

    @FXML
    private Label beforeAnalysisCenterTopLabel;

    public AnchorPane getBeforeAnalysisGeneralAnchorPane() {
        return beforeAnalysisGeneralAnchorPane;
    }

    @FXML
    private AnchorPane beforeAnalysisGeneralAnchorPane;

    @FXML
    private ImageView beforeAnalysisIconImageView;

    @FXML
    private Button beforeAnalysisInfoButton;

    @FXML
    private TextField beforeAnalysisNameOfPatientTextField;

    @FXML
    private Label beforeAnalysisNameOfProjectLabel;

    @FXML
    private TextField beforeAnalysisNameOfReportTextField;

    @FXML
    private Button beforeAnalysisStartAnalysisButton;

    @FXML
    private HBox beforeAnalysisTopHBox;

    public ImageView getBeforeAnalysisGeneralImageView() {
        return beforeAnalysisGeneralImageView;
    }

    @FXML
    private Label beforeAnalysisForPhotoSelectionLabel;

    @FXML
    private ImageView beforeAnalysisCameraForPhotoSelectionImageView;

    @FXML
    private ImageView beforeAnalysisGeneralImageView;

    private Stage currentStage;

    private Scene newScene;

    private boolean isBeforeAnalysisStartAnalysisButtonRed = false;

    @FXML
    private void switchingToTheMainMenu(MouseEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheInformationWindow(ActionEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-information-about-program.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    private void changingTheAnalysisStartButton() {
        if(beforeAnalysisNameOfReportTextField.getText().isEmpty() || beforeAnalysisNameOfPatientTextField.getText().isEmpty()) {
            beforeAnalysisStartAnalysisButton.getStyleClass().clear();
            beforeAnalysisStartAnalysisButton.getStyleClass().add("gray");
            beforeAnalysisStartAnalysisButton.setCursor(Cursor.DEFAULT);
            isBeforeAnalysisStartAnalysisButtonRed = false;
        } else {
            beforeAnalysisStartAnalysisButton.getStyleClass().clear();
            beforeAnalysisStartAnalysisButton.getStyleClass().add("red");
            beforeAnalysisStartAnalysisButton.setCursor(Cursor.HAND);
            isBeforeAnalysisStartAnalysisButtonRed = true;
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
    private void selectNewImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите изображение");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png")
        );
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        if(selectedFile != null) {
            beforeAnalysisGeneralImageView.setImage(new Image(selectedFile.toURI().toString()));
        }
    }

    @FXML
    private void startAnalysis(MouseEvent event) throws IOException {
        if(isBeforeAnalysisStartAnalysisButtonRed) {
            String[] nameParts = beforeAnalysisNameOfPatientTextField.getText().split(" ");
            currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-end-analysis-with-acc.fxml"));
            Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());

            SceneEndAnalysisWithAccController sceneEndAnalysisWithAccountController = fxmlLoader.getController();
            sceneEndAnalysisWithAccountController.getEndAnalysisGeneralImageView().setImage(beforeAnalysisGeneralImageView.getImage());

            sceneEndAnalysisWithAccountController.getEndAnalysisNameOfReportLabel().setText(beforeAnalysisNameOfReportTextField.getText());
            sceneEndAnalysisWithAccountController.getEndAnalysisNameOfPatientLabel().setText(beforeAnalysisNameOfPatientTextField.getText());

            sceneEndAnalysisWithAccountController.getEndAnalysisGeneralAnchorPane().prefWidthProperty().bind(sceneEndAnalysisWithAccountController.getEndAnalysisBorderPane().widthProperty());
            sceneEndAnalysisWithAccountController.getEndAnalysisGeneralImageView().fitWidthProperty().bind(sceneEndAnalysisWithAccountController.getEndAnalysisBorderPane().widthProperty());

            UserSession.addResearch(nameParts, beforeAnalysisNameOfReportTextField.getText());

            currentStage.setScene(newScene);
        }
    }

    @FXML
    void initialize() {
        beforeAnalysisBorderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() < 610) {
                beforeAnalysisTopHBox.setPrefHeight(37);
                beforeAnalysisTopHBox.setPrefWidth(743);

                beforeAnalysisCenterTopLabel.setPrefHeight(13);
                beforeAnalysisCenterTopLabel.setPrefWidth(320);
                beforeAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

                beforeAnalysisGeneralAnchorPane.setPrefHeight(296);
                beforeAnalysisGeneralImageView.setFitHeight(296);

                beforeAnalysisIconImageView.setFitHeight(30);
                beforeAnalysisIconImageView.setFitWidth(51);

                beforeAnalysisInfoButton.setPrefHeight(30);
                beforeAnalysisInfoButton.setPrefWidth(30);
                beforeAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));

                beforeAnalysisMyDocumentsButton.setPrefHeight(30);
                beforeAnalysisMyDocumentsButton.setPrefWidth(110);
                beforeAnalysisMyDocumentsButton.setFont(Font.font("Arial Black", 10));

                beforeAnalysisNameOfPatientTextField.setPrefHeight(24);
                beforeAnalysisNameOfPatientTextField.setPrefWidth(320);
                beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 10));

                beforeAnalysisNameOfProjectLabel.setPrefHeight(30);
                beforeAnalysisNameOfProjectLabel.setPrefWidth(56);
                beforeAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

                beforeAnalysisNameOfReportTextField.setPrefHeight(24);
                beforeAnalysisNameOfReportTextField.setPrefWidth(320);
                beforeAnalysisNameOfReportTextField.setFont(Font.font("System", 10));

                beforeAnalysisStartAnalysisButton.setPrefHeight(24);
                beforeAnalysisStartAnalysisButton.setPrefWidth(140);
                beforeAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 10));

                beforeAnalysisForPhotoSelectionLabel.setPrefWidth(121);
                beforeAnalysisForPhotoSelectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));

                beforeAnalysisCameraForPhotoSelectionImageView.setFitWidth(21);

            } else if (newValue.intValue() < 720) {
                beforeAnalysisTopHBox.setPrefHeight(40);
                beforeAnalysisTopHBox.setPrefWidth(743);

                beforeAnalysisCenterTopLabel.setPrefHeight(13);
                beforeAnalysisCenterTopLabel.setPrefWidth(420);
                beforeAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 15));

                beforeAnalysisGeneralAnchorPane.setPrefHeight(398);
                beforeAnalysisGeneralImageView.setFitHeight(398);

                beforeAnalysisIconImageView.setFitHeight(33);
                beforeAnalysisIconImageView.setFitWidth(56);

                beforeAnalysisInfoButton.setPrefHeight(33);
                beforeAnalysisInfoButton.setPrefWidth(33);
                beforeAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 15.5));

                beforeAnalysisMyDocumentsButton.setPrefHeight(33);
                beforeAnalysisMyDocumentsButton.setPrefWidth(120);
                beforeAnalysisMyDocumentsButton.setFont(Font.font("Arial Black", 10.5));

                beforeAnalysisNameOfPatientTextField.setPrefHeight(25);
                beforeAnalysisNameOfPatientTextField.setPrefWidth(420);
                beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 10.5));

                beforeAnalysisNameOfProjectLabel.setPrefHeight(33);
                beforeAnalysisNameOfProjectLabel.setPrefWidth(61);
                beforeAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

                beforeAnalysisNameOfReportTextField.setPrefHeight(25);
                beforeAnalysisNameOfReportTextField.setPrefWidth(420);
                beforeAnalysisNameOfReportTextField.setFont(Font.font("System", 10.5));

                beforeAnalysisStartAnalysisButton.setPrefHeight(25);
                beforeAnalysisStartAnalysisButton.setPrefWidth(187);
                beforeAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 10.5));

                beforeAnalysisForPhotoSelectionLabel.setPrefWidth(127);
                beforeAnalysisForPhotoSelectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11.5));

                beforeAnalysisCameraForPhotoSelectionImageView.setFitWidth(21.5);

            } else if (newValue.intValue() < 830) {
                beforeAnalysisTopHBox.setPrefHeight(43);
                beforeAnalysisTopHBox.setPrefWidth(743);

                beforeAnalysisCenterTopLabel.setPrefHeight(13);
                beforeAnalysisCenterTopLabel.setPrefWidth(520);
                beforeAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                beforeAnalysisGeneralAnchorPane.setPrefHeight(496.8);
                beforeAnalysisGeneralImageView.setFitHeight(496.8);

                beforeAnalysisIconImageView.setFitHeight(36);
                beforeAnalysisIconImageView.setFitWidth(61);

                beforeAnalysisInfoButton.setPrefHeight(36);
                beforeAnalysisInfoButton.setPrefWidth(36);
                beforeAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

                beforeAnalysisMyDocumentsButton.setPrefHeight(36);
                beforeAnalysisMyDocumentsButton.setPrefWidth(130);
                beforeAnalysisMyDocumentsButton.setFont(Font.font("Arial Black", 11));

                beforeAnalysisNameOfPatientTextField.setPrefHeight(26);
                beforeAnalysisNameOfPatientTextField.setPrefWidth(520);
                beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 11));

                beforeAnalysisNameOfProjectLabel.setPrefHeight(36);
                beforeAnalysisNameOfProjectLabel.setPrefWidth(66);
                beforeAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

                beforeAnalysisNameOfReportTextField.setPrefHeight(26);
                beforeAnalysisNameOfReportTextField.setPrefWidth(520);
                beforeAnalysisNameOfReportTextField.setFont(Font.font("System", 11));

                beforeAnalysisStartAnalysisButton.setPrefHeight(26);
                beforeAnalysisStartAnalysisButton.setPrefWidth(232);
                beforeAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 11));

                beforeAnalysisForPhotoSelectionLabel.setPrefWidth(132);
                beforeAnalysisForPhotoSelectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));

                beforeAnalysisCameraForPhotoSelectionImageView.setFitWidth(22);

            } else if (newValue.intValue() < 940) {
                beforeAnalysisTopHBox.setPrefHeight(46);
                beforeAnalysisTopHBox.setPrefWidth(743);

                beforeAnalysisCenterTopLabel.setPrefHeight(13);
                beforeAnalysisCenterTopLabel.setPrefWidth(625);
                beforeAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                beforeAnalysisGeneralAnchorPane.setPrefHeight(599);
                beforeAnalysisGeneralImageView.setFitHeight(599);

                beforeAnalysisIconImageView.setFitHeight(39);
                beforeAnalysisIconImageView.setFitWidth(66);

                beforeAnalysisInfoButton.setPrefHeight(39);
                beforeAnalysisInfoButton.setPrefWidth(39);
                beforeAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 16.5));

                beforeAnalysisMyDocumentsButton.setPrefHeight(39);
                beforeAnalysisMyDocumentsButton.setPrefWidth(140);
                beforeAnalysisMyDocumentsButton.setFont(Font.font("Arial Black", 11.5));

                beforeAnalysisNameOfPatientTextField.setPrefHeight(27);
                beforeAnalysisNameOfPatientTextField.setPrefWidth(625);
                beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 11.5));

                beforeAnalysisNameOfProjectLabel.setPrefHeight(39);
                beforeAnalysisNameOfProjectLabel.setPrefWidth(71);
                beforeAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

                beforeAnalysisNameOfReportTextField.setPrefHeight(27);
                beforeAnalysisNameOfReportTextField.setPrefWidth(625);
                beforeAnalysisNameOfReportTextField.setFont(Font.font("System", 11.5));

                beforeAnalysisStartAnalysisButton.setPrefHeight(27);
                beforeAnalysisStartAnalysisButton.setPrefWidth(279);
                beforeAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 11.5));

                beforeAnalysisForPhotoSelectionLabel.setPrefWidth(138);
                beforeAnalysisForPhotoSelectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12.5));

                beforeAnalysisCameraForPhotoSelectionImageView.setFitWidth(22.5);

            } else {
                beforeAnalysisTopHBox.setPrefHeight(49);
                beforeAnalysisTopHBox.setPrefWidth(743);

                beforeAnalysisCenterTopLabel.setPrefHeight(13);
                beforeAnalysisCenterTopLabel.setPrefWidth(728);
                beforeAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                beforeAnalysisGeneralAnchorPane.setPrefHeight(702.4);
                beforeAnalysisGeneralImageView.setFitHeight(702.4);

                beforeAnalysisIconImageView.setFitHeight(42);
                beforeAnalysisIconImageView.setFitWidth(71);

                beforeAnalysisInfoButton.setPrefHeight(42);
                beforeAnalysisInfoButton.setPrefWidth(42);
                beforeAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 17));

                beforeAnalysisMyDocumentsButton.setPrefHeight(42);
                beforeAnalysisMyDocumentsButton.setPrefWidth(150);
                beforeAnalysisMyDocumentsButton.setFont(Font.font("Arial Black", 12));

                beforeAnalysisNameOfPatientTextField.setPrefHeight(28);
                beforeAnalysisNameOfPatientTextField.setPrefWidth(728);
                beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 12));

                beforeAnalysisNameOfProjectLabel.setPrefHeight(42);
                beforeAnalysisNameOfProjectLabel.setPrefWidth(76);
                beforeAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

                beforeAnalysisNameOfReportTextField.setPrefHeight(28);
                beforeAnalysisNameOfReportTextField.setPrefWidth(728);
                beforeAnalysisNameOfReportTextField.setFont(Font.font("System", 12));

                beforeAnalysisStartAnalysisButton.setPrefHeight(28);
                beforeAnalysisStartAnalysisButton.setPrefWidth(325);
                beforeAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 12));

                beforeAnalysisForPhotoSelectionLabel.setPrefWidth(143);
                beforeAnalysisForPhotoSelectionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));

                beforeAnalysisCameraForPhotoSelectionImageView.setFitWidth(23);

            }
        });

        beforeAnalysisNameOfPatientTextField.textProperty().addListener((observable, oldValue, newValue) -> changingTheAnalysisStartButton());
        beforeAnalysisNameOfReportTextField.textProperty().addListener((observable, oldValue, newValue) -> changingTheAnalysisStartButton());
    }


}
