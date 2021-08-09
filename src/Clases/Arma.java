package Clases;

public class Arma extends ObjetoMueble {

    private int nivelEnergia;

    private int potenciarAtaque;

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public int getPotenciarAtaque() {
        return potenciarAtaque;
    }

    public void setPotenciarAtaque(int potenciarAtaque) {
        this.potenciarAtaque = potenciarAtaque;
    }
}
