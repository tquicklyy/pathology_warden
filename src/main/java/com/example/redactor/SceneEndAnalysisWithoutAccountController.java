package com.example.redactor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneEndAnalysisWithoutAccountController {

    @FXML
    private Button EndAnalysisAddDotsButton;

    public BorderPane getEndAnalysisBorderPane() {
        return EndAnalysisBorderPane;
    }

    @FXML
    private BorderPane EndAnalysisBorderPane;


    @FXML
    private Label EndAnalysisCenterTopLabel;

    @FXML
    private Button EndAnalysisDeleteDotsButton;

    @FXML
    private ImageView EndAnalysisDownoladImageView;

    @FXML
    private AnchorPane EndAnalysisEditAnchorPane;

    @FXML
    private ColorPicker EndAnalysisEditColorPicker;

    @FXML
    private Label EndAnalysisEditColorPickerLabel;

    @FXML
    private HBox EndAnalysisEditHBox;

    @FXML
    private ImageView EndAnalysisEditImageView;

    public AnchorPane getEndAnalysisGeneralAnchorPane() {
        return EndAnalysisGeneralAnchorPane;
    }

    @FXML
    private AnchorPane EndAnalysisGeneralAnchorPane;

    public ImageView getEndAnalysisGeneralImageView() {
        return EndAnalysisGeneralImageView;
    }

    @FXML
    private ImageView EndAnalysisGeneralImageView;

    @FXML
    private ImageView EndAnalysisIconImageView;

    @FXML
    private Button EndAnalysisInfoButton;

    @FXML
    private Line EndAnalysisLine;

    @FXML
    private Button EndAnalysisLoginButton;

    public Label getEndAnalysisNameOfPatientLabel() {
        return EndAnalysisNameOfPatientLabel;
    }

    @FXML
    private Label EndAnalysisNameOfPatientLabel;

    @FXML
    private Label EndAnalysisNameOfProjectLabel;

    public Label getEndAnalysisNameOfReportLabel() {
        return EndAnalysisNameOfReportLabel;
    }

    @FXML
    private Label EndAnalysisNameOfReportLabel;

    @FXML
    private Button EndAnalysisRegisterButton;

    @FXML
    private Button EndAnalysisStartAnalysisButton;

    @FXML
    private HBox EndAnalysisTopHBox;

    @FXML
    private VBox EndAnalysisTopLabelVBox;

    private Stage currentStage;

    private boolean isEndAnalysisEditAnchorPaneClosed = true;

    private static double EndAnalysisEditClosedAnchorPaneWidth = 57;
    private static double EndAnalysisEditOpenedAnchorPaneWidth = 500;

    private static double EndAnalysisAddDotsButtonLayOutX = 68;
    private static double EndAnalysisDeleteDotsButtonLayOutX = 212;
    private static double EndAnalysisEditColorPickerLayOutX = 356;
    private static double EndAnalysisEditColorPickerLabelLayOutX = 381;

    @FXML
    private void switchingToTheMainMenu(MouseEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    public void openingClosingEditButtons(MouseEvent event) throws IOException {
        Timeline timeline = new Timeline();

        KeyValue kv1, kv2, kv3, kv4, keyValueWidth;
        KeyFrame keyFrame;

        EndAnalysisAddDotsButton.setLayoutX(0);
        EndAnalysisDeleteDotsButton.setLayoutX(0);
        EndAnalysisEditColorPicker.setLayoutX(0);
        EndAnalysisEditColorPickerLabel.setLayoutX(0);

        if (isEndAnalysisEditAnchorPaneClosed) {
            kv1 = new KeyValue(EndAnalysisAddDotsButton.layoutXProperty(), EndAnalysisAddDotsButtonLayOutX);
            kv2 = new KeyValue(EndAnalysisDeleteDotsButton.layoutXProperty(), EndAnalysisDeleteDotsButtonLayOutX);
            kv3 = new KeyValue(EndAnalysisEditColorPicker.layoutXProperty(), EndAnalysisEditColorPickerLayOutX);
            kv4 = new KeyValue(EndAnalysisEditColorPickerLabel.layoutXProperty(), EndAnalysisEditColorPickerLabelLayOutX);

            keyValueWidth = new KeyValue(EndAnalysisEditAnchorPane.prefWidthProperty(), EndAnalysisEditOpenedAnchorPaneWidth);
            keyFrame = new KeyFrame(Duration.seconds(0.2), kv1, kv2, kv3, kv4, keyValueWidth);
            timeline.getKeyFrames().add(keyFrame);

            EndAnalysisEditImageView.setImage(new Image(getClass().getResource("/images/button-for-photo-editing-after-open.png").toString()));

            EndAnalysisAddDotsButton.setVisible(true);
            EndAnalysisEditColorPicker.setVisible(true);
            EndAnalysisEditColorPickerLabel.setVisible(true);
            EndAnalysisDeleteDotsButton.setVisible(true);

            EndAnalysisAddDotsButton.setDisable(false);
            EndAnalysisEditColorPicker.setDisable(false);
            EndAnalysisEditColorPickerLabel.setDisable(false);
            EndAnalysisDeleteDotsButton.setDisable(false);

            isEndAnalysisEditAnchorPaneClosed = false;

        } else {
            keyValueWidth = new KeyValue(EndAnalysisEditAnchorPane.prefWidthProperty(), EndAnalysisEditClosedAnchorPaneWidth);
            keyFrame = new KeyFrame(Duration.seconds(0.2), keyValueWidth);
            timeline.getKeyFrames().add(keyFrame);

            EndAnalysisEditImageView.setImage(new Image(getClass().getResource("/images/button-for-photo-editing-before-open.png").toString()));

            EndAnalysisAddDotsButton.setVisible(false);
            EndAnalysisEditColorPicker.setVisible(false);
            EndAnalysisEditColorPickerLabel.setVisible(false);
            EndAnalysisDeleteDotsButton.setVisible(false);

            EndAnalysisAddDotsButton.setDisable(true);
            EndAnalysisEditColorPicker.setDisable(true);
            EndAnalysisEditColorPickerLabel.setDisable(true);
            EndAnalysisDeleteDotsButton.setDisable(true);

            isEndAnalysisEditAnchorPaneClosed = true;
        }

        timeline.play();
    }

    @FXML
    void initialize() {
        EndAnalysisBorderPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                ChangeListener<Number> sceneSizesChangeListener = (observable, oldValue, newValue) -> {
                    if(newValue.intValue() < 610) {
                        EndAnalysisGeneralAnchorPane.setPrefHeight(296);
                        EndAnalysisGeneralImageView.setFitHeight(296);

                        EndAnalysisTopHBox.setPrefHeight(37);
                        EndAnalysisTopHBox.setPrefWidth(743);

                        EndAnalysisCenterTopLabel.setPrefHeight(13);
                        EndAnalysisCenterTopLabel.setPrefWidth(320);
                        EndAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

                        EndAnalysisIconImageView.setFitHeight(30);
                        EndAnalysisIconImageView.setFitWidth(51);

                        EndAnalysisInfoButton.setPrefHeight(30);
                        EndAnalysisInfoButton.setPrefWidth(30);
                        EndAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));

                        EndAnalysisLoginButton.setPrefHeight(30);
                        EndAnalysisLoginButton.setPrefWidth(55);
                        EndAnalysisLoginButton.setFont(Font.font("Arial Black", 10));

                        EndAnalysisRegisterButton.setPrefHeight(30);
                        EndAnalysisRegisterButton.setPrefWidth(100);
                        EndAnalysisRegisterButton.setFont(Font.font("Arial Black", 10));

                        EndAnalysisNameOfProjectLabel.setPrefHeight(30);
                        EndAnalysisNameOfProjectLabel.setPrefWidth(56);
                        EndAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

                        EndAnalysisStartAnalysisButton.setPrefHeight(24);
                        EndAnalysisStartAnalysisButton.setPrefWidth(140);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 10));

                        if(isEndAnalysisEditAnchorPaneClosed) EndAnalysisEditAnchorPane.setPrefWidth(57);
                        else EndAnalysisEditAnchorPane.setPrefWidth(500);

                        EndAnalysisAddDotsButton.setLayoutX(0);
                        EndAnalysisDeleteDotsButton.setLayoutX(0);
                        EndAnalysisEditColorPicker.setLayoutX(0);
                        EndAnalysisEditColorPickerLabel.setLayoutX(0);

                        EndAnalysisEditClosedAnchorPaneWidth = 57;
                        EndAnalysisEditOpenedAnchorPaneWidth = 500;
                        EndAnalysisEditAnchorPane.setPrefHeight(37);

                        EndAnalysisAddDotsButtonLayOutX = 68;
                        EndAnalysisDeleteDotsButtonLayOutX = 212;
                        EndAnalysisEditColorPickerLayOutX = 356;
                        EndAnalysisEditColorPickerLabelLayOutX = 381;

                        EndAnalysisAddDotsButton.setLayoutX(EndAnalysisAddDotsButtonLayOutX);
                        EndAnalysisDeleteDotsButton.setLayoutX(EndAnalysisDeleteDotsButtonLayOutX);
                        EndAnalysisEditColorPicker.setLayoutX(EndAnalysisEditColorPickerLayOutX);
                        EndAnalysisEditColorPickerLabel.setLayoutX(EndAnalysisEditColorPickerLabelLayOutX);

                        EndAnalysisEditImageView.setFitWidth(46);
                        EndAnalysisEditImageView.setFitHeight(27);

                        EndAnalysisEditImageView.setLayoutY(5);

                        EndAnalysisAddDotsButton.setPrefHeight(25);
                        EndAnalysisAddDotsButton.setPrefWidth(138);
                        EndAnalysisAddDotsButton.setFont(Font.font("Arial Black", 10));

                        EndAnalysisDeleteDotsButton.setPrefHeight(25);
                        EndAnalysisDeleteDotsButton.setPrefWidth(138);
                        EndAnalysisDeleteDotsButton.setFont(Font.font("Arial Black", 10));

                        EndAnalysisEditColorPicker.setPrefWidth(138);
                        EndAnalysisEditColorPicker.setPrefHeight(25);

                        EndAnalysisEditColorPickerLabel.setPrefWidth(88);
                        EndAnalysisEditColorPickerLabel.setPrefHeight(25);
                        EndAnalysisEditColorPickerLabel.setFont(Font.font("Arial Black", 10));

                        EndAnalysisEditHBox.setPrefWidth(500);
                        EndAnalysisEditHBox.setPrefHeight(37);

                        EndAnalysisNameOfReportLabel.setPrefWidth(236);
                        EndAnalysisNameOfReportLabel.setPrefHeight(17);
                        EndAnalysisNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD, 10));

                        EndAnalysisNameOfPatientLabel.setPrefWidth(230);
                        EndAnalysisNameOfPatientLabel.setPrefHeight(17);
                        EndAnalysisNameOfPatientLabel.setFont(Font.font("System", FontWeight.BOLD, 10));

                        EndAnalysisLine.setEndY(29);

                        EndAnalysisDownoladImageView.setFitWidth(28);
                        EndAnalysisDownoladImageView.setFitHeight(28);

                        EndAnalysisStartAnalysisButton.setPrefHeight(24);
                        EndAnalysisStartAnalysisButton.setPrefWidth(150);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 10));
                    } else if(newValue.intValue() < 720) {
                        EndAnalysisGeneralAnchorPane.setPrefHeight(397);
                        EndAnalysisGeneralImageView.setFitHeight(397);

                        EndAnalysisTopHBox.setPrefHeight(40);
                        EndAnalysisTopHBox.setPrefWidth(743);

                        EndAnalysisCenterTopLabel.setPrefHeight(13);
                        EndAnalysisCenterTopLabel.setPrefWidth(420);
                        EndAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 15));

                        EndAnalysisIconImageView.setFitHeight(33);
                        EndAnalysisIconImageView.setFitWidth(56);

                        EndAnalysisInfoButton.setPrefHeight(33);
                        EndAnalysisInfoButton.setPrefWidth(33);
                        EndAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 15.5));

                        EndAnalysisLoginButton.setPrefHeight(33);
                        EndAnalysisLoginButton.setPrefWidth(60);
                        EndAnalysisLoginButton.setFont(Font.font("Arial Black", 10.5));

                        EndAnalysisRegisterButton.setPrefHeight(33);
                        EndAnalysisRegisterButton.setPrefWidth(110);
                        EndAnalysisRegisterButton.setFont(Font.font("Arial Black", 10.5));

                        EndAnalysisNameOfProjectLabel.setPrefHeight(33);
                        EndAnalysisNameOfProjectLabel.setPrefWidth(61);
                        EndAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

                        EndAnalysisStartAnalysisButton.setPrefHeight(25);
                        EndAnalysisStartAnalysisButton.setPrefWidth(187);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 10.5));

                        if(isEndAnalysisEditAnchorPaneClosed) EndAnalysisEditAnchorPane.setPrefWidth(61);
                        else EndAnalysisEditAnchorPane.setPrefWidth(550);

                        EndAnalysisEditClosedAnchorPaneWidth = 61;
                        EndAnalysisEditOpenedAnchorPaneWidth = 550;
                        EndAnalysisEditAnchorPane.setPrefHeight(38);

                        EndAnalysisAddDotsButtonLayOutX = 73;
                        EndAnalysisDeleteDotsButtonLayOutX = 232;
                        EndAnalysisEditColorPickerLayOutX = 391;
                        EndAnalysisEditColorPickerLabelLayOutX = 416;

                        EndAnalysisAddDotsButton.setLayoutX(EndAnalysisAddDotsButtonLayOutX);
                        EndAnalysisDeleteDotsButton.setLayoutX(EndAnalysisDeleteDotsButtonLayOutX);
                        EndAnalysisEditColorPicker.setLayoutX(EndAnalysisEditColorPickerLayOutX);
                        EndAnalysisEditColorPickerLabel.setLayoutX(EndAnalysisEditColorPickerLabelLayOutX);

                        EndAnalysisEditImageView.setFitWidth(48);
                        EndAnalysisEditImageView.setFitHeight(29);

                        EndAnalysisEditImageView.setLayoutY(4);

                        EndAnalysisAddDotsButton.setPrefHeight(26);
                        EndAnalysisAddDotsButton.setPrefWidth(153);
                        EndAnalysisAddDotsButton.setFont(Font.font("Arial Black", 10.5));

                        EndAnalysisDeleteDotsButton.setPrefHeight(26);
                        EndAnalysisDeleteDotsButton.setPrefWidth(153);
                        EndAnalysisDeleteDotsButton.setFont(Font.font("Arial Black", 10.5));

                        EndAnalysisEditColorPicker.setPrefWidth(153);
                        EndAnalysisEditColorPicker.setPrefHeight(26);

                        EndAnalysisEditColorPickerLabel.setPrefWidth(103);
                        EndAnalysisEditColorPickerLabel.setPrefHeight(26);
                        EndAnalysisEditColorPickerLabel.setFont(Font.font("Arial Black", 10.5));

                        EndAnalysisEditHBox.setPrefWidth(550);
                        EndAnalysisEditHBox.setPrefHeight(38);

                        EndAnalysisNameOfReportLabel.setPrefWidth(260);
                        EndAnalysisNameOfReportLabel.setPrefHeight(18);
                        EndAnalysisNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD, 10.5));

                        EndAnalysisNameOfPatientLabel.setPrefWidth(255);
                        EndAnalysisNameOfPatientLabel.setPrefHeight(18);
                        EndAnalysisNameOfPatientLabel.setFont(Font.font("System", FontWeight.BOLD, 10.5));

                        EndAnalysisLine.setEndY(30);

                        EndAnalysisDownoladImageView.setFitWidth(29);
                        EndAnalysisDownoladImageView.setFitHeight(29);

                        EndAnalysisStartAnalysisButton.setPrefHeight(26);
                        EndAnalysisStartAnalysisButton.setPrefWidth(165);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 10.5));
                    } else if(newValue.intValue() < 830) {
                        EndAnalysisGeneralAnchorPane.setPrefHeight(492);
                        EndAnalysisGeneralImageView.setFitHeight(492);

                        EndAnalysisTopHBox.setPrefHeight(43);
                        EndAnalysisTopHBox.setPrefWidth(743);

                        EndAnalysisCenterTopLabel.setPrefHeight(13);
                        EndAnalysisCenterTopLabel.setPrefWidth(520);
                        EndAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                        EndAnalysisIconImageView.setFitHeight(36);
                        EndAnalysisIconImageView.setFitWidth(61);

                        EndAnalysisInfoButton.setPrefHeight(36);
                        EndAnalysisInfoButton.setPrefWidth(36);
                        EndAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

                        EndAnalysisLoginButton.setPrefHeight(36);
                        EndAnalysisLoginButton.setPrefWidth(65);
                        EndAnalysisLoginButton.setFont(Font.font("Arial Black", 11));

                        EndAnalysisRegisterButton.setPrefHeight(36);
                        EndAnalysisRegisterButton.setPrefWidth(120);
                        EndAnalysisRegisterButton.setFont(Font.font("Arial Black", 11));

                        EndAnalysisNameOfProjectLabel.setPrefHeight(36);
                        EndAnalysisNameOfProjectLabel.setPrefWidth(67);
                        EndAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

                        EndAnalysisStartAnalysisButton.setPrefHeight(26);
                        EndAnalysisStartAnalysisButton.setPrefWidth(232);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 11));

                        if(isEndAnalysisEditAnchorPaneClosed) EndAnalysisEditAnchorPane.setPrefWidth(65);
                        else EndAnalysisEditAnchorPane.setPrefWidth(600);

                        EndAnalysisEditClosedAnchorPaneWidth = 65;
                        EndAnalysisEditOpenedAnchorPaneWidth = 600;
                        EndAnalysisEditAnchorPane.setPrefHeight(39);

                        EndAnalysisAddDotsButtonLayOutX = 78;
                        EndAnalysisDeleteDotsButtonLayOutX = 252;
                        EndAnalysisEditColorPickerLayOutX = 426;
                        EndAnalysisEditColorPickerLabelLayOutX= 451;

                        EndAnalysisAddDotsButton.setLayoutX(EndAnalysisAddDotsButtonLayOutX);
                        EndAnalysisDeleteDotsButton.setLayoutX(EndAnalysisDeleteDotsButtonLayOutX);
                        EndAnalysisEditColorPicker.setLayoutX(EndAnalysisEditColorPickerLayOutX);
                        EndAnalysisEditColorPickerLabel.setLayoutX(EndAnalysisEditColorPickerLabelLayOutX);

                        EndAnalysisEditImageView.setFitWidth(50);
                        EndAnalysisEditImageView.setFitHeight(31);

                        EndAnalysisEditImageView.setLayoutY(4);

                        EndAnalysisAddDotsButton.setPrefHeight(27);
                        EndAnalysisAddDotsButton.setPrefWidth(168);
                        EndAnalysisAddDotsButton.setFont(Font.font("Arial Black", 11));

                        EndAnalysisDeleteDotsButton.setPrefHeight(27);
                        EndAnalysisDeleteDotsButton.setPrefWidth(168);
                        EndAnalysisDeleteDotsButton.setFont(Font.font("Arial Black", 11));

                        EndAnalysisEditColorPicker.setPrefWidth(168);
                        EndAnalysisEditColorPicker.setPrefHeight(27);

                        EndAnalysisEditColorPickerLabel.setPrefWidth(118);
                        EndAnalysisEditColorPickerLabel.setPrefHeight(27);
                        EndAnalysisEditColorPickerLabel.setFont(Font.font("Arial Black", 11));

                        EndAnalysisEditHBox.setPrefWidth(600);
                        EndAnalysisEditHBox.setPrefHeight(39);

                        EndAnalysisNameOfReportLabel.setPrefWidth(284);
                        EndAnalysisNameOfReportLabel.setPrefHeight(18);
                        EndAnalysisNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD, 11));

                        EndAnalysisNameOfPatientLabel.setPrefWidth(280);
                        EndAnalysisNameOfPatientLabel.setPrefHeight(18);
                        EndAnalysisNameOfPatientLabel.setFont(Font.font("System", FontWeight.BOLD, 11));

                        EndAnalysisLine.setEndY(31);

                        EndAnalysisDownoladImageView.setFitWidth(30);
                        EndAnalysisDownoladImageView.setFitHeight(30);

                        EndAnalysisStartAnalysisButton.setPrefHeight(27);
                        EndAnalysisStartAnalysisButton.setPrefWidth(180);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 11));
                    } else if (newValue.intValue() < 940) {
                        EndAnalysisGeneralAnchorPane.setPrefHeight(625);
                        EndAnalysisGeneralImageView.setFitHeight(625);

                        EndAnalysisTopHBox.setPrefHeight(46);
                        EndAnalysisTopHBox.setPrefWidth(743);

                        EndAnalysisCenterTopLabel.setPrefHeight(13);
                        EndAnalysisCenterTopLabel.setPrefWidth(625);
                        EndAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                        EndAnalysisIconImageView.setFitHeight(39);
                        EndAnalysisIconImageView.setFitWidth(66);

                        EndAnalysisInfoButton.setPrefHeight(39);
                        EndAnalysisInfoButton.setPrefWidth(39);
                        EndAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 16.5));

                        EndAnalysisLoginButton.setPrefHeight(39);
                        EndAnalysisLoginButton.setPrefWidth(70);
                        EndAnalysisLoginButton.setFont(Font.font("Arial Black", 11.5));

                        EndAnalysisRegisterButton.setPrefHeight(39);
                        EndAnalysisRegisterButton.setPrefWidth(130);
                        EndAnalysisRegisterButton.setFont(Font.font("Arial Black", 11.5));

                        EndAnalysisNameOfProjectLabel.setPrefHeight(39);
                        EndAnalysisNameOfProjectLabel.setPrefWidth(72);
                        EndAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

                        EndAnalysisStartAnalysisButton.setPrefHeight(27);
                        EndAnalysisStartAnalysisButton.setPrefWidth(279);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 11.5));

                        if(isEndAnalysisEditAnchorPaneClosed) EndAnalysisEditAnchorPane.setPrefWidth(69);
                        else EndAnalysisEditAnchorPane.setPrefWidth(650);

                        EndAnalysisEditClosedAnchorPaneWidth = 69;
                        EndAnalysisEditOpenedAnchorPaneWidth = 650;
                        EndAnalysisEditAnchorPane.setPrefHeight(40);

                        EndAnalysisAddDotsButtonLayOutX = 83;
                        EndAnalysisDeleteDotsButtonLayOutX = 272;
                        EndAnalysisEditColorPickerLayOutX = 461;
                        EndAnalysisEditColorPickerLabelLayOutX = 486;

                        EndAnalysisAddDotsButton.setLayoutX(EndAnalysisAddDotsButtonLayOutX);
                        EndAnalysisDeleteDotsButton.setLayoutX(EndAnalysisDeleteDotsButtonLayOutX);
                        EndAnalysisEditColorPicker.setLayoutX(EndAnalysisEditColorPickerLayOutX);
                        EndAnalysisEditColorPickerLabel.setLayoutX(EndAnalysisEditColorPickerLabelLayOutX);

                        EndAnalysisEditImageView.setFitWidth(53);
                        EndAnalysisEditImageView.setFitHeight(33);

                        EndAnalysisEditImageView.setLayoutY(3);

                        EndAnalysisAddDotsButton.setPrefHeight(28);
                        EndAnalysisAddDotsButton.setPrefWidth(183);
                        EndAnalysisAddDotsButton.setFont(Font.font("Arial Black", 11.5));

                        EndAnalysisDeleteDotsButton.setPrefHeight(28);
                        EndAnalysisDeleteDotsButton.setPrefWidth(183);
                        EndAnalysisDeleteDotsButton.setFont(Font.font("Arial Black", 11.5));

                        EndAnalysisEditColorPicker.setPrefWidth(183);
                        EndAnalysisEditColorPicker.setPrefHeight(28);

                        EndAnalysisEditColorPickerLabel.setPrefWidth(133);
                        EndAnalysisEditColorPickerLabel.setPrefHeight(28);
                        EndAnalysisEditColorPickerLabel.setFont(Font.font("Arial Black", 11.5));

                        EndAnalysisEditHBox.setPrefWidth(650);
                        EndAnalysisEditHBox.setPrefHeight(40);

                        EndAnalysisNameOfReportLabel.setPrefWidth(308);
                        EndAnalysisNameOfReportLabel.setPrefHeight(19);
                        EndAnalysisNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD, 11.5));

                        EndAnalysisNameOfPatientLabel.setPrefWidth(305);
                        EndAnalysisNameOfPatientLabel.setPrefHeight(19);
                        EndAnalysisNameOfPatientLabel.setFont(Font.font("System", FontWeight.BOLD, 11.5));

                        EndAnalysisLine.setEndY(32);

                        EndAnalysisDownoladImageView.setFitWidth(31);
                        EndAnalysisDownoladImageView.setFitHeight(31);

                        EndAnalysisStartAnalysisButton.setPrefHeight(28);
                        EndAnalysisStartAnalysisButton.setPrefWidth(195);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 11.5));
                    } else {
                        EndAnalysisGeneralAnchorPane.setPrefHeight(700.8);
                        EndAnalysisGeneralImageView.setFitHeight(700.8);

                        EndAnalysisTopHBox.setPrefHeight(49);
                        EndAnalysisTopHBox.setPrefWidth(743);

                        EndAnalysisCenterTopLabel.setPrefHeight(13);
                        EndAnalysisCenterTopLabel.setPrefWidth(728);
                        EndAnalysisCenterTopLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                        EndAnalysisIconImageView.setFitHeight(42);
                        EndAnalysisIconImageView.setFitWidth(71);

                        EndAnalysisInfoButton.setPrefHeight(42);
                        EndAnalysisInfoButton.setPrefWidth(42);
                        EndAnalysisInfoButton.setFont(Font.font("Arial", FontWeight.BOLD, 17));

                        EndAnalysisLoginButton.setPrefHeight(42);
                        EndAnalysisLoginButton.setPrefWidth(75);
                        EndAnalysisLoginButton.setFont(Font.font("Arial Black", FontWeight.BOLD, 12));

                        EndAnalysisRegisterButton.setPrefHeight(42);
                        EndAnalysisRegisterButton.setPrefWidth(142);
                        EndAnalysisRegisterButton.setFont(Font.font("Arial Black", 12));

                        EndAnalysisNameOfProjectLabel.setPrefHeight(42);
                        EndAnalysisNameOfProjectLabel.setPrefWidth(77);
                        EndAnalysisNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

                        EndAnalysisStartAnalysisButton.setPrefHeight(28);
                        EndAnalysisStartAnalysisButton.setPrefWidth(325);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 12));

                        if(isEndAnalysisEditAnchorPaneClosed) EndAnalysisEditAnchorPane.setPrefWidth(73);
                        else EndAnalysisEditAnchorPane.setPrefWidth(700);

                        EndAnalysisEditClosedAnchorPaneWidth = 73;
                        EndAnalysisEditOpenedAnchorPaneWidth = 700;
                        EndAnalysisEditAnchorPane.setPrefHeight(41);

                        EndAnalysisAddDotsButtonLayOutX = 88;
                        EndAnalysisDeleteDotsButtonLayOutX = 292;
                        EndAnalysisEditColorPickerLayOutX = 496;
                        EndAnalysisEditColorPickerLabelLayOutX = 521;

                        EndAnalysisAddDotsButton.setLayoutX(EndAnalysisAddDotsButtonLayOutX);
                        EndAnalysisDeleteDotsButton.setLayoutX(EndAnalysisDeleteDotsButtonLayOutX);
                        EndAnalysisEditColorPicker.setLayoutX(EndAnalysisEditColorPickerLayOutX);
                        EndAnalysisEditColorPickerLabel.setLayoutX(EndAnalysisEditColorPickerLabelLayOutX);

                        EndAnalysisEditImageView.setFitWidth(56);
                        EndAnalysisEditImageView.setFitHeight(33);

                        EndAnalysisEditImageView.setLayoutY(3);

                        EndAnalysisAddDotsButton.setPrefHeight(29);
                        EndAnalysisAddDotsButton.setPrefWidth(198);
                        EndAnalysisAddDotsButton.setFont(Font.font("Arial Black", 12));

                        EndAnalysisDeleteDotsButton.setPrefHeight(29);
                        EndAnalysisDeleteDotsButton.setPrefWidth(198);
                        EndAnalysisDeleteDotsButton.setFont(Font.font("Arial Black", 12));

                        EndAnalysisEditColorPicker.setPrefWidth(198);
                        EndAnalysisEditColorPicker.setPrefHeight(29);

                        EndAnalysisEditColorPickerLabel.setPrefWidth(148);
                        EndAnalysisEditColorPickerLabel.setPrefHeight(29);
                        EndAnalysisEditColorPickerLabel.setFont(Font.font("Arial Black", 12));

                        EndAnalysisEditHBox.setPrefWidth(700);
                        EndAnalysisEditHBox.setPrefHeight(41);

                        EndAnalysisNameOfReportLabel.setPrefWidth(332);
                        EndAnalysisNameOfReportLabel.setPrefHeight(19);
                        EndAnalysisNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD, 12));

                        EndAnalysisNameOfPatientLabel.setPrefWidth(330);
                        EndAnalysisNameOfPatientLabel.setPrefHeight(19);
                        EndAnalysisNameOfPatientLabel.setFont(Font.font("System", FontWeight.BOLD, 12));

                        EndAnalysisLine.setEndY(33);

                        EndAnalysisDownoladImageView.setFitWidth(32);
                        EndAnalysisDownoladImageView.setFitHeight(32);

                        EndAnalysisStartAnalysisButton.setPrefHeight(29);
                        EndAnalysisStartAnalysisButton.setPrefWidth(210);
                        EndAnalysisStartAnalysisButton.setFont(Font.font("Arial Black", 12));
                    }
                };
                newScene.heightProperty().addListener(sceneSizesChangeListener);
            }
        });
    }

}
