package model;

public class ComputaPrimos extends Thread{

    private int limiteInferior, limiteSuperior, contadorPrimos = 0;

    public ComputaPrimos(int limiteInferior, int limiteSuperior){
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    @Override
    public void run(){
        for(int i = this.limiteInferior; i <= this.limiteSuperior; i++){
            if(isPrimo(i)){
                contadorPrimos++;
            }
        }
    }

    private boolean isPrimo(int numero){
        for(int i = 2; i < numero; i++){
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }

    public int getContadorPrimos(){
        return contadorPrimos;
    }
}
