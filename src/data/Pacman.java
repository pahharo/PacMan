/*
 * Figura.java
 *
 * Created on 18 de septiembre de 2005, 19:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package data;

import guipacman.RejillaPanel;
import java.util.Vector;

/**
 * Representa una pieza del juego del tetris. Existen 7 tipos de piezas en este juego (ver el constructor).
 * @author acu
 */
public class Pacman {
    public static final int IZQUIERDA         = 0;
    public static final int DERECHA           = 1;
    public static final int ABAJO             = 2;
    public static final int ARRIBA            = 3;
    
    
    private Vector<Elemento> elements;
    private int xorigen;
    private int yorigen;
    
    /** 
     * Creates a new instance of Figura 
     * @param fila0 utilizado para definir las celdas ocupadas por esta Figura en la primera fila
     * @param fila1 utilizado para definir las celdas ocupadas por esta Figura en la segunda  fila
     * @param fila2 utilizado para definir las celdas ocupadas por esta Figura en la tercera  fila
     */
    public Pacman(int fila0) {
        elements = new Vector<Elemento>();
        addElements(0,fila0);
    }
    
    /**
     * Genera una nueva Figura, eligiendo el tipo de forma aleatoria entre las 7 posibilidades
     * @return la nueva Figura generada de forma aleatoria
     */
    public static Pacman nuevaFigura(){
        Pacman fig=null;
       
            fig = new Pacman(0xF);
        
        fig.xorigen=14;
        fig.yorigen=17;
        
        return fig;
    }
    
    /**
     * Añade los Elementos  ocupadas en la fila indicada como parámetro  a la Figura actual
     * @param fila la fila
     * @param valor entero usado como máscara hexadecimal para indicar las casillas ocupadas en la fila (ver el constructor)
     */
    private void addElements(int fila, int valor){
        if((valor & 0xF)>0) elements.addElement(new Elemento(fila,0));
    }
    
    /**
     * Obtiene el número de Elementos (celdas) que forma la Figura actual
     * @return el número de Elementos (celdas) que forma la Figura actual
     */
    public int getNElements(){
        return elements.size();
    }
    
    /**
     * Obtiene el Elemento en la posición pos de la Figura actual
     * @param pos la posición
     * @return el Elemento en la posición pos de la Figura actual
     */
    public Elemento getElementAt(int pos){
        return (Elemento)elements.elementAt(pos);
    }
    
    /**
     * Obtiene la posición x respecto al origen de coordenadas de la Rejilla de la Figura actual
     * @return la posición x respecto al origen de coordenadas de la Rejilla de la Figura actual
     */
    public int getXOrigen(){
        return xorigen;
    }
 
    /**
     * Obtiene la posición y respecto al origen de coordenadas de la Rejilla de la Figura actual
     * @return la posición y respecto al origen de coordenadas de la Rejilla de la Figura actual
     */
    public int getYOrigen(){
        return yorigen;
    }
    
    /**
     * Mueve la Figura actual una casilla en la dirección indicado por direccion (ABAJO,IZQUIERDA o ARRIBA)
     * @param direccion la dirección de movimiento (ABAJO,IZQUIERDA o ARRIBA)
     */
    public void mueve(int direccion){
        int c,d,i,j;
        if(direccion==ABAJO){
            yorigen++;
            
        }else if(direccion==IZQUIERDA){
            xorigen--;
        }else if(direccion==DERECHA){
            xorigen++;
        }
        else if(direccion==ARRIBA){
            yorigen--;
        }
    }
    
    /**
     * Rota la figura actual en sentido contrario a las agujas del reloj si al
     * hacerlo no choca contra ninguna otra figura ni contra los muros exteriores
     * @param rej La Rejilla del juego
     */
    public void mover(Rejilla rej){
        Elemento elemento;
        int x,y,i;
        Vector<Elemento> newelements=new Vector<Elemento>();        
        i=0;
        while(i<getNElements()){
            elemento=getElementAt(i);
            x=elemento.getColumna();
            y=elemento.getFila();
            if(rej.getTipoCelda(y-1+getXOrigen(),-x+3+getYOrigen())!=Rejilla.VACIA){
            } else{
                newelements.addElement(new Elemento(-x+3,y-1));
            }
            i++;
        }
            elements=newelements;
    }
}
 
