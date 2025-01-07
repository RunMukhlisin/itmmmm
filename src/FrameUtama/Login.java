
package FrameUtama;

import User.kelas.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        tClose = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        backg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/abbb.png"))); // NOI18N
        getContentPane().add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 230, 100));

        bLogin.setBackground(new java.awt.Color(28, 122, 161));
        bLogin.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        bLogin.setForeground(new java.awt.Color(255, 255, 255));
        bLogin.setText("Login");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        getContentPane().add(bLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 180, -1));

        tClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tClose.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tClose.setText("x");
        tClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tCloseMouseClicked(evt);
            }
        });
        getContentPane().add(tClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tUsername.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tUsername.setForeground(new java.awt.Color(28, 122, 161));
        tUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tUsername.setBorder(null);
        tUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUsernameActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/user (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tUsername)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 180, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tPass.setForeground(new java.awt.Color(28, 122, 161));
        tPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tPass.setBorder(null);
        tPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPassActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/padlock (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 180, -1));

        backg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/Login bcg.jpg"))); // NOI18N
        getContentPane().add(backg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 280));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tUsernameActionPerformed

    private void tPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPassActionPerformed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
              
        if (tUsername.getText().isEmpty() && tPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " USERNAME DAN PASSWORD TIDAK BOLEH KOSONG");
        } else if (tUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " USERNAME TIDAK BOLEH KOSONG");
        } else if (tPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " PASSWORD TIDAK BOLEH KOSONG");
        } else {
            try {
                user usr = new user();
                usr.setUserName(tUsername.getText());
                usr.setPassword(tPass.getText());
                usr.Login();
            if (sesi.getStatus().equals("Aktif")) {
                    new menu(sesi.getUsername()).setVisible(true);
                    dispose();
                    
            }
            } catch (SQLException sQLException) {
            }
        }
    }//GEN-LAST:event_bLoginActionPerformed

    private void tCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCloseMouseClicked
        dispose();
    }//GEN-LAST:event_tCloseMouseClicked

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
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            UIManager.put("Button.arc", 10);
            UIManager.put("TextComponent.arc", 10);
            UIManager.put("TableHeader.background", new Color(2,154,170));
            UIManager.put("TableHeader.foreground", Color.WHITE);
            UIManager.put("Table.selectionBackground", new Color(2,131,145));
            UIManager.put("Table.alternateRowColor", new Color(240, 240, 240));
            UIManager.put("Component.focusedBorderColor", new Color(2,154,170));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JLabel backg;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel tClose;
    private javax.swing.JPasswordField tPass;
    private javax.swing.JTextField tUsername;
    // End of variables declaration//GEN-END:variables
}
