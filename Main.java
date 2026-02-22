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
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap heapSortObj = new Heap();
        Merge mergeSortObj = new Merge();
        Random rand = new Random();

        //Crear unas 5 listas
        int[][] listas = new int[5][100];
        // Lista ordenada 1-100
        for (int i = 0; i < 100; i++) listas[0][i] = i + 1;
        //Lista invertida 100-1
        for (int i = 0; i < 100; i++) listas[1][i] = 100 - i;
        //Listas aleatorias
        for (int j = 2; j < 5; j++) {
            for (int i = 0; i < 100; i++) listas[j][i] = rand.nextInt(1000);
        }

        String[] nombres = {"Ordenada (1-100)", "Invertida (100-1)", "Aleatoria 1", "Aleatoria 2", "Aleatoria 3"};

        // comparar
        System.out.println("COMPARATIVA DE LOS SORTS (100 elementos)");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s | %-10s | %-10s%n", "Tipo de Lista", "Pasos", "Ciclos");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < listas.length; i++) {
            //Heap
            int[] copiaHeap = listas[i].clone();
            heapSortObj.heapSort(copiaHeap);
            String resHeap = heapSortObj.pasos + "/" + heapSortObj.ciclos;
            
            //Merge
            int[] copiaMerge = listas[i].clone();
            mergeSortObj.pasos = 0;
            mergeSortObj.ciclos = 0;
            mergeSortObj.ordenar(copiaMerge, 0 , copiaMerge.length -1 );
            String resMerge = mergeSortObj.pasos + "/" + mergeSortObj.ciclos;
            
            System.out.printf("%-15s | %-18s | %-18s%n", nombres[i], resHeap, resMerge);
        }
    }
}