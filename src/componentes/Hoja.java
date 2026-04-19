/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;
import logica.AbstractComposite;
/**
 *
 * @author JUANCA
 */
public class Hoja extends AbstractComposite{
    public Hoja(String nombre){
        super(nombre);
    }
    @Override
    public void mostrarDetalle(int profundidad){
        System.out.println(" ".repeat(profundidad) + " [Hoja]" + nombre);
    }
}
