/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import estructura.Nodo;

/**
 * Clase base abstracta que define el comportamiento y propiedades generales del árbol.
 *
 * @author JUANCA
 */
public abstract class ArbolBase {
    protected Nodo raiz;

    public ArbolBase() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // Métodos abstractos que deben ser implementados por el árbol específico
    public abstract void insertar(int valor);
    public abstract void eliminar(int valor);
    public abstract boolean buscar(int valor);

    // Propiedades comunes
    public int getAltura() {
        return calcularAltura(this.raiz);
    }

    protected int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0; // Un árbol vacío tiene altura 0
        }
        int alturaIzq = calcularAltura(nodo.getHijoIzquierdo());
        int alturaDer = calcularAltura(nodo.getHijoDerecho());
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public int getNivel(int valor) {
        return calcularNivel(this.raiz, valor, 1); // La raíz está en nivel 1
    }

    protected int calcularNivel(Nodo nodo, int valor, int nivelActual) {
        if (nodo == null) return 0; // 0 significa que no se encontró en la rama
        
        if (nodo.getValor() == valor) return nivelActual;
        
        // Primero busca a la izquierda
        int nivelAca = calcularNivel(nodo.getHijoIzquierdo(), valor, nivelActual + 1);
        if (nivelAca != 0) return nivelAca;
        
        // Si no está, busca a la derecha
        return calcularNivel(nodo.getHijoDerecho(), valor, nivelActual + 1);
    }
}
