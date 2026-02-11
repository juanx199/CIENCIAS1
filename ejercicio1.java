/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Estudiantes
 */

import java.util.Random;

public class ejercicio1{

    // Variables globales para las métricas
    static long comparaciones, intercambios, ciclos;

    public static void main(String[] args) {
        int tamaño = 100;
        
        // Genera listicas
        int[] ordenada = new int[tamaño];
        int[] invertida = new int[tamaño];
        int[] aleatoria = new int[tamaño];
        Random rand = new Random();

        for (int i = 0; i < tamaño; i++) {
            ordenada[i] = i + 1;               // 1- 100
            invertida[i] = tamaño - i;         // 100 - 1
            aleatoria[i] = rand.nextInt(1000); // Aleatoria
        }

        System.out.println("   Comparacion algoritmos de ordenamiento :D(N = " + tamaño + ")\n "
                + "######################################################");
        
        // Ejecución de pruebas para cada algoritmo
        probarAlgoritmo("BUBBLE SORT", ordenada, invertida, aleatoria, 1);
        probarAlgoritmo("INSERTION SORT", ordenada, invertida, aleatoria, 2);

    }

    static void probarAlgoritmo(String nombre, int[] ord, int[] inv, int[] ale, int tipo) {
        System.out.println("\n>>> " + nombre);
        System.out.printf("%-15s | %-10s | %-15s | %-12s%n", "Caso", "Ciclos", "Comparaciones", "Intercambios");
        System.out.println("---------------------------------------------------------------");

        ejecutarYMostrar("Ordenada", ord.clone(), tipo);
        ejecutarYMostrar("Invertida", inv.clone(), tipo);
        ejecutarYMostrar("Aleatoria", ale.clone(), tipo);
    }

    static void ejecutarYMostrar(String caso, int[] arr, int tipo) {
        comparaciones = 0; intercambios = 0; ciclos = 0;
        
        switch (tipo) {
            case 1 -> bubbleSort(arr);
            case 2 -> insertionSort(arr);
        }

        System.out.printf("%-15s | %-10d | %-15d | %-12d%n", caso, ciclos, comparaciones, intercambios);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                ciclos++; // Iteración del bucle interno
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambios++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // No contamos ciclos aquí porque el while ya lo hace
            while (j >= 0) {
                ciclos++; 
                comparaciones++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    intercambios++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }
}