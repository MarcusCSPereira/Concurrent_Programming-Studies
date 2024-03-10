package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.RunnableMatrizMulti;
import model.RunnableMatrizSingle;
import model.RunnableTimer;

public class Controller1 implements Initializable {

    @FXML
    private AnchorPane anchorPaneSingleThread;
    @FXML
    private AnchorPane anchorPaneMultiThread;

    private Label[][] matrizSingleThread = new Label[10][10];

    private Label[][] matrizMultiThread = new Label[10][10];
    @FXML
    private Label labelTimerSingleThread;
    @FXML
    private Label labelTimerMultiThread;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        iniciarMatriz(anchorPaneSingleThread, matrizSingleThread);
        iniciarMatriz(anchorPaneMultiThread, matrizMultiThread);

        RunnableMatrizSingle runnableMatrizSingle = new RunnableMatrizSingle(this.matrizSingleThread);
        Thread t1_single = new Thread(runnableMatrizSingle);
        
        
        RunnableMatrizMulti runnableMatrizMulti1 = new RunnableMatrizMulti(this.matrizMultiThread, 0);
        Thread t1_multi = new Thread(runnableMatrizMulti1);
        RunnableMatrizMulti runnableMatrizMulti2 = new RunnableMatrizMulti(this.matrizMultiThread, 1);
        Thread t2_multi = new Thread(runnableMatrizMulti2);
        RunnableMatrizMulti runnableMatrizMulti3 = new RunnableMatrizMulti(this.matrizMultiThread, 2);
        Thread t3_multi = new Thread(runnableMatrizMulti3);
        RunnableMatrizMulti runnableMatrizMulti4 = new RunnableMatrizMulti(this.matrizMultiThread, 3);
        Thread t4_multi = new Thread(runnableMatrizMulti4);
        RunnableMatrizMulti runnableMatrizMulti5 = new RunnableMatrizMulti(this.matrizMultiThread, 4);
        Thread t5_multi = new Thread(runnableMatrizMulti5);
        RunnableMatrizMulti runnableMatrizMulti6 = new RunnableMatrizMulti(this.matrizMultiThread, 5);
        Thread t6_multi = new Thread(runnableMatrizMulti6);
        RunnableMatrizMulti runnableMatrizMulti7 = new RunnableMatrizMulti(this.matrizMultiThread, 6);
        Thread t7_multi = new Thread(runnableMatrizMulti7);
        RunnableMatrizMulti runnableMatrizMulti8 = new RunnableMatrizMulti(this.matrizMultiThread, 7);
        Thread t8_multi = new Thread(runnableMatrizMulti8);
        RunnableMatrizMulti runnableMatrizMulti9 = new RunnableMatrizMulti(this.matrizMultiThread, 8);
        Thread t9_multi = new Thread(runnableMatrizMulti9);
        RunnableMatrizMulti runnableMatrizMulti10 = new RunnableMatrizMulti(this.matrizMultiThread, 9);
        Thread t10_multi = new Thread(runnableMatrizMulti10);
        
        RunnableTimer runnableTimer = new RunnableTimer(this.labelTimerSingleThread, this.labelTimerMultiThread);
        Thread threadTimer = new Thread(runnableTimer);
        
        threadTimer.start();
        
        t1_single.start();
        t1_multi.start();
        t2_multi.start();
        t3_multi.start();
        t4_multi.start();
        t5_multi.start();
        t6_multi.start();
        t7_multi.start();
        t8_multi.start();
        t9_multi.start();
        t10_multi.start();
    }

    public void iniciarMatriz(AnchorPane anchorPane, Label[][] matriz) {
        int x = 25;
        int y = 50;
        for (int linha = 0; linha <= 9; linha++) {
            for (int coluna = 0; coluna <= 9; coluna++) {

                Label label = new Label();
                label.setPrefHeight(25);
                label.setPrefWidth(25);
                label.setLineSpacing(1);
                label.setLayoutX(x);
                label.setLayoutY(y);
                label.setStyle("-fx-border-color:black;");
                anchorPane.getChildren().addAll(label);

                matriz[linha][coluna] = label;

                x = x + 25;
            }
            y = y + 25;
            x = 25;
        }
    }

}