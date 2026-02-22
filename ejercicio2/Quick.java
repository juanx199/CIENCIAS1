/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

/**
 *
 * @author JUANCA
 */
public class Quick {
    
    public long pasos = 0;
    public long ciclos = 0;

    public void ordenar(int[] arr, int low, int high) {
        if (low < high) {
            pasos++; // Condicional
            int pi = partition(arr, low, high);
            ordenar(arr, low, pi - 1);
            ordenar(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        pasos++; // Asignación del pivote
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            ciclos++; // Iteración del bucle
             pasos++; // Condicional
            if (arr[j] < pivot) {
               
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                pasos += 3; // 3 pasos por el intercambio
            }
        }

        // Swap final con el pivote
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        pasos += 3;
        
        return i + 1;
    }
}
}


