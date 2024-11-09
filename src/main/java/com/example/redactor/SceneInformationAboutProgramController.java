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
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SceneInformationAboutProgramController {

    @FXML
    private BorderPane infoMenuBorderPane;

    @FXML
    private VBox infoMenuCenterColoredVBox;

    @FXML
    private Text infoMenuThirdUpTextFlowFifthText;

    @FXML
    private Label infoMenuFirstCenterLabel;

    @FXML
    private VBox infoMenuFirstCenterVBox;

    @FXML
    private Text infoMenuThirdUpTextFlowFirstText;

    @FXML
    private Label infoMenuFirstUpLabel;

    @FXML
    private VBox infoMenuFirstUpVBox;

    @FXML
    private TextFlow infoMenuFourthCenterTextFlow;

    @FXML
    private Text infoMenuThirdUpTextFlowFourthText;

    @FXML
    private ImageView infoMenuIconImageView;

    @FXML
    private Label infoMenuNameOfProjectLabel;

    @FXML
    private Button infoMenuRegisterButton;

    @FXML
    private TextFlow infoMenuSecondCenterTextFlow;

    @FXML
    private VBox infoMenuSecondCenterVBox;

    @FXML
    private Text infoMenuThirdUpTextFlowSecondText;

    @FXML
    private TextFlow infoMenuSecondUpTextFlow;

    @FXML
    private VBox infoMenuSecondUpVBox;

    @FXML
    private TextFlow infoMenuTextFlow;

    @FXML
    private TextFlow infoMenuThirdCenterTextFlow;

    @FXML
    private TextFlow infoMenuThirdUpTextFlow;

    @FXML
    private Text infoMenuThirdUpTextFlowThirdText;

    @FXML
    private Text infoMenuSecondUpText;

    @FXML
    private Text infoMenuSecondCenterText;

    @FXML
    private Text infoMenuThirdCenterText;

    @FXML
    private Text infoMenuFourthCenterText;

    @FXML
    private HBox infoMenuTopHBox;

    private Stage currentStage;

    private Scene newScene;

    @FXML
    private void switchingToTheMainMenuForButton(ActionEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader;
        if(!UserSession.isIsLogged()) {
            fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-without-acc.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
        }
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheMainMenuForNotButton(MouseEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader;
        if(!UserSession.isIsLogged()) {
            fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-without-acc.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
        }
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    void initialize() {
        infoMenuFirstUpLabel.prefWidthProperty().bind(infoMenuCenterColoredVBox.widthProperty());
        infoMenuFirstCenterLabel.prefWidthProperty().bind(infoMenuCenterColoredVBox.widthProperty());

        infoMenuBorderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() < 610) {
                infoMenuIconImageView.setFitHeight(30);
                infoMenuIconImageView.setFitWidth(51);

                infoMenuNameOfProjectLabel.setPrefHeight(30);
                infoMenuNameOfProjectLabel.setPrefWidth(56);
                infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

                infoMenuTopHBox.setPrefHeight(37);

                infoMenuRegisterButton.setPrefHeight(30);
                infoMenuRegisterButton.setPrefWidth(150);
                infoMenuRegisterButton.setFont(Font.font("Arial Black", 10));

            } else if (newValue.doubleValue() < 720) {
                infoMenuIconImageView.setFitHeight(33);
                infoMenuIconImageView.setFitWidth(56);

                infoMenuNameOfProjectLabel.setPrefHeight(33);
                infoMenuNameOfProjectLabel.setPrefWidth(61);
                infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

                infoMenuTopHBox.setPrefHeight(40);

                infoMenuRegisterButton.setPrefHeight(33);
                infoMenuRegisterButton.setPrefWidth(160);
                infoMenuRegisterButton.setFont(Font.font("Arial Black", 10.5));

            } else if (newValue.doubleValue() < 830) {
                infoMenuIconImageView.setFitHeight(36);
                infoMenuIconImageView.setFitWidth(61);

                infoMenuNameOfProjectLabel.setPrefHeight(36);
                infoMenuNameOfProjectLabel.setPrefWidth(66);
                infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

                infoMenuTopHBox.setPrefHeight(43);

                infoMenuRegisterButton.setPrefHeight(36);
                infoMenuRegisterButton.setPrefWidth(170);
                infoMenuRegisterButton.setFont(Font.font("Arial Black", 11));

            } else if (newValue.doubleValue() < 940) {
                infoMenuIconImageView.setFitHeight(39);
                infoMenuIconImageView.setFitWidth(66);

                infoMenuNameOfProjectLabel.setPrefHeight(39);
                infoMenuNameOfProjectLabel.setPrefWidth(71);
                infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

                infoMenuTopHBox.setPrefHeight(46);

                infoMenuRegisterButton.setPrefHeight(39);
                infoMenuRegisterButton.setPrefWidth(180);
                infoMenuRegisterButton.setFont(Font.font("Arial Black", 11.5));
            } else {
                infoMenuIconImageView.setFitHeight(42);
                infoMenuIconImageView.setFitWidth(71);

                infoMenuNameOfProjectLabel.setPrefHeight(42);
                infoMenuNameOfProjectLabel.setPrefWidth(76);
                infoMenuNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

                infoMenuTopHBox.setPrefHeight(49);

                infoMenuRegisterButton.setPrefHeight(42);
                infoMenuRegisterButton.setPrefWidth(190);
                infoMenuRegisterButton.setFont(Font.font("Arial Black", 12));
            }
        });
        infoMenuBorderPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() < 976) {
                infoMenuCenterColoredVBox.setPrefWidth(490);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                infoMenuSecondUpTextFlow.setPrefHeight(54);
                infoMenuSecondUpTextFlow.setPrefWidth(439);
                infoMenuSecondUpText.setFont(Font.font("System", 12));

                infoMenuThirdUpTextFlow.setPrefHeight(48);
                infoMenuThirdUpTextFlow.setPrefWidth(439);

                infoMenuThirdUpTextFlowFirstText.setFont(Font.font("System", 12));
                infoMenuThirdUpTextFlowSecondText.setFont(Font.font("System", FontPosture.ITALIC, 12));
                infoMenuThirdUpTextFlowThirdText.setFont(Font.font("System", 12));
                infoMenuThirdUpTextFlowFourthText.setFont(Font.font("System", FontPosture.ITALIC, 12));
                infoMenuThirdUpTextFlowFifthText.setFont(Font.font("System", 12));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

                infoMenuSecondCenterTextFlow.setPrefHeight(72);
                infoMenuSecondCenterTextFlow.setPrefWidth(439);
                infoMenuSecondCenterText.setFont(Font.font("System", 12));

                infoMenuThirdCenterTextFlow.setPrefHeight(103);
                infoMenuThirdCenterTextFlow.setPrefWidth(439);
                infoMenuThirdCenterText.setFont(Font.font("System", 12));

                infoMenuFourthCenterTextFlow.setPrefHeight(85);
                infoMenuFourthCenterTextFlow.setPrefWidth(439);
                infoMenuFourthCenterText.setFont(Font.font("System", 12));

            } else if (newValue.doubleValue() < 1212) {
                infoMenuCenterColoredVBox.setPrefWidth(629);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                infoMenuSecondUpTextFlow.setPrefHeight(48);
                infoMenuSecondUpTextFlow.setPrefWidth(578);
                infoMenuSecondUpText.setFont(Font.font("System", 13));

                infoMenuThirdUpTextFlow.setPrefHeight(48);
                infoMenuThirdUpTextFlow.setPrefWidth(578);

                infoMenuThirdUpTextFlowFirstText.setFont(Font.font("System", 13));
                infoMenuThirdUpTextFlowSecondText.setFont(Font.font("System", FontPosture.ITALIC, 13));
                infoMenuThirdUpTextFlowThirdText.setFont(Font.font("System", 13));
                infoMenuThirdUpTextFlowFourthText.setFont(Font.font("System", FontPosture.ITALIC, 13));
                infoMenuThirdUpTextFlowFifthText.setFont(Font.font("System", 13));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 17));

                infoMenuSecondCenterTextFlow.setPrefHeight(72);
                infoMenuSecondCenterTextFlow.setPrefWidth(578);
                infoMenuSecondCenterText.setFont(Font.font("System", 13));

                infoMenuThirdCenterTextFlow.setPrefHeight(103);
                infoMenuThirdCenterTextFlow.setPrefWidth(578);
                infoMenuThirdCenterText.setFont(Font.font("System", 13));

                infoMenuFourthCenterTextFlow.setPrefHeight(85);
                infoMenuFourthCenterTextFlow.setPrefWidth(578);
                infoMenuFourthCenterText.setFont(Font.font("System", 13));

            } else if (newValue.doubleValue() < 1448) {
                infoMenuCenterColoredVBox.setPrefWidth(673);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondUpTextFlow.setPrefHeight(48);
                infoMenuSecondUpTextFlow.setPrefWidth(622);
                infoMenuSecondUpText.setFont(Font.font("System", 14));

                infoMenuThirdUpTextFlow.setPrefHeight(48);
                infoMenuThirdUpTextFlow.setPrefWidth(622);

                infoMenuThirdUpTextFlowFirstText.setFont(Font.font("System", 14));
                infoMenuThirdUpTextFlowSecondText.setFont(Font.font("System", FontPosture.ITALIC, 14));
                infoMenuThirdUpTextFlowThirdText.setFont(Font.font("System", 14));
                infoMenuThirdUpTextFlowFourthText.setFont(Font.font("System", FontPosture.ITALIC, 14));
                infoMenuThirdUpTextFlowFifthText.setFont(Font.font("System", 14));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

                infoMenuSecondCenterTextFlow.setPrefHeight(72);
                infoMenuSecondCenterTextFlow.setPrefWidth(622);
                infoMenuSecondCenterText.setFont(Font.font("System", 14));

                infoMenuThirdCenterTextFlow.setPrefHeight(103);
                infoMenuThirdCenterTextFlow.setPrefWidth(622);
                infoMenuThirdCenterText.setFont(Font.font("System", 14));

                infoMenuFourthCenterTextFlow.setPrefHeight(85);
                infoMenuFourthCenterTextFlow.setPrefWidth(622);
                infoMenuFourthCenterText.setFont(Font.font("System", 14));

            } else if (newValue.doubleValue() < 1684) {
                infoMenuCenterColoredVBox.setPrefWidth(818);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondUpTextFlow.setPrefHeight(48);
                infoMenuSecondUpTextFlow.setPrefWidth(767);
                infoMenuSecondUpText.setFont(Font.font("System", 15));

                infoMenuThirdUpTextFlow.setPrefHeight(48);
                infoMenuThirdUpTextFlow.setPrefWidth(767);

                infoMenuThirdUpTextFlowFirstText.setFont(Font.font("System", 15));
                infoMenuThirdUpTextFlowSecondText.setFont(Font.font("System", FontPosture.ITALIC, 15));
                infoMenuThirdUpTextFlowThirdText.setFont(Font.font("System", 15));
                infoMenuThirdUpTextFlowFourthText.setFont(Font.font("System", FontPosture.ITALIC, 15));
                infoMenuThirdUpTextFlowFifthText.setFont(Font.font("System", 15));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 19));

                infoMenuSecondCenterTextFlow.setPrefHeight(72);
                infoMenuSecondCenterTextFlow.setPrefWidth(767);
                infoMenuSecondCenterText.setFont(Font.font("System", 15));

                infoMenuThirdCenterTextFlow.setPrefHeight(103);
                infoMenuThirdCenterTextFlow.setPrefWidth(767);
                infoMenuThirdCenterText.setFont(Font.font("System", 15));

                infoMenuFourthCenterTextFlow.setPrefHeight(85);
                infoMenuFourthCenterTextFlow.setPrefWidth(767);
                infoMenuFourthCenterText.setFont(Font.font("System", 15));
            } else {
                infoMenuCenterColoredVBox.setPrefWidth(889);

                infoMenuFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondUpTextFlow.setPrefHeight(50);
                infoMenuSecondUpTextFlow.setPrefWidth(838);
                infoMenuSecondUpText.setFont(Font.font("System", 16));

                infoMenuThirdUpTextFlow.setPrefHeight(48);
                infoMenuThirdUpTextFlow.setPrefWidth(838);

                infoMenuThirdUpTextFlowFirstText.setFont(Font.font("System", 16));
                infoMenuThirdUpTextFlowSecondText.setFont(Font.font("System", FontPosture.ITALIC, 16));
                infoMenuThirdUpTextFlowThirdText.setFont(Font.font("System", 16));
                infoMenuThirdUpTextFlowFourthText.setFont(Font.font("System", FontPosture.ITALIC, 16));
                infoMenuThirdUpTextFlowFifthText.setFont(Font.font("System", 16));

                infoMenuFirstCenterLabel.setFont(Font.font("System", FontWeight.BOLD, 20));

                infoMenuSecondCenterTextFlow.setPrefHeight(75);
                infoMenuSecondCenterTextFlow.setPrefWidth(838);
                infoMenuSecondCenterText.setFont(Font.font("System", 16));

                infoMenuThirdCenterTextFlow.setPrefHeight(103);
                infoMenuThirdCenterTextFlow.setPrefWidth(838);
                infoMenuThirdCenterText.setFont(Font.font("System", 16));

                infoMenuFourthCenterTextFlow.setPrefHeight(85);
                infoMenuFourthCenterTextFlow.setPrefWidth(838);
                infoMenuFourthCenterText.setFont(Font.font("System", 16));
            }
        });
    }
}



