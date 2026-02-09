/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ciencas;

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
            if (!sc.hasNextInt()) { 
                sc.next();
                continue;
            }
            int num = sc.nextInt();
            if (num == -1) break;
            listaDinamica.add(num);
        }

        int n = listaDinamica.size();
        if (n == 0) return;

        // Creamos dos arrays iguales para comparar los algoritmos
        int[] arrBubble = new int[n];
        int[] arrInsertion = new int[n];
        for (int i = 0; i < n; i++) {
            arrBubble[i] = listaDinamica.get(i);
            arrInsertion[i] = listaDinamica.get(i);
        }

        // --- LÓGICA BUBBLE SORT ---
        int compB = 0, interB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                compB++; 
                if (arrBubble[j] > arrBubble[j + 1]) {
                    interB++;
                    int temp = arrBubble[j];
                    arrBubble[j] = arrBubble[j + 1];
                    arrBubble[j + 1] = temp;
                }
            }
        }

        // --- LÓGICA INSERTION SORT ---
        int compI = 0, movI = 0;
        for (int i = 1; i < n; i++) {
            int llave = arrInsertion[i];
            int j = i - 1;

            // Comparamos y desplazamos los elementos
            while (j >= 0) {
                compI++; // Contamos la comparación del while
                if (arrInsertion[j] > llave) {
                    arrInsertion[j + 1] = arrInsertion[j];
                    movI++; // Contamos el movimiento de datos
                    j--;
                } else {
                    break; // Si no es mayor, ya encontramos la posición
                }
            }
            arrInsertion[j + 1] = llave;
            movI++; // Contamos la inserción final del número
        }

        // --- RESULTADOS ---
        System.out.println("\n--- COMPARACIÓN DE RESULTADOS ---");
        System.out.println("Cantidad de números: " + n);

        System.out.println("\n[BUBBLE SORT]");
        System.out.println("Comparaciones: " + compB);
        System.out.println("Intercambios: " + interB);
        System.out.println("PASOS TOTALES: " + (compB + interB));

        System.out.println("\n[INSERTION SORT]");
        System.out.println("Comparaciones: " + compI);
        System.out.println("Movimientos/Inserciones: " + movI);
        System.out.println("PASOS TOTALES: " + (compI + movI));

        System.out.print("\nLista final ordenada: ");
        for (int num : arrInsertion) System.out.print(num + " ");
        
        sc.close();
    }
}