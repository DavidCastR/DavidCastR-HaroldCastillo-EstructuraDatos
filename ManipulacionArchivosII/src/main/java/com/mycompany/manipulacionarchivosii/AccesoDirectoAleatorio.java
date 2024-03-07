/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manipulacionarchivosii;

/**
 *
 * @author USER
 */

import java. io. RandomAccessFile;

public class AccesoDirectoAleatorio {

    public static void main(String[] args) {
        try {
        // Especifica la ruta del archivo en el que deseas escribir
        String filePath = "C:\\Users\\USER\\Documents\\Mi_Segundo_archivo.txt";

        // Abrir un archivo en modo de lectura/escritura
        RandomAccessFile randomAccessFile = new RandomAccessFile (filePath, "rw") ;
        // Mover el puntero a una posicion especifica
        randomAccessFile.seek(0);
        // Leer un entero desde la posición actual
        String StringValue = randomAccessFile. readLine();
        System.out.println("Valor leido: " + StringValue);
        // Mover el puntero a otra posición
        randomAccessFile.seek(20) ;
        // Escribir un nuevo entero en la nueva posicion
        randomAccessFile.writeChars("Este es un ejemplo de Escritura en RandomAccesFile");
        // Cerrar el archivo
        randomAccessFile.close ();
        } catch (Exception e) {
            e.printStackTrace () ;
        }
    }
}
