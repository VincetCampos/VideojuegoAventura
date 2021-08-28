package MethodFactory;

public class Batman extends NPC{

    public Batman(){
        setNombreNPC("Batman");

        int numeroX = (int) (Math.random()*10+1);

        int numeroY = (int) (Math.random()*10+1);

        setEjeX(numeroX);

        setEjeY(numeroY);

        System.out.println("Coordenadas: "+ getNombreNPC() + " Y: " + getEjeY() + " X: " + getEjeX());
    }
}
