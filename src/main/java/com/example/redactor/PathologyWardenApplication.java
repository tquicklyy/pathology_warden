package com.example.redactor;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class PathologyWardenApplication extends Application {
    final double MIN_WIDTH_STAGE = 1214.4000244140625;
    final double MIN_HEIGHT_STAGE = 737.5999755859375;
    private Timer timerForMainMenuStageDragging = new Timer();
    private boolean isMainMenuStageDragging = false;

    @Override
    public void start(Stage mainMenuStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        mainMenuStage.getIcons().add(new Image("file:./src/main/resources/images/logo-pathology-warden.png"));
        mainMenuStage.setTitle("Pathology Warden");
        mainMenuStage.setScene(scene);
        mainMenuStage.show();
        mainMenuStage.setMinWidth(MIN_WIDTH_STAGE);
        mainMenuStage.setMinHeight(MIN_HEIGHT_STAGE);

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
