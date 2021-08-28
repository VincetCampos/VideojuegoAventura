package MethodFactory;

public class Deadpool extends NPC{

    public Deadpool(){
        setNombreNPC("Deadpool");

        int numeroX = (int) (Math.random()*10+1);

        int numeroY = (int) (Math.random()*10+1);

        setEjeX(numeroX);

        setEjeY(numeroY);

        System.out.println("Coordenadas: "+ getNombreNPC() + " Y: " + getEjeY() + " X: " + getEjeX());

    }

}
