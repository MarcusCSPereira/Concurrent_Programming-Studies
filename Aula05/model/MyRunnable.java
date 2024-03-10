package model;

public class MyRunnable implements Runnable{

    static int count = 0;

    //static Object Lock1 = new Object();
    //static Object Lock2 = new Object();

    @Override
    public void run() {
        int i;
        synchronized(MyRunnable.class){
            count++;
            i = count*2;
        }

        double iElevadoA10 = Math.pow(i, 10);
        double sqrt = Math.sqrt(iElevadoA10);
        System.out.printf("%.2f%n",sqrt);
    }

    /*public static void imprimi(){
        synchronized(MyRunnable.class){
            System.out.println("Thread " + Thread.currentThread().getName() + " is running. Count: " + count);
        }
    }*/
    
} 
