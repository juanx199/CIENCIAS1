/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pecesymatriz;

/**
 *
 * @author Estudiantes
 */
import java.util.Random;
import java.util.Scanner;
import peces.SolucionPez;
import matriz.SolucionCandy;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("--- EJERCICIO 1: DISPENSADORES PEZ ---");
        System.out.print("Número de dispensadores (n): ");
        int nPez = sc.nextInt();
        System.out.print("Dulces a escoger (m): ");
        int mPez = sc.nextInt();

        int[][] matrizPez = new int[nPez][12];
        for (int i = 0; i < nPez; i++) {
            for (int j = 0; j < 12; j++) {
                matrizPez[i][j] = rnd.nextInt(300) + 1; // Sabor 1-300 
            }
        }
        System.out.println("Máximo sabor PEZ: " + SolucionPez.calcularMaximoSabor(nPez, mPez, matrizPez));

        System.out.println("\n--- EJERCICIO 2: CANDY (Caja de Dulces) ---");
        // Datos del ejemplo del PDF (Sample Input 1) [cite: 178]
        int[][] matrizCandy = {
            {1, 8, 2, 1, 9},
            {1, 7, 3, 5, 2},
            {1, 2, 10, 3, 10},
            {8, 4, 7, 9, 1},
            {7, 1, 3, 1, 6}
        };
        int resultadoCandy = SolucionCandy.resolverCandy(5, 5, matrizCandy);
        System.out.println("Máximo dulces (Esperado 54): " + resultadoCandy); // [cite: 194]
    }
}
