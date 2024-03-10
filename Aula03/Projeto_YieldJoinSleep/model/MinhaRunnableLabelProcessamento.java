package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class MinhaRunnableLabelProcessamento implements Runnable {

    Label label;
    int i;

    boolean yield;
    int sleep;

    public MinhaRunnableLabelProcessamento(Label label) {
        this.label = label;
        this.yield = Controller.yield;
        this.sleep = Controller.sleep * 1000;
    }

    @Override
    public void run() {
        try {
            for (i = 1; i <= 10; i++) {
                calcularPrimos();
                Platform.runLater(() -> label.setText(i + ""));
                Thread.sleep(sleep);
                if(this.yield){
                    Thread.yield();
                }
            }
            Platform.runLater(() -> label.setText("Finalizada!"));
        } catch (InterruptedException ex) {
            Logger.getLogger(MinhaRunnableLabelProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método criado apenas para fazer a thread ter um processamento maior
    //Este método está baseado no cálculo de números primos (de 1 até 75000)
    public void calcularPrimos(){
        int qtdDivisores;
        int qtdPrimos=0;
        
        for (int i = 1; i <= 60000; i++) {
            qtdDivisores = 0;
            for(int j= 1; j<= i; j++){
                if(i%j==0){
                    qtdDivisores++;
                }
            }
            if(qtdDivisores == 2){
                qtdPrimos++;
            }
        }
    }

}