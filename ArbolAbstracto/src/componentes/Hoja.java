package componentes;

import logica.AbstractComposite;

public class Hoja extends AbstractComposite {
    
    public Hoja(String nombre) {
        super(nombre);
    }
    
    @Override
    public void mostrarDetalle(int profundidad) {
        String espacios = "";
        for(int i = 0; i < profundidad; i++) {
            espacios = espacios + "  ";
        }
        System.out.println(espacios + "- " + nombre + " (Hoja)");
    }
    
    @Override
    public boolean esHoja() {
        return true;
    }
}
