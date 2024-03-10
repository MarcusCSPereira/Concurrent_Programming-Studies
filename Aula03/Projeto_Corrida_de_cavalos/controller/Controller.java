package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.RunnableCavalo;

public class Controller implements Initializable {

    @FXML
    private Button buttonIniciar;
    @FXML
    private Button buttonCavalo1;
    @FXML
    private Button buttonCavalo2;
    @FXML
    private Button buttonCavalo3;
    @FXML
    private Button buttonCavalo4;
    @FXML
    private Button buttonCavalo5;
    @FXML
    private Label labelLinhaChegada;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleButtonIniciar() {
        // Instanciando as Runnables
        RunnableCavalo runnableCavalo1 = new RunnableCavalo(buttonCavalo1, "Cavalo 1");
        RunnableCavalo runnableCavalo2 = new RunnableCavalo(buttonCavalo2, "Cavalo 2");
        RunnableCavalo runnableCavalo3 = new RunnableCavalo(buttonCavalo3, "Cavalo 3");
        RunnableCavalo runnableCavalo4 = new RunnableCavalo(buttonCavalo4, "Cavalo 4");
        RunnableCavalo runnableCavalo5 = new RunnableCavalo(buttonCavalo5, "Cavalo 5");

        // Alterando as prioridades de algumas Threads (apenas para observar o
        // resultado)
        //runnableCavalo1.prioridade = 10; // Cavalo 1
        //runnableCavalo2.prioridade = 7; // Cavalo 2

        // Instanciando as Threads
        Thread threadCavalo1 = new Thread(runnableCavalo1, "Cavalo 1");
        Thread threadCavalo2 = new Thread(runnableCavalo2, "Cavalo 2");
        Thread threadCavalo3 = new Thread(runnableCavalo3, "Cavalo 3");
        Thread threadCavalo4 = new Thread(runnableCavalo4, "Cavalo 4");
        Thread threadCavalo5 = new Thread(runnableCavalo5, "Cavalo 5");

        threadCavalo1.start();
        threadCavalo2.start();
        threadCavalo3.start();
        threadCavalo4.start();
        threadCavalo5.start();

    }

}