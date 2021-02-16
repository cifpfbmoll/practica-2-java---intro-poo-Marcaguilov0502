/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author marca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Escribe el nombre de la biblioteca:");
        String nombre = Biblioteca.input.nextLine();
        Biblioteca miBiblioteca = new Biblioteca();
        
        System.out.println("Usar contenido para pruebas?");
        System.out.println("1) Si");
        System.out.println("2) No");
        System.out.println("\nEscribe el numero:");
        int accion = Biblioteca.input.nextInt();
        String aux = Biblioteca.input.nextLine();
        
        if (accion == 1) {
            Libro newLibro = new Libro(1, "Los Juegos del Hambre", "Susan Collins", "Ni idea", 200);
            Biblioteca.listaLibros.add(newLibro);
            newLibro = new Libro(2, "Los Juegos del Hambre en Llamas", "Susan Collins", "Ni idea", 150);
            Biblioteca.listaLibros.add(newLibro);
            newLibro = new Libro(3, "El Quijote", "Miguel de Cervantes", "Ni idea", 2);
            Biblioteca.listaLibros.add(newLibro);
            newLibro = new Libro(8, "Harry Potter", "J.K. Rowlin", "Ni idea", 2000);
            Biblioteca.listaLibros.add(newLibro);
            
            Persona newPersona = new Persona("Marc", "Aguiló", "Valentí", "00000000A", "abcdefghij");
            Biblioteca.listaPersonas.add(newPersona);
            newPersona = new Persona("El", "Chavo", "Del 8", "88888888H", "88888888");
            Biblioteca.listaPersonas.add(newPersona);
        }
        Biblioteca.menu(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
        
        
    }
    
}
