package model;

public class Pedestal {
    private boolean livre = true;
    private int pecas = 0;

    public void setLivre(boolean livre) {
        this.livre = livre;
    }
    public boolean getLivre() {
        return livre;
    }

    public void setPecas(int pecas) {
        this.pecas = pecas;
    }
    public int getPecas() {
        return pecas;
    }

}
