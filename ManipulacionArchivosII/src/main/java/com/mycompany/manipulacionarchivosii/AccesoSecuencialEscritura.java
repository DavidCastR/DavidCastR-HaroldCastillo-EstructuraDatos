/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manipulacionarchivosii;

import java.io.BufferedWriter;
import java. io.FileWriter;
import java. io. IOException;

/**
 *
 * @author USER
 */
public class AccesoSecuencialEscritura {
    public static void main(String[] args) {
    // Especifica la ruta del archivo en el que deseas escribir
    String filePath = "C:\\Users\\USER\\Documents\\Mi_Segundo_archivo.txt";

    try (FileWriter fileWriter = new FileWriter (filePath) ;
        BufferedWriter bufferedWriter= new BufferedWriter (fileWriter)) {

        // Escribe lineas en el archivo de manera secuencial
        bufferedWriter.write ("Primera linea");
        bufferedWriter.newLine (); // Agrega un salto de linea
        bufferedWriter.write ("Segunda linea") ;
        bufferedWriter.newLine ();

        // Puedes seguir agregando mas lineas segun sea necesario
        } catch (IOException e) {
            e.printStackTrace () ;
        }
    }
}
