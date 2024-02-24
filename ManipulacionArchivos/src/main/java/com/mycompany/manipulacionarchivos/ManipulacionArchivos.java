/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manipulacionarchivos;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class ManipulacionArchivos {
    public static void main(String[] args) {
        
        // Nombre del archivo a manipular
        String nombreDelArchivo = "C:\\Users\\David\\Documents\\Mi_archivo.txt";
        // Operación de lectura de un archivo
        leerUnArchivo (nombreDelArchivo);        
        // Operación de escritura o edición
        escribirUnArchivo(nombreDelArchivo, "- Este es un ejemplo de edicion del contenido de un archivo");
        // Operación de lectura despues de la edición
        leerUnArchivo (nombreDelArchivo);
        // Operación de eliminación de un archivo
        eliminarArchivo (nombreDelArchivo) ;
        // Operación de creación de un archivo
        crearUnArchivo("C:\\Users\\David\\Documents\\Mi_archivo.txt");
        String nombreSegArchivo = "C:\\Users\\David\\Documents\\Mi_archivo.txt";
        escribirUnArchivo(nombreSegArchivo, "- Este es un ejemplo de creacion de archivo y edicion del archivo despues de eliminar el archivo original");
        // Operación de lectura de un archivo
        leerUnArchivo (nombreDelArchivo);
        
        // Operación para restaurar el contenido original del archivo, este metodo fue agregado unicamente para evitar modificar el archivo manualmente tras cada ejecucion
        restaurarElArchivo(nombreDelArchivo, "- Este es un ejemplo del contenido original del archivo");
    }
        
        // Funcion para leer un archivo
        public static void leerUnArchivo (String nombreArchivo){
            System.out.println ("Leyendo el contenido del archivo " + nombreArchivo + ":\n") ;
            try (Scanner scanner = new Scanner(new FileReader (nombreArchivo))) {
                while (scanner.hasNextLine()){
                    System.out.println(scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println ();
        }
        
        // Funcion para escribir o editar un archivo
        private static void escribirUnArchivo(String nombreArchivo, String contenido){
            System.out.println ("Escribiendo contenido en el archivo " + nombreArchivo + ":") ;
            try (BufferedWriter bw = new BufferedWriter (new FileWriter (nombreArchivo))) {
                bw.write (contenido) ;
            } catch (IOException e) {
                e.printStackTrace ();
            }
            System. out.println ();
        }
        
        // Operación para restaurar el contenido original del archivo, este metodo fue agregado unicamente para evitar modificar el archivo manualmente tras cada ejecucion
        private static void restaurarElArchivo(String nombreArchivo, String contenido){
            try (BufferedWriter bw = new BufferedWriter (new FileWriter (nombreArchivo))) {
                bw.write (contenido) ;
            } catch (IOException e) {
                e.printStackTrace ();
            }
            System. out.println ();
        }
        
        // Funcion para eliminar un archivo
        private static void eliminarArchivo(String nombreArchivo) {
            System. out.println ("Eliminando el archivo " + nombreArchivo + ":\n") ;
            File archivo = new File (nombreArchivo) ;
            if (archivo.delete ()) {
                System. out.println ("El archivo " + nombreArchivo +" fue eliminado correctamente.");
            } else {
                System. out.println("No se pudo eliminar el archivo " + nombreArchivo +".\nValide nuevamente el nombre y extension");
            }
            System.out.println ();
        }
        
        // Funcion para crear un nuevo archivo
        private static void crearUnArchivo(String nombreArchivo) {
            System.out.println ("Creando el archivo " + nombreArchivo + ":");
            try (FileWriter fw = new FileWriter (nombreArchivo) ) {
            // Puedes dejar el archivo vacio o escribir algo en el.
            } catch (IOException e) {
                e.printStackTrace ();
            }
            System.out.println ();
        }
}
