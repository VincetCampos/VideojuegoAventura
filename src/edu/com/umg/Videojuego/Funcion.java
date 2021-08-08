package edu.com.umg.Videojuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcion {

    Heroe heroe = new Heroe();

    Enemigo enemigo1 = new Enemigo();

    Scanner entrada = new Scanner(System.in);

    private List<ObjetoInmueble> objetosInmuebles;

    int y = 0;

    int x = 0;

    int vidas = 3;

    boolean gameOver = false;

    boolean victoria = false;

    boolean derrota = false;


    public Funcion(){
        heroe.setEjeX(0);
        heroe.setEjeY(0);
        heroe.setNombre("Heroe");
        heroe.setNivelEnergia(100);
        heroe.setCapacidadOfensiva(25);
        heroe.setNoVidas(vidas);

        objetosInmuebles = new ArrayList<>();

        enemigo1.setNombre("Enemigo normal");
        enemigo1.setEjeX(2);
        enemigo1.setEjeY(5);
        enemigo1.setNoVidas(1);
        enemigo1.setNivelEnergia(100);
        enemigo1.setCapacidadOfensiva(20);

    }

    public void correrJuego(){
        crearObjetosInmuebles();
        while(gameOver == false){
            ImprimirStats();
            avanzar();
            infoObjetoInmueble();
            batalla();
            terminarJuego();
        }
    }

    public void crearObjetosInmuebles(){

        ObjetoInmueble objetoInmueble1 = new ObjetoInmueble();

        objetoInmueble1.setEjeY(2);
        objetoInmueble1.setEjeX(1);
        objetoInmueble1.setNombre("Letrero");
        objetoInmueble1.setInfoinmueble("El letrero dice que " +
                "\n te quiere");

        objetosInmuebles.add(objetoInmueble1);

        ObjetoInmueble objetoInmueble2 = new ObjetoInmueble();
        objetoInmueble2.setEjeY(5);
        objetoInmueble2.setEjeX(4);
        objetoInmueble2.setNombre("árbol");
        objetoInmueble2.setInfoinmueble("Es una árbol muy alto");

        objetosInmuebles.add(objetoInmueble2);
    }

    public void avanzar(){

            String moverse = entrada.nextLine();

            if(moverse.equals("W")|| moverse.equals("w")){
                y++;
                heroe.setEjeY(y);

                if (heroe.getEjeY() > 10){
                    System.out.println("No se puede avanzar mas");
                    heroe.setEjeY(y--);
                }

            }else if (moverse.equals("D") || moverse.equals("d")){
                x++;
                heroe.setEjeX(x);

                if (heroe.getEjeX() > 10){
                    System.out.println("No se puede avanzar mas");
                    heroe.setEjeX(x--);
                }

            }else if (moverse.equals("S") || moverse.equals("s")){
                y--;
                heroe.setEjeY(y);

                if (heroe.getEjeY() < -10){
                    System.out.println("No se puede avanzar mas");
                    heroe.setEjeY(y++);
                }
            }else if (moverse.equals("A") || moverse.equals("a")) {
                x--;
                heroe.setEjeX(x);
                if (heroe.getEjeX() < -10){
                    System.out.println("No se puede avanzar mas");
                    heroe.setEjeX(x++);
                }
            }else if (moverse.equals("rendirse")) {
                heroe.setNoVidas(0);
            }else {
                System.out.println("Ese no es un comando valido");
            }

    }
    public void ImprimirStats(){
        System.out.println("Coordenada en Y: " + heroe.getEjeY() + " Coordenada en X: " + heroe.getEjeX());
        System.out.println("Estadisticas \n" +
                heroe.getNombre() + " Energia: " + heroe.getNivelEnergia() + " Poder: " + heroe.getCapacidadOfensiva() +
                "\n Vidas: " + heroe.getNoVidas());
    }

    public void terminarJuego(){

        if(heroe.getNivelEnergia() == 0){
            System.out.println("Has sido derrotado");
            heroe.setNoVidas(heroe.getNoVidas()-1);
            heroe.setNivelEnergia(100);
            System.out.println("Le quedan: " + heroe.getNoVidas() + " vida(s)");
            heroe.setEjeY(0);
            heroe.setEjeX(0);
        }
        if (heroe.getNoVidas() == 0){
            System.out.println("Game Over");
            gameOver = true;
        }
    }
    public void infoObjetoInmueble() {
        for (ObjetoInmueble objetoInmueble : objetosInmuebles) {
            if (heroe.getEjeX() == objetoInmueble.getEjeX() && heroe.getEjeY() == objetoInmueble.getEjeY()) {
                System.out.println("El heroe se encontro con un " + objetoInmueble.getNombre()
                        +  " " + objetoInmueble.getInfoinmueble());
                System.out.println("El heroe da un paso hacia la izquierda");
                heroe.setEjeX(x--);
                break;
            }
        }
    }

    public void batalla(){
        do {
            if (heroe.getEjeX() == enemigo1.getEjeX() && heroe.getEjeY() == enemigo1.getEjeY()){
                System.out.println("Heroe: " + " Energia: " + heroe.getNivelEnergia() +
                        "\n     Poder de ataque: " + heroe.getCapacidadOfensiva());

                System.out.println(enemigo1.getNombre() + " Energia: " + enemigo1.getNivelEnergia());

                System.out.println("Has entrado en una batalla contra un " + enemigo1.getNombre());
                System.out.println("Que vas a hacer");
                System.out.println("presione 1 para Atacar");
                System.out.println("presione 2 para usar un objeto");
                String decisionBatalla = entrada.nextLine();
                if (decisionBatalla.equals("1")){
                    System.out.println("Has lanzado un golpe preciso al " + enemigo1.getNombre() + " le provocas "
                            + heroe.getCapacidadOfensiva() + " puntos de daño");

                    enemigo1.setNivelEnergia(enemigo1.getNivelEnergia() - heroe.getCapacidadOfensiva());

                }else if (decisionBatalla.equals("2")){
                    System.out.println("en proceso");
                }else {
                    System.out.println("Esa no es una opcion");
                }
                System.out.println("El " + enemigo1.getNombre() + " te golpea y de hace "
                        + enemigo1.getCapacidadOfensiva() + " puntos de daño");

                heroe.setNivelEnergia(heroe.getNivelEnergia() - enemigo1.getCapacidadOfensiva());

                if (enemigo1.getNivelEnergia() == 0){
                    System.out.println("Enemigo abatido");
                    victoria = true;
                    enemigo1.setEjeX(15);

                }else if(heroe.getNivelEnergia() == 0){
                    derrota = true;
                    terminarJuego();
                }

            }else{
                break;
            }
        }while (!victoria || !derrota);
    }

}
