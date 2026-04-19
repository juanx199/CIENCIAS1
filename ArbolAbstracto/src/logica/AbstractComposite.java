package logica;

import java.util.List;

public abstract class AbstractComposite {
    protected String nombre;
    
    public AbstractComposite(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public abstract void mostrarDetalle(int profundidad);
    
    public abstract boolean esHoja();
    
    public void agregar(AbstractComposite componente) {
        throw new UnsupportedOperationException("Este nodo no puede tener hijos");
    }
    
    public void eliminar(AbstractComposite componente) {
        throw new UnsupportedOperationException("Este nodo no puede tener hijos");
    }
    
    public List<AbstractComposite> getHijos() {
        throw new UnsupportedOperationException("Este nodo no tiene hijos");
    }
}
