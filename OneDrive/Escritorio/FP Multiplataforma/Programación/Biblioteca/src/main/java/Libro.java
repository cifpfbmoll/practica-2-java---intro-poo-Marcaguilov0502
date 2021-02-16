/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marca
 */
public class Libro {
    
    //Atributos

    public static Scanner input = new Scanner(System.in);
    private static int cantidadDeLibros;
    
    private long isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int copias;
    private int copiasDisponibles;    
    
    //Constructores
        
    public Libro() {
        cantidadDeLibros++;
    }

    public Libro(long isbn, String titulo, String autor, String editorial, int copias) {
        cantidadDeLibros++;
        
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setCopias(copias);
        this.setCopiasDisponibles(getCopias());
    }
    
    public Libro(Libro Libro) {
        cantidadDeLibros++;
        
        this.setIsbn(Libro.getIsbn());
        this.setTitulo(Libro.getTitulo());
        this.setAutor(Libro.getAutor());
        this.setEditorial(Libro.getEditorial());
        this.setCopias(Libro.getCopias());
        this.setCopiasDisponibles(Libro.getCopiasDisponibles());
    }
    
    // Getters y setters
    
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        while (isbn <= 0L && isbn > 10000000000L) {
            System.out.println("ISBN Incorrecto");
            System.out.println("Escribe un ISBN válido:");
            isbn = input.nextInt();
            String aux = input.nextLine();
        }
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        while (copias < 1) {
            System.out.println("Numero de copias Incorrecto");
            System.out.println("Escribe un numero de copias válido:");
            copias = input.nextInt();
            String aux = input.nextLine();
        }
        this.copias = copias;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }
    
    //toString
    
     @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", copias=" + copias + ", copiasDisponibles=" + copiasDisponibles + '}';
    }
    
    //Metodos

    public static void agregarLibro(ArrayList<Libro> listaLibros, Biblioteca miBiblioteca){
        
        System.out.println("\nEscribe el ISBN:");
        long newIsbn = input.nextLong();
        String aux = input.nextLine();
        
        System.out.println("Escribe el título:");
        String newTitulo = input.nextLine();

        System.out.println("Escribe el autor:");
        String newAutor = input.nextLine();

        System.out.println("Escribe la editorial:");
        String newEditorial = input.nextLine();
        
        System.out.println("Escribe el numero de copias:");
        int newNumeroCopias = input.nextInt();
        aux = input.nextLine();
        
        Libro newLibro = new Libro(newIsbn, newTitulo, newAutor, newEditorial, newNumeroCopias);
        listaLibros.add(newLibro);
        System.out.println("\nLibro añadido correctamente");
        Biblioteca.menuLibro(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
    }
    
    public static int localizarIsbn(ArrayList<Libro> listaLibros, long isbn)  {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).isbn == isbn) {
                return i;
            }
        }
        return -1;
    }
    
    public static void buscarPorTitulo(ArrayList<Libro> listaLibros, Biblioteca miBiblioteca) {
        int resultados = 0;
        System.out.println("\nEscriba el titulo del libro:");
        String busqueda = input.nextLine();
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).titulo.toLowerCase().contains(busqueda.toLowerCase())) {
                imprimirLibro(listaLibros.get(i));
                resultados =+ 1;
            }
        }
        if (resultados == 0) {
            System.out.println("\nNo se han encontrado resultados");
        }
        Biblioteca.menuLibro(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
    }
    
    public static void eliminarLibro(ArrayList<Libro> listaLibros, Biblioteca miBiblioteca){
        System.out.println("\nEscribe el ISBN del libro que quieras eliminar:");
        long isbn = input.nextLong();
        String aux = input.nextLine();
        int index = localizarIsbn(listaLibros, isbn);
        if (index != -1) {
            listaLibros.remove(index);
            System.out.println("\nLibro eliminado correctamente");
            Biblioteca.menuLibro(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
        }
        else {
            System.out.println("\nIsbn introducido incorrecto");
            Biblioteca.menuLibro(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
        }
    }
    
    public static void imprimirLibro(Libro miLibro) {
        System.out.println("\nISBN: " + miLibro.getIsbn());
        System.out.println("Título: " + miLibro.getTitulo());
        System.out.println("Autor: " + miLibro.getAutor());
        System.out.println("Editorial: " + miLibro.getEditorial());
        System.out.println("Numero de copias: " + miLibro.getCopias());
        System.out.println("Numero de copias disponibles: " + miLibro.getCopiasDisponibles());
    }
    
    public static void reservar (ArrayList<Libro> listaLibros, Biblioteca miBiblioteca) {
        System.out.println("\nEscribe el ISBN del libro que desee reservar:");
        long isbn = input.nextLong();
        String aux = input.nextLine();
        
        if (listaLibros.get(localizarIsbn(listaLibros, isbn)).getCopiasDisponibles() > 0) {
            listaLibros.get(localizarIsbn(listaLibros, isbn)).setCopiasDisponibles(listaLibros.get(localizarIsbn(listaLibros, isbn)).getCopiasDisponibles()-1);
            System.out.println("\nCopia reservada");
        }
        else {
            System.out.println("\nNo quedan copias de este título");
        }
        Biblioteca.menuLibro(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
    }
}
