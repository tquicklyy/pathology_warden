package com.example.redactor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.binding.NumberBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class PathologyWardenApplication extends Application {
    final double MIN_WIDTH_STAGE = Screen.getPrimary().getBounds().getWidth()*0.7;
    final double MIN_HEIGHT_STAGE = Screen.getPrimary().getBounds().getHeight()*0.8;
    private Timer timerForMainMenuStageDragging = new Timer();
    private boolean isMainMenuStageDragging = false;

    @Override
    public void start(Stage mainMenuStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load() );


        mainMenuStage.getIcons().add(new Image("file:./src/main/resources/images/logo-pathology-warden.png"));
        mainMenuStage.setTitle("Pathology Warden");

        mainMenuStage.setMinWidth(MIN_WIDTH_STAGE);
        mainMenuStage.setMinHeight(MIN_HEIGHT_STAGE);
        mainMenuStage.setWidth(MIN_WIDTH_STAGE);
        mainMenuStage.setHeight(MIN_HEIGHT_STAGE);
        mainMenuStage.setScene(scene);
        mainMenuStage.show();

        SceneMainMenuController mainController = fxmlLoader.getController();

        System.out.println(scene.heightProperty().doubleValue());
        NumberBinding sizeOfMainMenuGeneralAnchorPane = Bindings.min(mainController.getMainMenuBorderPane().widthProperty().multiply(0.7), mainController.getMainMenuBorderPane().heightProperty().multiply(0.7));
        mainController.getMainMenuGeneralAnchorPane().maxHeightProperty().bind(sizeOfMainMenuGeneralAnchorPane);
        mainController.getMainMenuGeneralAnchorPane().maxWidthProperty().bind(sizeOfMainMenuGeneralAnchorPane);
        mainController.getMainMenuGeneralAnchorPane().minHeightProperty().bind(sizeOfMainMenuGeneralAnchorPane);
        mainController.getMainMenuGeneralAnchorPane().minWidthProperty().bind(sizeOfMainMenuGeneralAnchorPane);

        mainController.getMainMenuCenterTopLabel().maxWidthProperty().bind(sizeOfMainMenuGeneralAnchorPane);
        mainController.getMainMenuCenterTopLabel().minWidthProperty().bind(sizeOfMainMenuGeneralAnchorPane);

        mainController.getMainMenuStartAnalysisButton().maxWidthProperty().bind(sizeOfMainMenuGeneralAnchorPane.divide(4));
        mainController.getMainMenuStartAnalysisButton().minWidthProperty().bind(sizeOfMainMenuGeneralAnchorPane.divide(4));

        mainController.getMainMenuInfoButton().maxWidthProperty().bind(mainController.getMainMenuInfoButton().heightProperty());
        mainController.getMainMenuInfoButton().minWidthProperty().bind(mainController.getMainMenuInfoButton().heightProperty());

        mainController.getMainMenuInfoButton().maxHeightProperty().bind(mainController.getMainMenuTopRightHBox().heightProperty().multiply(0.8));
        mainController.getMainMenuInfoButton().minHeightProperty().bind(mainController.getMainMenuTopRightHBox().heightProperty().multiply(0.8));

        mainController.getMainMenuRegisterButton().maxHeightProperty().bind(mainController.getMainMenuInfoButton().heightProperty());
        mainController.getMainMenuRegisterButton().minHeightProperty().bind(mainController.getMainMenuInfoButton().heightProperty());

        mainController.getMainMenuLoginButton().maxHeightProperty().bind(mainController.getMainMenuInfoButton().heightProperty());
        mainController.getMainMenuLoginButton().minHeightProperty().bind(mainController.getMainMenuInfoButton().heightProperty());

        mainController.getMainMenuRegisterButton().maxWidthProperty().bind(mainController.getMainMenuRegisterButton().heightProperty().multiply(3));
        mainController.getMainMenuRegisterButton().minWidthProperty().bind(mainController.getMainMenuRegisterButton().heightProperty().multiply(3));

        mainController.getMainMenuLoginButton().maxWidthProperty().bind(mainController.getMainMenuLoginButton().heightProperty().multiply(1.7));
        mainController.getMainMenuLoginButton().minWidthProperty().bind(mainController.getMainMenuLoginButton().heightProperty().multiply(1.7));

        mainController.getMainMenuNameOfProjectLabel().maxHeightProperty().bind(mainController.getMainMenuIconImageView().fitWidthProperty());
        mainController.getMainMenuNameOfProjectLabel().minHeightProperty().bind(mainController.getMainMenuIconImageView().fitHeightProperty());

        mainController.getMainMenuIconImageView().fitHeightProperty().bind(mainController.getMainMenuInfoButton().heightProperty());
        mainController.getMainMenuIconImageView().fitWidthProperty().bind(mainController.getMainMenuInfoButton().heightProperty());

        mainController.getMainMenuNameOfProjectLabel().maxWidthProperty().bind(mainController.getMainMenuIconImageView().fitWidthProperty().multiply(2));
        mainController.getMainMenuNameOfProjectLabel().minWidthProperty().bind(mainController.getMainMenuIconImageView().fitWidthProperty().multiply(2));

        mainController.getMainMenuStartAnalysisButton().maxHeightProperty().bind(mainController.getMainMenuGeneralAnchorPane().heightProperty().multiply(0.1));
        mainController.getMainMenuStartAnalysisButton().minHeightProperty().bind(mainController.getMainMenuGeneralAnchorPane().heightProperty().multiply(0.1));

        mainController.getMainMenuTopHBox().maxHeightProperty().bind(mainController.getMainMenuCenterTopLabel().heightProperty().multiply(1.7));
        mainController.getMainMenuTopHBox().minHeightProperty().bind(mainController.getMainMenuCenterTopLabel().heightProperty().multiply(1.7));

        mainController.getMainMenuStartAnalysisButton().maxWidthProperty().bind(mainController.getMainMenuGeneralAnchorPane().widthProperty().divide(2));
        mainController.getMainMenuStartAnalysisButton().minWidthProperty().bind(mainController.getMainMenuGeneralAnchorPane().widthProperty().divide(2));

        mainController.getMainMenuPlusImageView().fitWidthProperty().bind(mainController.getMainMenuPlusImageView().fitHeightProperty());
        mainController.getMainMenuPlusImageView().fitHeightProperty().bind(mainController.getMainMenuCenterButton().heightProperty());

        mainController.getMainMenuCenterButton().maxWidthProperty().bind(mainController.getMainMenuGeneralAnchorPane().heightProperty().multiply(0.25));
        mainController.getMainMenuCenterButton().minWidthProperty().bind(mainController.getMainMenuGeneralAnchorPane().heightProperty().multiply(0.25));

        mainController.getMainMenuCenterButton().maxHeightProperty().bind(mainController.getMainMenuGeneralAnchorPane().heightProperty().multiply(0.1));
        mainController.getMainMenuCenterButton().minHeightProperty().bind(mainController.getMainMenuGeneralAnchorPane().heightProperty().multiply(0.1));

        mainController.getMainMenuCenterHBox().maxWidthProperty().bind((mainController.getMainMenuCenterButton().widthProperty().add(mainController.getMainMenuPlusImageView().fitWidthProperty())).multiply(1.1));
        mainController.getMainMenuCenterHBox().minWidthProperty().bind((mainController.getMainMenuCenterButton().widthProperty().add(mainController.getMainMenuPlusImageView().fitWidthProperty())).multiply(1.1));

        mainController.getMainMenuCenterHBox().maxHeightProperty().bind(mainController.getMainMenuCenterButton().heightProperty().multiply(1.1));
        mainController.getMainMenuCenterHBox().minHeightProperty().bind(mainController.getMainMenuCenterButton().heightProperty().multiply(1.1));

        mainController.getMainMenuTopLabelVBox().maxHeightProperty().bind(sizeOfMainMenuGeneralAnchorPane.multiply(0.1));
        mainController.getMainMenuTopLabelVBox().minHeightProperty().bind(sizeOfMainMenuGeneralAnchorPane.multiply(0.1));

        mainController.getMainMenuBottomLabelVBox().maxHeightProperty().bind(mainController.getMainMenuBorderPane().heightProperty().subtract (mainController.getMainMenuTopHBox().heightProperty()).subtract (mainController.getMainMenuTopLabelVBox().heightProperty()).subtract (mainController.getMainMenuGeneralAnchorPane().heightProperty()));
        mainController.getMainMenuBottomLabelVBox().minHeightProperty().bind(mainController.getMainMenuBorderPane().heightProperty().subtract (mainController.getMainMenuTopHBox().heightProperty()).subtract (mainController.getMainMenuTopLabelVBox().heightProperty()).subtract (mainController.getMainMenuGeneralAnchorPane().heightProperty()));

        ChangeListener<Number> mainMenuStagePositionChangeListener = (observable, oldValue, newValue) -> {
            if (!isMainMenuStageDragging) {
                isMainMenuStageDragging = true;
                mainMenuStage.setMinWidth(0);
                mainMenuStage.setMinHeight(0);
            }
            resetTimerForMainMenuStageDragging(mainMenuStage);
        };
        mainMenuStage.xProperty().addListener(mainMenuStagePositionChangeListener);
        mainMenuStage.yProperty().addListener(mainMenuStagePositionChangeListener);
    }

    private void resetTimerForMainMenuStageDragging(Stage stage) {
        timerForMainMenuStageDragging.cancel();
        timerForMainMenuStageDragging = new Timer();
        timerForMainMenuStageDragging.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    isMainMenuStageDragging = false;
                    stage.setMinWidth(MIN_WIDTH_STAGE);
                    stage.setMinHeight(MIN_HEIGHT_STAGE);
                });
            }
        }, 100);
    }

    public static void main(String[] args) {
        launch();
    }
}
