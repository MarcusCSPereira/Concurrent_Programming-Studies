package model;

public class RoboProdutor implements Runnable {

    Pedestal p;

    public RoboProdutor(Pedestal p) {
        this.p = p;
    }

    public void run() {
        while (p.getPecas() < 10) {
            System.out.println(Thread.currentThread().getName() + " Produzindo peça");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            synchronized (p) {
                while (!p.getLivre()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Esperando retirada de peça");
                        p.wait();
                    } catch (InterruptedException e) {
                    }
                }
                p.setPecas(p.getPecas()+1);
                System.out.println(Thread.currentThread().getName() + " Peça " + p.getPecas() + " colocada");
                p.setLivre(false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                p.notifyAll();
                System.out.println(Thread.currentThread().getName() + " Notificando");
            }
        }
    }
}