import model.Pedestal;
import model.RoboConsumidor;
import model.RoboProdutor;

public class MainProdutoConsumidor {

    public static void main(String[] args) {
        Pedestal p = new Pedestal();
        Thread prod = new Thread(new RoboProdutor(p), "Produtor");
        Thread cons = new Thread(new RoboConsumidor(p), "\tConsumidor");
        //Thread cons2 = new Thread(new RoboConsumidor(p), "Consumidor2");
        cons.start();//Não é necessário ordem de start no caso, pois um depende da sincronização do outro
        //cons2.start();
        prod.start();
    }
}