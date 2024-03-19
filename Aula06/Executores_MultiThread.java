import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Exemplo de execução de tarefas com Executor em MultiThread
 *
 * @author MarcusCSPereira
 */

public class Executores_MultiThread {


  public static void main(String[] args) throws Exception {

  ExecutorService executor = null;

    try {
      //executor = Executors.newFixedThreadPool(4);
      executor = Executors.newCachedThreadPool();
      Tarefa t1 = new Tarefa();
      Tarefa t2 = new Tarefa();
      Tarefa t3 = new Tarefa();
      Tarefa t4 = new Tarefa();

      List<Tarefa> tarefas = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        tarefas.add(new Tarefa());
      }

      String string = executor.invokeAny(tarefas);
      System.out.println(string);

      /*List<Future<String>> list = executor.invokeAll(tarefas);

      for (Future<String> future : list) {
        System.out.println(future.get());
      }*/

      executor.shutdown();

    } catch (Exception e) {
      throw e;
    }finally{
      if(executor!=null){
        executor.shutdownNow();
      }
    }
  }

  public static class Tarefa implements Callable<String> {

    @Override
    public String call() throws Exception {
      Thread.sleep(1000);
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      return "Hello World! " + name + " - " + nextInt;
    }
  }
}
