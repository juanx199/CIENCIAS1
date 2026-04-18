/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolabstracto;
import componentes.Raiz;
import componentes.Hoja;
import logica.AbstractComposite;

/**
 *
 * @author JUANCA
 */
public class ArbolAbstracto {

    public static void main(String[] args) {
        AbstractComposite miArbol = new Raiz("Arbol blblbl");
        
        AbstractComposite ramaEstudiantes = new Raiz("Estudiantes");
        AbstractComposite ramaProyectos = new Raiz("Proyectos_Java");

        // Agregamos hojas a las ramas
        ramaEstudiantes.agregar(new Hoja("Juan Camilo"));
        ramaEstudiantes.agregar(new Hoja("Compañero_1"));
        
        ramaProyectos.agregar(new Hoja("Analisis_Dominos.pdf"));
        ramaProyectos.agregar(new Hoja("Codigo_Composite.java"));

        // Armamos el árbol completo
        miArbol.agregar(ramaEstudiantes);
        miArbol.agregar(ramaProyectos);

        // Ejecutamos la operación
        System.out.println("--- ESTRUCTURA DE ARBOL ABSTRACTO ---");
        miArbol.mostrarDetalle(0);
    }
    
}
