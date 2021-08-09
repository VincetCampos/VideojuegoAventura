package edu.com.umg.Videojuego;

public class Principal {

    public static void main(String[] args) {

        Universo funcion = new Universo();

        System.out.println("Bienvenido a un nuevo mundo heroe");
        System.out.println("Necesitas derrotar 2 enemigos para ganar");
        System.out.println("Para moverte puedes teclar W, A, S, D" +
                "\ny escribe mochila para acceder a tu inventario");

        funcion.correrJuego();

    }
}
