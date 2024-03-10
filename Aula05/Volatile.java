public class Volatile {
    private static volatile int number = 0;
    private static volatile boolean ready = false;

    private static class MeuRunnable implements Runnable {
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            if(number!=42){
                System.out.println("number = " + number);
            }
        }
    }

    public static void main(String[] args) {
        while(true){
            
            Thread t0 = new Thread(new MeuRunnable());
            t0.start();
            Thread t1 = new Thread(new MeuRunnable());
            t1.start();
            Thread t2 = new Thread(new MeuRunnable());
            t2.start();

            number = 42;
            ready = true;

            while(
                t0.getState() != Thread.State.TERMINATED || t1.getState() != Thread.State.TERMINATED || t2.getState() != Thread.State.TERMINATED){

            }
            
        }
    }
}
