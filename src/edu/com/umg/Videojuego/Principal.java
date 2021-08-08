package edu.com.umg.Videojuego;

public class Principal {

    public static void main(String[] args) {

        Funcion funcion = new Funcion();

        System.out.println("Bienvenido");
        System.out.println("Para moverte puedes teclar W, A, S, D");

        funcion.correrJuego();

    }
}
