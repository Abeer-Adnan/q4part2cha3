/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfxx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class StudentEntryPage extends Application implements EventHandler<ActionEvent> {

    Label lstudentdata, lid, lname, lmajor, lgrade;
    TextField tid, tname, tmajor, tgrade;
    Button Badd, Breset, BExit;
    ListView list;
    Stage sta;
    ArrayList<Student> arr = new ArrayList<Student>();

    @Override
    public void start(Stage primaryStage) {
        GridPane grd = new GridPane();
        grd.setHgap(10);
        grd.setVgap(10);
        grd.setAlignment(Pos.CENTER);

        lstudentdata = new Label("Student Data ");
        lstudentdata.setId("ls");
        lstudentdata.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        lid = new Label("Id: ");
        lname = new Label("Name: ");
        lmajor = new Label("Major: ");
        lgrade = new Label("Grade:");

        VBox vl = new VBox(20, lid, lname, lmajor, lgrade);
        tid = new TextField();
        tname = new TextField();
        tmajor = new TextField();
        tgrade = new TextField();

        Badd = new Button("Add");
        Badd.setOnAction(this);
        Breset = new Button("Reaet");
        Breset.setOnAction(this);
        BExit = new Button("Exit");
        BExit.setOnAction(this);

        HBox hb = new HBox(10, Badd, Breset, BExit);
        hb.setAlignment(Pos.BASELINE_RIGHT);
        VBox tl = new VBox(10, tid, tname, tmajor, tgrade, hb);
        list = new ListView();
        list.setVisible(false);
        list.setPrefSize(340, 300);
        HBox all = new HBox(10, vl, tl, list);
        grd.add(lstudentdata, 0, 0);
        grd.add(all, 0, 1);

        Scene scene = new Scene(grd, 630, 490);
        scene.getStylesheets().add(getClass().getResource("Logincss.css").toExternalForm());
        primaryStage.setTitle("Student Entry Page");
        primaryStage.setScene(scene);
        primaryStage.show();
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
            try{
            Student ss = new Student(Integer.parseInt(tid.getText()), tname.getText(), tmajor.getText(), Double.parseDouble(tgrade.getText()));

            arr.add(ss);
            arr.sort(new Comparator<Student>() {
                @Override
                public int compare(Student t, Student t1) {
                    return t.compareTo(t1);
                }

            });
            list.getItems().clear();
            for (Student t : arr) {
                list.getItems().add(t.toString());

            }
            list.setVisible(true);
        }catch(InputMismatchException  e){
            e.getMessage();
            
        }} else if (event.getSource() == Breset) {

            tid.setText("");
            tname.setText("");
            tmajor.setText("");
            tgrade.setText("");

            list.getItems().clear();
            arr.clear();
        } else if (event.getSource() == BExit) {
            System.exit(0);
        }
    }

}
