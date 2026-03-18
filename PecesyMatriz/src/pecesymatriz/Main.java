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
import peces.SolucionPez;


import java.util.Random;
import java.util.Scanner;
import peces.SolucionPez;
//import ejercicioX.OtroEjercicio;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Ingrese número de dispensadores (n): ");
        int n = sc.nextInt();
        System.out.print("Ingrese total de dulces a escoger (m): ");
        int m = sc.nextInt();

        // 1. Generar matriz nx12 con sabores de 1 a 300
        int[][] matrizDulces = new int[n][12];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                matrizDulces[i][j] = rnd.nextInt(300) + 1;
            }
        }

        // 2. Resolver
        long inicio = System.currentTimeMillis();
        int resultado = SolucionPez.calcularMaximoSabor(n, m, matrizDulces);
        long fin = System.currentTimeMillis();

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Máximo sabor posible: " + resultado);
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
        
        System.out.println("\n------------------");
        //OtroEjercicio.ejecutar();
    }
}