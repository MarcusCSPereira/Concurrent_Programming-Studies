package model;

public class ContadorRunnableComJoin_2 implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " iniciou");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - Contador: " + i);
        }
        System.out.println(name + " terminou");
    }
    
}
