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
        Scanner sc = new Scanner(System.in);
        
        int [][] tableroEjemplo = {};
        if(SudokuSolver.resolver(tableroEjemplo)){
            System.out.println("\n Sudoku resuelto");
            SudokuSolver.imprimirTablero(tableroEjemplo);
        }else{
            System.out.println(" No pude encontrar solución :( ");
        }
    }
    
}
