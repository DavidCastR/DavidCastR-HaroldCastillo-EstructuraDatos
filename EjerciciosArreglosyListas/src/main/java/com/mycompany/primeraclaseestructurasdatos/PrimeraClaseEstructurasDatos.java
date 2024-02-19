package com.mycompany.primeraclaseestructurasdatos;
/**
 *
 * @author David
 */
public class PrimeraClaseEstructurasDatos {

    public static void main(String[] args) {
        // Crear un array de enteros
        int[] miArray = {1, 2, 3, 4, 5};
 
        // Mostrar el contenido original del array
        System.out.println("Contenido original del array:");
        mostrarArray(miArray);
 
        //Adicionar un nuevo elemento al final del array
        int nuevoElemento = 6;
        miArray = agregarElementoAlFinal(miArray, nuevoElemento);
 
        //Mostrar el contenido del array después de adicionar el nuevo elemento
        System.out.println("\nContenido del array después de adicionar un nuevo elemento:");
        mostrarArray(miArray);
        
        // Editar un elemento en el array
        int indiceEditar = 2;
        int nuevoValor = 7;
        miArray = editarElemento(miArray, indiceEditar, nuevoValor);
 
        // Mostrar el contenido del array después de la edición
        System.out.println("\nContenido del array después de la edición:");
        mostrarArray(miArray);
 
        //Eliminar un elemento del array
        int indiceEliminar = 3;
        miArray = eliminarElemento(miArray, indiceEliminar);
 
        // Mostrar el contenido del array después de la eliminación
        System.out.println("\nContenido del array después de la eliminación:");
        mostrarArray(miArray);
    }
    // Método para mostrar el contenido de un array de enteros
    private static void mostrarArray(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
 
    //Método para adicionar un elemento al final de un array de enteros
    private static int[] agregarElementoAlFinal(int[] array, int elemento) {
        int nuevoTamanio = array.length + 1;
        int[] nuevoArray = new int[nuevoTamanio];
 
        //Copiar los elementos originales al nuevo array
        for (int i = 0; i < array.length; i++) {
            nuevoArray[i] = array[i];
        }
 
        //Adicionar el nuevo elemento al final del nuevo array
        nuevoArray[nuevoTamanio - 1] = elemento;
        return nuevoArray;
    }
        // Método para editar un elemento en un array de cadenas
        private static int[] editarElemento(int[] array, int indice, int nuevoValor) {
        if (indice >= 0 && indice < array.length) {
            array[indice] = nuevoValor;
        } else {
            System.out.println("Índice fuera de rango. No se puede realizar la edición.");
        }
        return array;
    }
    
    //Método para eliminar un elemento de un array de cadenas
    private static int[] eliminarElemento(int[] array, int indice) {
        if (indice >= 0 && indice < array.length) {
            int[] nuevoArray = new int[array.length - 1];
            int nuevoIndice = 0;
 
            //Copiar los elementos al nuevo array, excluyendo el elemento a eliminar
            for (int i = 0; i < array.length; i++) {
                if (i != indice) {
                    nuevoArray[nuevoIndice] = array[i];
                    nuevoIndice++;
                }
            }
 
            return nuevoArray;
        } else {
            System.out.println("Índice fuera de rango. No se puede realizar la eliminación.");
            return array;
        }
    }
}

