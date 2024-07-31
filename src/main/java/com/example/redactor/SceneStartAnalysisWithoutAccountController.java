package com.example.redactor;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneStartAnalysisWithoutAccountController {

    public BorderPane getBeforeAnalysisBorderPane() {
        return beforeAnalysisBorderPane;
    }

    @FXML
    private BorderPane beforeAnalysisBorderPane;

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
    private Button beforeAnalysisLoginButton;

    @FXML
    private TextField beforeAnalysisNameOfPatientTextField;

    @FXML
    private Label beforeAnalysisNameOfProjectLabel;

    @FXML
    private TextField beforeAnalysisNameOfReportTextField;

    @FXML
    private Button beforeAnalysisRegisterButton;

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

    private boolean isBeforeAnalysisStartAnalysisButtonRed = false;

    @FXML
    private void switchingToTheMainMenu(MouseEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        System.out.println(currentStage.getScene().getWidth());
        System.out.println(newScene.getWidth());
        System.out.println(currentStage.getScene().getWidth());
        currentStage.setScene(newScene);
        currentStage.show();
        System.out.println(newScene.getWidth());
        System.out.println(currentStage.getScene().getWidth());
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
    private void startAnalysis(MouseEvent event) throws IOException {
        if(isBeforeAnalysisStartAnalysisButtonRed) {
            currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-of-end-analysis-without-account.fxml"));
            Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());

            SceneEndAnalysisWithoutAccountController sceneEndAnalysisWithoutAccountController = fxmlLoader.getController();
            sceneEndAnalysisWithoutAccountController.getEndAnalysisGeneralImageView().setImage(beforeAnalysisGeneralImageView.getImage());

            sceneEndAnalysisWithoutAccountController.getEndAnalysisNameOfReportLabel().setText(beforeAnalysisNameOfReportTextField.getText());
            sceneEndAnalysisWithoutAccountController.getEndAnalysisNameOfPatientLabel().setText(beforeAnalysisNameOfPatientTextField.getText());

            sceneEndAnalysisWithoutAccountController.getEndAnalysisGeneralAnchorPane().prefWidthProperty().bind(sceneEndAnalysisWithoutAccountController.getEndAnalysisBorderPane().widthProperty());
            sceneEndAnalysisWithoutAccountController.getEndAnalysisGeneralImageView().fitWidthProperty().bind(sceneEndAnalysisWithoutAccountController.getEndAnalysisBorderPane().widthProperty());

            currentStage.setScene(newScene);
            currentStage.show();
        }
    }

    @FXML
    void initialize() {
        beforeAnalysisBorderPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                ChangeListener<Number> sceneSizesChangeListener = (observable, oldValue, newValue) -> {
                    if(newValue.intValue() < 610) {
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

                        beforeAnalysisLoginButton.setPrefHeight(30);
                        beforeAnalysisLoginButton.setPrefWidth(55);
                        beforeAnalysisLoginButton.setFont(Font.font("Arial Black", 10));

                        beforeAnalysisRegisterButton.setPrefHeight(30);
                        beforeAnalysisRegisterButton.setPrefWidth(100);
                        beforeAnalysisRegisterButton.setFont(Font.font("Arial Black", 10));

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

                    } else if(newValue.intValue() < 720) {
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

                        beforeAnalysisLoginButton.setPrefHeight(33);
                        beforeAnalysisLoginButton.setPrefWidth(60);
                        beforeAnalysisLoginButton.setFont(Font.font("Arial Black", 10.5));

                        beforeAnalysisRegisterButton.setPrefHeight(33);
                        beforeAnalysisRegisterButton.setPrefWidth(110);
                        beforeAnalysisRegisterButton.setFont(Font.font("Arial Black", 10.5));

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
                    } else if(newValue.intValue() < 830) {
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

                        beforeAnalysisLoginButton.setPrefHeight(36);
                        beforeAnalysisLoginButton.setPrefWidth(65);
                        beforeAnalysisLoginButton.setFont(Font.font("Arial Black", 11));

                        beforeAnalysisRegisterButton.setPrefHeight(36);
                        beforeAnalysisRegisterButton.setPrefWidth(120);
                        beforeAnalysisRegisterButton.setFont(Font.font("Arial Black", 11));

                        beforeAnalysisNameOfPatientTextField.setPrefHeight(26);
                        beforeAnalysisNameOfPatientTextField.setPrefWidth(520);
                        beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 11));

                        beforeAnalysisNameOfProjectLabel.setPrefHeight(36);
                        beforeAnalysisNameOfProjectLabel.setPrefWidth(67);
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

                        beforeAnalysisLoginButton.setPrefHeight(39);
                        beforeAnalysisLoginButton.setPrefWidth(70);
                        beforeAnalysisLoginButton.setFont(Font.font("Arial Black", 11.5));

                        beforeAnalysisRegisterButton.setPrefHeight(39);
                        beforeAnalysisRegisterButton.setPrefWidth(130);
                        beforeAnalysisRegisterButton.setFont(Font.font("Arial Black", 11.5));

                        beforeAnalysisNameOfPatientTextField.setPrefHeight(27);
                        beforeAnalysisNameOfPatientTextField.setPrefWidth(625);
                        beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 11.5));

                        beforeAnalysisNameOfProjectLabel.setPrefHeight(39);
                        beforeAnalysisNameOfProjectLabel.setPrefWidth(72);
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

                        beforeAnalysisLoginButton.setPrefHeight(42);
                        beforeAnalysisLoginButton.setPrefWidth(75);
                        beforeAnalysisLoginButton.setFont(Font.font("Arial Black", FontWeight.BOLD, 12));

                        beforeAnalysisRegisterButton.setPrefHeight(42);
                        beforeAnalysisRegisterButton.setPrefWidth(142);
                        beforeAnalysisRegisterButton.setFont(Font.font("Arial Black", 12));

                        beforeAnalysisNameOfPatientTextField.setPrefHeight(28);
                        beforeAnalysisNameOfPatientTextField.setPrefWidth(728);
                        beforeAnalysisNameOfPatientTextField.setFont(Font.font("System", 12));

                        beforeAnalysisNameOfProjectLabel.setPrefHeight(42);
                        beforeAnalysisNameOfProjectLabel.setPrefWidth(77);
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
                };
                newScene.heightProperty().addListener(sceneSizesChangeListener);

                ChangeListener<String> textFieldsTextChangers = (observable, oldValue, newValue) -> {
                    changingTheAnalysisStartButton();
                };

                beforeAnalysisNameOfPatientTextField.textProperty().addListener(textFieldsTextChangers);
                beforeAnalysisNameOfReportTextField.textProperty().addListener(textFieldsTextChangers);
            }
        });

    }

}
