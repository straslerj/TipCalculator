/*
 * Name: Jake Strasler
 * Tip Calculator
 * Created: 3/3/2020
 */
package straslerj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Driver class for TipCalculator project; required in all JavaFX projects
 */
public class TipCalculatorDriver extends Application {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 275;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
