/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import estructura.Nodo;
import modelo.ArbolBase;

/**
 * Árbol Binario de Búsqueda que hereda propiedades base.
 * Implementa métodos de un árbol binario de busqueda.
 *
 * @author JUANCA
 */
public class ArbolBusqueda extends ArbolBase {
    
    @Override
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        
        if (valor < actual.getValor()) {
            actual.setHijoIzquierdo(insertarRecursivo(actual.getHijoIzquierdo(), valor));
        } else if (valor > actual.getValor()) {
            actual.setHijoDerecho(insertarRecursivo(actual.getHijoDerecho(), valor));
        }
        
        return actual;
    }
    
    @Override
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) return false;
        
        if (valor == actual.getValor()) return true;
        
        return valor < actual.getValor()
          ? buscarRecursivo(actual.getHijoIzquierdo(), valor)
          : buscarRecursivo(actual.getHijoDerecho(), valor);
    }
    
    @Override
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }
    
    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) return null; // Nodo no encontrado
        
        if (valor < actual.getValor()) {
            actual.setHijoIzquierdo(eliminarRecursivo(actual.getHijoIzquierdo(), valor));
        } else if (valor > actual.getValor()) {
            actual.setHijoDerecho(eliminarRecursivo(actual.getHijoDerecho(), valor));
        } else {
            // Nodo a eliminar encontrado
            
            // Caso 1 y Caso 2: Un solo hijo o sin hijos
            if (actual.getHijoIzquierdo() == null) {
                return actual.getHijoDerecho();
            } else if (actual.getHijoDerecho() == null) {
                return actual.getHijoIzquierdo();
            }
            
            // Caso 3: Dos hijos. Obtener el sucesor (el menor del subárbol derecho)
            int minimoValor = encontrarMinimo(actual.getHijoDerecho());
            actual.setValor(minimoValor);
            // Eliminar el sucesor desde el árbol derecho
            actual.setHijoDerecho(eliminarRecursivo(actual.getHijoDerecho(), minimoValor));
        }
        return actual;
    }
    
    private int encontrarMinimo(Nodo actual) {
        return actual.getHijoIzquierdo() == null ? actual.getValor() : encontrarMinimo(actual.getHijoIzquierdo());
    }
    
    // Recorridos para analizar los resultados bajo distintos algoritmos
    public void imprimirInOrder() {
        System.out.print("In-Order:   ");
        inOrderRecursivo(raiz);
        System.out.println();
    }
    
    private void inOrderRecursivo(Nodo actual) {
        if (actual != null) {
            inOrderRecursivo(actual.getHijoIzquierdo());
            System.out.print(actual.getValor() + " ");
            inOrderRecursivo(actual.getHijoDerecho());
        }
    }
    
    public void imprimirPreOrder() {
        System.out.print("Pre-Order:  ");
        preOrderRecursivo(raiz);
        System.out.println();
    }
    
    private void preOrderRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.getValor() + " ");
            preOrderRecursivo(actual.getHijoIzquierdo());
            preOrderRecursivo(actual.getHijoDerecho());
        }
    }
    
    public void imprimirPostOrder() {
        System.out.print("Post-Order: ");
        postOrderRecursivo(raiz);
        System.out.println();
    }
    
    private void postOrderRecursivo(Nodo actual) {
        if (actual != null) {
            postOrderRecursivo(actual.getHijoIzquierdo());
            postOrderRecursivo(actual.getHijoDerecho());
            System.out.print(actual.getValor() + " ");
        }
    }
}
