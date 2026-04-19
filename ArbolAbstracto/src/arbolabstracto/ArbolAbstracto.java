package arbolabstracto;

import componentes.Raiz;
import componentes.Hoja;
import logica.AbstractComposite;
import java.util.Scanner;

public class ArbolAbstracto {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== CREACION DE ESTRUCTURA DE ARBOL ===");
        System.out.println("Este programa implementa el patron Composite");
        System.out.println("Permite crear un arbol con raices/ramas y hojas");
        System.out.println();
        
        System.out.print("Ingrese el nombre de la raiz principal: ");
        String nombreRaiz = scanner.nextLine();
        
        AbstractComposite raizPrincipal = new Raiz(nombreRaiz);
        
        menuPrincipal(raizPrincipal);
    }
    
    private static void menuPrincipal(AbstractComposite nodoActual) {
        boolean salir = false;
        
        while(!salir) {
            System.out.println("\n==========================================");
            System.out.println("NODO ACTUAL: " + nodoActual.getNombre());
            System.out.println("TIPO: " + (nodoActual.esHoja() ? "Hoja" : "Raiz/Rama"));
            System.out.println("==========================================");
            System.out.println("1. Agregar una Hoja");
            System.out.println("2. Agregar una Rama (Sub-raiz)");
            System.out.println("3. Ver estructura del arbol");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    agregarHoja(nodoActual);
                    break;
                case 2:
                    agregarRama(nodoActual);
                    break;
                case 3:
                    verEstructura(nodoActual);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
    
    private static void agregarHoja(AbstractComposite nodoActual) {
        if(nodoActual.esHoja()) {
            System.out.println("Error: No se puede agregar hijos a una Hoja");
            return;
        }
        
        System.out.print("Nombre de la nueva Hoja: ");
        String nombre = scanner.nextLine();
        
        if(nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacio");
            return;
        }
        
        Hoja nuevaHoja = new Hoja(nombre);
        nodoActual.agregar(nuevaHoja);
    }
    
    private static void agregarRama(AbstractComposite nodoActual) {
        if(nodoActual.esHoja()) {
            System.out.println("Error: No se puede agregar hijos a una Hoja");
            return;
        }
        
        System.out.print("Nombre de la nueva Rama: ");
        String nombre = scanner.nextLine();
        
        if(nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacio");
            return;
        }
        
        Raiz nuevaRama = new Raiz(nombre);
        nodoActual.agregar(nuevaRama);
        
        System.out.print("Desea entrar a esta nueva rama para administrarla? (s/n): ");
        String respuesta = scanner.nextLine();
        
        if(respuesta.equalsIgnoreCase("s")) {
            menuPrincipal(nuevaRama);
        }
    }
    
    private static void verEstructura(AbstractComposite nodoActual) {
        System.out.println("\n--- ESTRUCTURA DEL ARBOL ---");
        System.out.println("(+) = Nodo compuesto (puede tener hijos)");
        System.out.println("(-) = Nodo hoja (no puede tener hijos)");
        System.out.println();
        
        // Buscar la raiz principal
        AbstractComposite raiz = encontrarRaiz(nodoActual);
        if(raiz != null) {
            raiz.mostrarDetalle(0);
        } else {
            nodoActual.mostrarDetalle(0);
        }
    }
    
    private static AbstractComposite encontrarRaiz(AbstractComposite nodo) {
        return nodo;
    }
}
