/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokusuma;

/**
 *
 * @author JUANCA
 */
public class Suma {
    public class SumaMaxima {

    // Método principal de Divide y Vencerás
    public int calcular(int[] arr, int bajo, int alto) {
        // Caso base: un solo elemento
        if (bajo == alto) {
            return arr[bajo];
        }

        // Encontrar el punto medio
        int medio = (bajo + alto) / 2;

        /* Retornar el máximo de tres posibles casos:
         * 1. Suma máxima en la mitad izquierda
         * 2. Suma máxima en la mitad derecha
         * 3. Suma máxima que cruza el punto medio
         */
        return Math.max(Math.max(calcular(arr, bajo, medio), 
                                 calcular(arr, medio + 1, alto)), 
                        sumaCruze(arr, bajo, medio, alto));
    }

    // Método auxiliar para encontrar la suma que cruza el centro
    private int sumaCruze(int[] arr, int bajo, int medio, int alto) {
        // Suma hacia la izquierda del medio
        int suma = 0;
        int sumaIzquierda = Integer.MIN_VALUE;
        for (int i = medio; i >= bajo; i--) {
            suma += arr[i];
            if (suma > sumaIzquierda) {
                sumaIzquierda = suma;
            }
        }

        // Suma hacia la derecha del medio
        suma = 0;
        int sumaDerecha = Integer.MIN_VALUE;
        for (int i = medio + 1; i <= alto; i++) {
            suma += arr[i];
            if (suma > sumaDerecha) {
                sumaDerecha = suma;
            }
        }

        return sumaIzquierda + sumaDerecha;
    }
}

