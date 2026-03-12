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

        // Ordenar monedas de mayor a menor
        Arrays.sort(monedas);

        System.out.println("\n--- CAMBIO CON MÉTODO VORAZ ---");

        for (int i = monedas.length - 1; i >= 0; i--) {

            int cantidad = monto / monedas[i];

            if (cantidad > 0) {
                System.out.println("Moneda de " + monedas[i] + ": " + cantidad);
                monto = monto % monedas[i];
            }
        }

        if (monto > 0) {
            System.out.println("No se puede dar el cambio exacto.");
        } else {
            System.out.println("Cambio completado correctamente.");
        }
    }
}

