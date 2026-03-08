/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moneda_sudoku9x9;
import java.util.Scanner;

/**
 *
 * @author JUANCA
 */
public class Moneda_Sudoku9x9 {

    public static void main(String[] args) {
        // Creamos un tablero de 9x9 lleno de ceros (vacío)
        int[][] tablero = new int[9][9];
        
        // Usamos un long[] para que el contador pueda ser modificado dentro del método
        long[] contadorPasos = {0};

        System.out.println("--- SOLUCIONADOR DE SUDOKU (BACKTRACKING) ---");
        System.out.println("Estado inicial: Tablero vacío.");
        System.out.println("Calculando la primera solución posible...");

        long tiempoInicio = System.currentTimeMillis();

        if (SudokuSolver.resolver(tablero, contadorPasos)) {
            SudokuSolver.imprimirTablero(tablero);
            long tiempoFin = System.currentTimeMillis();
            
            System.out.println("\nResumen de ejecución:");
            System.out.println(">> Pasos (llamadas al algoritmo): " + contadorPasos[0]);
            System.out.println(">> Tiempo empleado: " + (tiempoFin - tiempoInicio) + " ms");
        } else {
            System.out.println("No se encontró ninguna solución.");
        }
    }
}