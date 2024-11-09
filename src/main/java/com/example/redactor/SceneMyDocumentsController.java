package com.example.redactor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SceneMyDocumentsController {

    @FXML
    private ScrollPane myDocumentsScrollPane;

    @FXML
    private BorderPane myDocumentsBorderPane;

    @FXML
    private VBox myDocumentsCenterColoredVBox;

    @FXML
    private Label myDocumentsFirstUpLabel;

    @FXML
    private Label myDocumentsSecondUpLabel;

    @FXML
    private ImageView myDocumentsIconImageView;

    @FXML
    private Label myDocumentsNameOfProjectLabel;

    @FXML
    private Button myDocumentsBackButton;

    @FXML
    private HBox myDocumentsTopHBox;

    private Stage currentStage;

    private Scene newScene;

    public static SceneMyDocumentsController currentSceneMyDocumentsController;

    public static HashMap<String, HBox> sceneMyDocumentsMyDocumentsEditHBox = new HashMap<>();
    public static HashMap<String, Label> sceneMyDocumentsMyDocumentsNameOfReportLabel = new HashMap<>();
    public static HashMap<String, Line> sceneMyDocumentsMyDocumentsLine = new HashMap<>();
    public static HashMap<String, Label> sceneMyDocumentsMyDocumentsNameOfPatientLabel = new HashMap<>();
    public static HashMap<String, ImageView> sceneMyDocumentsMyDocumentsDeleteImageView = new HashMap<>();

    @FXML
    private void switchingToTheMainMenuForButton(ActionEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    @FXML
    private void switchingToTheMainMenuForNotButton(MouseEvent event) throws IOException {
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu-with-acc.fxml"));
        newScene = new Scene(fxmlLoader.load(), currentStage.getScene().getWidth(), currentStage.getScene().getHeight());
        currentStage.setScene(newScene);
    }

    public static void createHBox() {
        HBox myDocumentsEditHBox;
        Label myDocumentsNameOfReportLabel;
        Line myDocumentsLine;
        Label myDocumentsNameOfPatientLabel;
        ImageView myDocumentsDeleteImageView;

        for(String nameOfReport: UserSession.nameOfReport) {
            myDocumentsEditHBox= new HBox();
            myDocumentsNameOfReportLabel= new Label();
            myDocumentsLine= new Line();
            myDocumentsNameOfPatientLabel= new Label();
            myDocumentsDeleteImageView= new ImageView();

            sceneMyDocumentsMyDocumentsEditHBox.put(nameOfReport, myDocumentsEditHBox);
            sceneMyDocumentsMyDocumentsNameOfReportLabel.put(nameOfReport, myDocumentsNameOfReportLabel);
            sceneMyDocumentsMyDocumentsLine.put(nameOfReport, myDocumentsLine);
            sceneMyDocumentsMyDocumentsNameOfPatientLabel.put(nameOfReport, myDocumentsNameOfPatientLabel);
            sceneMyDocumentsMyDocumentsDeleteImageView.put(nameOfReport, myDocumentsDeleteImageView);

            myDocumentsEditHBox.getChildren().addAll(myDocumentsNameOfReportLabel, myDocumentsLine, myDocumentsNameOfPatientLabel, myDocumentsDeleteImageView);
            myDocumentsEditHBox.setAlignment(Pos.CENTER);
            myDocumentsEditHBox.setStyle("-fx-border-color: #FC7777;");
            myDocumentsEditHBox.maxWidthProperty().bind(myDocumentsEditHBox.prefWidthProperty());
            myDocumentsEditHBox.minWidthProperty().bind(myDocumentsEditHBox.prefWidthProperty());
            myDocumentsEditHBox.minHeightProperty().bind(myDocumentsEditHBox.prefHeightProperty());
            myDocumentsEditHBox.minHeightProperty().bind(myDocumentsEditHBox.prefHeightProperty());
            myDocumentsEditHBox.setPadding(new Insets(0,3,0,0));
            VBox.setMargin(myDocumentsEditHBox, new Insets(5,0,7,2));


            myDocumentsNameOfReportLabel.setText(nameOfReport);
            myDocumentsNameOfReportLabel.setAlignment(Pos.CENTER);

            myDocumentsLine.setStroke(Paint.valueOf("#FC7777"));
            myDocumentsLine.setStrokeWidth(1.2);
            myDocumentsLine.setStartX(0);
            myDocumentsLine.setEndX(0);

            myDocumentsNameOfPatientLabel.setAlignment(Pos.CENTER);
            myDocumentsNameOfPatientLabel.fontProperty().bind(myDocumentsNameOfReportLabel.fontProperty());
            myDocumentsNameOfPatientLabel.setText(String.format("" +
                    "%s " +
                    "%s " +
                    "%s",
                    UserSession.patientLastName.get(nameOfReport),
                    UserSession.patientFirstName.get(nameOfReport),
                    UserSession.patientPatronymicName.get(nameOfReport)
            ));

            myDocumentsDeleteImageView.setCursor(Cursor.HAND);
            myDocumentsDeleteImageView.setImage(new Image(SceneMyDocumentsController.class.getResource("/images/button-for-delete.png").toString()));
            myDocumentsDeleteImageView.fitWidthProperty().bind(myDocumentsDeleteImageView.fitHeightProperty());
            myDocumentsDeleteImageView.setOnMousePressed(_ -> {
                currentSceneMyDocumentsController.myDocumentsCenterColoredVBox.getChildren().remove(sceneMyDocumentsMyDocumentsEditHBox.get(nameOfReport));

                sceneMyDocumentsMyDocumentsEditHBox.remove(nameOfReport);
                sceneMyDocumentsMyDocumentsNameOfReportLabel.remove(nameOfReport);
                sceneMyDocumentsMyDocumentsLine.remove(nameOfReport);
                sceneMyDocumentsMyDocumentsNameOfPatientLabel.remove(nameOfReport);
                sceneMyDocumentsMyDocumentsDeleteImageView.remove(nameOfReport);

                UserSession.deleteReport(nameOfReport);
            });
        }
    }

    public void displayHBox() {
        ObservableList<Node> childrenOfMyDocumentsCenterColoredVBox = myDocumentsCenterColoredVBox.getChildren();
        for(int i = childrenOfMyDocumentsCenterColoredVBox.size() - 1; i >= 2; i--) {
            childrenOfMyDocumentsCenterColoredVBox.remove(i);
        }

        for(String nameOfReport: UserSession.nameOfReport) {
            childrenOfMyDocumentsCenterColoredVBox.add(sceneMyDocumentsMyDocumentsEditHBox.get(nameOfReport));
        }
    }

    public void updateSizesForHeight(Number newValue) {
        if (newValue.doubleValue() < 610) {
            myDocumentsIconImageView.setFitHeight(30);
            myDocumentsIconImageView.setFitWidth(51);

            myDocumentsNameOfProjectLabel.setPrefHeight(30);
            myDocumentsNameOfProjectLabel.setPrefWidth(56);
            myDocumentsNameOfProjectLabel.setFont(Font.font("Arial Black", 10));

            myDocumentsTopHBox.setPrefHeight(37);

            myDocumentsBackButton.setPrefHeight(30);
            myDocumentsBackButton.setPrefWidth(150);
            myDocumentsBackButton.setFont(Font.font("Arial Black", 10));

        } else if (newValue.doubleValue() < 720) {
            myDocumentsIconImageView.setFitHeight(33);
            myDocumentsIconImageView.setFitWidth(56);

            myDocumentsNameOfProjectLabel.setPrefHeight(33);
            myDocumentsNameOfProjectLabel.setPrefWidth(61);
            myDocumentsNameOfProjectLabel.setFont(Font.font("Arial Black", 10.5));

            myDocumentsTopHBox.setPrefHeight(40);

            myDocumentsBackButton.setPrefHeight(33);
            myDocumentsBackButton.setPrefWidth(160);
            myDocumentsBackButton.setFont(Font.font("Arial Black", 10.5));

        } else if (newValue.doubleValue() < 830) {
            myDocumentsIconImageView.setFitHeight(36);
            myDocumentsIconImageView.setFitWidth(61);

            myDocumentsNameOfProjectLabel.setPrefHeight(36);
            myDocumentsNameOfProjectLabel.setPrefWidth(66);
            myDocumentsNameOfProjectLabel.setFont(Font.font("Arial Black", 11));

            myDocumentsTopHBox.setPrefHeight(43);

            myDocumentsBackButton.setPrefHeight(36);
            myDocumentsBackButton.setPrefWidth(170);
            myDocumentsBackButton.setFont(Font.font("Arial Black", 11));

        } else if (newValue.doubleValue() < 940) {
            myDocumentsIconImageView.setFitHeight(39);
            myDocumentsIconImageView.setFitWidth(66);

            myDocumentsNameOfProjectLabel.setPrefHeight(39);
            myDocumentsNameOfProjectLabel.setPrefWidth(71);
            myDocumentsNameOfProjectLabel.setFont(Font.font("Arial Black", 11.5));

            myDocumentsTopHBox.setPrefHeight(46);

            myDocumentsBackButton.setPrefHeight(39);
            myDocumentsBackButton.setPrefWidth(180);
            myDocumentsBackButton.setFont(Font.font("Arial Black", 11.5));
        } else {
            myDocumentsIconImageView.setFitHeight(42);
            myDocumentsIconImageView.setFitWidth(71);

            myDocumentsNameOfProjectLabel.setPrefHeight(42);
            myDocumentsNameOfProjectLabel.setPrefWidth(76);
            myDocumentsNameOfProjectLabel.setFont(Font.font("Arial Black", 12));

            myDocumentsTopHBox.setPrefHeight(49);

            myDocumentsBackButton.setPrefHeight(42);
            myDocumentsBackButton.setPrefWidth(190);
            myDocumentsBackButton.setFont(Font.font("Arial Black", 12));
        }
    }

    public void updateSizesForWidth(Number newValue) {
        if (newValue.doubleValue() < 976) {
            myDocumentsScrollPane.setPrefWidth(490);

            myDocumentsFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD,16));

            myDocumentsSecondUpLabel.setFont(Font.font("System",12));

            for(HBox myDocumentsEditHBox: sceneMyDocumentsMyDocumentsEditHBox.values()) {
                myDocumentsEditHBox.setPrefWidth(myDocumentsCenterColoredVBox.getPrefWidth() - 14);
                myDocumentsEditHBox.prefHeight(37);
            }

            for(Label myDocumentsNameOfReportLabel: sceneMyDocumentsMyDocumentsNameOfReportLabel.values()) {
                myDocumentsNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD,10));
                myDocumentsNameOfReportLabel.setPrefWidth(236);
            }

            for(Label myDocumentsNameOfPatientLabel: sceneMyDocumentsMyDocumentsNameOfPatientLabel.values()) {
                myDocumentsNameOfPatientLabel.setPrefWidth(230);
            }

            for(Line myDocumentsLine: sceneMyDocumentsMyDocumentsLine.values()) {
                myDocumentsLine.setEndY(29);
            }

            for(ImageView myDocumentsDeleteImageView: sceneMyDocumentsMyDocumentsDeleteImageView.values()) {
                myDocumentsDeleteImageView.setFitHeight(28);
            }
        } else if (newValue.doubleValue() < 1212) {
            myDocumentsScrollPane.setPrefWidth(629);

            myDocumentsFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD,17));

            myDocumentsSecondUpLabel.setFont(Font.font("System",13));

            for(HBox myDocumentsEditHBox: sceneMyDocumentsMyDocumentsEditHBox.values()) {
                myDocumentsEditHBox.setPrefWidth(myDocumentsCenterColoredVBox.getPrefWidth() - 14);
                myDocumentsEditHBox.prefHeight(38);
            }

            for(Label myDocumentsNameOfReportLabel: sceneMyDocumentsMyDocumentsNameOfReportLabel.values()) {
                myDocumentsNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD,11));
                myDocumentsNameOfReportLabel.setPrefWidth(320.5);
            }

            for(Label myDocumentsNameOfPatientLabel: sceneMyDocumentsMyDocumentsNameOfPatientLabel.values()) {
                myDocumentsNameOfPatientLabel.setPrefWidth(314.5);
            }

            for(Line myDocumentsLine: sceneMyDocumentsMyDocumentsLine.values()) {
                myDocumentsLine.setEndY(31);
            }

            for(ImageView myDocumentsDeleteImageView: sceneMyDocumentsMyDocumentsDeleteImageView.values()) {
                myDocumentsDeleteImageView.setFitHeight(29);
            }
        } else if (newValue.doubleValue() < 1448) {
            myDocumentsScrollPane.setPrefWidth(673);

            myDocumentsFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD,18));

            myDocumentsSecondUpLabel.setFont(Font.font("System",14));

            for(HBox myDocumentsEditHBox: sceneMyDocumentsMyDocumentsEditHBox.values()) {
                myDocumentsEditHBox.setPrefWidth(myDocumentsCenterColoredVBox.getPrefWidth() - 14);
                myDocumentsEditHBox.prefHeight(39);
            }

            for(Label myDocumentsNameOfReportLabel: sceneMyDocumentsMyDocumentsNameOfReportLabel.values()) {
                myDocumentsNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD,12));
                myDocumentsNameOfReportLabel.setPrefWidth(342.5);
            }

            for(Label myDocumentsNameOfPatientLabel: sceneMyDocumentsMyDocumentsNameOfPatientLabel.values()) {
                myDocumentsNameOfPatientLabel.setPrefWidth(336.5);
            }

            for(Line myDocumentsLine: sceneMyDocumentsMyDocumentsLine.values()) {
                myDocumentsLine.setEndY(32);
            }

            for(ImageView myDocumentsDeleteImageView: sceneMyDocumentsMyDocumentsDeleteImageView.values()) {
                myDocumentsDeleteImageView.setFitHeight(30);
            }
        } else if (newValue.doubleValue() < 1684) {
            myDocumentsScrollPane.setPrefWidth(818);

            myDocumentsFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD,19));

            myDocumentsSecondUpLabel.setFont(Font.font("System",15));

            for(HBox myDocumentsEditHBox: sceneMyDocumentsMyDocumentsEditHBox.values()) {
                myDocumentsEditHBox.setPrefWidth(myDocumentsCenterColoredVBox.getPrefWidth() - 14);
                myDocumentsEditHBox.prefHeight(40);
            }

            for(Label myDocumentsNameOfReportLabel: sceneMyDocumentsMyDocumentsNameOfReportLabel.values()) {
                myDocumentsNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD,13));
                myDocumentsNameOfReportLabel.setPrefWidth(415);
            }

            for(Label myDocumentsNameOfPatientLabel: sceneMyDocumentsMyDocumentsNameOfPatientLabel.values()) {
                myDocumentsNameOfPatientLabel.setPrefWidth(409);
            }

            for(Line myDocumentsLine: sceneMyDocumentsMyDocumentsLine.values()) {
                myDocumentsLine.setEndY(33);
            }

            for(ImageView myDocumentsDeleteImageView: sceneMyDocumentsMyDocumentsDeleteImageView.values()) {
                myDocumentsDeleteImageView.setFitHeight(31);
            }
        } else {
            myDocumentsScrollPane.setPrefWidth(889);

            myDocumentsFirstUpLabel.setFont(Font.font("System", FontWeight.BOLD,20));

            myDocumentsSecondUpLabel.setFont(Font.font("System",16));

            for(HBox myDocumentsEditHBox: sceneMyDocumentsMyDocumentsEditHBox.values()) {
                myDocumentsEditHBox.setPrefWidth(myDocumentsCenterColoredVBox.getPrefWidth() - 14);
                myDocumentsEditHBox.prefHeight(41);
            }

            for(Label myDocumentsNameOfReportLabel: sceneMyDocumentsMyDocumentsNameOfReportLabel.values()) {
                myDocumentsNameOfReportLabel.setFont(Font.font("System", FontWeight.BOLD,14));
                myDocumentsNameOfReportLabel.setPrefWidth(450.5);
            }

            for(Label myDocumentsNameOfPatientLabel: sceneMyDocumentsMyDocumentsNameOfPatientLabel.values()) {
                myDocumentsNameOfPatientLabel.setPrefWidth(444.5);
            }

            for(Line myDocumentsLine: sceneMyDocumentsMyDocumentsLine.values()) {
                myDocumentsLine.setEndY(34);
            }

            for(ImageView myDocumentsDeleteImageView: sceneMyDocumentsMyDocumentsDeleteImageView.values()) {
                myDocumentsDeleteImageView.setFitHeight(32);
            }
        }
    }

    @FXML
    void initialize() {
        myDocumentsCenterColoredVBox.prefWidthProperty().bind(myDocumentsScrollPane.prefWidthProperty().subtract(16));
        myDocumentsCenterColoredVBox.prefHeightProperty().bind(myDocumentsScrollPane.prefHeightProperty());

        myDocumentsFirstUpLabel.prefWidthProperty().bind(myDocumentsCenterColoredVBox.prefWidthProperty());
        myDocumentsSecondUpLabel.prefWidthProperty().bind(myDocumentsCenterColoredVBox.prefWidthProperty());

        myDocumentsBorderPane.heightProperty().addListener((_, _, newValue) -> {
            updateSizesForHeight(newValue);
        });
        myDocumentsBorderPane.widthProperty().addListener((_, _, newValue) -> {
            updateSizesForWidth(newValue);
        });

        Platform.runLater(() -> {
            updateSizesForHeight(myDocumentsBorderPane.getHeight());
            updateSizesForWidth(myDocumentsBorderPane.getWidth());
        });

    }
}
