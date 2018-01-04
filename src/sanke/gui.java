/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import search.AbstractSolver;
import search.BestFirstSolver;
import search.BreadthFirstSolver;
import search.DepthFirstSolver;
import search.State;

/**
 *
 * @author SPL
 */
public class gui extends javax.swing.JFrame {

    /**
     * Creates new form gui
     */
    public gui() {
        
        initComponents();
        blocks = new ArrayList<>();
        JPanel bl;
        for ( int a = 0; a < 13*13; a++ ) {
            bl = new JPanel(false);
            bl.setBorder(new LineBorder(java.awt.Color.white));
            bl.setLocation(a%13*21, a/13*21);
            bl.setSize(21, 21);
            blocks.add(bl);
            jPanel1.add(bl);
        }
        palya = new ArrayList<>();
        for ( int a = 0; a < 13*13; a++ ) {
            palya.add(0);
        }
    }
    
    ArrayList<JPanel> blocks;
    
    game start;
    ArrayList<Integer> palya;
    
    class work extends SwingWorker<List<State>, String> {

        @Override
        protected List<State> doInBackground() throws Exception {
            // /*BreadthFirstSolver  p = new BreadthFirstSolver(); */
            BestFirstSolver p = new BestFirstSolver();
            
            return p.solve(gui.start); //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        gui gui;
        public void start(gui gui) {
            this.gui = gui;
        }

        public int exec() {
            execute();
            return 11;
        }
        
        public int e() {
            this.execute();
            return 0;
        }
        
        
        
        @Override
        protected void done() {
            try {
                if ( get() == null ) {
                    gui.jTextArea1.setText("Sikertelen ");
                }
               
                    gui.megoldott = get();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
            super.done(); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    work work;
    List<State> megoldott;
    
    int cel = 0;
    
    public void newGame() {
        
        int ossz = 0;
        cel = 0;//int cel = 0;
        int a = 0;
        
        for ( a = 0; a < 13*13; a++)
            palya.set(a, 0);
        
        a = 0;
        
        while ( ossz < 13 || cel == 0 ) {
            
                if ( Math.random() >  0.91 && ossz  < 13) {
                    palya.set(a, 1);
                    ossz++;
                }
                else {
                    
                    if ( Math.random() > 0.98 && cel == 0 ) {
                        palya.set(a,2);
                        cel = a;
                    }
                }
                
            
            a++;
            if ( a == (13*13) ) {
                a = 0;
            }
        }
        
        a = 0;
        ossz = 0;
        
        a = (int) (Math.random() * (palya.size()-5) );
        
        ArrayList<Integer> palya1 = new ArrayList<>(palya);
        
        while ( ossz < 3 ) {
            //palya1.add(0);
            if ( palya1.get(a) == 0 && a%13 < 9 && a%13 > 4 ) {
                ossz++;
            }
            else {
                ossz = 0;
            }
            if ( ossz == 3 ) {
                palya1.set(a-3, 4);
                palya1.add(a-2, 5);
                palya1.add(a-1, 6);
                palya1.add(a, 7);
            }
            a++;

        }
        
        start = new game(palya1, this);
        work = new work();
    }
    
    public void updatePalya() {
        for ( int a = 0; a < 13*13; a++ ) {
            blocks.get(a).setBackground(java.awt.Color.gray);
            
            if ( palya.get(a) == 1 ) {
                blocks.get(a).setBackground(java.awt.Color.red);
            }
            if ( palya.get(a) == 2 ) {
                blocks.get(a).setBackground(java.awt.Color.yellow);
            }
            
        }
    }
    
    
    public void updateSnake(game e) {

        blocks.get((e.Snake.mySnake.get(0).x+(e.Snake.mySnake.get(0).y*13))).setBackground(java.awt.Color.blue);
        for ( int a = 1; a < e.Snake.mySnake.size(); a++ ) {
            blocks.get(e.Snake.mySnake.get(a).x+e.Snake.mySnake.get(a).y*13).setBackground(java.awt.Color.CYAN);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newGame();
        updatePalya();  updateSnake(start); // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    int hanyadik = 1;
    
    game megoldas;
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        
        if ( megoldott != null && megoldott.size() > hanyadik ) {
            
            megoldas = (game)megoldott.get(hanyadik);
            ArrayList<game.snake.gameObject> prevSnake = ((game)megoldott.get(hanyadik-1)).Snake.mySnake;
            ArrayList<game.snake.gameObject> snake = megoldas.Snake.mySnake;
            for ( int a = 0; a < snake.size(); a++ ) {
                palya.set(prevSnake.get(a).x + prevSnake.get(a).y*13,0);
                palya.set(snake.get(a).x + snake.get(a).y*13,a+4);
            }
            updatePalya(); updateSnake(start); 
            hanyadik++;
        }
        else  {     
            work.start(this); work.exec();//work.runStates(start);// TODO add your handling code here:
            
            //work.run();
            //work.exe();
            //work.run( );//work.e();//work.exec();
        }
        if ( megoldott != null ) {
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
