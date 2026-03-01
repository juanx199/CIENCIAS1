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
        Sudoku juego = new Sudoku();

        System.out.println("Generando el tablerito aleatorio .....");

        if (juego.solver(){
            juego.imprimir();
        }
        System.out.println();
        juego.imprimirResultados();
    }
}

