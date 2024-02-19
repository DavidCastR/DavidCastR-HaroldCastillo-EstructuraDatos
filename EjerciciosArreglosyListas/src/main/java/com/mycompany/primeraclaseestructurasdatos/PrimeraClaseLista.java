package com.mycompany.primeraclaseestructurasdatos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author David
 */
public class PrimeraClaseLista {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Scanner scanner = new Scanner(System.in);
        int opcion, numero;

        do {
            System.out.println("1. leer la lista");
            System.out.println("2. Agregar un numero");
            System.out.println("3. Actualizar un numero");
            System.out.println("4. Borrar un numero");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Números en la lista: " + numeros);
                    break;
                case 2:               
                    System.out.print("Ingresa un número: ");
                    numero = scanner.nextInt();
                    numeros.add(numero);
                    System.out.println("Números en la lista despues de agregar: " + numeros);
                    break;
                case 3:
                    System.out.println("Números en la lista: " + numeros);
                    System.out.print("Índice del número a actualizar: ");
                    int indice = scanner.nextInt();
                    System.out.print("Nuevo número: ");
                    numero = scanner.nextInt();
                    numeros.set(indice, numero);
                    System.out.println("Números en la lista despues de actualizar: " + numeros);
                    break;
                case 4:
                    System.out.println("Números en la lista: " + numeros);
                    System.out.print("Índice del número a borrar: ");
                    int indiceABorrar = scanner.nextInt();
                    numeros.remove(indiceABorrar);
                    System.out.println("Números en la lista despues de borrar: " + numeros);
                    break;
            }
        } while (opcion != 5);
    }
}
