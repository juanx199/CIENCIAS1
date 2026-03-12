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

        Arrays.sort(monedas); // ordena de menor a mayor
        int restante = monto;

        System.out.println("Cambio para: " + monto);

        for (int i = monedas.length - 1; i >= 0; i--) {

            int moneda = monedas[i];
            int contador = 0;

            while (restante >= moneda) {
                restante -= moneda;
                contador++;
            }

            if (contador > 0) {
                System.out.println("Moneda de " + moneda + ": " + contador);
            }
        }

        if (restante == 0) {
            System.out.println("Cambio completado.");
        } else {
            System.out.println("No se puede dar cambio exacto.");
        }
    }
}



