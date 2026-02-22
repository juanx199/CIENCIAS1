/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorts;

/**
 *
 * @author JUANCA
 */
import java.util.Random;

public class Main {
   public static void main(String[] args) {
        Heap heapSortObj = new Heap();
        Merge mergeSortObj = new Merge();
        Quick quickSortObj = new Quick(); // <-- Nuevo objeto
        Random rand = new Random();
        
        int n = 100;
        int[][] listas = new int[5][n];
        // ... (tus bucles de generación de listas se mantienen igual)

        String[] nombres = {"Ordenada (1-100)", "Invertida (100-1)", "Aleatoria 1", "Aleatoria 2", "Aleatoria 3"};

        long [][] resultadosPasos = new long[5][3];
        long [][] resultadosCiclos = new long[5][3];

        for (int i = 0; i < listas.length; i++) {
            // --- Heap ---
            int[] copiaHeap = listas[i].clone();
            heapSortObj.pasos = 0;
            heapSortObj.ciclos = 0;
            heapSortObj.heapSort(copiaHeap);
            resultadosPasos[i][0] = heapSortObj.pasos;
            resultadosCiclos[i][0] = heapSortObj.ciclos;

            // --- Merge ---
            int[] copiaMerge = listas[i].clone();
            mergeSortObj.pasos = 0;
            mergeSortObj.ciclos = 0;
            mergeSortObj.ordenar(copiaMerge, 0 , copiaMerge.length - 1);
            resultadosPasos[i][1] = mergeSortObj.pasos;
            resultadosCiclos[i][1] = mergeSortObj.ciclos;
            
            // --- Quick --- (NUEVA SECCIÓN)
            int[] copiaQuick = listas[i].clone();
            quickSortObj.pasos = 0;
            quickSortObj.ciclos = 0;
            quickSortObj.ordenar(copiaQuick, 0, copiaQuick.length - 1);
            resultadosPasos[i][2] = quickSortObj.pasos; // Guardamos en la columna 2
            resultadosCiclos[i][2] = quickSortObj.ciclos;
        }    
        
        imprimirTabla("CONTEO DE PASOS", nombres, resultadosPasos);
        System.out.println("\n");
        imprimirTabla("CONTEO DE CICLOS", nombres, resultadosCiclos);
    }        
        
    public static void imprimirTabla(String titulo, String[] nombres, long [][] datos){
        System.out.println(titulo);
        System.out.println("-".repeat(80));
        // Ajustamos el printf para incluir Quick
        System.out.printf("%-20s | %-12s | %-12s | %-12s%n", "Tipo de lista", "Heap", "Merge", "Quick");
        System.out.println("-".repeat(80));
        for (int i = 0 ; i < nombres.length; i++){
            // Agregamos datos[i][2] a la impresión
            System.out.printf("%-20s | %-12d | %-12d | %-12d%n", nombres[i], datos[i][0], datos[i][1], datos[i][2]);
        }
        System.out.println("-".repeat(80));
    }
              
}

