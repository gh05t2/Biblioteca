package es.maestredam.biblioteca.model;

public class Proyecto extends Publicacion implements Prestable, Comparable {
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int titulacion;
    private boolean prestado=false;
    private int vecesPrestado=0;

    //<editor-fold defaultstate="collapsed" desc="Constantes Públicas">
    /**
     * Titulación Administración y finanzas
     */
    public final static int TITU_AUF = 0;

    /**
     * Tiyulación Desarrollo Ap. Multiplataforma
     */
    public final static int TITU_DAM = 1;

    /**
     * Titulación Automoción
     */
    public final static int TITU_AUTO = 2;

    /**
     * Array de cadenas con la descripción de cada titulación
     */
    private final static String titulaciones[]={"Administración y finanzas", "Desarrollo Ap. Multiplataforma",
            "Automoción"};
    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor principal de la clase Libro y el cual hereda de la clase Publicacion
     * @param titulo Titulo del libro
     * @param yearPublic Fecha del libro
     */
    public Proyecto(String titulo, int yearPublic, int titulacion){
        super(titulo,yearPublic);
        this.titulacion=titulacion;
    }

    /**
     * Constructor principal de la clase Libro y el cual hereda de la clase Publicacion
     * @param titulo Titulo del libro
     */
    public Proyecto(String titulo, int titulacion){
        super(titulo);
        this.titulacion=titulacion;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Getters de la clase Proyecto
     */
    //<editor-fold defaultstate="collapsed" desc="Getters">
    @Override
    public boolean isPrestado() {
        return prestado;
    }

    public String getTitulacion() {
        return titulaciones[titulacion];
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Operaciones">
    /**
     * Método para prestar un objeto Proyecto
     * Implementado de la interface Prestable
     */
    @Override
    public void prestar() {
        prestado=true;
        vecesPrestado++;
    }

    /**
     * Método para devolver un objeto Proyecto prestado a la biblioteca
     * Implementado de la interface Prestable
     */
    @Override
    public void devolver() throws IllegalAccessError{
        if(prestado)
            prestado=false;
        else
            throw new IllegalAccessError("No se puede devolver el proyecto porque no se ha prestado");
    }

    /**
     * Método que devuelve una cadena con la información de un Libro, que llama en primera instancia al método toString
     * de la clase Publicacion
     * @return Libro
     */
    @Override
    public String toString(){
        return super.toString()+"\nEs un proyecto de grado superior de "+getTitulacion()+" que se ha prestado "
                +vecesPrestado+" veces";
    }

    /**
     * Compara el código de dos objetos Proyecto
     * @param otro Segundo objeto Proyecto
     * @return La igualdad entre los códigos de los objetos
     */
    @Override
    public boolean equals(Publicacion otro){
        return otro instanceof Proyecto && super.equals(otro) && this.titulacion==((Proyecto) otro).titulacion;
    }
    //</editor-fold>
    //</editor-fold>
}
