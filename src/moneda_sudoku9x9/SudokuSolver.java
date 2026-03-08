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
    public static boolean resolver(int[][] tablero, long[] contador) {
        contador[0]++ ; //cada que se entre se suma un paso
        
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[fila][col] == 0) { //Buscar una casilla vacía
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            // Seguir con el resto 
                            if (resolver(tablero, contador)) return true;
                            
                            tablero[fila][col] = 0; // Se marca como malo y se hace backtrackin
                        }
                    }
                    return false; // No hubo número válido entonces retrocedemos
                }
            }
        }
        return true; // Tablero lleno
    }

    private static boolean esValido(int[][] t, int fila, int col, int num) {
        for (int i = 0; i < 9; i++) {
            // Revisar la fila
            if (t[fila][i] == num) return false;
            // Revisar la columna
            if (t[i][col]== num) return false;
            // Revisar el cuadrito 3x3
            if (t[3*(fila/3) + i/3][3* (col/3)+i%3] == num )return false;
        }
        return true;
    }
    
    public static void imprimirTablero(int[][] tablero) {
        System.out.println("\n +------+------+------+");
        for (int i = 0; i < 9; i++) {
            if (i > 0 && i%3 ==0) System.out.println("|------+------+------+");
            for (int j=0; j < 9; j++){
                if(j %3 == 0)System.out.print("| ");
                System.out.print(tablero[i][j]);
            }
            System.out.print("|");
        }
        System.out.println("+-------+-------+-------+");
    }
}
