import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * JAVA MULTITHREAD - SynchronousQueue
 * 
 * @author MarcusCSPereira
 */
public class SynchronousQueue_1 {

  private static final SynchronousQueue<String> FILA = 
      new SynchronousQueue<>();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();

    Runnable r1 = () -> {
      put("Eu sou a mensagem!, vim da thread: " + Thread.currentThread().getName());
      System.out.println("Escreveu na fila!");
    };
    Runnable r2 = () -> {
      String msg = take();
      System.out.println("Pegou da fila! ");
      System.out.println("Mensagem: " + msg + " e estou sendo impressa agora na thread: " + Thread.currentThread().getName());
    };

    executor.execute(r1);
    executor.execute(r2);

    executor.shutdown();
  }

  private static String take() {
    try {
      return FILA.take();
//      return FILA.poll(timeout, unit);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
      return "Exceção!";
    }
  }

  private static void put(String mensagem) {
    try {
      FILA.put(mensagem);
//      FILA.offer(e, timeout, unit);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }

}
