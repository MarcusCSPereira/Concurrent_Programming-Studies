import model.ComputaPrimos;

public class ImprimePrimos {
    public static void main(String[] args) {
        System.out.println("Inicio de processo:\n");

        int inicio=5;
        int fim=25;

        ComputaPrimos t1 = new ComputaPrimos(inicio, fim/2);
        t1.start();
        ComputaPrimos t2 = new ComputaPrimos((fim/2)+1, fim);
        t2.start();
        
        // Espera as threads terminarem:
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Primos encontrados: " + (t1.getContadorPrimos() + t2.getContadorPrimos()));

        System.out.println("\nFim de processo");
    }
}
