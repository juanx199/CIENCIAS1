/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peces;

/**
 *
 * @author Estudiantes
 */



public class SolucionPez {

    public static int calcularMaximoSabor(int n, int m, int[][] matriz) {
        // dp[j] almacenará el máximo sabor para j dulces tomados
        // Usamos un array unidimensional para ahorrar espacio (optimizando la fila anterior)
        int[] dp = new int[m + 1];

        // Procesamos cada dispensador uno por uno
        for (int i = 0; i < n; i++) {
            // Calculamos sumas acumuladas para el dispensador actual (0 a 12 dulces)
            int[] sumasPrefijo = new int[13];
            int sumaActual = 0;
            for (int k = 1; k <= 12; k++) {
                sumaActual += matriz[i][k - 1];
                sumasPrefijo[k] = sumaActual;
            }

            // Actualizamos el DP de atrás hacia adelante para no usar el mismo dispensador dos veces
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= 12; k++) {
                    if (j >= k) {
                        dp[j] = Math.max(dp[j], dp[j - k] + sumasPrefijo[k]);
                    }
                }
            }
        }
        return dp[m];
    }
}