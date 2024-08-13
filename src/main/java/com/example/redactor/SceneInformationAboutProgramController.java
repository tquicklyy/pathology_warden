package com.example.redactor;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class SceneInformationAboutProgramController {

    @FXML
    private BorderPane infoMenuBorderPane;

    @FXML
    private VBox infoMenuCenterColoredVBox;

    @FXML
    private Text infoMenuFifthText;

    @FXML
    private Label infoMenuFirstCenterLabel;

    @FXML
    private VBox infoMenuFirstCenterVBox;

    @FXML
    private Text infoMenuFirstText;

    @FXML
    private Label infoMenuFirstUpLabel;

    @FXML
    private VBox infoMenuFirstUpVBox;

    @FXML
    private Label infoMenuFourthCenterLabel;

    @FXML
    private Text infoMenuFourthText;

    @FXML
    private ImageView infoMenuIconImageView;

    @FXML
    private Label infoMenuNameOfProjectLabel;

    @FXML
    private Button infoMenuRegisterButton;

    @FXML
    private Label infoMenuSecondCenterLabel;

    @FXML
    private VBox infoMenuSecondCenterVBox;

    @FXML
    private Text infoMenuSecondText;

    @FXML
    private Label infoMenuSecondUpLabel;

    @FXML
    private VBox infoMenuSecondUpVBox;

    @FXML
    private TextFlow infoMenuTextFlow;

    @FXML
    private Label infoMenuThirdCenterLabel;

    @FXML
    private Text infoMenuThirdText;

    @FXML
    private HBox infoMenuTopHBox;

    private Stage currentStage;

    @FXML
    private void switchingToTheMainMenuForButton(ActionEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheMainMenuForNotButton(MouseEvent event) throws IOException {
        currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    private void InfoMenuBorderPaneSizeChanged() {
        double infoMenuBorderPaneWidth = infoMenuBorderPane.getWidth();
        double infoMenuBorderPaneHeight = infoMenuBorderPane.getHeight();
        if (infoMenuBorderPaneHeight < 610) {
            infoMenuIconImageView.setFitHeight(30);
            infoMenuIconImageView.setFitWidth(51);

            infoMenuNameOfProjectLabel.setPrefHeight(30);
            infoMenuNameOfProjectLabel.setPrefWidth(56);
            infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

            infoMenuTopHBox.setPrefHeight(37);

            infoMenuRegisterButton.setPrefHeight(30);
            infoMenuRegisterButton.setPrefWidth(150);
            infoMenuRegisterButton.setFont(Font.font("Arial Black", 10));

            infoMenuSecondUpVBox.setPrefHeight(106);

            infoMenuSecondUpLabel.setPrefHeight(54);

            infoMenuTextFlow.setPrefHeight(48);

            infoMenuSecondCenterVBox.setPrefHeight(274);

            infoMenuSecondCenterLabel.setPrefHeight(72);

            infoMenuThirdCenterLabel.setPrefHeight(110);

            infoMenuFourthCenterLabel.setPrefHeight(90);

            if (infoMenuBorderPaneWidth < 976) {
                infoMenuCenterColoredVBox.setPrefWidth(490);

                infoMenuSecondUpLabel.setPrefWidth(463);

                infoMenuTextFlow.setPrefWidth(463);

                infoMenuSecondCenterLabel.setPrefWidth(463);

                infoMenuThirdCenterLabel.setPrefWidth(463);

                infoMenuFourthCenterLabel.setPrefWidth(463);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                infoMenuSecondUpLabel.setFont(Font.font("System", 12));

                infoMenuFirstText.setFont(Font.font("System", 12));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 12));
                infoMenuThirdText.setFont(Font.font("System", 12));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 12));
                infoMenuFifthText.setFont(Font.font("System", 12));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 12));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 12));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 12));


            } else if (infoMenuBorderPaneWidth < 1212) {
                infoMenuCenterColoredVBox.setPrefWidth(726);

                infoMenuSecondUpLabel.setPrefWidth(699);

                infoMenuTextFlow.setPrefWidth(699);

                infoMenuSecondCenterLabel.setPrefWidth(699);

                infoMenuThirdCenterLabel.setPrefWidth(699);

                infoMenuFourthCenterLabel.setPrefWidth(699);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                infoMenuSecondUpLabel.setFont(Font.font("System", 13));

                infoMenuFirstText.setFont(Font.font("System", 13));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 13));
                infoMenuThirdText.setFont(Font.font("System", 13));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 13));
                infoMenuFifthText.setFont(Font.font("System", 13));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 13));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 13));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 13));

            } else if (infoMenuBorderPaneWidth < 1448) {
                infoMenuCenterColoredVBox.setPrefWidth(962);

                infoMenuSecondUpLabel.setPrefWidth(935);

                infoMenuTextFlow.setPrefWidth(935);

                infoMenuSecondCenterLabel.setPrefWidth(935);

                infoMenuThirdCenterLabel.setPrefWidth(935);

                infoMenuFourthCenterLabel.setPrefWidth(935);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondUpLabel.setFont(Font.font("System", 14));

                infoMenuFirstText.setFont(Font.font("System", 14));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 14));
                infoMenuThirdText.setFont(Font.font("System", 14));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 14));
                infoMenuFifthText.setFont(Font.font("System", 14));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 14));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 14));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 14));

            } else if (infoMenuBorderPaneWidth < 1684) {
                infoMenuCenterColoredVBox.setPrefWidth(1212);

                infoMenuSecondUpLabel.setPrefWidth(1184);

                infoMenuTextFlow.setPrefWidth(1184);

                infoMenuSecondCenterLabel.setPrefWidth(1184);

                infoMenuThirdCenterLabel.setPrefWidth(1184);

                infoMenuFourthCenterLabel.setPrefWidth(1184);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondUpLabel.setFont(Font.font("System", 15));

                infoMenuFirstText.setFont(Font.font("System", 15));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuThirdText.setFont(Font.font("System", 15));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuFifthText.setFont(Font.font("System", 15));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 15));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 15));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 15));

            } else {
                infoMenuCenterColoredVBox.setPrefWidth(1462);

                infoMenuSecondUpLabel.setPrefWidth(1435);

                infoMenuTextFlow.setPrefWidth(1435);

                infoMenuSecondCenterLabel.setPrefWidth(1435);

                infoMenuThirdCenterLabel.setPrefWidth(1435);

                infoMenuFourthCenterLabel.setPrefWidth(1435);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondUpLabel.setFont(Font.font("System", 16));

                infoMenuFirstText.setFont(Font.font("System", 16));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuThirdText.setFont(Font.font("System", 16));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuFifthText.setFont(Font.font("System", 16));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 16));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 16));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 16));
            }

        } else if (infoMenuBorderPaneHeight < 720) {
            infoMenuIconImageView.setFitHeight(33);
            infoMenuIconImageView.setFitWidth(56);

            infoMenuNameOfProjectLabel.setPrefHeight(33);
            infoMenuNameOfProjectLabel.setPrefWidth(61);
            infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

            infoMenuTopHBox.setPrefHeight(40);

            infoMenuRegisterButton.setPrefHeight(33);
            infoMenuRegisterButton.setPrefWidth(160);
            infoMenuRegisterButton.setFont(Font.font("Arial Black", 10.5));

            infoMenuSecondUpVBox.setPrefHeight(125);

            infoMenuSecondUpLabel.setPrefHeight(64);

            infoMenuTextFlow.setPrefHeight(48);

            infoMenuSecondCenterVBox.setPrefHeight(360);

            infoMenuSecondCenterLabel.setPrefHeight(76);

            infoMenuThirdCenterLabel.setPrefHeight(140);

            infoMenuFourthCenterLabel.setPrefHeight(95);

            if (infoMenuBorderPaneWidth < 976) {
                infoMenuCenterColoredVBox.setPrefWidth(490);

                infoMenuSecondUpLabel.setPrefWidth(463);

                infoMenuTextFlow.setPrefWidth(463);

                infoMenuSecondCenterLabel.setPrefWidth(463);

                infoMenuThirdCenterLabel.setPrefWidth(463);

                infoMenuFourthCenterLabel.setPrefWidth(463);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                infoMenuSecondUpLabel.setFont(Font.font("System", 13));

                infoMenuFirstText.setFont(Font.font("System", 13));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 13));
                infoMenuThirdText.setFont(Font.font("System", 13));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 13));
                infoMenuFifthText.setFont(Font.font("System", 13));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 13));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 13));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 13));


            } else if (infoMenuBorderPaneWidth < 1212) {
                infoMenuCenterColoredVBox.setPrefWidth(726);

                infoMenuSecondUpLabel.setPrefWidth(699);

                infoMenuTextFlow.setPrefWidth(699);

                infoMenuSecondCenterLabel.setPrefWidth(699);

                infoMenuThirdCenterLabel.setPrefWidth(699);

                infoMenuFourthCenterLabel.setPrefWidth(699);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondUpLabel.setFont(Font.font("System", 14));

                infoMenuFirstText.setFont(Font.font("System", 14));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 14));
                infoMenuThirdText.setFont(Font.font("System", 14));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 14));
                infoMenuFifthText.setFont(Font.font("System", 14));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 14));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 14));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 14));

            } else if (infoMenuBorderPaneWidth < 1448) {
                infoMenuCenterColoredVBox.setPrefWidth(962);

                infoMenuSecondUpLabel.setPrefWidth(935);

                infoMenuTextFlow.setPrefWidth(935);

                infoMenuSecondCenterLabel.setPrefWidth(935);

                infoMenuThirdCenterLabel.setPrefWidth(935);

                infoMenuFourthCenterLabel.setPrefWidth(935);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondUpLabel.setFont(Font.font("System", 15));

                infoMenuFirstText.setFont(Font.font("System", 15));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuThirdText.setFont(Font.font("System", 15));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuFifthText.setFont(Font.font("System", 15));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 15));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 15));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 15));

            } else if (infoMenuBorderPaneWidth < 1684) {
                infoMenuCenterColoredVBox.setPrefWidth(1212);

                infoMenuSecondUpLabel.setPrefWidth(1184);

                infoMenuTextFlow.setPrefWidth(1184);

                infoMenuSecondCenterLabel.setPrefWidth(1184);

                infoMenuThirdCenterLabel.setPrefWidth(1184);

                infoMenuFourthCenterLabel.setPrefWidth(1184);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondUpLabel.setFont(Font.font("System", 16));

                infoMenuFirstText.setFont(Font.font("System", 16));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuThirdText.setFont(Font.font("System", 16));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuFifthText.setFont(Font.font("System", 16));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 16));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 16));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 16));

            } else {
                infoMenuCenterColoredVBox.setPrefWidth(1462);

                infoMenuSecondUpLabel.setPrefWidth(1435);

                infoMenuTextFlow.setPrefWidth(1435);

                infoMenuSecondCenterLabel.setPrefWidth(1435);

                infoMenuThirdCenterLabel.setPrefWidth(1435);

                infoMenuFourthCenterLabel.setPrefWidth(1435);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondUpLabel.setFont(Font.font("System", 17));

                infoMenuFirstText.setFont(Font.font("System", 17));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuThirdText.setFont(Font.font("System", 17));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuFifthText.setFont(Font.font("System", 17));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 17));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 17));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 17));
            }

        } else if (infoMenuBorderPaneHeight < 830) {
            infoMenuIconImageView.setFitHeight(36);
            infoMenuIconImageView.setFitWidth(61);

            infoMenuNameOfProjectLabel.setPrefHeight(36);
            infoMenuNameOfProjectLabel.setPrefWidth(67);
            infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

            infoMenuTopHBox.setPrefHeight(43);

            infoMenuRegisterButton.setPrefHeight(36);
            infoMenuRegisterButton.setPrefWidth(170);
            infoMenuRegisterButton.setFont(Font.font("Arial Black", 11));

            infoMenuSecondUpVBox.setPrefHeight(136);

            infoMenuSecondUpLabel.setPrefHeight(64);

            infoMenuTextFlow.setPrefHeight(48);

            infoMenuSecondCenterVBox.setPrefHeight(393);

            infoMenuSecondCenterLabel.setPrefHeight(105);

            infoMenuThirdCenterLabel.setPrefHeight(140);

            infoMenuFourthCenterLabel.setPrefHeight(100);

            if (infoMenuBorderPaneWidth < 976) {
                infoMenuCenterColoredVBox.setPrefWidth(490);

                infoMenuSecondUpLabel.setPrefWidth(463);

                infoMenuTextFlow.setPrefWidth(463);

                infoMenuSecondCenterLabel.setPrefWidth(463);

                infoMenuThirdCenterLabel.setPrefWidth(463);

                infoMenuFourthCenterLabel.setPrefWidth(463);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondUpLabel.setFont(Font.font("System", 14));

                infoMenuFirstText.setFont(Font.font("System", 14));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 14));
                infoMenuThirdText.setFont(Font.font("System", 14));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 14));
                infoMenuFifthText.setFont(Font.font("System", 14));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 14));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 14));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 14));


            } else if (infoMenuBorderPaneWidth < 1212) {
                infoMenuCenterColoredVBox.setPrefWidth(726);

                infoMenuSecondUpLabel.setPrefWidth(699);

                infoMenuTextFlow.setPrefWidth(699);

                infoMenuSecondCenterLabel.setPrefWidth(699);

                infoMenuThirdCenterLabel.setPrefWidth(699);

                infoMenuFourthCenterLabel.setPrefWidth(699);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondUpLabel.setFont(Font.font("System", 15));

                infoMenuFirstText.setFont(Font.font("System", 15));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuThirdText.setFont(Font.font("System", 15));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuFifthText.setFont(Font.font("System", 15));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 15));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 15));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 15));

            } else if (infoMenuBorderPaneWidth < 1448) {
                infoMenuCenterColoredVBox.setPrefWidth(962);

                infoMenuSecondUpLabel.setPrefWidth(935);

                infoMenuTextFlow.setPrefWidth(935);

                infoMenuSecondCenterLabel.setPrefWidth(935);

                infoMenuThirdCenterLabel.setPrefWidth(935);

                infoMenuFourthCenterLabel.setPrefWidth(935);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondUpLabel.setFont(Font.font("System", 16));

                infoMenuFirstText.setFont(Font.font("System", 16));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuThirdText.setFont(Font.font("System", 16));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuFifthText.setFont(Font.font("System", 16));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 16));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 16));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 16));

            } else if (infoMenuBorderPaneWidth < 1684) {
                infoMenuCenterColoredVBox.setPrefWidth(1212);

                infoMenuSecondUpLabel.setPrefWidth(1184);

                infoMenuTextFlow.setPrefWidth(1184);

                infoMenuSecondCenterLabel.setPrefWidth(1184);

                infoMenuThirdCenterLabel.setPrefWidth(1184);

                infoMenuFourthCenterLabel.setPrefWidth(1184);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondUpLabel.setFont(Font.font("System", 17));

                infoMenuFirstText.setFont(Font.font("System", 17));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuThirdText.setFont(Font.font("System", 17));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuFifthText.setFont(Font.font("System", 17));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 17));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 17));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 17));

            } else {
                infoMenuCenterColoredVBox.setPrefWidth(1462);

                infoMenuSecondUpLabel.setPrefWidth(1435);

                infoMenuTextFlow.setPrefWidth(1435);

                infoMenuSecondCenterLabel.setPrefWidth(1435);

                infoMenuThirdCenterLabel.setPrefWidth(1435);

                infoMenuFourthCenterLabel.setPrefWidth(1435);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                infoMenuSecondUpLabel.setFont(Font.font("System", 18));

                infoMenuFirstText.setFont(Font.font("System", 18));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 18));
                infoMenuThirdText.setFont(Font.font("System", 18));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 18));
                infoMenuFifthText.setFont(Font.font("System", 18));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 18));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 18));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 18));
            }

        } else if (infoMenuBorderPaneHeight < 940) {
            infoMenuIconImageView.setFitHeight(39);
            infoMenuIconImageView.setFitWidth(66);

            infoMenuNameOfProjectLabel.setPrefHeight(39);
            infoMenuNameOfProjectLabel.setPrefWidth(72);
            infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

            infoMenuTopHBox.setPrefHeight(46);

            infoMenuRegisterButton.setPrefHeight(39);
            infoMenuRegisterButton.setPrefWidth(180);
            infoMenuRegisterButton.setFont(Font.font("Arial Black", 11.5));

            infoMenuSecondUpVBox.setPrefHeight(151);

            infoMenuSecondUpLabel.setPrefHeight(75);

            infoMenuTextFlow.setPrefHeight(48);

            infoMenuSecondCenterVBox.setPrefHeight(420);

            infoMenuSecondCenterLabel.setPrefHeight(105);

            infoMenuThirdCenterLabel.setPrefHeight(147);

            infoMenuFourthCenterLabel.setPrefHeight(126);

            if (infoMenuBorderPaneWidth < 976) {
                infoMenuCenterColoredVBox.setPrefWidth(490);

                infoMenuSecondUpLabel.setPrefWidth(463);

                infoMenuTextFlow.setPrefWidth(463);

                infoMenuSecondCenterLabel.setPrefWidth(463);

                infoMenuThirdCenterLabel.setPrefWidth(463);

                infoMenuFourthCenterLabel.setPrefWidth(463);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondUpLabel.setFont(Font.font("System", 15));

                infoMenuFirstText.setFont(Font.font("System", 15));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuThirdText.setFont(Font.font("System", 15));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 15));
                infoMenuFifthText.setFont(Font.font("System", 15));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 15));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 15));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 15));


            } else if (infoMenuBorderPaneWidth < 1212) {
                infoMenuCenterColoredVBox.setPrefWidth(726);

                infoMenuSecondUpLabel.setPrefWidth(699);

                infoMenuTextFlow.setPrefWidth(699);

                infoMenuSecondCenterLabel.setPrefWidth(699);

                infoMenuThirdCenterLabel.setPrefWidth(699);

                infoMenuFourthCenterLabel.setPrefWidth(699);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondUpLabel.setFont(Font.font("System", 16));

                infoMenuFirstText.setFont(Font.font("System", 16));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuThirdText.setFont(Font.font("System", 16));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuFifthText.setFont(Font.font("System", 16));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 16));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 16));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 16));

            } else if (infoMenuBorderPaneWidth < 1448) {
                infoMenuCenterColoredVBox.setPrefWidth(962);

                infoMenuSecondUpLabel.setPrefWidth(935);

                infoMenuTextFlow.setPrefWidth(935);

                infoMenuSecondCenterLabel.setPrefWidth(935);

                infoMenuThirdCenterLabel.setPrefWidth(935);

                infoMenuFourthCenterLabel.setPrefWidth(935);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondUpLabel.setFont(Font.font("System", 17));

                infoMenuFirstText.setFont(Font.font("System", 17));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuThirdText.setFont(Font.font("System", 17));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuFifthText.setFont(Font.font("System", 17));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 17));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 17));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 17));

            } else if (infoMenuBorderPaneWidth < 1684) {
                infoMenuCenterColoredVBox.setPrefWidth(1212);

                infoMenuSecondUpLabel.setPrefWidth(1184);

                infoMenuTextFlow.setPrefWidth(1184);

                infoMenuSecondCenterLabel.setPrefWidth(1184);

                infoMenuThirdCenterLabel.setPrefWidth(1184);

                infoMenuFourthCenterLabel.setPrefWidth(1184);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                infoMenuSecondUpLabel.setFont(Font.font("System", 18));

                infoMenuFirstText.setFont(Font.font("System", 18));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 18));
                infoMenuThirdText.setFont(Font.font("System", 18));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 18));
                infoMenuFifthText.setFont(Font.font("System", 18));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 18));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 18));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 18));

            } else {
                infoMenuCenterColoredVBox.setPrefWidth(1462);

                infoMenuSecondUpLabel.setPrefWidth(1435);

                infoMenuTextFlow.setPrefWidth(1435);

                infoMenuSecondCenterLabel.setPrefWidth(1435);

                infoMenuThirdCenterLabel.setPrefWidth(1435);

                infoMenuFourthCenterLabel.setPrefWidth(1435);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 23));

                infoMenuSecondUpLabel.setFont(Font.font("System", 19));

                infoMenuFirstText.setFont(Font.font("System", 19));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 19));
                infoMenuThirdText.setFont(Font.font("System", 19));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 19));
                infoMenuFifthText.setFont(Font.font("System", 19));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 23));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 19));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 19));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 19));
            }

        } else {
            infoMenuIconImageView.setFitHeight(42);
            infoMenuIconImageView.setFitWidth(71);

            infoMenuNameOfProjectLabel.setPrefHeight(42);
            infoMenuNameOfProjectLabel.setPrefWidth(77);
            infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

            infoMenuTopHBox.setPrefHeight(49);

            infoMenuRegisterButton.setPrefHeight(42);
            infoMenuRegisterButton.setPrefWidth(190);
            infoMenuRegisterButton.setFont(Font.font("Arial Black", 12));

            infoMenuSecondUpVBox.setPrefHeight(172);

            infoMenuSecondUpLabel.setPrefHeight(100);

            infoMenuTextFlow.setPrefHeight(48);

            infoMenuSecondCenterVBox.setPrefHeight(494);

            infoMenuSecondCenterLabel.setPrefHeight(125);

            infoMenuThirdCenterLabel.setPrefHeight(200);

            infoMenuFourthCenterLabel.setPrefHeight(150);

            if (infoMenuBorderPaneWidth < 976) {
                infoMenuCenterColoredVBox.setPrefWidth(490);

                infoMenuSecondUpLabel.setPrefWidth(463);

                infoMenuTextFlow.setPrefWidth(463);

                infoMenuSecondCenterLabel.setPrefWidth(463);

                infoMenuThirdCenterLabel.setPrefWidth(463);

                infoMenuFourthCenterLabel.setPrefWidth(463);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondUpLabel.setFont(Font.font("System", 16));

                infoMenuFirstText.setFont(Font.font("System", 16));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuThirdText.setFont(Font.font("System", 16));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 16));
                infoMenuFifthText.setFont(Font.font("System", 16));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 16));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 16));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 16));


            } else if (infoMenuBorderPaneWidth < 1212) {
                infoMenuCenterColoredVBox.setPrefWidth(726);

                infoMenuSecondUpLabel.setPrefWidth(699);

                infoMenuTextFlow.setPrefWidth(699);

                infoMenuSecondCenterLabel.setPrefWidth(699);

                infoMenuThirdCenterLabel.setPrefWidth(699);

                infoMenuFourthCenterLabel.setPrefWidth(699);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondUpLabel.setFont(Font.font("System", 17));

                infoMenuFirstText.setFont(Font.font("System", 17));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuThirdText.setFont(Font.font("System", 17));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 17));
                infoMenuFifthText.setFont(Font.font("System", 17));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 21));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 17));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 17));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 17));

            } else if (infoMenuBorderPaneWidth < 1448) {
                infoMenuCenterColoredVBox.setPrefWidth(962);

                infoMenuSecondUpLabel.setPrefWidth(935);

                infoMenuTextFlow.setPrefWidth(935);

                infoMenuSecondCenterLabel.setPrefWidth(935);

                infoMenuThirdCenterLabel.setPrefWidth(935);

                infoMenuFourthCenterLabel.setPrefWidth(935);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                infoMenuSecondUpLabel.setFont(Font.font("System", 18));

                infoMenuFirstText.setFont(Font.font("System", 18));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 18));
                infoMenuThirdText.setFont(Font.font("System", 18));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 18));
                infoMenuFifthText.setFont(Font.font("System", 18));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 22));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 18));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 18));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 18));

            } else if (infoMenuBorderPaneWidth < 1684) {
                infoMenuCenterColoredVBox.setPrefWidth(1212);

                infoMenuSecondUpLabel.setPrefWidth(1184);

                infoMenuTextFlow.setPrefWidth(1184);

                infoMenuSecondCenterLabel.setPrefWidth(1184);

                infoMenuThirdCenterLabel.setPrefWidth(1184);

                infoMenuFourthCenterLabel.setPrefWidth(1184);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 23));

                infoMenuSecondUpLabel.setFont(Font.font("System", 19));

                infoMenuFirstText.setFont(Font.font("System", 19));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 19));
                infoMenuThirdText.setFont(Font.font("System", 19));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 19));
                infoMenuFifthText.setFont(Font.font("System", 19));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 23));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 19));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 19));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 19));

            } else {
                infoMenuCenterColoredVBox.setPrefWidth(1462);

                infoMenuSecondUpLabel.setPrefWidth(1435);

                infoMenuTextFlow.setPrefWidth(1435);

                infoMenuSecondCenterLabel.setPrefWidth(1435);

                infoMenuThirdCenterLabel.setPrefWidth(1435);

                infoMenuFourthCenterLabel.setPrefWidth(1435);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 24));

                infoMenuSecondUpLabel.setFont(Font.font("System", 20));

                infoMenuFirstText.setFont(Font.font("System", 20));
                infoMenuSecondText.setFont(Font.font("System", FontWeight.BOLD, 20));
                infoMenuThirdText.setFont(Font.font("System", 20));
                infoMenuFourthText.setFont(Font.font("System", FontWeight.BOLD, 20));
                infoMenuFifthText.setFont(Font.font("System", 20));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 24));

                infoMenuSecondCenterLabel.setFont(Font.font("System", 20));

                infoMenuThirdCenterLabel.setFont(Font.font("System", 20));

                infoMenuFourthCenterLabel.setFont(Font.font("System", 20));
            }

        }
    }

    @FXML
    void initialize() {
        infoMenuFirstUpLabel.prefWidthProperty().bind(infoMenuCenterColoredVBox.widthProperty());
        infoMenuFirstCenterLabel.prefWidthProperty().bind(infoMenuCenterColoredVBox.widthProperty());

        infoMenuBorderPane.heightProperty().addListener((observable, oldValue, newValue) -> InfoMenuBorderPaneSizeChanged());
        infoMenuBorderPane.widthProperty().addListener((observable, oldValue, newValue) -> InfoMenuBorderPaneSizeChanged());
    }
}



