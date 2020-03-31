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
public class OptionsPag extends Application implements EventHandler<ActionEvent> {

    Button Badd, Bview;
    Stage sstage;

    @Override
    public void start(Stage primaryStage) {
        Badd = new Button("Add Student");
        Bview = new Button("View Student");
        Badd.setOnAction(this);
        GridPane grp = new GridPane();
        grp.add(Badd, 0, 0);
        grp.add(Bview, 0, 1);
        grp.setVgap(10);
        grp.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grp, 300, 250);
        scene.getStylesheets().add(getClass().getResource("Logincss.css").toExternalForm());
        primaryStage.setTitle("Options Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        sstage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == Badd) {
            StudentEntryPage s2 = new StudentEntryPage();
            sstage.close();
            try {
                s2.start(new Stage());
            } catch (Exception e) {

            }

        }
    }

}
