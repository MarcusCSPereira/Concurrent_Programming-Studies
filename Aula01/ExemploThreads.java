import model.MyThread;

public class ExemploThreads {
    public static void main(String[] args) {
        System.out.println("Inicio de processo:");
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
        System.out.println("Fim de processo");
    }
}
