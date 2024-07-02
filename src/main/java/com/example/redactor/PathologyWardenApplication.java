package com.example.redactor;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class PathologyWardenApplication extends Application {
    static double MIN_WIDTH_STAGE = 1214.4000244140625;
    static double MIN_HEIGHT_STAGE = 737.5999755859375;
    private Timer timer = new Timer();
    private boolean isDragging = false;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.getIcons().add(new Image("file:./src/main/resources/images/logo-pathology-warden.png"));
        stage.setTitle("Pathology Warden");
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(MIN_WIDTH_STAGE);
        stage.setMinHeight(MIN_HEIGHT_STAGE);

        ChangeListener<Number> positionChangeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (!isDragging) {
                    isDragging = true;
                    stage.setMinWidth(0);
                    stage.setMinHeight(0);
                }
                resetDragEndTimer(stage);
            }
        };
        stage.xProperty().addListener(positionChangeListener);
        stage.yProperty().addListener(positionChangeListener);
    }

    private void resetDragEndTimer(Stage stage) {
        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    isDragging = false;
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
