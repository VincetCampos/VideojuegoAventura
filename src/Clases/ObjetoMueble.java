package Clases;

import Clases.Entidad;

public class ObjetoMueble extends Entidad {

    private boolean itemrecogido;

    private String descripcionObjeto;

    public boolean isItemrecogido() {
        return itemrecogido;
    }

    public void setItemrecogido(boolean itemrecogido) {
        this.itemrecogido = itemrecogido;
    }

    public String getDescripcionObjeto() {
        return descripcionObjeto;
    }

    public void setDescripcionObjeto(String descripcionObjeto) {
        this.descripcionObjeto = descripcionObjeto;
    }
}
