import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Exemplo de execução de tarefas com Executor em SingleThread
 *
 * @author MarcusCSPereira
 */

public class Executors_SingleThread_Callable {
    public static void main(String[] args) throws Exception {

        ExecutorService executor=null;
        try {
            executor = Executors.newSingleThreadExecutor();

            /*
            executor.execute(new Tarefa());
            executor.execute(new Tarefa());
            executor.execute(new Tarefa());
            executor.execute(new Tarefa());
            */

            Future<?> future = executor.submit(new Tarefa());

            System.out.println(future.isDone());

            System.out.println(future.get(1, TimeUnit.SECONDS));

            /*
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS); // aguarda 5 segundos para terminar
            */

            System.out.println(future.isDone());

        } catch (Exception e) {
            throw e;
        }finally{
            if(executor!=null){
                //executor.shutdown();
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
