package edu.com.umg.Videojuego;

import Clases.*;
import MethodFactory.NPC;
import MethodFactory.NPCFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Universo {

    Heroe heroe = new Heroe();

    Enemigo enemigo1 = new Enemigo();

    Enemigo enemigo2 = new Enemigo();

    ObjetoInmueble fuenteVida = new ObjetoInmueble();

    Scanner entrada = new Scanner(System.in);

    private List<ObjetoInmueble> objetosInmuebles;

    private List<Enemigo> enemigos;

    private List<ObjetoMueble> objetoMuebles;

    private List<Arma> armas;

    //usar mapas para obtener y sobreescribir datos
    private Map<String , NPC> mapaNPCs;

    int y = 0;

    int x = 0;

    int vidas = 3;

    String nombreNPC;

    boolean gameOver = false;

    boolean victoria;

    boolean derrota;

    //se crea la fabrica de los npc
    private NPCFactory npcFactory = new NPCFactory();


    public Universo(){
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

        mapaNPCs = new HashMap<>();
    }

    public void correrJuego(){
        crearEnemigos();
        crearObjetosInmuebles();
        crearobjetosMuebles();
        while(!gameOver){
            crearNPC();
            ImprimirStats();
            avanzar();
            infoObjetoInmueble();
            infoObjetoMueble();
            batalla();
            encontrarNPC();
            regenerarVida();
            terminarJuego();
        }
    }
    public void crearNPC(){

        //una forma de obtener numeros aleatorios
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10);

        //usar switch cuando se ocupan numeros
        switch (randomNum){
            case 0:
                nombreNPC = "SpiderMan";
                break;
            case 1:
                nombreNPC = "Venom";
                break;
            case 2:
                nombreNPC = "Deadpool";
                break;
            case 3:
                nombreNPC = "SuperMan";
                break;
            case 4:
                nombreNPC = "Batman";
            default:
                return;
        }

        //guardar los datos en arreglos o mapas para que no desaparescan despues de salir del scope
        //forma para ingresar los datos en un mapa
        mapaNPCs.put(nombreNPC , npcFactory.fabricarNPC(nombreNPC));
    }
    public void encontrarNPC(){

        //System.out.println("Coordenadas heore: "+ heroe.getEjeY() + " " + heroe.getEjeX());

        //un for que itera el mapa, obtiene los datos y los compara

        for (var entry : mapaNPCs.entrySet()) {
            NPC npc = entry.getValue();
            if (heroe.getEjeY() == npc.getEjeY() && heroe.getEjeX() == npc.getEjeX()){
                System.out.println("Hola me encontraste, mi nombre es " + npc.getNombreNPC());
            }
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
        comida.setDescripcionObjeto("Un sandwitch que aumenta 25 puntos de salud");
        objetoMuebles.add(comida);

        ObjetoMueble pocion = new ObjetoMueble();
        pocion.setEjeY(1);
        pocion.setEjeX(-5);
        pocion.setNombre("Pocion regenerativa");
        pocion.setDescripcionObjeto("Pocion capaz de aumentar la vida");
        objetoMuebles.add(pocion);

        Arma espada = new Arma();
        espada.setEjeY(3);
        espada.setEjeX(3);
        espada.setNombre("Espada Corta");
        espada.setDescripcionObjeto("Espada que otorga un incremento de 10 puntos de ataque");
        espada.setNivelEnergia(50);
        espada.setPotenciarAtaque(10);
        objetoMuebles.add(espada);

        Arma flechas = new Arma();
        flechas.setEjeY(-2);
        flechas.setEjeX(-3);
        flechas.setNombre("Flechas");
        flechas.setDescripcionObjeto("Flecha robustas con un Arco");
        flechas.setNivelEnergia(0);
        flechas.setPotenciarAtaque(15);
        objetoMuebles.add(flechas);
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
            }
            else if (moverse.equals("mochila")) {
                if (heroe.vermochila() > 0){
                    System.out.println("Elije que item quieres usar");
                    String eleccion = entrada.nextLine();
                    int seleccionInt;
                    try {
                        seleccionInt = Integer.parseInt(eleccion);
                        heroe.usarMochila(seleccionInt);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Seleccion Invalida");
                    }
                }
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
                    String decisionBatalla = entrada.nextLine();
                    if (decisionBatalla.equals("1")){
                        System.out.println("Has lanzado un golpe preciso al " + enemigo.getNombre() + " le provocas "
                                + heroe.getCapacidadOfensiva() + " puntos de daño");

                        enemigo.setNivelEnergia(enemigo.getNivelEnergia() - heroe.getCapacidadOfensiva());

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

    public void infoObjetoMueble(){
        for (ObjetoMueble objetoMueble : objetoMuebles) {
            if (heroe.getEjeX() == objetoMueble.getEjeX() && heroe.getEjeY() == objetoMueble.getEjeY()) {
                System.out.println("El heroe se encontro con un item " + objetoMueble.getNombre()
                        +  " " + objetoMueble.getDescripcionObjeto());
                System.out.println("Desea recogerlo? (S/N)");
                String respuesta = entrada.nextLine();
                if ("S".equals(respuesta) || "s".equals(respuesta)){
                    if (heroe.recogerItem(objetoMueble)){
                        objetoMuebles.remove(objetoMueble);
                        System.out.println("Item recogido");
                    }else{
                        System.out.println("No se puede recoger la mochila esta llena");
                    }
                }
                break;
            }
        }
    }
}
