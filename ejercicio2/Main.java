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
        Random rand = new Random();
        
        int n = 100;
        
        //Crear unas 5 listas
        int[][] listas = new int[5][n];
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
        
        long [][] resultadosPasos = new long[5][3];
        long [][] resultadosCiclos = new long[5][3];
        //System.out.println("COMPARATIVA DE LOS SORTS (100 elementos)");
        //System.out.println("-------------------------------------------------");
        //System.out.printf("%-20s | %-10s | %-10s%n", "Tipo de Lista", "Pasos", "Ciclos");
        //System.out.println("-------------------------------------------------");

        for (int i = 0; i < listas.length; i++) {
            //Heap
            int[] copiaHeap = listas[i].clone();
            heapSortObj.pasos = 0;
            heapSortObj.ciclos = 0;
            
            heapSortObj.heapSort(copiaHeap);
            //String resHeap = heapSortObj.pasos + "/" + heapSortObj.ciclos;
            
            resultadosPasos[i][0] = heapSortObj.pasos;
            resultadosCiclos[i][0] = heapSortObj.ciclos;
            //Merge
            int[] copiaMerge = listas[i].clone();
            mergeSortObj.pasos = 0;
            mergeSortObj.ciclos = 0;
            mergeSortObj.ordenar(copiaMerge, 0 , copiaMerge.length -1 );
            resultadosPasos[i][1] = mergeSortObj.pasos;
            resultadosCiclos[i][1] = mergeSortObj.ciclos;
        }    
        imprimirTabla("CONTEO DE PASOS" , nombres , resultadosPasos);
        System.out.println("\n");
        imprimirTabla("CONTEO DE CICLOS BBLBL", nombres , resultadosCiclos);
    }        
        
    public static void imprimirTabla(String titulo, String[] nombres, long [][] datos){
            System.out.println(titulo);
            System.out.println("-".repeat(60));
            System.out.printf("%-20s | %-12s | %-12s%n", "Tipo de lista","Heap","Merge") ;
            System.out.println("-".repeat(70));
            for (int i = 0 ; i < nombres.length; i++){
                System.out.printf("%-20s | %-15d | %-15d%n", nombres[i], datos[i][0],datos[i][1]);
            }
            System.out.println("-".repeat(60));
        }
              
}
