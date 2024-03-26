import java.util.concurrent.CompletableFuture;

/**
 * JAVA MULTITHREAD - CompletableFuture (simples)
 * 
 * @author MarcusCSPereira
 */
public class CompletableFuture_1 {

  public static void main(String[] args) {
    CompletableFuture<String> processe = processe();
    
    CompletableFuture<String> thenApply = 
        processe.thenApply(s -> s + " Lembre-se do porquê você começou!");
    
    CompletableFuture<Void> thenAccept = 
        thenApply.thenAccept(s -> System.out.println(s));
    
    System.out.println("Nunca pare de estudar!");
    
    sleep();
    sleep();
    sleep();
  }

  private static CompletableFuture<String> processe() {
    return CompletableFuture.supplyAsync(() -> {
      sleep();
      return "Fim das Aulas de Java Multithread!";
    });
  }
  
  private static final void sleep() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }

}