/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manipulacionarchivosii;

/**
 *
 * @author USER
 */

import java. io.BufferedReader;
import java.io.FileReader;
import java. io. IOException;

public class AccesoSecuencialLectura {
    public static void main(String[] args) {
        // Especifica la ruta del archivo que deseas leer
        String filePath = "C:\\Users\\USER\\Documents\\Mi_Segundo_archivo.txt";

        try (FileReader fileReader = new FileReader (filePath);
            BufferedReader bufferedReader = new BufferedReader (fileReader)) {

            String line;
            // Lee cada linea del archivo de manera secuencial
            while ((line = bufferedReader. readLine ()) != null) {
                System. out.println(line) ;
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
