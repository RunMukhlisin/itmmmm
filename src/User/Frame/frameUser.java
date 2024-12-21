/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User.Frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import  User.kelas.*;

public class frameUser extends javax.swing.JFrame {

    public frameUser() {
        initComponents();
        loadTabel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        tUsername = new javax.swing.JTextField();
        tPass = new javax.swing.JPasswordField();
        bTambah = new javax.swing.JButton();
        bBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cRole = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cRole1 = new javax.swing.JComboBox<>();
        cbBukuinduk = new javax.swing.JCheckBox();
        cbPembayaran = new javax.swing.JCheckBox();
        cbInventaris = new javax.swing.JCheckBox();
        cbSurat = new javax.swing.JCheckBox();
        cbKepegawaian = new javax.swing.JCheckBox();
        cbPerpus = new javax.swing.JCheckBox();
        bHapus = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("DM Sans ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAMBAH USER");

        jLabel2.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA");

        jLabel3.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USERNAME");

        jLabel4.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");

        tNama.setForeground(new java.awt.Color(0, 0, 102));
        tNama.setToolTipText("");

        tUsername.setForeground(new java.awt.Color(0, 0, 102));
        tUsername.setToolTipText("");
        tUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUsernameActionPerformed(evt);
            }
        });

        tPass.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        tPass.setForeground(new java.awt.Color(0, 0, 102));
        tPass.setToolTipText("");

        bTambah.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bTambah.setForeground(new java.awt.Color(0, 0, 102));
        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bBack.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bBack.setForeground(new java.awt.Color(0, 0, 102));
        bBack.setText("Back");
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ROLE");

        cRole.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cRole.setForeground(new java.awt.Color(0, 0, 102));
        cRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin" }));
        cRole.setToolTipText("");

        tbUser.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        tbUser.setForeground(new java.awt.Color(0, 0, 102));
        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUser);

        jLabel6.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("STATUS");

        cRole1.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cRole1.setForeground(new java.awt.Color(0, 0, 102));
        cRole1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));
        cRole1.setToolTipText("");

        cbBukuinduk.setBackground(new java.awt.Color(0, 0, 102));
        cbBukuinduk.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cbBukuinduk.setForeground(new java.awt.Color(255, 255, 255));
        cbBukuinduk.setText("Buku Induk");

        cbPembayaran.setBackground(new java.awt.Color(0, 0, 102));
        cbPembayaran.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cbPembayaran.setForeground(new java.awt.Color(255, 255, 255));
        cbPembayaran.setText("Pembayaran");

        cbInventaris.setBackground(new java.awt.Color(0, 0, 102));
        cbInventaris.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cbInventaris.setForeground(new java.awt.Color(255, 255, 255));
        cbInventaris.setText("Inventaris");

        cbSurat.setBackground(new java.awt.Color(0, 0, 102));
        cbSurat.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cbSurat.setForeground(new java.awt.Color(255, 255, 255));
        cbSurat.setText("Managemen Surat");

        cbKepegawaian.setBackground(new java.awt.Color(0, 0, 102));
        cbKepegawaian.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cbKepegawaian.setForeground(new java.awt.Color(255, 255, 255));
        cbKepegawaian.setText("Kepegawaian");

        cbPerpus.setBackground(new java.awt.Color(0, 0, 102));
        cbPerpus.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        cbPerpus.setForeground(new java.awt.Color(255, 255, 255));
        cbPerpus.setText("Perpustakaan");

        bHapus.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bHapus.setForeground(new java.awt.Color(0, 0, 102));
        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bUbah.setFont(new java.awt.Font("DM Sans SemiBold", 0, 12)); // NOI18N
        bUbah.setForeground(new java.awt.Color(0, 0, 102));
        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbKepegawaian)
                            .addComponent(cbBukuinduk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbPembayaran)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bHapus)
                                    .addComponent(cbPerpus))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bUbah)
                        .addGap(53, 53, 53)
                        .addComponent(bBack)
                        .addGap(525, 525, 525))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbInventaris, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSurat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(tNama)
                                .addComponent(tPass)
                                .addComponent(cRole, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cRole1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBukuinduk)
                            .addComponent(cbPembayaran)
                            .addComponent(cbInventaris))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbKepegawaian)
                            .addComponent(cbPerpus)
                            .addComponent(cbSurat)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bBack)
                    .addComponent(bUbah)
                    .addComponent(bHapus))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        try {
            user user = new user();
            userPrivilege up = new userPrivilege();
            user.setUserName(tUsername.getText());
            user.setPassword(tPass.getText());
            user.setNama(tNama.getText());
            if (cRole.getSelectedItem().equals("Admin")) {
                user.setRole(1);
            } else {
                user.setRole(0);
            }
            if (cRole1.getSelectedItem().equals("Aktif")) {
                user.setStatus(1);
            } else {
                user.setStatus(0);
            }

            if (cbBukuinduk.isSelected()) {
                up.setIdPrivilege(1);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbPembayaran.isSelected()) {
                up.setIdPrivilege(2);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbInventaris.isSelected()) {
                up.setIdPrivilege(3);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbSurat.isSelected()) {
                up.setIdPrivilege(4);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbKepegawaian.isSelected()) {
                up.setIdPrivilege(5);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbPerpus.isSelected()) {
                up.setIdPrivilege(6);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            user.tambahUser();
            loadTabel();
            reset();
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void tUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tUsernameActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        try {
            user user = new user();
            user.setUserName(tUsername.getText());
            user.hapusUser();
            loadTabel();
            reset();
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        try {
            user usr = new user();
            userPrivilege up = new userPrivilege();
            usr.setUserName(tUsername.getText());
            usr.setNama(tNama.getText());
            usr.setPassword(tPass.getText());
            if (cRole.getSelectedItem().equals("Admin")) {
                usr.setRole(1);
            } else {
                usr.setRole(0);
            }
            if (cRole1.getSelectedItem().equals("Aktif")) {
                usr.setStatus(1);
            } else {
                usr.setStatus(0);
            }
            usr.ubahUser();
            if (cbBukuinduk.isSelected()) {
                up.setIdPrivilege(1);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbPembayaran.isSelected()) {
                up.setIdPrivilege(2);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbInventaris.isSelected()) {
                up.setIdPrivilege(3);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbSurat.isSelected()) {
                up.setIdPrivilege(4);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbKepegawaian.isSelected()) {
                up.setIdPrivilege(5);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
            if (cbPerpus.isSelected()) {
                up.setIdPrivilege(6);
                up.setUsername(tUsername.getText());
                up.tambahUserPrivilege();
            }
        } catch (SQLException sQLException) {
        }
        loadTabel();
        reset();
    }//GEN-LAST:event_bUbahActionPerformed

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
        int baris = tbUser.rowAtPoint(evt.getPoint());
        String name = tbUser.getValueAt(baris, 0).toString();
        String username = tbUser.getValueAt(baris, 1).toString();
        String role = tbUser.getValueAt(baris, 2).toString();
        String status = tbUser.getValueAt(baris, 3).toString();

        tUsername.setText(username);
        tUsername.setEditable(false);
        tNama.setText(name);
        cRole.setSelectedItem(role);
        cRole1.setSelectedItem(status);
    }//GEN-LAST:event_tbUserMouseClicked

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        dispose();
    }//GEN-LAST:event_bBackActionPerformed

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
            java.util.logging.Logger.getLogger(frameUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack;
    public javax.swing.JButton bHapus;
    public javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private javax.swing.JComboBox<String> cRole;
    private javax.swing.JComboBox<String> cRole1;
    private javax.swing.JCheckBox cbBukuinduk;
    private javax.swing.JCheckBox cbInventaris;
    private javax.swing.JCheckBox cbKepegawaian;
    private javax.swing.JCheckBox cbPembayaran;
    private javax.swing.JCheckBox cbPerpus;
    private javax.swing.JCheckBox cbSurat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tNama;
    private javax.swing.JPasswordField tPass;
    private javax.swing.JTextField tUsername;
    private javax.swing.JTable tbUser;
    // End of variables declaration//GEN-END:variables
    void loadTabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Username");
        model.addColumn("Role");
        model.addColumn("Status");

        try {
            user us = new user();
            ResultSet data = us.tampilUser();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("nama"),
                    data.getString("username"),
                    data.getInt("role") == 1 ? "Admin" : "Superadmin",
                    data.getInt("status") == 1 ? "Aktif" : "Tidak Aktif"
                });
            }
        } catch (SQLException sQLException) {
        }
        tbUser.setModel(model);
    }

    void reset() {
        tUsername.setText(null);
        tUsername.setEditable(true);
        tPass.setText(null);
        tNama.setText(null);
        cRole.setSelectedItem(null);
        cRole1.setSelectedItem(null);
        cbBukuinduk.setSelected(false);
        cbPembayaran.setSelected(false);
        cbInventaris.setSelected(false);
        cbSurat.setSelected(false);
        cbKepegawaian.setSelected(false);
        cbPerpus.setSelected(false);

    }

}
