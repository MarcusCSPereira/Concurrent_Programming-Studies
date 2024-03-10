import model.Thread_1;
import model.Runnable_1;

public class Main_1 {

    public static void main(String[] args) {

        //Criando uma thread a partir de uma classe que herda a Classe Thread.
        Thread_1 t1 = new Thread_1();
        t1.start(); 

        //Criando uma thread a partir de uma classe que implementa a interface Runnable.
        Runnable_1 runnable = new Runnable_1();
        Thread threadRunnable = new Thread(runnable);
        threadRunnable.start();
    }
}