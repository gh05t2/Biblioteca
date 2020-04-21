package es.maestredam.biblioteca.model;

import java.util.Comparator;
import java.util.LinkedList;

public class ProyectosApp {

    public static void main(String[] args) {
        LinkedList<Prestable> colecPublicaciones = new LinkedList<>();

        colecPublicaciones.add( new Proyecto("Cuentas y otras cosas", Proyecto.TITU_AUF) );
        colecPublicaciones.add( new Proyecto("Diccionarios de objetos", Proyecto.TITU_DAM) );
        colecPublicaciones.add( new Proyecto("Motores de inyección", Proyecto.TITU_AUTO) );
        colecPublicaciones.add( new Libro("Al filo de las sombras") );

        int count=0;
        for(Prestable recorre : colecPublicaciones)
            if(recorre instanceof Proyecto && count<2) {
                recorre.prestar();
                count++;
            } else {
                assert recorre instanceof Libro;
                recorre.prestar();
            }


        System.out.printf("Publicaciones prestadas: %d\n\n", cuentaPrestados(colecPublicaciones));

        Comparator<? super Prestable> comparator = (Comparator<Prestable>) (o1, o2) -> 0;
        colecPublicaciones.sort(comparator);

        for (Prestable recorre : colecPublicaciones)
            System.out.println(recorre.toString());


        int sumNumEjemplares=0;
        for (Prestable recorre : colecPublicaciones)
            if(recorre instanceof Proyecto) {
                sumNumEjemplares++;
            } else {
                assert recorre instanceof Libro;
                sumNumEjemplares+=((Libro) recorre).getNumEjemplares();
            }
        System.out.printf("\nNumero total de ejemplares: %d",sumNumEjemplares);
    }

    public static int cuentaPrestados(LinkedList<Prestable> publi){
        int prestados=0;
        for(Prestable recorre : publi)
            if(recorre instanceof Libro)
                prestados+=((Libro) recorre).getCountPrestados();
            else if(recorre instanceof Proyecto && recorre.isPrestado())
                prestados++;

        return prestados;
    }
}
