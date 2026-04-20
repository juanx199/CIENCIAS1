/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinario;

import logica.ArbolBusqueda;

/**
 * Clase de prueba para el Árbol Binario de Búsqueda.
 *
 * @author JUANCA
 */
public class ArbolBinario {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE ÁRBOL BINARIO DE BÚSQUEDA ===");
        ArbolBusqueda arbol = new ArbolBusqueda();
        
        System.out.println("Insertando valores: 50, 30, 20, 40, 70, 60, 80");
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);
        
        arbol.imprimirInOrder(); // Debería imprimir: 20 30 40 50 60 70 80
        
        System.out.println("\nAltura del árbol: " + arbol.getAltura());
        System.out.println("Nivel del nodo 60: " + arbol.getNivel(60));
        System.out.println("¿Existe el 40?: " + arbol.buscar(40));
        System.out.println("¿Existe el 90?: " + arbol.buscar(90));
        
        System.out.println("\nEliminando el nodo 20 (hoja)...");
        arbol.eliminar(20);
        arbol.imprimirInOrder();
        
        System.out.println("Eliminando el nodo 30 (con hijo)...");
        arbol.eliminar(30);
        arbol.imprimirInOrder();
        
        System.out.println("Eliminando el nodo 50 (con dos hijos - Raíz)...");
        arbol.eliminar(50);
        arbol.imprimirInOrder();
        
        if (arbol.getRaiz() != null) {
            System.out.println("\nNueva raíz: " + arbol.getRaiz().getValor());
            System.out.println("Nueva altura del árbol: " + arbol.getAltura());
        }
    }
}
