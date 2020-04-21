package es.maestredam.biblioteca.model;
import java.util.Date;

public class Libro extends Publicacion implements Prestable {
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private final int numEjemplares;
    private boolean prestado=false;
    private static int countPrestados=0;
    private int vecesPrestado=0;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor principal de la clase Libro y el cual hereda de la clase Publicacion
     * @param titulo Titulo del libro
     * @param numEjemplares Número de ejemplares del libro en la biblioteca
     * @param yearPublic Fecha del libro
     */
    public Libro(String titulo, int numEjemplares, int yearPublic){
        super(titulo,yearPublic);
        this.numEjemplares=numEjemplares;
    }

    /**
    * Constructor principal de la clase Libro y el cual hereda de la clase Publicacion
    * @param titulo Titulo del libro
    */
    public Libro(String titulo){
        super(titulo);
        numEjemplares = 10;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Getters de la clase Publicacion
     */
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getNumEjemplares() {
        return numEjemplares;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public int getCountPrestados() {
        return countPrestados;
    }

    public int getVecesPrestado() {
        return vecesPrestado;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Operaciones">
    /**
     * Método para prestar un objeto Libro de la biblioteca
     * Implementado de la interface Prestable
     */
    public void prestar(){
        prestado=true;
        countPrestados++;
        vecesPrestado++;
    }

    /**
     * Método para devolver un objeto Libro prestado a la biblioteca
     * Implementado de la interface Prestable
     */
    public void devolver(){
        if(countPrestados == 0)
            prestado=false;
        else
            countPrestados--;
    }

    /**
     * Método que devuelve una cadena con la información de un Libro, que llama en primera instancia al método toString
     * de la clase Publicacion
     * @return Libro
     */
    @Override
    public String toString(){
        return super.toString()+"\nEs un libro que se ha prestado "+vecesPrestado+" y que se encuentran prestados "+
                countPrestados+" ejemplares del total de "+numEjemplares;
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
