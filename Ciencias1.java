/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ciencias1;

/**
 *
 * @author JUANCA
 */

import java.util.Scanner ;
import java.util.ArrayList;

public class Ciencias1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listaDinamica = new ArrayList<>();
        
        System.out.println("¡Bienvenido! ");
        System.out.println("Introduce los números. Escribe -1 para terminar:");

        // 1. Leer datos
        while (true) {
            System.out.print("Número: ");
            int num = sc.nextInt();
            if (num == -1) break; // Salde del bucla :b
            listaDinamica.add(num);
        }

        // Convertimos el ArrayList a un array normal para el algoritmo
        int n = listaDinamica.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = listaDinamica.get(i);
        }

        // El Bubble Sort con contador de pasos
        int contadorPasos = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                contadorPasos++; // Cuenta l comparación
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Lista ordenadita
        System.out.println("\n## Resultados ##");
        System.out.print("Lista ordenada: ");
        for (int num : arr) System.out.print(num + " ");
        
        System.out.println("\nCantidad de números : " + n);
        System.out.println("Total de comparaciones realizadas: " + contadorPasos);
        
        sc.close();
    }
    
}
