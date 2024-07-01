package com.example.redactor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class PathologyWardenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PathologyWardenApplication.class.getResource("scene-main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image("file:./src/main/resources/images/logo-pathology-warden.png"));
        stage.setTitle("Pathology Warden");
        stage.setScene(scene);
        stage.show();


        // Нужно добавить событие на переход между мониторами с разным масштабом экрана(на мень)
        stage.setMinWidth(1214.4000244140625);
        stage.setMinHeight(737.5999755859375);
    }

    public static void main(String[] args) {
        launch();
    }
}