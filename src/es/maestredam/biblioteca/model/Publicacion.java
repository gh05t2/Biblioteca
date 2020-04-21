package es.maestredam.biblioteca.model;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Publicacion implements Comparable {
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private static int CODIGO_INC=1;
    protected int codigo;
    protected String titulo;
    protected int yearPublic;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor principal de la clase Publicacion y el cual se va a heredar
     * @param titulo Titulo de la publicación
     * @param yearPublic Fecha de la publicación
     */
    public Publicacion(String titulo, int yearPublic){
        this.titulo=titulo;
        this.yearPublic=yearPublic;
        codigo=CODIGO_INC++;
    }

    /**
     * Constructor sobrecargado
     * @param titulo Titulo de la publicación
     */
    public Publicacion(String titulo){
        this.titulo=titulo;
        yearPublic=Calendar.getInstance().get(Calendar.YEAR);
        codigo=CODIGO_INC++;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Getters de la clase Publicacion
     */
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getYearPublic() {
        return yearPublic;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Operaciones">
    /**
     * Método que devuelve una cadena con el contenido de una Publicacion
     * @return Publicacion
     */
    public String toString(){
        return "Publicación nº "+codigo+" llamada "+titulo+" y publicada en "+yearPublic;
    }

    /**
     * Compara el código de dos objetos Publicacion
     * @param otro Segundo objeto Publicacion
     * @return La igualdad entre los códigos de los objetos
     */
    public boolean equals(Publicacion otro){
        return codigo==otro.codigo;
    }

    /**
     * Método que calcula la antigüedad de una Publicación en años comparándo el año en el que se creó con el año de
     * la fecha actual
     * @return Antigüedad de la publicación
     */
    public int getAntiguedad(){
        return (new Date().getYear())-yearPublic;
    }
    //</editor-fold>
    //</editor-fold>
}
