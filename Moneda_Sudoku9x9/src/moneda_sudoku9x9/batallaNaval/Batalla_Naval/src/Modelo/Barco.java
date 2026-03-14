package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Barco {
	
	private String nombre;
	private List<String> coordenadas;
	private int vidas;
	private int tamano;
	
	public Barco(String nombre, List<String> coordenadas, int vidas, int tamano) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.vidas= vidas;
		this.tamano = tamano;
		
	}
	
	public void agregar(int x, int y) {
		coordenadas.add(x +" , " + y);
		
	}
	
	public boolean impacto(int x, int y) {
		if(coordenadas.contains(x +" , " + y)) {
			vidas--;
			return true;
		}
		
		return false;
	}
	
	public boolean estado() {
		return vidas == 0;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	

}
