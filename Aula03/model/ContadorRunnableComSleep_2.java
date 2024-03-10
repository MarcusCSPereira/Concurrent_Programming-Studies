package model;

public class ContadorRunnableComSleep_2 implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " iniciou");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - Contador: " + i);
            if(i % 3 ==0){
                try {
                    Thread.sleep(2000);//Método que faz a thread atual parar por um tempo determinado.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
        System.out.println(name + " terminou");
    }
    
}
