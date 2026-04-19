/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

public abstract class AbstractComposite {
    protected String nombre;
    public String getNombre(){
        return nombre;
    }
    public AbstractComposite(String nombre){
        this.nombre = nombre;
    }
    
    public abstract void mostrarDetalle(int profundidad);
    
    public void agregar(AbstractComposite componente){
        throw new UnsupportedOperationException("No se puede hacer en este nodo");
    }
    public void eliminar(AbstractComposite componente){
        throw new UnsupportedOperationException("No se puede hacer en este nodo");
    }
}
