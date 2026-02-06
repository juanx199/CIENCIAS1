/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ciencas;

/**
 *
 * @author Estudiantes
 */


import java.util.Scanner;
import java.util.ArrayList;

public class Ciencas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listaDinamica = new ArrayList<>();
        
        System.out.println("¡Bienvenido!");
        System.out.println("Introduce los números. Escribe -1 para terminar:");

        while (true) {
            System.out.print("Número: ");
            if (!sc.hasNextInt()) { // Validación simple por si meten letras
                sc.next();
                continue;
            }
            int num = sc.nextInt();
            if (num == -1) break;
            listaDinamica.add(num);
        }

        int n = listaDinamica.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = listaDinamica.get(i);
        }

        // --- Variables de control ---
        int totalCiclos = 0;      // Vueltas del bucle exterior
        int comparaciones = 0;    // Cuántas veces preguntamos "es mayor que?"
        int intercambios = 0;     // Cuántas veces movimos los números de lugar
        int pasosTotales = 0;     // Suma de comparaciones + intercambios

        // --- Bubble Sort ---
        for (int i = 0; i < n; i++) {
            totalCiclos++; // Contamos cada vez que el algoritmo inicia una pasada completa
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++; 
                if (arr[j] > arr[j + 1]) {
                    intercambios++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        pasosTotales = comparaciones + intercambios;

        // --- Resultados ---
     
        System.out.print("Lista ordenada: ");
        for (int num : arr) System.out.print(num + " ");
        
        System.out.println("\n\nCantidad de números: " + n);
        System.out.println("Ciclos totales (i): " + totalCiclos);
        System.out.println("Comparaciones realizadas: " + comparaciones);
        System.out.println("Intercambios realizados: " + intercambios);
        System.out.println("PASOS TOTALES (Lógica): " + pasosTotales);
        
        sc.close();
    }
}