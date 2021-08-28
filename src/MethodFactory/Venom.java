package MethodFactory;

public class Venom extends NPC {

    public Venom(){
        setNombreNPC("Venom");

        int numeroX = (int) (Math.random()*10+1);

        int numeroY = (int) (Math.random()*10+1);

        setEjeX(numeroX);

        setEjeY(numeroY);

        System.out.println("Coordenadas: "+ getNombreNPC() + " Y: " + getEjeY() + " X: " + getEjeX());
    }
}
