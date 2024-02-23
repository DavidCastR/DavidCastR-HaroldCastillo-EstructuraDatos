/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciolistasenlazadas;

/**
 *
 * @author hdavidcastillo
 */
public class EjercicioListasEnlazadas {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
              
        // Agregar al final de la lista
        lista.agregarAlFinal(12);
        lista.agregarAlFinal(15);
        lista.agregarAlFinal(9);
        
        System.out.println("Ejemplo de lista Simple\n\nImpresion de lista antes de agregar");
        lista.listar();
        lista.agregarAlFinal(8);
        System.out.println("\nImpresion de lista despues de agregar");
        lista.listar();
        
        System.out.println("\n\nImpresion de lista antes de eliminar - Eliminando posicion 1");
        lista.listar();
        lista.removerPorPosicion(1);
        System.out.println("\nImpresion de lista despues de eliminar");
        lista.listar();
        
        System.out.println("\n\nImpresion de lista");
        lista.listar();
    }
}
