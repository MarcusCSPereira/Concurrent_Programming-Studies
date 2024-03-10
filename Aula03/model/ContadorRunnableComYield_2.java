package model;

public class ContadorRunnableComYield_2 implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " iniciou");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - Contador: " + i);
            Thread.yield();//Método que faz a thread atual parar e dar a vez para outra thread.
        }
        System.out.println(name + " terminou");
    }
    
}
