
package com.dev.sqlapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    public static MainController mainController;
    public static Connection conn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // main screen is defined
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscreen.fxml"));
        Parent root = loader.load();

        mainController = loader.getController();
        // draw the main 2D rectangle for the app
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        // draw the main scene
        Scene scene = new Scene(root);
        primaryStage.setTitle("SQL App");
        primaryStage.setScene(scene);
        // set screen to full screen boundaries
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
        // show connection dialog when start
        mainController.handleNewConnection(null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void warning(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(msg);
        alert.showAndWait();
    }

    public static void error(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(msg);
        alert.showAndWait();
    }

    public static void info(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(msg);
        alert.showAndWait();
    }
}