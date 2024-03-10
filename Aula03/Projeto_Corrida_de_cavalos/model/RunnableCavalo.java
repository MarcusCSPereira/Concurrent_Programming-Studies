package model;

import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class RunnableCavalo implements Runnable {

    private static int posicaoChegada = 0; // Variável compartilhada para determinar a ordem de chegada dos cavalos

    private Button button;
    private String nome;
    private int prioridade = Thread.MIN_PRIORITY;

    public RunnableCavalo(Button button, String nome) {
        this.button = button;
        this.nome = nome;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(prioridade);
        System.out.println(Thread.currentThread().getName() + " - Prioridade: " + Thread.currentThread().getPriority());

        for (int i = 1; i <= 600; i++) {
            Platform.runLater(() -> button.setLayoutX(button.getLayoutX() + 1));
            if (button.getLayoutX() == 350) {
                synchronized (RunnableCavalo.class) {
                    if (posicaoChegada == 0) {
                        posicaoChegada++;
                        System.out.println("Cavalo " + nome + " chegou em " + posicaoChegada + "º lugar!");
                    } else {
                        System.out.println("Cavalo " + nome + " chegou em " + ++posicaoChegada + "º lugar!");
                    }
                }
                break;
            }
            sleep1();
        }
    }

    public void sleep1() {
        try {
            Thread.sleep(new Random().nextInt(200));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
