import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JAVA MULTITHREAD - CyclicBarrier 
 * 1) Número de participantes
 * 
 * @author MarcusCSPereira
 */
public class CyclicBarrier_1 {

  public static void main(String[] args) {
    
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    
    ExecutorService executor = Executors.newFixedThreadPool(3);
    
    Runnable r1 = () -> {
      System.out.println(432d*3d);
      await(cyclicBarrier);
      System.out.println("Terminei o processamento 1.");
    };
    Runnable r2 = () -> {
      System.out.println(Math.pow(3d, 14d));
      await(cyclicBarrier);
      System.out.println("Terminei o processamento 2.");
    };
    Runnable r3 = () -> {
      System.out.println(45d*127d/12d);
      await(cyclicBarrier);
      System.out.println("Terminei o processamento 3.");
    };
    
    executor.submit(r1);
    executor.submit(r2);
    executor.submit(r3);
    
    executor.shutdown();
  }

  private static void await(CyclicBarrier cyclicBarrier) {
    try {
      cyclicBarrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }

}