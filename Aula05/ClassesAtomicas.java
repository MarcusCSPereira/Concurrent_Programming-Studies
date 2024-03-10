import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ClassesAtomicas {

    //static AtomicInteger i = new AtomicInteger(-1);
    //static AtomicBoolean b = new AtomicBoolean(false);
    static AtomicReference<Object> s = new AtomicReference<>(new Object());

    public static void main(String[] args) {
        MeuRunnable meuRunnable = new MeuRunnable();

        Thread t0 = new Thread(meuRunnable);
        Thread t1 = new Thread(meuRunnable);
        Thread t2 = new Thread(meuRunnable);
        t0.start();
        t1.start();
        t2.start();
    }

    public static class MeuRunnable implements Runnable {
        public void run() {
            String name = Thread.currentThread().getName();
            //System.out.println(name + " " + i.incrementAndGet());
            //System.out.println(name + " " + b.compareAndSet(false, true));
            System.out.println(name + " " + s.getAndSet(new Object()));
        }
    }
}
