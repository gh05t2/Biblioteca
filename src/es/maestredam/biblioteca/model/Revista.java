package es.maestredam.biblioteca.model;

import java.util.Date;

public class Revista extends Publicacion {
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private static final int NUM_EJEMPLARES=2;
    private final int numero;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor principal de la clase Revista y el cual hereda de la clase Publicacion
     * @param titulo Titulo de la revista
     * @param numero Número del ejemplar de la revista en la biblioteca
     * @param yearPublic Fecha del libro
     */
    public Revista(String titulo, int yearPublic, int numero){
        super(titulo,yearPublic);
        this.numero=numero;
    }

    /**
     * Constructor principal de la clase revista y el cual hereda de la clase Publicacion
     * @param titulo Titulo del libro
     */
    public Revista(String titulo){
        super(titulo);
        numero=1;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Getters de la clase Publicacion
     */
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getNumero() {
        return numero;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Operaciones">
    /**
     * Método que devuelve una cadena con la información de una Revista, que llama en primera instancia al método
     * toString de la clase Publicacion
     * @return Revista
     */
    @Override
    public String toString(){
        return super.toString()+"\nEs una revista y su número de publicación es "+numero;
    }

    /**
     * Método equals del interface comparable
     * @param otro Segundo objeto Publicacion
     * @return Igualdad entre el año de publicación
     */
    @Override
    public boolean equals(Publicacion otro) {
        return this.yearPublic==otro.yearPublic;
    }
    //</editor-fold>
    //</editor-fold>
}
