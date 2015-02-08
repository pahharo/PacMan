/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guipacman;
import data.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author manu
 */
public class PacmanFrame extends javax.swing.JFrame {

    private Rejilla rejilla;
    private Pacman figura;
    private Mueve mueve;
    private RejillaPanel rejillaPanel;
    boolean start=true;
    private int RECORD;

    /**
     * Creates new form TetrisFrame
     */
    public PacmanFrame() {
        initComponents();
        rejilla = new Rejilla(32,32);
        mueve=new Mueve(this, 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rejillaPanel1 = new RejillaPanel(this);
        ;
        jScrollPane1 = new javax.swing.JScrollPane();
        puntuacion = new javax.swing.JTextArea();
        Inicio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Record = new javax.swing.JTextArea();
        StartStop = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        puntuacion.setColumns(20);
        puntuacion.setRows(5);
        jScrollPane1.setViewportView(puntuacion);

        Inicio.setText("Inicio");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });

        Record.setColumns(20);
        Record.setRows(5);
        jScrollPane2.setViewportView(Record);

        StartStop.setText("Stop");
        StartStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rejillaPanel1Layout = new javax.swing.GroupLayout(rejillaPanel1);
        rejillaPanel1.setLayout(rejillaPanel1Layout);
        rejillaPanel1Layout.setHorizontalGroup(
            rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rejillaPanel1Layout.createSequentialGroup()
                .addContainerGap(748, Short.MAX_VALUE)
                .addGroup(rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rejillaPanel1Layout.createSequentialGroup()
                        .addComponent(Inicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StartStop)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rejillaPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        rejillaPanel1Layout.setVerticalGroup(
            rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rejillaPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(rejillaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inicio)
                    .addComponent(StartStop))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuItem1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rejillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rejillaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        inicializaJuego();
        mueve.reanudar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem1MenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MenuKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void StartStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartStopActionPerformed
        if(start){
            mueve.suspender();
            start=false;
            StartStop.setText("Start");
        } else{
            mueve.reanudar();
            StartStop.setText("Stop");
            start=true;
        }
    }//GEN-LAST:event_StartStopActionPerformed

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        nuevaFigura();
        mueve.reanudar();
        setPuntuacion();
    }//GEN-LAST:event_InicioActionPerformed
    
    /**
* Obtiene una nueva figura cuyo tipo es seleccionado de forma aleatoria
*/
    public void nuevaFigura(){
        figura = Pacman.nuevaFigura();
    }
    /**
    * Deja VACIA todas las celdas de la Rejilla, la inicializa
    * de nuevo. Además genera una nueva Figura de tipo aleatorio
    */
    public void inicializaJuego(){
        rejilla.initRejilla();
        nuevaFigura();
    }
    
    /**
    * Obtiene una referencia al panel donde se dibujan las piezas del juego
    * @return una referencia al panel del juego
    */
    public RejillaPanel getPanel(){
        return rejillaPanel1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PacmanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacmanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacmanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacmanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacmanFrame().setVisible(true);
            }
        });
    }
    /**int puntos
* Obtiene una referencia a la Rejilla del juego
* @return una referencia a la Rejilla del juego
*/
public Rejilla getRejilla(){
    return rejilla;
}
/**
* Obtiene una referencia a la Figura que cae actualmente en el juego
* @return una referencia a la Figura actual
*/
public Pacman getFigura(){
    return figura;
}
/**
* Obtiene una referencia a la Figura que cae actualmente en el juego
* @return una referencia a la Figura actual
*/
public int getMove(){
    return rejillaPanel1.lastmove;
}

    /**
     * Método que imprime en el recuadro correspondiente la puntuación actual
     */
    public void setPuntuacion(){
        puntuacion.setText("Puntuación: "+rejilla.puntos);
    }
    
        /**
     * Consultamos el fichero donde está guardado el record actual, en caso de que no exista
     * se crea uno nuevo con la puntuación record actual.
     * 
     * @param puntuacion
     * @throws IOException 
     */
    
    public void setRecord(int puntuacion) throws IOException{
        puntuacion=rejilla.puntos;
        String sFichero = "record.txt";
        File fichero = new File(sFichero);
        
        if (fichero.exists()){
        
            BufferedReader rw=new BufferedReader(new FileReader(sFichero)); 
            String actuals=rw.readLine();
            if(actuals!=null){
            int actual=Integer.parseInt(actuals);
           
            if(actual<puntuacion){
                PrintWriter pw = new PrintWriter ( new FileWriter (sFichero));
               pw.println(puntuacion);
               pw.close();
                Record.setText("Record "+puntuacion);

            }
            else Record.setText("Record "+actual);
        }}
        else {
                PrintWriter pw = new PrintWriter ( new FileWriter (fichero));
               pw.println(puntuacion);
               pw.close();
               Record.setText("Record "+puntuacion);
        }
    }

/**
* Obtiene una nueva figura cuyo tipo es seleccionado de forma aleatoria
*/



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inicio;
    private javax.swing.JTextArea Record;
    private javax.swing.JButton StartStop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea puntuacion;
    private guipacman.RejillaPanel rejillaPanel1;
    // End of variables declaration//GEN-END:variables
}
