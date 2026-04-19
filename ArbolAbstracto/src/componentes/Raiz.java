package componentes;

import logica.AbstractComposite;
import java.util.ArrayList;
import java.util.List;

public class Raiz extends AbstractComposite {
    private List<AbstractComposite> hijos;
    
    public Raiz(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<AbstractComposite>();
    }
    
    @Override
    public void agregar(AbstractComposite componente) {
        hijos.add(componente);
        System.out.println("  -> Se agrego '" + componente.getNombre() + "' a '" + this.nombre + "'");
    }
    
    @Override
    public void eliminar(AbstractComposite componente) {
        if(hijos.remove(componente)) {
            System.out.println("  -> Se elimino '" + componente.getNombre() + "' de '" + this.nombre + "'");
        } else {
            System.out.println("  -> No se encontro el componente");
        }
    }
    
    @Override
    public List<AbstractComposite> getHijos() {
        return hijos;
    }
    
    @Override
    public void mostrarDetalle(int profundidad) {
        String espacios = "";
        for(int i = 0; i < profundidad; i++) {
            espacios = espacios + "  ";
        }
        System.out.println(espacios + "+ " + nombre + " (Raiz/Rama)");
        
        for(AbstractComposite hijo : hijos) {
            hijo.mostrarDetalle(profundidad + 1);
        }
    }
    
    @Override
    public boolean esHoja() {
        return false;
    }
}
