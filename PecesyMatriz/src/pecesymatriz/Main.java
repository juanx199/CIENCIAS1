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

            // --- EJERCICIO 1: DISPENSADORES PEZ ---
            // Mantenemos tu lógica original para PEZ
            System.out.println("--- EJERCICIO 1: DISPENSADORES PEZ ---");
            System.out.print("Número de dispensadores (n): ");
            int nPez = sc.nextInt();
            System.out.print("Dulces a escoger (m): ");
            int mPez = sc.nextInt();

            int[][] matrizPez = new int[nPez][12];
            for (int i = 0; i < nPez; i++) {
                for (int j = 0; j < 12; j++) {
                    matrizPez[i][j] = rnd.nextInt(300) + 1; 
                }
            }
            System.out.println("Máximo sabor PEZ: " + SolucionPez.calcularMaximoSabor(nPez, mPez, matrizPez));

            // --- EJERCICIO 2: CANDY (AHORA ALEATORIO) ---
            System.out.println("\n--- EJERCICIO 2: CANDY (Caja de Dulces Aleatoria) ---");
            
            // Pedimos dimensiones para que no siempre sea la misma matriz
            System.out.print("Ingrese número de filas (M): ");
            int filas = sc.nextInt();
            System.out.print("Ingrese número de columnas (N): ");
            int columnas = sc.nextInt();

            // Generamos la matriz con valores al azar entre 1 y 100
            int[][] matrizCandyAleatoria = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matrizCandyAleatoria[i][j] = rnd.nextInt(100) + 1; 
                }
            }

            // Resolvemos con la nueva matriz
            int resultadoCandy = SolucionCandy.resolverCandy(filas, columnas, matrizCandyAleatoria);
            
            System.out.println("Resultado obtenido con datos al azar: " + resultadoCandy);
            System.out.println("-------------------------------------------");
        }
}
