import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SincronizarColecoes {

    //private static List<String> lista = Collections.synchronizedList(new ArrayList<String>());

    //private static ConcurrentHashMap<Integer, String> lista = new ConcurrentHashMap<>();

    private static BlockingQueue<String> fila = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException{

        MeuRunnable meuRunnable = new MeuRunnable();
        Thread t0 = new Thread(meuRunnable);
        Thread t1 = new Thread(meuRunnable);
        Thread t2 = new Thread(meuRunnable);

        t0.start();
        t1.start();
        t2.start();
        System.out.println(fila);
        //System.out.println(lista);
        Thread.sleep(1000);
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            //lista.add("teste");
            //lista.put(new Random().nextInt(),"teste");

            fila.add("teste");
            fila.poll();
            fila.offer("teste");
            try {
                fila.put("teste");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
