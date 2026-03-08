/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moneda_sudoku9x9;

/**
 *
 * @author JUANCA
 */
public class SudokuSolver {
    public static boolean resolver(int[][] tablero) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[fila][col] == 0) { // Celda vacía
                    for (int num = 1; num <= 9; num++) {
                        if (esSeguro(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            if (resolver(tablero)) return true;
                            tablero[fila][col] = 0; // Se marca como absurdo y se limpia
                        }
                    }
                    return false; // No hubo número válido, retrocede
                }
            }
        }
        return true; // Tablero lleno
    }

    private static boolean esSeguro(int[][] b, int f, int c, int n) {
        for (int i = 0; i < 9; i++) {
            // Verificar fila, columna y sub-recuadro 3x3
            if (b[f][i] == n || b[i][c] == n || 
                b[f - f % 3 + i / 3][c - c % 3 + i % 3] == n) return false;
        }
        return true;
    }
    
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) System.out.print(tablero[i][j] + " ");
            System.out.println();
        }
    }
}
