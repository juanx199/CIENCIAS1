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
    
    // Método principal para resolver el problema de los dulces
    public static int calcularMaximo(int[][] matriz) {
        if (matriz == null || matriz.length == 0) return 0;
        
        int nPeces = matriz.length;
        int[] valoresMaximosPorPez = new int[nPeces];

        // PASO 1: Resolver DP para cada Pez (fila) individualmente
        for (int i = 0; i < nPeces; i++) {
            valoresMaximosPorPez[i] = resolverFila(matriz[i]);
        }

        // PASO 2: Resolver DP para elegir Peces (filas) no consecutivos
        return resolverFila(valoresMaximosPorPez);
    }

    // Lógica de DP: Máxima suma de elementos no adyacentes
    private static int resolverFila(int[] fila) {
        if (fila.length == 0) return 0;
        if (fila.length == 1) return fila[0];

        int previo2 = 0;           // dp[i-2]
        int previo1 = fila[0];     // dp[i-1]

        for (int i = 1; i < fila.length; i++) {
            int actual = Math.max(previo1, fila[i] + previo2);
            previo2 = previo1;
            previo1 = actual;
        }
        return previo1;
    }
}
