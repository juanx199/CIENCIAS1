package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Tablero implements Serializable {
	private int [][] tablero = new int [10][10];
	private ArrayList<Barco> barcos;
	
	public void crearBarcos() {
		
		barcos.add(new Barco("Portaviones", 5));
		barcos.add(new Barco("Crucero", 4));
		
	}

	
	public boolean disparo(int[x], int[y]) {
		
		if(tablero [x][y] = 2) {
			tablero [x][y] = 3;
		}		
		tablero [x][y] = 1; //agua
		
		
	}
	
}

}
