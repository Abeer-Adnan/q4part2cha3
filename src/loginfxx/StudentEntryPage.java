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
import java.util.stream.Collectors;
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
import javafx.scene.control.TextArea;
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
    TextArea texar;
    Label lstudentdata, lid, lname, lmajor, lgrade;
    TextField tid, tname, tmajor, tgrade;
    Button Badd, Breset, BExit;
   // Button QA ,QB,QC,QD,QE,QF;
    ListView<Student> list;
    Stage sta;
    ArrayList<Student> arr = new ArrayList<Student>();
   
    @Override
    public void start(Stage primaryStage) {
        GridPane grd = new GridPane();
        grd.setHgap(10);
        grd.setVgap(10);
        grd.setAlignment(Pos.CENTER);

        texar = new TextArea();
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
        grd.add(texar, 0, 3);
      // QA = new Button("QA");
      // QA.setOnAction(this);
       //QB = new Button("QB");
      // QB.setOnAction(this);
      // QC = new Button("QC");
     //   QC.setOnAction(this);
     //  QD = new Button("QD");
     //  QD.setOnAction(this);
     //  QF = new Button("QF");
    //   QF.setOnAction(this);
    //    HBox hbutton = new HBox(7,QA,QB,QC,QD,QF);
       // grd.add(hbutton, 0, 2);
        Scene scene = new Scene(grd, 900, 700);
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
          //  if(event.getSource() == QA){
           list.getItems().clear();
            list.getItems().setAll(
                    arr
                   . stream()
                     .sorted(Comparator.comparing(Student :: getName))
                    .collect(Collectors.toList())
            );//}
          
          //  if(event.getSource() == QB){
            texar.clear();
             texar.appendText(" Sorted by Name and Grade \n");
          arr.stream()
                    .sorted(Comparator.comparing(Student :: getGrade).reversed())
                   .map(c -> c.getName() +"  "+ c.getGrade())
                   .forEach(c -> 
                   {
                       texar.appendText(c +"\n");
                   });
          // }
            
       //  if(event.getSource() == QC){
          
        texar.clear();
             texar.appendText("Grade values in the range 80 to 90 \n");
                  arr
                   .stream()
                 .sorted(Comparator.comparing(Student :: getGrade).reversed())
                   .filter(f -> f.getGrade() >= 80 && f.getGrade() <= 90)
                   .map( f -> f.getName() + "  "+ f.getGrade())
                          .forEach(f -> 
                   {
                       texar.appendText(f +"\n");
                   });
        // }
        // if(event.getSource() == QD){
           texar.clear();
             texar.appendText("Total average of all Students grades \n");
          double avg =
          arr
                  .stream()
                  .mapToDouble(Student :: getGrade)
                  .average()
                  .getAsDouble();
          texar.appendText(avg +"\n");
        // } 
         // if(event.getSource() == QF){
         texar.clear();
             texar.appendText("Group Students by major");
                arr
                        .stream()
                        .collect(Collectors.
                                groupingBy(Student::getMajor))
                        .forEach((major, studmajor) -> {
                            texar.appendText(major+"\n");
                          texar.appendText("***** \n");
                            studmajor.forEach(e -> texar.appendText(e+"\n"));
                                    
                                    });
          //}        
         
        }catch(NumberFormatException  e){
           list.setVisible(true);
            
        }} else if (event.getSource() == Breset) {

            tid.setText("");
            tname.setText("");
            tmajor.setText("");
            tgrade.setText("");
            texar.clear();

            list.getItems().clear();
            arr.clear();
        } else if (event.getSource() == BExit) {
            System.exit(0);
        }
    }

}
