/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matriz;

/**
 *
 * @author Estudiantes
 */
public class SolucionCandy {

     public static int resolverCandy(int M, int N, int[][] matriz) {
        if (M == 0 || N == 0) return 0;

        // DP para cada fila individualmente
        int[] resultadosFilas = new int[M];
        for (int i = 0; i < M; i++) {
            resultadosFilas[i] = maximoNoAdyacente(matriz[i], N);
        }

        // DP final sobre los resultados de las filas
        return maximoNoAdyacente(resultadosFilas, M);
    }

    /**
     * Lógica de DP lineal: Subproblema de elegir elementos no consecutivos.
     */
    private static int maximoNoAdyacente(int[] arr, int n) {
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            // Decisión: No tomar el actual vs Tomarlo + el óptimo de hace dos posiciones
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
