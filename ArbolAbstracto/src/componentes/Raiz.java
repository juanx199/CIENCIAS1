/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;
import logica.AbstractComposite;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JUANCA
 */
public class Raiz extends AbstractComposite{
    private List<AbstractComposite> hijos = new ArrayList<>();
    
    public Raiz(String nombre){
        super(nombre);
    }
    @Override
    public void agregar(AbstractComposite componente){
        hijos.add(componente);
        
    }
    @Override
    public void eliminar(AbstractComposite componente){
        hijos.remove(componente);
    }
    @Override
    public void mostrarDetalle(int profundidad){
        System.out.println(" ".repeat(profundidad) + "[Raiz/Rama]" + nombre);
        for (AbstractComposite hijo : hijos) {
            hijo.mostrarDetalle(profundidad + 1);
        }
    }
}
