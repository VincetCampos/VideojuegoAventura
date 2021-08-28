package MethodFactory;

public abstract class NPC {

    private int EjeX;

    private int EjeY;

    private String nombreNPC;

    public int getEjeX() {
        return EjeX;
    }

    public void setEjeX(int ejeX) {
        EjeX = ejeX;
    }

    public int getEjeY() {
        return EjeY;
    }

    public void setEjeY(int ejeY) {
        EjeY = ejeY;
    }

    public String getNombreNPC() {
        return nombreNPC;
    }

    public void setNombreNPC(String nombreNPC) {
        this.nombreNPC = nombreNPC;
    }

}
