package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.MinhaRunnableLabelFinal;
import model.MinhaRunnableLabelProcessamento;


public class Controller implements Initializable {
    
    @FXML
    private Button buttonIniciar;
    @FXML
    private Label labelProcessamentoThread1;
    @FXML
    private Label labelProcessamentoThread2;
    @FXML
    private Label labelFinal;
    @FXML
    private CheckBox checkBoxYield;
    @FXML
    private CheckBox checkBoxJoin;
    @FXML
    private TextField textFieldSleep;
    
    MinhaRunnableLabelProcessamento minhaThread1;
    MinhaRunnableLabelProcessamento minhaThread2;
    Thread t1;
    Thread t2;
    
    MinhaRunnableLabelFinal minhaThread3;
    Thread t3;
    
    public static boolean yield = false;
    public static int sleep = 1;
    public static boolean join = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void handleButtonIniciar() throws InterruptedException{
        yield = this.checkBoxYield.isSelected();
        join = this.checkBoxJoin.isSelected();
        sleep = Integer.parseInt(this.textFieldSleep.getText());
                
        minhaThread1 = new MinhaRunnableLabelProcessamento(labelProcessamentoThread1);
        t1 = new Thread(minhaThread1, "Thread 1");
        
        
        minhaThread2 = new MinhaRunnableLabelProcessamento(labelProcessamentoThread2);
        t2 = new Thread(minhaThread2, "Thread 2");
        
        
        minhaThread3 = new MinhaRunnableLabelFinal(labelFinal, t1, t2);
        t3 = new Thread(minhaThread3, "Thread 3");
        
        t1.start();
        this.labelProcessamentoThread1.setText("Thread pronta...");
        t2.start();
        this.labelProcessamentoThread2.setText("Thread pronta...");
        t3.start();
        
        
    }
    
    
    
    
    
}