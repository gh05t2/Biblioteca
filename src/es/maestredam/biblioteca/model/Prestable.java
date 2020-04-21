package es.maestredam.biblioteca.model;

public interface Prestable {
    void prestar();
    void devolver();
    boolean isPrestado();
}
