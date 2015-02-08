package data;
import javax.swing.JPanel;
import guipacman.PacmanFrame;
import data.*;
import guipacman.RejillaPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase implementa una hebra que hace que se mueva continuamente hacia abajo la Figura actual.
 *  La hebra se encarga tambi�n de ir refrescando la pantalla
 * dónde se dibuja todos. Además controla si la Figura
 * choca contra un muro o contra las piezas ya colocadas. 
 */
public class Mueve implements Runnable{
    private int delay;
    private boolean continuar=true;
    private boolean suspendFlag=true;
    private PacmanFrame frame;
       
    /**
     * Constructor de la clase, que inicializa la referencia utilizadas por
     * la hebra al TetrisMidlet, establece el retardo en milisegundos
     * entre movimiento y movimiento de la Figura actual, y comienza a ejecutar
     * la hebra. 
     */
    public Mueve(PacmanFrame fr,int nivel){
        frame=fr;
        delay= actualizaRetardo(nivel);
        Thread t=new Thread(this);
        t.start();
    }
    
    /**
     * C�digo que constituye las sentencias de la hebra. En este caso, se encarga
     * de hacer que se muevan continuamente la Serpiente
     * y los Ratones. La hebra se encarga tambi�n de ir refrescando la pantalla
     * d�nde se dibuja todo, y los puntos acumulados. Adem�s controla si
     * la Serpiente choca contra un muro o contra s� misma, para comenzar
     * el juego de nuevo. Cuando la Serpiente come un Raton aumenta su longitud
     * en una celda.
     */
    public void run(){
        try{
            while(continuar){
                synchronized(this){
                    while(suspendFlag){
                        wait();
                    }
                }
                Thread.sleep(delay);
                frame.setRecord(frame.getRejilla().getPuntuacion());
                frame.setPuntuacion();
                int lastmove=frame.getMove(); // último movimiento
                //Dependiendo de hacia donde se mueva comprobamos si se choca y sino movemos
                if(lastmove==0){
                    // Quedate como estás
                }
                else if(lastmove==2){
                    if(!frame.getRejilla().seChoca(frame.getFigura(),Pacman.ABAJO)){
                        frame.getRejilla().cocoZampado(frame.getFigura(), Pacman.ABAJO);
                        frame.getFigura().mueve(Pacman.ABAJO);
                        if(frame.getPanel()!=null)
                            frame.getPanel().repaint();
                    } 
                } else if(lastmove==4){
                    if(!frame.getRejilla().seChoca(frame.getFigura(),Pacman.IZQUIERDA)){
                        frame.getRejilla().cocoZampado(frame.getFigura(), Pacman.IZQUIERDA);
                        frame.getFigura().mueve(Pacman.IZQUIERDA);
                        if(frame.getPanel()!=null)
                            frame.getPanel().repaint();
                    } 
                } else if(lastmove==6){
                    if(!frame.getRejilla().seChoca(frame.getFigura(),Pacman.DERECHA)){
                        frame.getRejilla().cocoZampado(frame.getFigura(), Pacman.DERECHA);
                        frame.getFigura().mueve(Pacman.DERECHA);
                        if(frame.getPanel()!=null)
                            frame.getPanel().repaint();
                    } 
                } else if(lastmove==8){
                    if(!frame.getRejilla().seChoca(frame.getFigura(),Pacman.ARRIBA)){
                        frame.getRejilla().cocoZampado(frame.getFigura(), Pacman.ARRIBA);
                        frame.getFigura().mueve(Pacman.ARRIBA);
                        if(frame.getPanel()!=null)
                            frame.getPanel().repaint();
                    } 
                } else{
                    boolean valor=frame.getRejilla().copiaFiguraEnRejilla(frame.getFigura());
                    frame.getRejilla().eliminarFilasLlenas();
                    if(frame.getPanel()!=null)
                        frame.getPanel().repaint();
                    if(!valor)
                        frame.nuevaFigura();
                    else{
                        System.out.println("He llegado al final");
                        continuar=false;
                    }
                }
            }// end while(continuar)
        } catch(InterruptedException e){
            System.out.println("Hilo MueveSerpiente interrumpido");
        } catch (IOException ex) {
            Logger.getLogger(Mueve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Detiene momentaneamente la ejecución de la hebra, haciendo que la Figura actual
     * quede parada.
     */
    synchronized public void suspender(){
        frame.getPanel().repaint();
        suspendFlag=true;
    }
    
    /**
     * Reanuda el movimiento de la hebra. La Figura actual vuelve  a moverse.
     */
    public synchronized void reanudar(){
        if(frame.getPanel()!=null)
            frame.getPanel().repaint();
        suspendFlag = false;
        notify();
    }
    
    /**
     * Termina la ejecución de la hebra.
     */
    public void parar(){
        continuar=false;
    }
    
    /**
     * Nos dice si la hebra está o no parada.
     * @return true si la hebra de movimiento está parada, false en otro caso
     */
    synchronized public boolean getParado(){
        return suspendFlag;
    }
    
    
    /**
     * La siguiente función actualiza el retardo que espera la hebra
     * para mover la Figura actual. El nivel más lento será
     * el 0 (retardo 700) y el más rápido el 10 (retardo 50)
     */
    private int actualizaRetardo(int nivel) {
        if (nivel>10) nivel=10;
        else if (nivel<0) nivel=0;
        return ( 400-(nivel*35) );
    }
}
 
