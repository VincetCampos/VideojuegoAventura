package Clases;

import Clases.Entidad;

public class Guerrero extends Entidad {

    private int nivelEnergia;

    private int NoVidas;

    private int capacidadOfensiva;

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public int getNoVidas() {
        return NoVidas;
    }

    public void setNoVidas(int noVidas) {
        NoVidas = noVidas;
    }

    public int getCapacidadOfensiva() {
        return capacidadOfensiva;
    }

    public void setCapacidadOfensiva(int capacidadOfensiva) {
        this.capacidadOfensiva = capacidadOfensiva;
    }
}
