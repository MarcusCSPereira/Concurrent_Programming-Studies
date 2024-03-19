import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Exemplo de execução de tarefas agendadas com ScheduledExecutorService
 *
 * @author MarcusCSPereira
 */

public class Executores_Scheduled {
  public static void main(String[] args) throws Exception {
  ScheduledExecutorService executor=null;

    try {
      executor = Executors.newScheduledThreadPool(3);
      //executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
      //executor.scheduleAtFixedRate(new Tarefa(), 0, 1, TimeUnit.SECONDS);
      executor.scheduleWithFixedDelay(new Tarefa(), 0, 1, TimeUnit.SECONDS);
      

    } catch (Exception e) {
      throw e;
    }finally{
      executor.shutdownNow();
    }
  }

  public static class Tarefa implements Runnable {

    @Override
    public void run() {
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      System.out.println("Cesinha te maceta");
    }
  }

 /*public static class Tarefa implements Callable<String> {

    @Override
    public String call() throws Exception {
      Thread.sleep(1000);
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      return "Hello World! " + name + " - " + nextInt;
    }
  }*/
}
