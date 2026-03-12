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

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Cambio de monedas (Greedy)");
        System.out.println("2. Resolver Sudoku (Backtracking)");

        int opcion = scanner.nextInt();

        if (opcion == 1) {

            System.out.println("Ingrese el monto:");
            int monto = scanner.nextInt();

            System.out.println("Ingrese cantidad de tipos de moneda:");
            int n = scanner.nextInt();

            int[] monedas = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Moneda " + (i + 1) + ": ");
                monedas[i] = scanner.nextInt();
            }

            CambioVoraz.calcularCambio(monto, monedas);

        } else if (opcion == 2) {

            int[][] tablero = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
            };

            long[] contadorPasos = {0};

            System.out.println("--- SOLUCIONADOR DE SUDOKU ---");

            long tiempoInicio = System.currentTimeMillis();

            if (SudokuSolver.resolver(tablero, contadorPasos)) {

                SudokuSolver.imprimirTablero(tablero);

                long tiempoFin = System.currentTimeMillis();

                System.out.println("\nResumen de ejecución:");
                System.out.println("Pasos: " + contadorPasos[0]);
                System.out.println("Tiempo: " + (tiempoFin - tiempoInicio) + " ms");

            } else {
                System.out.println("No se encontró solución.");
            }
        }
    }

}
