/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinario;

import logica.ArbolBusqueda;
import java.util.Scanner;
import javax.swing.JFrame;
import vista.LienzoArbol;


 // Clase principal simulando un menú ppara el Árbol Binario de Búsqueda.
public class ArbolBinario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBusqueda arbol = new ArbolBusqueda();
        boolean salir = false;

        System.out.println("=== SISTEMA DE ÁRBOL BINARIO DE BÚSQUEDA ===");

        while (!salir) {
            System.out.println("\n==========================================");
            System.out.println("1. Insertar un valor");
            System.out.println("2. Eliminar un valor");
            System.out.println("3. Buscar un valor");
            System.out.println("4. Ver estado general del Árbol (Consola)");
            System.out.println("5. Visualizar Árbol Gráficamente (Ventana Swing)");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            
            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el valor a insertar: ");
                        int valorInsertar = Integer.parseInt(scanner.nextLine());
                        arbol.insertar(valorInsertar);
                        System.out.println("Valor " + valorInsertar + " insertado correctamente.");
                        break;
                    case 2:
                        System.out.print("Ingresa el valor a eliminar: ");
                        int valorEliminar = Integer.parseInt(scanner.nextLine());
                        arbol.eliminar(valorEliminar);
                        System.out.println("Comando de eliminación para " + valorEliminar + " ejecutado.");
                        break;
                    case 3:
                        System.out.print("Ingresa el valor a buscar: ");
                        int valorBuscar = Integer.parseInt(scanner.nextLine());
                        boolean existe = arbol.buscar(valorBuscar);
                        if (existe) {
                            System.out.println("=> RESULTADO: El valor " + valorBuscar + " SÍ está en el árbol (Nivel " + arbol.getNivel(valorBuscar) + ").");
                        } else {
                            System.out.println("=> RESULTADO: El valor " + valorBuscar + " NO se encuentra en el árbol.");
                        }
                        break;
                    case 4:
                        System.out.println("\n--- ESTADO ACTUAL DEL ÁRBOL ---");
                        if (arbol.getRaiz() == null) {
                            System.out.println("El árbol está totalmente vacío.");
                        } else {
                            arbol.imprimirPreOrder();
                            arbol.imprimirInOrder();
                            arbol.imprimirPostOrder();
                            System.out.println("Altura total del árbol: " + arbol.getAltura());
                            System.out.println("Valor de la Raiz Principal: " + arbol.getRaiz().getValor());
                        }
                        break;
                    case 5:
                        if (arbol.getRaiz() == null) {
                            System.out.println("\nEl árbol está vacío. Inserta nodos primero.");
                        } else {
                            System.out.println("\n==> Abriendo ventana gráfica. Puedes seguir usando este menú.");
                            JFrame ventana = new JFrame("Visualizador Árbol Binario de Búsqueda");
                            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            ventana.setSize(900, 700);
                            ventana.setLocationRelativeTo(null);
                            
                            LienzoArbol lienzo = new LienzoArbol();
                            lienzo.setRaiz(arbol.getRaiz());
                            
                            ventana.add(lienzo);
                            ventana.setVisible(true);
                        }
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingresa un número válido.");
            }
        }
        
        scanner.close();
    }
}
