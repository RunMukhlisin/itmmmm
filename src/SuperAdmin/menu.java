package SuperAdmin;

import SuperAdmin.Login;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author SayMukhlisin
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form contohh
     */
    public menu() {
        initComponents();
        KPGBLU.setVisible(false);
        BUKUBLU.setVisible(false);
        PEMBABLU.setVisible(false);
        IVEBLU.setVisible(false);
        MANABLU.setVisible(false);
        PERPUSBLU.setVisible(false);
        LOGOUTBLU.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tTanggal = new javax.swing.JLabel();
        tJam = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        KPGBLU = new javax.swing.JLabel();
        KPGGRAY = new javax.swing.JLabel();
        BUKUBLU = new javax.swing.JLabel();
        BUKUGRAY = new javax.swing.JLabel();
        PEMBABLU = new javax.swing.JLabel();
        PEMBAGRAY1 = new javax.swing.JLabel();
        IVEBLU = new javax.swing.JLabel();
        IVEGRAY = new javax.swing.JLabel();
        MANABLU = new javax.swing.JLabel();
        MANAGRAY = new javax.swing.JLabel();
        PERPUSBLU = new javax.swing.JLabel();
        PERPUSGRAY = new javax.swing.JLabel();
        pnlogout = new javax.swing.JPanel();
        LOGOUT = new javax.swing.JLabel();
        LOGOUTBLU = new javax.swing.JLabel();
        LOGOUTGRAY = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/User New.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("DM Sans SemiBold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Admin");

        tTanggal.setBackground(new java.awt.Color(255, 255, 255));
        tTanggal.setFont(new java.awt.Font("DM Sans SemiBold", 0, 18)); // NOI18N
        tTanggal.setForeground(new java.awt.Color(255, 255, 255));
        tTanggal.setText("24 November 2024");

        tJam.setBackground(new java.awt.Color(255, 255, 255));
        tJam.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        tJam.setForeground(new java.awt.Color(255, 255, 255));
        tJam.setText("00.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 535, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tTanggal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tJam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel9))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tJam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTanggal)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 110, 30));

        KPGBLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KPGBLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/KEPEGAWAIAN BLU.png"))); // NOI18N
        KPGBLU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KPGBLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KPGBLUMouseExited(evt);
            }
        });
        jPanel1.add(KPGBLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 128, 99, -1));

        KPGGRAY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KPGGRAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/KEPEGAWAIAN GRAY.png"))); // NOI18N
        KPGGRAY.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        KPGGRAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KPGGRAYMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KPGGRAYMouseExited(evt);
            }
        });
        jPanel1.add(KPGGRAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 128, 99, -1));

        BUKUBLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BUKUBLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/BUKU INDUK BLUEpng.png"))); // NOI18N
        BUKUBLU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BUKUBLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BUKUBLUMouseExited(evt);
            }
        });
        jPanel1.add(BUKUBLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 128, 98, -1));

        BUKUGRAY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BUKUGRAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/BUKU INDUK GRAY.png"))); // NOI18N
        BUKUGRAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BUKUGRAYMouseEntered(evt);
            }
        });
        jPanel1.add(BUKUGRAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 128, 98, -1));

        PEMBABLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PEMBABLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/PEMBAYARAN BLUE.png"))); // NOI18N
        PEMBABLU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PEMBABLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PEMBABLUMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PEMBABLUMouseExited(evt);
            }
        });
        jPanel1.add(PEMBABLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 128, 98, -1));

        PEMBAGRAY1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PEMBAGRAY1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/PEMBAYARAN GRAYpng.png"))); // NOI18N
        PEMBAGRAY1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PEMBAGRAY1MouseEntered(evt);
            }
        });
        jPanel1.add(PEMBAGRAY1, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 128, 98, -1));

        IVEBLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IVEBLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/IVENTARISBLU.png"))); // NOI18N
        IVEBLU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IVEBLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IVEBLUMouseExited(evt);
            }
        });
        jPanel1.add(IVEBLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 364, 99, -1));

        IVEGRAY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IVEGRAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/IVENTARISGRAY.png"))); // NOI18N
        IVEGRAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IVEGRAYMouseEntered(evt);
            }
        });
        jPanel1.add(IVEGRAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 364, 99, -1));

        MANABLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MANABLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/MANAJEMEN BLU.png"))); // NOI18N
        MANABLU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MANABLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MANABLUMouseExited(evt);
            }
        });
        jPanel1.add(MANABLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 150, -1));

        MANAGRAY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MANAGRAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/MANAJEMEN GRAY.png"))); // NOI18N
        MANAGRAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MANAGRAYMouseEntered(evt);
            }
        });
        jPanel1.add(MANAGRAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 150, -1));

        PERPUSBLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PERPUSBLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/PERPUSTAKAAN BLU.png"))); // NOI18N
        PERPUSBLU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PERPUSBLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PERPUSBLUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PERPUSBLUMouseExited(evt);
            }
        });
        jPanel1.add(PERPUSBLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 364, 110, -1));

        PERPUSGRAY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PERPUSGRAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/PERPUSTAKAAN GRAY.png"))); // NOI18N
        PERPUSGRAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PERPUSGRAYMouseEntered(evt);
            }
        });
        jPanel1.add(PERPUSGRAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 364, 110, -1));

        pnlogout.setBackground(new java.awt.Color(255, 255, 255));
        pnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlogoutMouseExited(evt);
            }
        });
        pnlogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LOGOUT.setFont(new java.awt.Font("DM Sans", 1, 18)); // NOI18N
        LOGOUT.setText("Log Out");
        pnlogout.add(LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        LOGOUTBLU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOGOUTBLU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/LOGOUT BLU.png"))); // NOI18N
        LOGOUTBLU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGOUTBLUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LOGOUTBLUMousePressed(evt);
            }
        });
        pnlogout.add(LOGOUTBLU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LOGOUTGRAY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOGOUTGRAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/LOGOUT GRAY.png"))); // NOI18N
        LOGOUTGRAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGOUTGRAYMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGOUTGRAYMouseExited(evt);
            }
        });
        pnlogout.add(LOGOUTGRAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, -1, 30));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KPGBLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KPGBLUMouseExited
        // TODO add your handling code here:
        KPGBLU.setVisible(false);
    }//GEN-LAST:event_KPGBLUMouseExited

    private void KPGGRAYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KPGGRAYMouseEntered
                KPGBLU.setVisible(true);
    }//GEN-LAST:event_KPGGRAYMouseEntered

    private void KPGGRAYMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KPGGRAYMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_KPGGRAYMouseExited

    private void BUKUGRAYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUKUGRAYMouseEntered
        BUKUBLU.setVisible(true);
    }//GEN-LAST:event_BUKUGRAYMouseEntered

    private void BUKUBLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUKUBLUMouseExited
        BUKUBLU.setVisible(false);
    }//GEN-LAST:event_BUKUBLUMouseExited

    private void PEMBAGRAY1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEMBAGRAY1MouseEntered
        PEMBABLU.setVisible(true);
    }//GEN-LAST:event_PEMBAGRAY1MouseEntered

    private void PEMBABLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEMBABLUMouseExited
        PEMBABLU.setVisible(false);
    }//GEN-LAST:event_PEMBABLUMouseExited

    private void IVEGRAYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IVEGRAYMouseEntered
        IVEBLU.setVisible(true);
    }//GEN-LAST:event_IVEGRAYMouseEntered

    private void IVEBLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IVEBLUMouseExited
        IVEBLU.setVisible(false);
    }//GEN-LAST:event_IVEBLUMouseExited

    private void MANAGRAYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGRAYMouseEntered
        MANABLU.setVisible(true);
    }//GEN-LAST:event_MANAGRAYMouseEntered

    private void MANABLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANABLUMouseExited
        MANABLU.setVisible(false);
    }//GEN-LAST:event_MANABLUMouseExited

    private void PERPUSGRAYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PERPUSGRAYMouseEntered
        PERPUSBLU.setVisible(true);
    }//GEN-LAST:event_PERPUSGRAYMouseEntered

    private void PERPUSBLUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PERPUSBLUMouseEntered
        
    }//GEN-LAST:event_PERPUSBLUMouseEntered

    private void PERPUSBLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PERPUSBLUMouseExited
        PERPUSBLU.setVisible(false);
    }//GEN-LAST:event_PERPUSBLUMouseExited

    private void pnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlogoutMouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_pnlogoutMouseClicked

    private void PEMBABLUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEMBABLUMouseClicked

    }//GEN-LAST:event_PEMBABLUMouseClicked

    private void LOGOUTBLUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTBLUMousePressed

    }//GEN-LAST:event_LOGOUTBLUMousePressed

    private void LOGOUTGRAYMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTGRAYMouseExited
        // TODO add your handling cod;
    }//GEN-LAST:event_LOGOUTGRAYMouseExited

    private void LOGOUTGRAYMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTGRAYMouseEntered
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_LOGOUTGRAYMouseEntered

    private void LOGOUTBLUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTBLUMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LOGOUTBLUMouseExited

    private void pnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlogoutMouseEntered
        // TODO add your handling code here:
        LOGOUTBLU.setVisible(true);
    }//GEN-LAST:event_pnlogoutMouseEntered

    private void pnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlogoutMouseExited
        // TODO add your handling code here:
        LOGOUTBLU.setVisible(false);
    }//GEN-LAST:event_pnlogoutMouseExited

    /**
     * @param args the command line arguments
     */
        public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            UIManager.put("Button.arc", 10);
            UIManager.put("TextComponent.arc", 10);
            UIManager.put("TableHeader.background", new Color(0,51,153));
            UIManager.put("TableHeader.foreground", Color.WHITE);
            UIManager.put("Table.selectionBackground", new Color(102, 153, 255));
            UIManager.put("Table.alternateRowColor", new Color(240, 240, 240));
            UIManager.put("Component.focusedBorderColor", new Color(102, 153, 255));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BUKUBLU;
    private javax.swing.JLabel BUKUGRAY;
    private javax.swing.JLabel IVEBLU;
    private javax.swing.JLabel IVEGRAY;
    private javax.swing.JLabel KPGBLU;
    private javax.swing.JLabel KPGGRAY;
    private javax.swing.JLabel LOGOUT;
    private javax.swing.JLabel LOGOUTBLU;
    private javax.swing.JLabel LOGOUTGRAY;
    private javax.swing.JLabel MANABLU;
    private javax.swing.JLabel MANAGRAY;
    private javax.swing.JLabel PEMBABLU;
    private javax.swing.JLabel PEMBAGRAY1;
    private javax.swing.JLabel PERPUSBLU;
    private javax.swing.JLabel PERPUSGRAY;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlogout;
    private javax.swing.JLabel tJam;
    private javax.swing.JLabel tTanggal;
    // End of variables declaration//GEN-END:variables
}
