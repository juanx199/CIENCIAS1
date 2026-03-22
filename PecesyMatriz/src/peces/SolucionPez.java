/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peces;

/**
 *
 * @author Juanca
 */

public class SolucionPez {

    public static int calcularMaximoSabor(int n, int m, int[][] matriz) {
        // dp[j] almacenará el máximo sabor para j dulces tomados
        // Usamos un array para ahorrar espacio 
        int[] dp = new int[m + 1];
        System.out.println("=== MEMORIA DP ===");
        System.out.println("Buscando el sabor máximo para " + m + "dulces");
        // Procesamos cada dispensador uno por uno
        for (int i = 0; i < n; i++) {
            // Calculamos sumas acumuladas para el dispensador actual 
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
            //MOstrar la memoria
            if (i < 5 || i == n-1){
                imprimirFilaCorta(i +1 , dp);
            } else if (i == 5){
                System.out.println(" procesando dispensadores intermedios ... ");
            }
        }
             
        return dp[m];
    }
    private static void imprimirFilaCorta(int id, int[] dp){
        System.out.print("Dispensador #"+ id + " Memoria:[0, ");
        
        int elementos = Math.min(dp.length, 5);
        for (int i = 0; i < elementos; i++){
            System.out.print(dp[i] + ", ");
        }
        System.out.println(" ... " + dp[dp.length - 1] + "]");
    }
}