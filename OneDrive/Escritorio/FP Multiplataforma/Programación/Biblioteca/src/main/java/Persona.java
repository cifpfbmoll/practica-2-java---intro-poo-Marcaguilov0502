
import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
    
    //Atributos
    public static Scanner input = new Scanner(System.in);
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private String clave;
    
    //Constructores

    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, String nif, String clave) {
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setNif(nif);
        setClave(clave);
    }
    
    //ToString

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nif=" + nif + ", clave=" + clave + '}';
    }
    
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        while (clave.length() < 8) {
            System.out.println("\nLa contraseña debe tener 8 caracteres como minimo");
            System.out.println("Escribe otra contraseña:");
            clave = input.nextLine();
        }
        this.clave = clave;
    }
    
    //Métodos
    
    public static void agregarPersona(ArrayList<Persona> listaPersonas, Biblioteca miBiblioteca) {
        System.out.println("\nEscribe el nombre:");
        String nombre = input.nextLine();
        
        System.out.println("Escribe el primer apellido:");
        String apellido1 = input.nextLine();
        
        System.out.println("Escribe el segundo apellido:");
        String apellido2 = input.nextLine();
        
        System.out.println("Escribe el NIF:");
        String nif = input.nextLine();
        
        System.out.println("Escribe una contraseña:");
        String clave = input.nextLine();
        
        Persona newPersona = new Persona(nombre, apellido1, apellido2, nif, clave);
        listaPersonas.add(newPersona);
        System.out.println("\nPersona añadida correctamente");
        Biblioteca.menuPersona(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
    }
    
    public static void eliminarPersona (ArrayList<Persona> listaPersonas, Biblioteca miBiblioteca) {
        System.out.println("\nEscribe el NIF de la persona que desees eliminar:");
        String nif = input.nextLine();
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).nif == nif) {
                listaPersonas.remove(i);
                System.out.println("n/Persona eliminada correctamente");
                break;
            }
        }
        System.out.println("\nEse nif no existe ");
        Biblioteca.menuPersona(Biblioteca.listaLibros, Biblioteca.listaPersonas, miBiblioteca);
    }
}
