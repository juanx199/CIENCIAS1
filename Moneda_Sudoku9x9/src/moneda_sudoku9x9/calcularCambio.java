/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moneda_sudoku9x9;

/**
 *
 * @author JUANCA
 */
import java.util.Arrays;

public class calcularCambio {

   public static void calcularCambio(int monto, int[] monedas) {

        // Ordenar monedas de menor a mayor
        Arrays.sort(monedas);

        System.out.println("\n--- CAMBIO CON MÉTODO VORAZ ---");

        int restante = monto;

        // recorrer de mayor a menor
        for (int i = monedas.length - 1; i >= 0; i--) {

            int moneda = monedas[i];

            while (restante >= moneda) {
                restante -= moneda;
                System.out.println("Se usa moneda de: " + moneda +
                                   "  -> restante: " + restante);
            }
        }

        if (restante != 0) {
            System.out.println("No se pudo dar el cambio exacto.");
        } else {
            System.out.println("Cambio completado.");
        }
    }
}


