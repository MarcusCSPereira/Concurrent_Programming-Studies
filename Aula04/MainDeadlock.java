import model.ClasseA;
import model.ClasseB;
import model.Runnable1;
import model.Runnable2;

public class MainDeadlock {

    public static void main(String[] args) {
        ClasseA objA = new ClasseA();
        ClasseB objB = new ClasseB();
        
        Runnable1 runnable1 = new Runnable1(objA, objB);
        Runnable2 runnable2 = new Runnable2(objA, objB);
        
        Thread t1 = new Thread(runnable1, "Thread 1");
        Thread t2 = new Thread(runnable2, "Thread 2");
        
        t1.start();
        t2.start();
    }
}