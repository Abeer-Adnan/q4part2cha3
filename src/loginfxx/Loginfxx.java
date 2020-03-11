/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfxx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class Loginfxx extends Application implements EventHandler<ActionEvent> {

    Label lwelcome, luser, lpass;
    TextField tuser, tpass;
    Button Bsignin, BExit;
    Stage sta;
    Alert a;

    @Override
    public void start(Stage primaryStage) {
        sta = primaryStage;
        GridPane gp = new GridPane();
        // gp.setHgap(5);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        lwelcome = new Label("Welcome ");
        lwelcome.setId("lw");
        lwelcome.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gp.add(lwelcome, 0, 0);
        luser = new Label("User Name:");
        gp.add(luser, 0, 1);
        lpass = new Label("PassWord:");
        gp.add(lpass, 0, 2);
        tuser = new TextField();
        gp.add(tuser, 1, 1);
        tpass = new TextField();
        gp.add(tpass, 1, 2);
        Bsignin = new Button("Sign in ");
        GridPane.setHalignment(Bsignin, HPos.CENTER);
        gp.add(Bsignin, 1, 3);
        Bsignin.setOnAction(this);
        BExit = new Button("Exit ");
        GridPane.setHalignment(BExit, HPos.RIGHT);
        gp.add(BExit, 1, 3);
        BExit.setOnAction(this);
        Scene s = new Scene(gp, 300, 260);
        s.getStylesheets().add(getClass().getResource("Logincss.css").toExternalForm());
        a = new Alert(Alert.AlertType.NONE);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(s);
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

        if (event.getSource() == Bsignin) {
            try {
                Scanner s = new Scanner(new File("C:\\Users\\rant\\Documents\\NetBeansProjects\\Loginfxx\\src\\loginfxx\\Login.txt"));

                while (s.hasNext()) {
                    String textfile = s.nextLine();
                    String[] arr = textfile.split(" ");

                    if (tuser.getText().equals(arr[0]) && (tpass.getText().equals(arr[1]))) {
                        LoginFxx2 l = new LoginFxx2();
                        sta.close();
                        try {
                            l.start(new Stage());
                        } catch (Exception e) {
                            System.out.println("!!!!!!!!!!!!");
                        }

                    } else {
                        a.setAlertType(Alert.AlertType.ERROR);
                        a.setContentText("Please Enter UserName and PassWord Correctly  :) ");
                        a.show();
                    }

                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (event.getSource() == BExit) {
            System.exit(0);
        }

    }
}
