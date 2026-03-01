/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokusuma;

/**
 *
 * @author JUANCA
 */
public class Sudoku {
    private int [][] tablero;
    private int n = 4;
    
    private int intentos = 0; 
    private int backtracks = 0;
    private int llamadas = 0;
            
    public Sudoku(){
        tablero = new int[n][n];
    }
    public boolean solver(){
        llamadas ++;
        
        int fila = -1, col = -1;
        boolean vacio = true;
        
        //buscar una casilla vacía
        for (int i = 0; i < n ; i++ ){
            for (int j = 0; j < n ; j++){
                if (tablero[i][j] == 0){
                    fila = i;
                    col = j;
                    vacio = false;
                    break;
                }
                
            }
            if(!vacio)break;
        }
        if (vacio)return true; // se llenó el tablero
        
        for (int num = 1 ; num <=n; num++){
            
            intentos ++;
            if (Sirve(fila,col,num)){
                tablero[fila][col] = num;
                
                if (solver())
                    return true;
                tablero[fila][col] = 0;
                backtracks ++;
            }
            
        }
        return false;
        
    }
    
    private boolean Sirve(int fila, int col, int num){
        
        //filas
        for (int j = 0; j < n; j++)
            if (tablero[fila][j] == num)
                return false;
        //columnas
        for (int i = 0; i < n; i++)
            if (tablero[i][col] == num)
                return false;
        
        //bloques2x2
        int inicioFila = fila - fila %2;
        int inicioCol = col - col %2;
        
        for (int i = 0; i< 2; i++)
            for (int j = 0; j< 2 ; j++)
                if (tablero[inicioFila + i][inicioCol + j] == num)
                    return false;
        return true;              
    }
    public void imprimir(){
        for (int[]fila : tablero){
            for (int num : fila)
                System.out.print(num + " ");
            System.out.println();
        }
    }
    public void imprimirResultados(){
        System.out.println(" ### RESULTADOS ###");
        System.out.println(" Intentos: " + intentos);
        System.out.println(" Bactracks: " + backtracks);
        System.out.println(" Llamadas recursivs:" + llamadas);
    }
}

