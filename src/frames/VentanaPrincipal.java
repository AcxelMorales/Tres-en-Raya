
package frames;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author acxel
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private boolean casilla [] [] = new boolean[3][3];
    private int matriz [] [] = new int[3][3];
    private String turno = "usuario1";
    private int empate = 0;
    private String usuario1, usuario2;
    private int vG1 = 0, vG2 = 0, vE = 0;
    
    public VentanaPrincipal(String u1, String u2) {
        this.usuario1 = u1;
        this.usuario2 = u2;
        initComponents();
        reglasIniciales();
        llenarCasillas();
        llenarMatriz();
    }
    
    private void reglasIniciales() {
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
    }
    
    private void llenarCasillas() {
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                casilla[i][j] = true;
            }
        }
    }
    
    private void llenarMatriz() {
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    
    private void comprobarGanador() {
        boolean ganador1 = false;
        boolean ganador2 = false;
        
        ganador1 = comprobar(1);
        ganador2 = comprobar(2);
        
        if (ganador1) {
            vG1++;
            VentanaGanador vg = new VentanaGanador(this, true, usuario1);
            vg.setVisible(true);
            reiniciarJuego();
        } else if (ganador2) {
            vG2++;
            VentanaGanador vg = new VentanaGanador(this, true, usuario2);
            vg.setVisible(true);
            reiniciarJuego();
        } else {
            for (byte i = 0; i < 3; i++) {
                for (byte j = 0; j < 3; j++) {
                    if (matriz[i][j] != 0) {
                        empate++;
                    }
                }
            }
            
            if (empate == 9) {
                vE++;
                VentanaEmpate ve = new VentanaEmpate(this, true);
                ve.setVisible(true);
                reiniciarJuego();
            } else {
                empate = 0;
            }
        }
    }
    
    private boolean comprobar(int num) {
        boolean ganador = false;
        
        if(matriz[0][0] == num && matriz[0][1] == num && matriz[0][2] == num) {
            ganador = true;
        } else if (matriz[1][0] == num && matriz[1][1] == num && matriz[1][2] == num) {
            ganador = true;
        } else if (matriz[2][0] == num && matriz[2][1] == num && matriz[2][2] == num) {
            ganador = true;
        } else if (matriz[0][0] == num && matriz[1][0] == num && matriz[2][0] == num) {
            ganador = true;
        } else if (matriz[0][1] == num && matriz[1][1] == num && matriz[2][1] == num) {
            ganador = true;
        } else if (matriz[0][2] == num && matriz[1][2] == num && matriz[2][2] == num) {
            ganador = true;
        } else if (matriz[0][0] == num && matriz[1][1] == num && matriz[2][2] == num) {
            ganador = true;
        } else if (matriz[0][2] == num && matriz[1][1] == num && matriz[2][0] == num){
            ganador = true;
        }
        return ganador;
    }
    
    private void reiniciarJuego() {
        llenarMatriz();
        llenarCasillas();
        
        btnArribaIzquierda.setIcon(null);
        btnArriba.setIcon(null);
        btnArribaDerecha.setIcon(null);
        btnCentroIzquierda.setIcon(null);
        btnCentro.setIcon(null);
        btnCentroDerecha.setIcon(null);
        btnAbajoIzquierda.setIcon(null);
        btnAbajo.setIcon(null);
        btnAbajoDerecha.setIcon(null);
        quienJuegaPrimero();
    }
    
    private void quienJuegaPrimero() {
        VentanaTurno vt = new VentanaTurno(this, true, usuario1, usuario2);
        vt.setVisible(true);
        turno = vt.getTurno();
    }
    
    private void dibujarX(JButton btn) {
        btn.setIcon(new ImageIcon(getClass().getResource("/files/equis.png")));
    }
    
    private void dibujarO(JButton btn) {
        btn.setIcon(new ImageIcon(getClass().getResource("/files/circulo.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btnArribaIzquierda = new javax.swing.JButton();
        btnArriba = new javax.swing.JButton();
        btnArribaDerecha = new javax.swing.JButton();
        btnCentroIzquierda = new javax.swing.JButton();
        btnCentro = new javax.swing.JButton();
        btnCentroDerecha = new javax.swing.JButton();
        btnAbajoIzquierda = new javax.swing.JButton();
        btnAbajo = new javax.swing.JButton();
        btnAbajoDerecha = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        itemJuego = new javax.swing.JMenu();
        subItemComenzarDeNuevo = new javax.swing.JMenuItem();
        subItemTabla = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        subItemSalir = new javax.swing.JMenuItem();
        itemAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new java.awt.GridLayout(3, 3));

        btnArribaIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArribaIzquierdaActionPerformed(evt);
            }
        });
        panel.add(btnArribaIzquierda);

        btnArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArribaActionPerformed(evt);
            }
        });
        panel.add(btnArriba);

        btnArribaDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArribaDerechaActionPerformed(evt);
            }
        });
        panel.add(btnArribaDerecha);

        btnCentroIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentroIzquierdaActionPerformed(evt);
            }
        });
        panel.add(btnCentroIzquierda);

        btnCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentroActionPerformed(evt);
            }
        });
        panel.add(btnCentro);

        btnCentroDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentroDerechaActionPerformed(evt);
            }
        });
        panel.add(btnCentroDerecha);

        btnAbajoIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbajoIzquierdaActionPerformed(evt);
            }
        });
        panel.add(btnAbajoIzquierda);

        btnAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbajoActionPerformed(evt);
            }
        });
        panel.add(btnAbajo);

        btnAbajoDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbajoDerechaActionPerformed(evt);
            }
        });
        panel.add(btnAbajoDerecha);

        itemJuego.setText("Juego");
        itemJuego.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N

        subItemComenzarDeNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        subItemComenzarDeNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        subItemComenzarDeNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/repetir.png"))); // NOI18N
        subItemComenzarDeNuevo.setText("Comenzar de nuevo");
        subItemComenzarDeNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subItemComenzarDeNuevoActionPerformed(evt);
            }
        });
        itemJuego.add(subItemComenzarDeNuevo);

        subItemTabla.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        subItemTabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        subItemTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/table.png"))); // NOI18N
        subItemTabla.setText("Mostrar tabla de resultados");
        subItemTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subItemTablaActionPerformed(evt);
            }
        });
        itemJuego.add(subItemTabla);
        itemJuego.add(separador);

        subItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        subItemSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        subItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/exit.png"))); // NOI18N
        subItemSalir.setText("Salir");
        subItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subItemSalirActionPerformed(evt);
            }
        });
        itemJuego.add(subItemSalir);

        menu.add(itemJuego);

        itemAyuda.setText("Ayuda");
        itemAyuda.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        itemAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemAyudaMouseClicked(evt);
            }
        });
        itemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAyudaActionPerformed(evt);
            }
        });
        menu.add(itemAyuda);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subItemComenzarDeNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subItemComenzarDeNuevoActionPerformed
        vG1 = 0; vG2 = 0; vE = 0;
        reiniciarJuego();
    }//GEN-LAST:event_subItemComenzarDeNuevoActionPerformed

    private void subItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_subItemSalirActionPerformed

    private void btnArribaIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArribaIzquierdaActionPerformed
        if (casilla[0][0]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnArribaIzquierda);
                matriz[0][0] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnArribaIzquierda);
                matriz[0][0] = 2;
                turno = "usuario1";
            }
            casilla[0][0] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnArribaIzquierdaActionPerformed

    private void btnArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArribaActionPerformed
        if (casilla[0][1]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnArriba);
                matriz[0][1] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnArriba);
                matriz[0][1] = 2;
                turno = "usuario1";
            }
            casilla[0][1] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnArribaActionPerformed

    private void btnArribaDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArribaDerechaActionPerformed
        if (casilla[0][2]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnArribaDerecha);
                matriz[0][2] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnArribaDerecha);
                matriz[0][2] = 2;
                turno = "usuario1";
            }
            casilla[0][2] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnArribaDerechaActionPerformed

    private void btnCentroIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentroIzquierdaActionPerformed
        if (casilla[1][0]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnCentroIzquierda);
                matriz[1][0] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnCentroIzquierda);
                matriz[1][0] = 2;
                turno = "usuario1";
            }
            casilla[1][0] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnCentroIzquierdaActionPerformed

    private void btnCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentroActionPerformed
        if (casilla[1][1]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnCentro);
                matriz[1][1] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnCentro);
                matriz[1][1] = 2;
                turno = "usuario1";
            }
            casilla[1][1] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnCentroActionPerformed

    private void btnCentroDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentroDerechaActionPerformed
        if (casilla[1][2]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnCentroDerecha);
                matriz[1][2] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnCentroDerecha);
                matriz[1][2] = 2;
                turno = "usuario1";
            }
            casilla[1][2] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnCentroDerechaActionPerformed

    private void btnAbajoIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbajoIzquierdaActionPerformed
        if (casilla[2][0]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnAbajoIzquierda);
                matriz[2][0] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnAbajoIzquierda);
                matriz[2][0] = 2;
                turno = "usuario1";
            }
            casilla[2][0] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnAbajoIzquierdaActionPerformed

    private void btnAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbajoActionPerformed
        if (casilla[2][1]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnAbajo);
                matriz[2][1] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnAbajo);
                matriz[2][1] = 2;
                turno = "usuario1";
            }
            casilla[2][1] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnAbajoActionPerformed

    private void btnAbajoDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbajoDerechaActionPerformed
        if (casilla[2][2]) {
            if (turno.equals("usuario1")) {
                dibujarX(btnAbajoDerecha);
                matriz[2][2] = 1;
                turno = "usuario2";
            } else {
                dibujarO(btnAbajoDerecha);
                matriz[2][2] = 2;
                turno = "usuario1";
            }
            casilla[2][2] = false;
            comprobarGanador();
        }
    }//GEN-LAST:event_btnAbajoDerechaActionPerformed

    private void subItemTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subItemTablaActionPerformed
        VentanaTabla vt = new VentanaTabla(this, true, usuario1, usuario2, vG1, vG2, vE);
        vt.setVisible(true);
    }//GEN-LAST:event_subItemTablaActionPerformed

    private void itemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAyudaActionPerformed
        
    }//GEN-LAST:event_itemAyudaActionPerformed

    private void itemAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemAyudaMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://www.guiainfantil.com/articulos/ocio/juegos/juego-de-tres-en-raya-como-jugar-con-los-ninos-con-papel-y-lapiz/"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemAyudaMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal(null, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbajo;
    private javax.swing.JButton btnAbajoDerecha;
    private javax.swing.JButton btnAbajoIzquierda;
    private javax.swing.JButton btnArriba;
    private javax.swing.JButton btnArribaDerecha;
    private javax.swing.JButton btnArribaIzquierda;
    private javax.swing.JButton btnCentro;
    private javax.swing.JButton btnCentroDerecha;
    private javax.swing.JButton btnCentroIzquierda;
    private javax.swing.JMenu itemAyuda;
    private javax.swing.JMenu itemJuego;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel panel;
    private javax.swing.JPopupMenu.Separator separador;
    private javax.swing.JMenuItem subItemComenzarDeNuevo;
    private javax.swing.JMenuItem subItemSalir;
    private javax.swing.JMenuItem subItemTabla;
    // End of variables declaration//GEN-END:variables
}
