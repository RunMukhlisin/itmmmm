/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Manajemen_Surat.Frame;

import static Manajemen_Surat.Frame.MenuUtama.lb_Username;
import Manajemen_Surat.Kelas.Kategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rizan
 */
public class MenuSampahKategori extends javax.swing.JPanel {

    /**
     * Creates new form MenuSampahKategori
     */
    public MenuSampahKategori() {
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
        tf_Kode = new javax.swing.JTextField();
        tf_Nama = new javax.swing.JTextField();
        bt_HapusPermanen = new javax.swing.JButton();
        bt_Restore = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SampahKategori = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Menu Sampah Kategori");

        jLabel2.setText("Nama Bagian");

        jLabel3.setText("Kode Bagian");

        bt_HapusPermanen.setText("Hapus Permanen");
        bt_HapusPermanen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HapusPermanenActionPerformed(evt);
            }
        });

        bt_Restore.setText("Restore");
        bt_Restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RestoreActionPerformed(evt);
            }
        });

        bt_Reset.setText("Reset");
        bt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetActionPerformed(evt);
            }
        });

        tb_SampahKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_SampahKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SampahKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SampahKategori);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_HapusPermanen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_Restore, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tf_Nama, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                    .addComponent(tf_Kode))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_Kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_HapusPermanen)
                    .addComponent(bt_Restore)
                    .addComponent(bt_Reset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_HapusPermanenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HapusPermanenActionPerformed
        try {

            if (tf_Kode.getText().isEmpty()) {
                TimeJOption.AutoCloseJOptionPane.showMessageDialog("Pilih data yang ingin dihapus!", null, JOptionPane.WARNING_MESSAGE, 1000);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, """
                                                              Yakin ingin menghapus data ini?
                                                               Anda tidak dapat membalikkan aksi ini""",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                Kategori kodeHapus = new Manajemen_Surat.Kelas.Kategori();
                kodeHapus.setUser_login(lb_Username.getText());
                kodeHapus.KodeSetUser();
                kodeHapus.setKode_kategori(tf_Kode.getText());
                kodeHapus.KodeHapusPermanen();
                reset();

            }
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_bt_HapusPermanenActionPerformed

    private void bt_RestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RestoreActionPerformed
        try {

            if (tf_Kode.getText().isEmpty()) {
                TimeJOption.AutoCloseJOptionPane.showMessageDialog("Pilih data yang ingin dikembalikan!", null, JOptionPane.WARNING_MESSAGE, 1000);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Ingin mengembalikan data ini?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                Kategori kodeHapus = new Manajemen_Surat.Kelas.Kategori();
                kodeHapus.setUser_login(MenuUtama.lb_Username.getText());
                kodeHapus.setKode_kategori(tf_Kode.getText());
                kodeHapus.KodeRestore();
                reset();
                tf_Kode.setEditable(false);
            }
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_bt_RestoreActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void tb_SampahKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SampahKategoriMouseClicked
        int baris = tb_SampahKategori.rowAtPoint(evt.getPoint());
        String kode = tb_SampahKategori.getValueAt(baris, 0).toString();
        String nama = tb_SampahKategori.getValueAt(baris, 1).toString();
        tf_Kode.setText(kode);
        tf_Nama.setText(nama);
        tf_Kode.setEditable(false);
    }//GEN-LAST:event_tb_SampahKategoriMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_HapusPermanen;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Restore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_SampahKategori;
    private javax.swing.JTextField tf_Kode;
    private javax.swing.JTextField tf_Nama;
    // End of variables declaration//GEN-END:variables

    public void loadTabel() {
        // Model tabel dengan sel yang tidak bisa diedit
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Semua sel tidak dapat diedit
            }
        };
        model.addColumn("Kode Kategori Surat");
        model.addColumn("Nama Kategori Surat");
        model.addColumn("User Login");

        try {
            Kategori k = new Kategori();
            ResultSet data = k.KodeTampilTabelSampah();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("kode_kategori"),
                    data.getString("nama_kategori"),
                    data.getString("user_login"),});
            }

            data.close();
        } catch (SQLException sQLException) {
        }

        tb_SampahKategori.setModel(model);
        tb_SampahKategori.getTableHeader().setReorderingAllowed(false); // Tidak bisa geser header
        tb_SampahKategori.getTableHeader().setResizingAllowed(false);   // Tidak bisa ubah ukuran kolom
    }

    void reset() {
        tf_Kode.setText(null);
        tf_Nama.setText(null);
        loadTabel();
    }

}
