package com.example.redactor;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SceneStartAnalysisWithoutAccountController {

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

    public Button getMainMenuGoToMainMenuButton() {
        return mainMenuGoToMainMenuButton;
    }

    @FXML
    private Button mainMenuGoToMainMenuButton;

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


    public VBox getMainMenuTopLabelVBox() {
        return mainMenuTopLabelVBox;
    }

    @FXML
    private VBox mainMenuTopLabelVBox;

    public ImageView getMainMenuGeneralImageView() {
        return mainMenuGeneralImageView;
    }

    public VBox getMainMenuBottomButtonVBox() {
        return mainMenuBottomButtonVBox;
    }

    @FXML
    private VBox mainMenuBottomButtonVBox;

    @FXML
    void initialize() {
        mainMenuCenterTopLabel.setAlignment(Pos.CENTER);
        mainMenuStartAnalysisButton.setAlignment(Pos.CENTER);
    }
}
