/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokusuma;

/**
 *
 * @author JUANCA
 */
public class Main {
public static void main(String[] args) {
        // --- PARTE 1: SUDOKU (Fuerza Bruta) ---
        Sudoku juego = new Sudoku();
        System.out.println("=== EJECUTANDO SUDOKU 4x4 (Fuerza Bruta) ===");
        
        if (juego.solver()) {
            juego.imprimir();
        }
        juego.imprimirResultados();

        System.out.println("\n-------------------------------------------\n");

        // --- PARTE 2: SUMA SUBSECUENTE (Divide y Vencerás) ---
        System.out.println("=== EJECUTANDO SUMA SUBSECUENTE (Divide y Vencerás) ===");
        int[] arregloEjemplo = {-2, -5, 6, -2, -3, 1, 5, -6};
        
        SumaMaxima sm = new SumaMaxima();
        int resultado = sm.calcular(arregloEjemplo, 0, arregloEjemplo.length - 1);

        System.out.print("Arreglo analizado: [");
        for(int i=0; i < arregloEjemplo.length; i++) 
            System.out.print(arregloEjemplo[i] + (i == arregloEjemplo.length-1 ? "" : ", "));
        System.out.println("]");
        
        System.out.println("La suma subsecuente más grande es: " + resultado);
    }
}


