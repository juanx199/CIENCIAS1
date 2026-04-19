/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolabstracto;
import componentes.Raiz;
import componentes.Hoja;
import logica.AbstractComposite;
import java.util.Scanner;
// Lo volví a subir 
/**
 *
 * @author JUANCA
 */
public class ArbolAbstracto {
    private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
        System.out.println("=== CONFIGURACIÓN INICIAL DEL ÁRBOL ===");
        System.out.print("Ingrese el nombre de la Raíz Principal: ");
        String nombreRaiz = sc.nextLine();
        
        // Creamos el nodo raíz principal
        AbstractComposite miArbol = new Raiz(nombreRaiz);
        
        ejecutarMenu(miArbol);
    }

    private static void ejecutarMenu(AbstractComposite nodoActual) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n--- GESTIONANDO: " + nodoActual.getNombre() + " ---");
            System.out.println("1. Agregar Hoja (Dato final)");
            System.out.println("2. Agregar Sub-Raíz (Rama)");
            System.out.println("3. Ver estructura completa");
            System.out.println("4. Salir / Finalizar");
            System.out.print("Seleccione una opción: ");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                // Al caer aquí, 'opcion' será -1, enviándolo directo al 'default' del menú para advertirle al usuario
            }
            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la nueva Hoja: ");
                    String nHoja = sc.nextLine();
                    nodoActual.agregar(new Hoja(nHoja));
                    break;
                case 2:
                    System.out.print("Nombre de la nueva Rama: ");
                    String nRama = sc.nextLine();
                    AbstractComposite nuevaRama = new Raiz(nRama);
                    nodoActual.agregar(nuevaRama);
                    System.out.println("¿Desea entrar a esta nueva rama para agregarle hijos ahora? (s/n)");
                    if(sc.nextLine().equalsIgnoreCase("s")) {
                        ejecutarMenu(nuevaRama); // Recursividad para navegar el árbol
                    }
                    break;
                case 3:
                    System.out.println("\nVISUALIZACIÓN:");
                    nodoActual.mostrarDetalle(0);
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
