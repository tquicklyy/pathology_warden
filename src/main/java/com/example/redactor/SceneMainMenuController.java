package com.example.redactor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SceneMainMenuController {

    @FXML
    private BorderPane mainMenuBorderPane;

    @FXML
    private Label mainMenuCenterTopLabel;

    @FXML
    private AnchorPane mainMenuGeneralAnchorPane;

    @FXML
    private ImageView mainMenuGeneralImageView;

    public ImageView getMainMenuIconImageView() {
        return mainMenuIconImageView;
    }

    @FXML
    private ImageView mainMenuIconImageView;

    public HBox getMainMenuTopHBox() {
        return mainMenuTopHBox;
    }


    public Button getMainMenuInfoButton() {
        return mainMenuInfoButton;
    }

    @FXML
    private Button mainMenuInfoButton;

    public Button getMainMenuLoginButton() {
        return mainMenuLoginButton;
    }

    @FXML
    private Button mainMenuLoginButton;

    public Label getMainMenuNameOfProjectLabel() {
        return mainMenuNameOfProjectLabel;
    }

    @FXML
    private Label mainMenuNameOfProjectLabel;

    public Button getMainMenuRegisterButton() {
        return mainMenuRegisterButton;
    }

    @FXML
    private Button mainMenuRegisterButton;

    public Button getMainMenuStartAnalysisButton() {
        return mainMenuStartAnalysisButton;
    }

    @FXML
    private Button mainMenuStartAnalysisButton;

    @FXML
    private HBox mainMenuTopHBox;

    public AnchorPane getMainMenuGeneralAnchorPane() {
        return mainMenuGeneralAnchorPane;
    }

    public BorderPane getMainMenuBorderPane() {
        return mainMenuBorderPane;
    }

    public Label getMainMenuCenterTopLabel() {
            return mainMenuCenterTopLabel;
    }

    public Button getMainMenuCenterButton() {
        return mainMenuCenterButton;
    }

    public HBox getMainMenuCenterHBox() {
        return mainMenuCenterHBox;
    }

    @FXML
    private Button mainMenuCenterButton;

    @FXML
    private HBox mainMenuCenterHBox;

    public VBox getMainMenuTopLabelVBox() {
        return mainMenuTopLabelVBox;
    }

    @FXML
    private VBox mainMenuTopLabelVBox;

    public VBox getMainMenuBottomLabelVBox() {
        return mainMenuBottomLabelVBox;
    }

    @FXML
    private VBox mainMenuBottomLabelVBox;

    @FXML
    private ImageView mainMenuPlusImageView;

    public ImageView getMainMenuPlusImageView() {
        return mainMenuPlusImageView;
    }

    @FXML
    void initialize() {
        mainMenuCenterTopLabel.setAlignment(Pos.CENTER);
        mainMenuCenterButton.setText("Выбрать\nизображение");
        mainMenuCenterButton.setAlignment(Pos.CENTER_LEFT);
        mainMenuStartAnalysisButton.setAlignment(Pos.CENTER);

        mainMenuStartAnalysisButton.setStyle("-fx-background-color: #808080");

    }
}
