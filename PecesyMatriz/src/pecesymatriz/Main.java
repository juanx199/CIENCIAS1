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


public class Main {
    public static void main(String[] args) {
        // Configuraciones del problema
        int filasPeces = 1000;
        int dulcesPorPez = 12;
        int saborMin = 1;
        int saborMax = 300;

        // 1. Generar la matriz aleatoria
        int[][] almacenPez = generarDatosAleatorios(filasPeces, dulcesPorPez, saborMin, saborMax);

        System.out.println("=== SISTEMA DE GESTIÓN DE CARAMELOS PEZ ===");
        System.out.println("Generados " + filasPeces + " dispensadores con " + dulcesPorPez + " dulces cada uno.");
        System.out.println("Rango de sabores: [" + saborMin + " - " + saborMax + "]\n");

        // 2. Resolver el problema de los Peces
        long tiempoInicio = System.currentTimeMillis();
        int resultadoMaximo = SolucionPez.calcularMaximo(almacenPez);
        long tiempoFin = System.currentTimeMillis();

        System.out.println("RESULTADO:");
        System.out.println("Valor máximo de dulces recolectados: " + resultadoMaximo);
        System.out.println("Tiempo de procesamiento: " + (tiempoFin - tiempoInicio) + " ms");

        System.out.println("\n-------------------------------------------");
        
        // 3. Ejecutar el otro ejercicio
        //OtroEjercicio.ejecutar();
    }

    /**
     * Genera una matriz de dulces con valores aleatorios.
     */
    public static int[][] generarDatosAleatorios(int filas, int columnas, int min, int max) {
        int[][] matriz = new int[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // nextInt(max - min + 1) + min asegura que el rango sea [1, 300]
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }
}