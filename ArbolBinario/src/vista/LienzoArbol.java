package vista;

import estructura.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


 // Componente gráfico encargado de dibujar recursivamente las aristas y nodos del Árbol Binario de Búsqueda.
 
public class LienzoArbol extends JPanel {
    private Nodo raiz;
    private final int RADIO = 23;
    private final int SEPARACION_Y = 60;

    public LienzoArbol() {
        setBackground(new Color(245, 245, 245)); 

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            Graphics2D g2 = (Graphics2D) g;
            // Antialiasing para suavizar los trazos redondos
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Calcular el inicio en el centro superior
            dibujarNodo(g2, raiz, getWidth() / 2, 40, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics2D g, Nodo nodo, int x, int y, int separacionX) {
        // Dibujar Arista a hijo Izquierdo
        if (nodo.getHijoIzquierdo() != null) {
            g.setColor(new Color(100, 100, 100)); 
            g.drawLine(x, y, x - separacionX, y + SEPARACION_Y);
            dibujarNodo(g, nodo.getHijoIzquierdo(), x - separacionX, y + SEPARACION_Y, separacionX / 2);
        }
        
        // Dibujar Arista a hijo Derecho
        if (nodo.getHijoDerecho() != null) {
            g.setColor(new Color(100, 100, 100));
            g.drawLine(x, y, x + separacionX, y + SEPARACION_Y);
            dibujarNodo(g, nodo.getHijoDerecho(), x + separacionX, y + SEPARACION_Y, separacionX / 2);
        }

        // Dibujar Círculo (Fondo del nodo)
        g.setColor(new Color(41, 128, 185)); 
        g.fillOval(x - RADIO, y - RADIO, RADIO * 2, RADIO * 2);
        
        // Dibujar Borde del Ndo
        g.setColor(new Color(26, 82, 118));
        g.drawOval(x - RADIO, y - RADIO, RADIO * 2, RADIO * 2);

        // Imprimir Texto con el Valor Numérico al interior
        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, 15));
        String texto = String.valueOf(nodo.getValor());
        FontMetrics fm = g.getFontMetrics();
        int anchoTexto = fm.stringWidth(texto);
        int altoTexto = fm.getAscent();
        
        //  centrar los textos en el círculo
        g.drawString(texto, x - (anchoTexto / 2), y + (altoTexto / 2) - 2);
    }
}
