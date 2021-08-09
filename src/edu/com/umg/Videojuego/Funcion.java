package edu.com.umg.Videojuego;

import Clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcion {

    Heroe heroe = new Heroe();

    Enemigo enemigo1 = new Enemigo();

    Enemigo enemigo2 = new Enemigo();

    ObjetoInmueble fuenteVida = new ObjetoInmueble();

    Scanner entrada = new Scanner(System.in);

    private List<ObjetoInmueble> objetosInmuebles;

    private List<Enemigo> enemigos;

    private List<ObjetoMueble> objetoMuebles;

    private List<Arma> armas;

    int y = 0;

    int x = 0;

    int vidas = 3;

    boolean gameOver = false;

    boolean victoria;

    boolean derrota;


    public Funcion(){
        heroe.setEjeX(0);
        heroe.setEjeY(0);
        heroe.setNombre("Heroe");
        heroe.setNivelEnergia(100);
        heroe.setCapacidadOfensiva(25);
        heroe.setNoVidas(vidas);

        fuenteVida.setEjeY(4);
        fuenteVida.setEjeX(4);
        fuenteVida.setNombre("Fuente Vida");
        fuenteVida.setInfoinmueble("Al beber de sus aguas recuperas todos los puntos de energia");

        objetosInmuebles = new ArrayList<>();

        enemigos = new ArrayList<>();

        objetoMuebles = new ArrayList<>();

        armas = new ArrayList<>();
    }

    public void correrJuego(){
        crearEnemigos();
        crearObjetosInmuebles();
        while(!gameOver){
            ImprimirStats();
            avanzar();
            infoObjetoInmueble();
            batalla();
            regenerarVida();
            terminarJuego();
        }
    }

    public void crearObjetosInmuebles(){

        ObjetoInmueble objetoInmueble1 = new ObjetoInmueble();

        objetoInmueble1.setEjeY(2);
        objetoInmueble1.setEjeX(1);
        objetoInmueble1.setNombre("Letrero");
        objetoInmueble1.setInfoinmueble("El letrero dice que: " +
                "\nEn las coordenadas Y: 5 X: 2 hay un enemigo" +
                "\nEn las coordenadas Y: 4 X: 4 existe una fuente magica" );

        objetosInmuebles.add(objetoInmueble1);

        ObjetoInmueble objetoInmueble2 = new ObjetoInmueble();
        objetoInmueble2.setEjeY(5);
        objetoInmueble2.setEjeX(4);
        objetoInmueble2.setNombre("árbol");
        objetoInmueble2.setInfoinmueble("Es una árbol muy alto");

        objetosInmuebles.add(objetoInmueble2);

    }

    public void crearEnemigos(){
        enemigo1.setNombre("Enemigo normal");
        enemigo1.setEjeX(2);
        enemigo1.setEjeY(5);
        enemigo1.setNoVidas(1);
        enemigo1.setNivelEnergia(100);
        enemigo1.setCapacidadOfensiva(20);

        enemigos.add(enemigo1);

        enemigo2.setEjeX(8);
        enemigo2.setEjeY(-3);
        enemigo2.setNombre("Enemigo fuerte");
        enemigo2.setNivelEnergia(100);
        enemigo2.setNoVidas(1);
        enemigo2.setCapacidadOfensiva(30);

        enemigos.add(enemigo2);
    }

    public void crearobjetosMuebles(){

        ObjetoMueble comida = new ObjetoMueble();

        comida.setEjeX(-4);
        comida.setEjeY(-1);
        comida.setNombre("Un sandwitch");
        comida.setDescripcionObjeto("Un sandwitch que regenera 25 puntos de salud");
        comida.setItemrecogido(false);
        objetoMuebles.add(comida);

        ObjetoMueble pocion = new ObjetoMueble();
        pocion.setEjeY(1);
        pocion.setEjeX(-5);
        pocion.setNombre("Pocion regenerativa");
        pocion.setDescripcionObjeto("Pocion capaz de regenerar toda la vida");
        pocion.setItemrecogido(false);
        objetoMuebles.add(pocion);

        Arma espada = new Arma();
        espada.setEjeY(3);
        espada.setEjeX(3);
        espada.setNombre("Espada Corta");
        espada.setDescripcionObjeto("Espada que otorga un incremento de 10 puntos de ataque");
        espada.setNivelEnergia(50);
        espada.setPotenciarAtaque(10);
        espada.setItemrecogido(false);
        armas.add(espada);
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
    public void regenerarVida(){
        if (heroe.getEjeX() == fuenteVida.getEjeX() && heroe.getEjeY() == fuenteVida.getEjeY()){
            System.out.println("Has encontrado: " + fuenteVida.getNombre());
            System.out.println(fuenteVida.getInfoinmueble());
            if (heroe.getNivelEnergia() == 100){
                System.out.println("Ya tienes todas tus energias");
            }else{
                System.out.println("Tus energias han sido renovadas");
                heroe.setNivelEnergia(100);
            }
        }
    }

    public void ImprimirStats(){
        System.out.println("Estadisticas \n" +
                heroe.getNombre() + " Energia: " + heroe.getNivelEnergia() + " Poder: " + heroe.getCapacidadOfensiva() +
                "\nVidas: " + heroe.getNoVidas());
        System.out.println("Coordenada en Y: " + heroe.getEjeY() + " Coordenada en X: " + heroe.getEjeX());
    }

    public void terminarJuego(){

        if(heroe.getNivelEnergia() <= 0){
            System.out.println("Has sido derrotado");
            heroe.setNoVidas(heroe.getNoVidas()-1);
            heroe.setNivelEnergia(100);
            System.out.println("Le quedan: " + heroe.getNoVidas() + " vida(s)");
            heroe.setEjeX(0);
            heroe.setEjeY(0);
            y = 0;
            x = 0;
            System.out.println("Ten han enviado a las coordenas X: " + heroe.getEjeX() + " y " +
                    "las coordenadas Y: " + heroe.getEjeY());
        }
        if (heroe.getNoVidas() == 0){
            System.out.println("Game Over");
            gameOver = true;
        }
        if(enemigo1.getNoVidas() == 0 && enemigo2.getNoVidas() == 0){
            System.out.println("Has derrotado a todos los enemigos" +
                    "\nFin del juego");

            gameOver = true;

        }
    }
    public void infoObjetoInmueble() {
        for (ObjetoInmueble objetoInmueble : objetosInmuebles) {
            if (heroe.getEjeX() == objetoInmueble.getEjeX() && heroe.getEjeY() == objetoInmueble.getEjeY()) {
                System.out.println("El heroe se encontro con un " + objetoInmueble.getNombre()
                        +  " " + objetoInmueble.getInfoinmueble());
                break;
            }
        }
    }

    public void batalla(){
        victoria = false;
        derrota = false;
        for (Enemigo enemigo : enemigos){
            do {
                if (heroe.getEjeX() == enemigo.getEjeX() && heroe.getEjeY() == enemigo.getEjeY()){
                    System.out.println("Heroe: " + " Energia: " + heroe.getNivelEnergia() +
                            "\n     Poder de ataque: " + heroe.getCapacidadOfensiva());

                    System.out.println(enemigo.getNombre() + " Energia: " + enemigo.getNivelEnergia());

                    System.out.println("Has entrado en una batalla contra un " + enemigo.getNombre());
                    System.out.println("Que vas a hacer");
                    System.out.println("presione 1 para Atacar");
                    System.out.println("presione 2 para usar un objeto");
                    String decisionBatalla = entrada.nextLine();
                    if (decisionBatalla.equals("1")){
                        System.out.println("Has lanzado un golpe preciso al " + enemigo.getNombre() + " le provocas "
                                + heroe.getCapacidadOfensiva() + " puntos de daño");

                        enemigo.setNivelEnergia(enemigo.getNivelEnergia() - heroe.getCapacidadOfensiva());

                    }else if (decisionBatalla.equals("2")){
                        System.out.println("en proceso");
                    }else {
                        System.out.println("Esa no es una opcion");
                    }
                    System.out.println("El " + enemigo.getNombre() + " te golpea y de hace "
                            + enemigo.getCapacidadOfensiva() + " puntos de daño");

                    heroe.setNivelEnergia(heroe.getNivelEnergia() - enemigo.getCapacidadOfensiva());

                    if (enemigo.getNivelEnergia() <= 0){
                        System.out.println("Enemigo abatido");
                        victoria = true;
                        enemigo.setNoVidas(enemigo.getNoVidas()-1);

                    }else if(heroe.getNivelEnergia() <= 0){
                        derrota = true;
                        terminarJuego();
                    }
                    if (enemigo.getNoVidas() == 0){
                        enemigo.setEjeX(15);
                    }
                }else{
                    break;
                }
            }while (!victoria || !derrota);
        }
    }
}
