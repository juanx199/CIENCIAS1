/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package postfija;

import java.util.Scanner;
import java.util.Stack;


public class PostFija {

    static int prioridad(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': case '%': return 2;
            case '^': return 3;
        }
        return -1;
    }
public static String infijaAPostfija(String exp) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            } 
            // 1. Si es cualquier apertura, a la pila
            else if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } 
            // 2. Si es cualquier cierre, vaciamos hasta encontrar la pareja
            else if (c == ')' || c == ']' || c == '}') {
                char aperturaCorrespondiente = (c == ')') ? '(' : (c == ']') ? '[' : '{';
                
                while (!pila.isEmpty() && pila.peek() != aperturaCorrespondiente) {
                    resultado.append(pila.pop());
                }
                if (!pila.isEmpty()) pila.pop(); // Sacamos el signo de apertura
            } 
            else if (prioridad(c) > 0) {
                while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(c)) {
                    resultado.append(pila.pop());
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            resultado.append(pila.pop());
        }
        return resultado.toString();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresa la operación: ");
        String operacion = sc.nextLine();
        
        System.out.println("Postfija: " + infijaAPostfija(operacion));
        sc.close();
    }
}
