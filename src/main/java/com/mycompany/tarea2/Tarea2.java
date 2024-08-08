/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea2;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DELL LATITUDE 5401
 */


class Libro {
        private String titulo;
        private String autor;
        private boolean disponible;

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean estaDisponible() {
        return disponible;
    }
    
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("El libro '" + titulo + "' no esta disponible para ser prestado.");
        }
    }
     public void devolver() {
        disponible = true;
        System.out.println("El libro '" + titulo + " esta disponible.");
    }
}
        
 class Usuario {
    private String nombre;
    private List<Libro> librosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
     public void prestarLibro(Libro libro) {
        if (libro.estaDisponible()) {
            libro.prestar();
            librosPrestados.add(libro);
        } else {
            System.out.println("El usuario '" + nombre + "' no puede prestar el libro '" + libro.getTitulo() + "' porque no esta disponible.");
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
        } else {
            System.out.println("El usuario '" + nombre + "' no tiene el libro '" + libro.getTitulo() + "'.");
        }
    }

    public void listarLibrosPrestados() {
        if (!librosPrestados.isEmpty()) {
            System.out.println("Libros prestados por " + nombre + ":");
            for (Libro libro : librosPrestados) {
                System.out.println("- " + libro.getTitulo() + " de " + libro.getAutor());
            }
        } else {
            System.out.println("El usuario '" + nombre + "' no tiene libros prestados.");
        }
    }
}
  

public class Tarea2 {

    public static void main(String[] args) {
        Libro libro1 = new Libro("1984", "George Orwell");
        Libro libro2 = new Libro("El Quijote", "Miguel de Cervantes");

        // Crear un usuario
        Usuario usuario1 = new Usuario("Juan Pérez");

        // Prestar libros
        usuario1.prestarLibro(libro1);
        usuario1.prestarLibro(libro2);

        // Listar libros prestados
        usuario1.listarLibrosPrestados();

        // Devolver un libro
        usuario1.devolverLibro(libro1);

        // Listar libros prestados nuevamente
        usuario1.listarLibrosPrestados();
    }
}
    

