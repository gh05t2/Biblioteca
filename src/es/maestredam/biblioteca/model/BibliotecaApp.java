package es.maestredam.biblioteca.model;
import java.util.Calendar;

public class BibliotecaApp {
    public static void main(String[] args) {
        Libro lib1 = new Libro("La Odisea", 5, Calendar.getInstance().get(Calendar.YEAR));
        Libro lib2 = new Libro("La Ilíada", 5, Calendar.getInstance().get(Calendar.YEAR));
        Libro lib3 = new Libro("Desvirgando a la noche con poemas suicidas", 10,
                Calendar.getInstance().get(Calendar.YEAR));

        Revista rev1 = new Revista("Hobbyconsolas");
        Revista rev2 = new Revista("Planeta Manga");

        Publicacion[] publicaciones = {lib1, lib2, lib3, rev1, rev2};

        for(Publicacion recorre : publicaciones)
            System.out.printf("%s ",recorre.getTitulo());

        lib1.prestar();

        System.out.println(getTopLibro(publicaciones).toString());

        System.out.printf("Cuántas publicaciones hay prestadas: %d\n", cuentaPrestados(publicaciones));

        System.out.printf("Cuántas publicaciones son anteriores a 2019: %d\n", publicacionesAnterioresA(publicaciones,
                2019));

        Publicacion antique=publicaciones[0];
        for(int i=1; i<publicaciones.length; i++)
            if(publicaciones[i].getAntiguedad() > antique.getAntiguedad())
                antique=publicaciones[i];
        System.out.printf("Publicación más antigua: %s\n",antique.getTitulo());

        System.out.printf("Número de ejemplares totales: %d\n", cuentaNumEjemplares(publicaciones));

        for(Publicacion recorre : publicaciones) {
            System.out.printf("%s tiene ",recorre.getTitulo());
            if (recorre instanceof Libro)
                System.out.printf("%d ejemplares\n", ((Libro) recorre).getNumEjemplares());
            else
                System.out.println("2 ejemplares");
        }
    }

    private static Libro getTopLibro(Publicacion[] publicacions){
        Libro resultado = null;
        for(Publicacion recorre : publicacions)
            if(recorre instanceof Libro && ((Libro) recorre).getVecesPrestado() > resultado.getVecesPrestado())
                resultado=(Libro)recorre;

        return resultado;
    }

    private static Libro[] getTopLibro(Publicacion[] publicacions, Libro libMayor){
        Libro[] resultado = new Libro[publicacions.length];
        int i=0;
        for(Publicacion recorre : publicacions)
            if(recorre instanceof Libro && ((Libro) recorre).getVecesPrestado() == libMayor.getVecesPrestado()) {
                resultado[i] = (Libro) recorre;
                i++;
            }

        return resultado;
    }

    private static int cuentaPrestados(Publicacion[] publicacions){
        int sumPrestados=0;
        for(Publicacion recorre : publicacions)
            if(recorre instanceof Libro)
                sumPrestados+=((Libro) recorre).getCountPrestados();

        return sumPrestados;
    }

    private static int publicacionesAnterioresA(Publicacion[] publicacions, int yearComp){
        int count=0;
        for(Publicacion recorre : publicacions)
            if(yearComp > recorre.getYearPublic())
                count++;

        return count;
    }

    private static int cuentaNumEjemplares(Publicacion[] publicacions){
        int count=0;
        for(Publicacion recorre : publicacions)
            if(recorre instanceof Libro)
                count+=((Libro) recorre).getNumEjemplares();
            else
                count+=2;

        return count;
    }
}
