/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimcorte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author USER
 */

public class Cola {
    private String turno;
    private String nombre;

    public Cola(String turno, String nombre) {
        this.turno = turno;
        this.nombre = nombre;
    }

    // Getters and setters

    public String getTurno() {
        return turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static Queue<Cola> leerArchivo(String ruta) {
        Queue<Cola> cola = new ArrayDeque<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;

        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String[] datos;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                cola.add(new Cola(datos[0], datos[1]));
            }
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
        return cola;
    }
}
