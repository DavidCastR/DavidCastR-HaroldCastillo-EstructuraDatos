/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimcorte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

/**
 *
 * @author USER
 */
public class Pila {
    
    private String prioridad;
    private String nombre;

    public String getPrioridad() {
        return prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static Stack<String[]> leerArchivo(String ruta) {
        Stack<String[]> pila = new Stack<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;

        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 2) {
                    String[] datosAAlmacenar = new String[2];
                    // Almacenar el segundo dato (nombre)
                    datosAAlmacenar[1] = datos[1];
                    // Almacenar el último dato (prioridad)
                    datosAAlmacenar[0] = datos[datos.length - 1];
                    pila.push(datosAAlmacenar);
                }
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
        return pila;
    }
}
