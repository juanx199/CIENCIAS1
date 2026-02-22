/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;     

public class Merge {
    public long pasos = 0;
    public long ciclos =0;
    
    public void ordenar (int arr[], int l, int r){
        ciclos ++;
        if (l < r){
            int m = l +(r-l)/2;
            
            ordenar(arr, l, m);
            ordenar(arr, m+1,r);
            merge(arr, l, m,r );        
        }
    }
    private void merge(int arr[], int l, int m, int r){
        int n1 = m - l +1;
        int n2 = r - m;
        
        int L[] = new int [n1];
        int R[] = new int [n2];
        
        for (int i = 0; i<n1; ++i){
            ciclos++;
            L[i] = arr[l + i];
            pasos ++; //mueve el dato
        }
        for (int j = 0; j<n2; ++j){
            ciclos++;
            R[j] = arr[m+1+j];
            pasos++; //mueve otro dato
        }
        int i = 0, j=0;
        int k = l;
        
        while(i < n1 && j < n2){
            ciclos ++;
            pasos ++;
            
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else{
                arr[k] = R[j];
                j++;
            }
            pasos++;
            k++;
        }
        
        while (i < n1){
            ciclos++;
            arr[k]= L[i];
            i++;
            k++;
            pasos++;
        }
        while (j < n2){
            ciclos++;
            arr[k]= R[j];
            j++;
            k++;
            pasos++;
        }
    }
}