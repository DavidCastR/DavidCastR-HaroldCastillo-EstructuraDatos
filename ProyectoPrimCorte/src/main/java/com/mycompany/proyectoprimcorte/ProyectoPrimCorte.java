/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoprimcorte;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class ProyectoPrimCorte {

    public static Queue<Cola> cola = null;
    public static Stack<String[]> pila = new Stack<>();
    public static void main(String[] args) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                               1. Seleccionar archivo a cargar y leer los datos
                               2. Organizar el archivo por turno
                               3. Organizar el archivo por prioridad
                               4. Obtener cola para la toma de examenes
                               5. Desencolar el siguiente turno 
                               6. Obtener pila para procesar los resultados de examenes
                               7. Obtener el Primer dato de la pila de procesamiento de examentes 
                               8. Guardar la informacion de turnos organizada
                               9. Obtener datos demograficos (Adulto Mayor/Menores de edad, Sexo del paciente)
                               10. Salir""");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    //Leer el archivo original con el cual se van a generar las operaciones
                    String ruta = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosAtencion.csv";
                    Archivo.LeerArchivo(ruta);
                }
                case 2 -> {
                    //Leer el archivo inicial y generar el archivo ordenado por turno
                    try {
                        String inputFile = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosAtencion.csv";
                        String outputFile = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosOrdenadosTurno.csv";
                        String tempDirectory = "temp";
                        OrdenacionExternaDirectaTurno.externalSort(inputFile, outputFile, tempDirectory);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("""
                                       Leyendo y organizando el archivo por turno ...
                                       Por favor valide el archivo DatosOrdenadosTurno.csv en la raiz para ver el ordenamiento
                                       """);
                }
                case 3 -> {
                    try {
                        //Leer el archivo inicial y generar el archivo ordenado por prioridad
                        String inputFile = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosAtencion.csv";
                        String outputFile = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosOrdenadosPrioridad.csv";
                        String tempDirectory = "temp";
                        OrdenacionExternaDirectaPrioridad.externalSort(inputFile, outputFile, tempDirectory);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("""
                                       Leyendo y organizando el archivo por prioridad ...
                                       Por favor valide el archivo DatosOrdenadosPrioridad.csv en la raiz para ver el ordenamiento
                                       """);
                }
                case 4 -> {
                    //obtener del darchivo ordenado de turnos una cola para desencolar los turnos por numero menor a mayor
                    String rutaCola = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosOrdenadosTurno.csv";
                    cola = Cola.leerArchivo(rutaCola);
                    System.out.println("Cola obtenida para la toma de exámenes.");
                    for (Cola elemento : cola) {
                        System.out.println("Turno: " + elemento.getTurno() + ", Nombre: " + elemento.getNombre());
                    }
                }

                case 5 -> {
                     // Imprimir la cola antes de desencolar
                    System.out.println("Cola actual:");
                    for (Cola elemento : cola) {
                        System.out.println("Turno: " + elemento.getTurno() + ", Nombre: " + elemento.getNombre());
                    }

                    // Desencolar el siguiente turno
                    if (cola != null && !cola.isEmpty()) {
                        Cola siguienteTurno = cola.poll();
                        System.out.println("Siguiente turno desencolado:");
                        System.out.println("Turno: " + siguienteTurno.getTurno() + ", Nombre: " + siguienteTurno.getNombre());

                        // Imprimir la cola actualizada después de desencolar
                        System.out.println("Cola actualizada:");
                        for (Cola elemento : cola) {
                            System.out.println("Turno: " + elemento.getTurno() + ", Nombre: " + elemento.getNombre());
                        }
                    } else {
                        System.out.println("No hay turnos en la cola o la cola no ha sido obtenida aún.");
                    }
                }
                case 6 -> {
                    //Obtener del archivo de prioridad para obtener una pila y quitar valores de la pila de acuerdo a la prioridad
                    String rutaPila = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosOrdenadosPrioridad.csv";
                    pila = Pila.leerArchivo(rutaPila);
                    System.out.println("Pila obtenida para procesar los resultados de exámenes.");
                    // Imprimir todos los elementos de la pila
                    System.out.println("Elementos de la pila:");
                    for (String[] elemento : pila) {
                        System.out.println("Nombre: " + elemento[1] + ", Prioridad: " + elemento[0]);
                    }
                }
                case 7 -> {
                    // Desencolar el siguiente dato de la pila
                    if (!pila.isEmpty()) {
                        String[] siguienteDato = pila.pop();
                        System.out.println("Siguiente dato desapilado:");
                        System.out.println("Nombre: " + siguienteDato[1] + ", Prioridad: " + siguienteDato[0]);
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    // Imprimir todos los elementos de la pila
                    System.out.println("Elementos de la pila:");
                    for (String[] elemento : pila) {
                        System.out.println("Nombre: " + elemento[1] + ", Prioridad: " + elemento[0]);
                    }
                }
                case 8 -> {
                    //Guardar la cola en un archivo txt
                    String rutaArchivo = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\ColaOrdenada.txt";
                    Archivo.guardarColaEnArchivo(rutaArchivo, cola);
                }
                case 9 -> {
                    //leer el archivo y calcular los datos de acuerdo a las comparaciones del metodo calcularDemograficos
                    String ruta = "C:\\Users\\USER\\Documents\\ProyectoPrimerCorte\\DatosAtencion.csv";
                    Archivo.calcularDemograficos(ruta);
                }
            }
        } while (opcion != 10);
    }
}
