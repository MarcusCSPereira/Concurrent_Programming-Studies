package model;

public class RoboConsumidor implements Runnable {

    Pedestal p;

    public RoboConsumidor(Pedestal p) {
        this.p = p;
    }

    public void run() {
        while (p.getPecas() < 10) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (p) {
                while (p.getLivre()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Esperando peça");
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Peça "+ p.getPecas() + " retirada");
                p.setLivre(true);
                p.notifyAll();
                System.out.println(Thread.currentThread().getName() + " Notificando");
            }
        }
    }
}
