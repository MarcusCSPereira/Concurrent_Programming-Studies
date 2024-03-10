import model.ContadorRunnableComSleep_2;
import model.ContadorRunnableComYield_2;
import model.ContadorRunnable_2;
import model.ContadorRunnableComJoin_2;

public class Main_2 {
    public static void main(String[] args) {
        //A cada execução o resultado pode ser diferente, pois as threads são executadas de forma concorrente.

        System.out.println("Main iniciou");

        /*Aplicando método contador sem nenhum método de controle:
        Thread t1 = new Thread(new ContadorRunnable_2(), "Thread 1");
        Thread t2 = new Thread(new ContadorRunnable_2(), "\tThread 2");
        

        /*Aplicando método contador com yield:
        Thread t1 = new Thread(new ContadorRunnableComYield_2(), "Thread 1");
        Thread t2 = new Thread(new ContadorRunnableComYield_2(), "\tThread 2");
        */
        
        /*Aplicando método contador com sleep:
        Thread t1 = new Thread(new ContadorRunnableComSleep_2(), "Thread 1");
        Thread t2 = new Thread(new ContadorRunnableComSleep_2(), "\tThread 2");
        */

        //Utilizando o método join para que a thread da classe Main espere as outras threads terminarem:
        Thread t1 = new Thread(new ContadorRunnableComJoin_2(), "Thread 1");
        Thread t2 = new Thread(new ContadorRunnableComJoin_2(), "\tThread 2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nAs duas threads terminaram a contagem");
    }
}
