package MethodFactory;

public class SuperMan extends NPC{

    public SuperMan(){
        setNombreNPC("SuperMan");

        int numeroX = (int) (Math.random()*10+1);

        int numeroY = (int) (Math.random()*10+1);

        setEjeX(numeroX);

        setEjeY(numeroY);

        System.out.println("Coordenadas: "+ getNombreNPC() + " Y: " + getEjeY() + " X: " + getEjeX());
    }
}
