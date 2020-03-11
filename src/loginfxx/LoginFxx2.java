/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfxx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class LoginFxx2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button add = new Button("Add Student");
        Button view = new Button("View Student");
        GridPane grp = new GridPane();
        grp.add(add, 0, 0);
        grp.add(view, 0, 1);
        grp.setVgap(10);
        grp.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grp, 300, 250);
        scene.getStylesheets().add(getClass().getResource("Logincss.css").toExternalForm());
        primaryStage.setTitle("Options Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
