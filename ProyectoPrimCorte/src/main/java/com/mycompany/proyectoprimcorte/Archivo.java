/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimcorte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

/**
 *
 * @author USER
 */
public class Archivo {
    public static void LeerArchivo (String ruta) {
        //Uso de la clase File para leer y escribir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
 
        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File(ruta);
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
            //Creacion de Arreglo para guardar los datos leidos del archivo CSV
            String[] datos = null;
            //Leemos hasta que se termine el archivo
            while ((linea = br.readLine()) != null) {
            //Utilizamos el separador para los datos
            datos = linea.split(";");
            //Presentamos los datos
            System.out.println("Turno: "+datos [0]+ " Nombres y Apellidos: "+datos [1]+" Edad: "+datos [2]+" Genero: "+datos [3]+" Examen: "+datos [4]+" Valor: "+datos [5]+" Prioridad: "+datos [6]//
            );
            }
            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }        
    }
    
    public static void guardarColaEnArchivo(String ruta, Queue<Cola> cola) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (Cola elemento : cola) {
                // Escribir el elemento en una línea del archivo
                writer.write(elemento.getTurno() + "," + elemento.getNombre());
                writer.newLine(); // Agregar un salto de línea
            }
            System.out.println("Cola guardada en el archivo: " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void calcularDemograficos (String rutaArchivo){
        // Variables para contar
        int menoresDeEdad = 0;
        int terceraEdad = 0;
        int masculinos = 0;
        int femeninos = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en campos usando coma como separador
                String[] campos = linea.split(";");
                
                // Comparar el tercer valor (edad) y actualizar variables
                int edad = Integer.parseInt(campos[2]);
                if (edad < 18) {
                    menoresDeEdad++;
                } else if (edad >= 60) {
                    terceraEdad++;
                }

                // Comparar el cuarto valor (género) y actualizar variables
                String genero = campos[3].trim(); // Eliminar espacios en blanco
                if (genero.equalsIgnoreCase("Masculino")) {
                    masculinos++;
                } else if (genero.equalsIgnoreCase("Femenino")) {
                    femeninos++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir los resultados
        System.out.println("Personas menores de 18 años: " + menoresDeEdad);
        System.out.println("Personas de tercera edad (60 años o mas): " + terceraEdad);
        System.out.println("Personas de genero masculino: " + masculinos);
        System.out.println("Personas de genero femenino: " + femeninos);
    }
}
