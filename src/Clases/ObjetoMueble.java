package Clases;

import Clases.Entidad;

public class ObjetoMueble extends Entidad {


    private String descripcionObjeto;

    private int nivelEnergia;

    public ObjetoMueble(){
        nivelEnergia = 25;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public String getDescripcionObjeto() {
        return descripcionObjeto;
    }

    public void setDescripcionObjeto(String descripcionObjeto) {
        this.descripcionObjeto = descripcionObjeto;
    }
}
