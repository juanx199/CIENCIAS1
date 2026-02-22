/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

public class Heap {
    public long pasos = 0;
    public long ciclos = 0;

    public void heapSort(int[] arr) {
        int n = arr.length;
        pasos = 0; // Reiniciar contadores
        ciclos = 0;

        // Construir el heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            ciclos++;
            heapify(arr, n, i);
        }

        // Extraer elementos del heap
        for (int i = n - 1; i > 0; i--) {
            ciclos++;
            // Intercambio
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            pasos++; 
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        ciclos++; // Cada llamada a heapify cuenta como un ciclo para añadirloal contador 
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n) {
            pasos++;
            if (arr[l] > arr[largest]) largest = l;
        }

        if (r < n) {
            pasos++; 
            if (arr[r] > arr[largest]) largest = r;
        }

        if (largest != i) {
            pasos++; // Intercambio
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}