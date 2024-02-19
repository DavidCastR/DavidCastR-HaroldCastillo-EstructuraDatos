/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pilasycolas;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
/**
 *
 * @author Harold David Castillo Romero
 */
public class PilasyColas {

    public static void main(String[] args) {
        //Ejercicio de Pila
        //
        //instancia de Pila
        Stack pila= new Stack<>();
        //Agregar elementos a la pila
        pila.push("Guayaba");
        pila.push("Limon");
        pila.push("Naranja");
        pila.push("Pera");
        pila.push("Manzana");
        //Impresion de la pila para validar los elementos agregados
        System.out.println("Elementos de la Pila: \n"+ pila);
        //Imprimir el Ultimo en la pila
        System.out.println("Ultimo elemento en la Pila " + pila.lastElement());
        //Imprimir el Primero en la pila
        System.out.println("Primer elemento en la Pila " + pila.firstElement());
        //Mostrar el tamaño de la pila
        System.out.println("El tamaño de la pila es: " +pila.size());
        //Eliminar un elemento de la pila
        pila.pop();
        System.out.println("Elementos de la pila despues de eliminar:\n"+pila + "\n\n");
        
        //Ejercicio de Cola
        //
        //instancia de Cola
        Queue <String> cola = new LinkedList();
        //Agregar elementos a la cola
        cola.offer("Susuki");
        cola.offer("BMW");
        cola.offer("Mazda");
        cola.offer("Toyota");
        cola.offer("Ferrari");
        //Impresion de la cola para validar los elementos agregados
        System.out.println("Elementos de la cola"+ cola);
        //imprimir el Ultimo en la cola
        String ultimoElemento = ((LinkedList<String>) cola).peekLast();
        System.out.println("Ultimo elemento en la cola " + ultimoElemento);
        //Imprimir el Primero en la cola
        System.out.println("Primer elemento en la cola " +cola.peek());
        //Imprimir el Tamaño de la cola
        System.out.println("El tamaño de la cola es:" +cola.size());
        //Eliminar el primer elemento de la cola
        System.out.println("Eliminando el siguiente elemento: "+cola.remove());
        System.out.println(cola);
    }
}
