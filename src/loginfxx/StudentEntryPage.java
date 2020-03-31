/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfxx;

import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class StudentEntryPage extends Application  implements EventHandler<ActionEvent>{

    Label lstudentdata, lid, lname, lmajor, lgrade;
    TextField tid, tname, tmajor, tgrade;
    Button Badd, Breset, BExit;
    ListView list;
    Stage sta;
    ArrayList<String> arr = new ArrayList<String>();

    @Override
    public void start(Stage primaryStage) {
        GridPane grd = new GridPane();
        grd.setHgap(-85);
        grd.setVgap(8);
     
        grd.setAlignment(Pos.CENTER);

        lstudentdata = new Label("Student Data ");
        lstudentdata.setId("ls");
        lstudentdata.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        lid = new Label("Id: ");
        lname = new Label("Name: ");
        lmajor = new Label("Major: ");
        lgrade = new Label("Grade:");
        grd.add(lstudentdata, 0, 0);
        grd.add(lid, 0, 1);
        grd.add(lname, 0, 2);
        grd.add(lmajor, 0, 3);
        grd.add(lgrade, 0, 4);

        tid = new TextField();
        tname = new TextField();
        tmajor = new TextField();
        tgrade = new TextField();
       
        grd.add(tid, 1, 1);
        grd.add(tname, 1, 2);
        grd.add(tmajor, 1, 3);
        grd.add(tgrade, 1, 4);

        Badd = new Button("Add");
        Badd.setOnAction(this);
        Breset = new Button("Reaet");
        Breset.setOnAction(this);
        BExit = new Button("Exit");
        BExit.setOnAction(this);
    
        // list=new ListView();
        //grd.add(list, 2, 1);
        //list.setPrefSize(200, 200);
        //list.setPadding(new Insets(0,10,80,20));
     //   list.setVisible(false);
         HBox hb = new HBox(10, Badd, Breset, BExit);
         
         hb.setPadding(new Insets(10, 0, 0, 10));
         GridPane.setHalignment(hb, HPos.CENTER);
         grd.add(hb, 1, 5);
        Scene scene = new Scene(grd, 300, 250);
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
        Student ss = new Student(0, STYLESHEET_MODENA, STYLESHEET_MODENA, 0);
      if(event.getSource()== Badd){
          arr.add(tid.getText());
          arr.add(tname.getText());
          arr.add(tmajor.getText());
          arr.add(tgrade.getText());
          Collections.sort(arr);
          list.getItems().add(arr);
        //  list.setVisible(true);
}else if(event.getSource()== Breset){
     tid.clear();
          tname.clear();
          tmajor.clear();
          tgrade.clear();
}else if(event.getSource()== BExit){
    System.exit(0);
}
    }

}
