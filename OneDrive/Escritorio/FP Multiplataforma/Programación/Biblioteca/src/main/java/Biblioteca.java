import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    
    //Atributos
    public static Scanner input = new Scanner(System.in);
    
    private String nombre;
    public static ArrayList <Libro> listaLibros = new ArrayList<Libro>();
    public static ArrayList <Persona> listaPersonas = new ArrayList<Persona>();

    //Constructores
    
    public Biblioteca() {
    }

    public Biblioteca(String nombre) {
        this.setNombre(nombre);
    }
    
    public Biblioteca(Biblioteca biblioteca) {
        this.setNombre(biblioteca.getNombre());
    }

    //To string

    @Override
    public String toString() {
        return "Biblioteca{" + "nombre=" + nombre + '}';
    }
    
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = StringUtils.capitalize(nombre);
    }

    public static ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ArrayList<Libro> listaLibros) {
        Biblioteca.listaLibros = listaLibros;
    }

    public static ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public static void setListaPersonas(ArrayList<Persona> listaPersonas) {
        Biblioteca.listaPersonas = listaPersonas;
    }
    
    //Métodos
    
    public void imprimirLibrosTodos(ArrayList<Libro> listaLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro.imprimirLibro(listaLibros.get(i));
        }
    }
    
    public void imprimirLibrosDisponibles(ArrayList<Libro> listaLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getCopiasDisponibles() > 0) {
                Libro.imprimirLibro(listaLibros.get(i));
            }
        }
    }
    
    public static void menu (ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas, Biblioteca miBiblioteca) {
        System.out.println("\nA que menú deseas acceder?");
        System.out.println("1) Menú de libros.");
        System.out.println("2) Menú de personas.");
        System.out.println("3) Apagar.");
        System.out.println("\nEscribe el numero:");
        int accion = input.nextInt();
        String aux = input.nextLine();
        
        switch (accion) {
            case 1:
                menuLibro(listaLibros, listaPersonas, miBiblioteca);
                break;
            case 2:
                menuPersona(listaLibros, listaPersonas, miBiblioteca);
                break;
            case 3:
                break;
            default:
                menu(listaLibros, listaPersonas, miBiblioteca);
                break;
        }
    }
    
    public static void menuPersona (ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas, Biblioteca miBiblioteca) {
        System.out.println("\n¿Que acción desea realizar?");
        System.out.println("1) Añadir persona.");
        System.out.println("2) Eliminar persona.");
        System.out.println("3) Salir");
        System.out.println("\nEscribe el numero:");
        int accion = input.nextInt();
        String aux = input.nextLine();
        
        switch (accion) {
            case 1:
                Persona.agregarPersona(listaPersonas, miBiblioteca);
                break;
            case 2:
                Persona.eliminarPersona(listaPersonas, miBiblioteca);
                break;
            case 3:
                menu(listaLibros, listaPersonas, miBiblioteca);
                break;
            default:
                menuPersona(listaLibros, listaPersonas, miBiblioteca);
                break;
        }
    }
    
    public static void menuLibro(ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas, Biblioteca miBiblioteca) {
        System.out.println("\n¿Que acción desea realizar?");
        System.out.println("1) Añadir libro.");
        System.out.println("2) Eliminar libro.");
        System.out.println("3) Buscar libro.");
        System.out.println("4) Reservar.");
        System.out.println("5) Mostrar libros.");
        System.out.println("6) Salir.");
        System.out.println("\nEscribe el numero:");
        int accion = input.nextInt();
        String aux = input.nextLine();
        
        switch (accion) {
            case 1:
                Libro.agregarLibro(listaLibros, miBiblioteca);
                break;
            case 2:
                Libro.eliminarLibro(listaLibros, miBiblioteca);
                break;
            case 3:
                System.out.println("\n¿Buscar por ISBN o título?");
                System.out.println("1) ISBN.");
                System.out.println("2) Título.");
                System.out.println("\n Escribe el numero:");
                accion = input.nextInt();
                aux = input.nextLine();
                if (accion == 1) {
                    System.out.println("\nEscribe el ISBN que desee buscar");
                    long isbn = input.nextLong();
                    aux = input.nextLine();
                    int index = Libro.localizarIsbn(listaLibros, isbn);
                    listaLibros.get(index).imprimirLibro(listaLibros.get(index));
                    Biblioteca.menuLibro(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
                    break;
                }
                else {
                    Libro.buscarPorTitulo(listaLibros, miBiblioteca);
                    break;
                }
            case 4:
                Libro.reservar(listaLibros, miBiblioteca);
                break;
            case 5:
                System.out.println("\nQue libros quieres ver?");
                System.out.println("1) Todos");
                System.out.println("2) Disponibles");
                System.out.println("\nEscribe el numero:");
                accion = input.nextInt();
                aux = input.nextLine();
                if (accion == 1) {
                    miBiblioteca.imprimirLibrosTodos(listaLibros);
                }
                else {
                     miBiblioteca.imprimirLibrosDisponibles(listaLibros);
                }
                menuLibro(listaLibros, listaPersonas, miBiblioteca);
                break;
            case 6:
                menu(listaLibros, listaPersonas, miBiblioteca);
                break;
            default:
                menuLibro(listaLibros, listaPersonas, miBiblioteca);
                break;
                
        }
    }
}
