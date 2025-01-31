/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pembayaran.template;

import Pembayaran.Kelas.jenis_pembayaran;
import Pembayaran.popUp.TambahJenis;
import Pembayaran.popUp.UpdateJenis;
import static Pembayaran.template.Main.pnKonten;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alxxstrdy
 */
public class pnJenisPembayaran extends javax.swing.JPanel {

    /**
     * Creates new form pnHome
     */
    public pnJenisPembayaran() {
        initComponents();
        getData();
        bHapus.setVisible(false);        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbJenis = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(173, 217, 216));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        tbJenis.setModel(new javax.swing.table.DefaultTableModel(
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
        tbJenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbJenisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbJenis);

        bTambah.setBackground(new java.awt.Color(38, 222, 129));
        bTambah.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bHapus.setBackground(new java.awt.Color(252, 92, 101));
        bHapus.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        bHapus.setForeground(new java.awt.Color(255, 255, 255));
        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tbJenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbJenisMouseClicked
        bHapus.setVisible(true);
        bTambah.setText("Update");
    }//GEN-LAST:event_tbJenisMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int row = tbJenis.getSelectedRow();
        String id = tbJenis.getModel().getValueAt(row, 0).toString();
        jenis_pembayaran.setId_jenis(id);
        try {
            jenis_pembayaran jp = new jenis_pembayaran();
            jp.hapusJenis();
        } catch (SQLException sQLException) {
        }
        pnKonten.removeAll();
        pnKonten.add(new pnJenisPembayaran());
        pnKonten.repaint();
        pnKonten.revalidate();
    }//GEN-LAST:event_bHapusActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        if (bTambah.getText().equals("Tambah")) {
            boolean closable = true;
            TambahJenis mhs = new TambahJenis(null, closable);
            mhs.setVisible(true);
        } else if (bTambah.getText().equals("Update")) {
            int row = tbJenis.getSelectedRow();
            jenis_pembayaran.setId_jenis(tbJenis.getModel().getValueAt(row, 0).toString());
            jenis_pembayaran.setNama_jenis(tbJenis.getModel().getValueAt(row, 1).toString());
            jenis_pembayaran.setNominal(Integer.parseInt(tbJenis.getModel().getValueAt(row, 2).toString().replace(",", "")));
            boolean closable = true;
            UpdateJenis mhs = new UpdateJenis(null, closable);
            mhs.setVisible(true);
        }
    }//GEN-LAST:event_bTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbJenis;
    // End of variables declaration//GEN-END:variables
void getData() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA JENIS PEMBAYARAN");
        model.addColumn("NOMINAL");

        try {
            jenis_pembayaran pem = new jenis_pembayaran();
            ResultSet data = pem.tampilJenis();

            while (data.next()) {
                String nominal = String.valueOf(data.getInt("nominal")).replaceAll("[^\\d]", "");
                double nom = Double.parseDouble(nominal);
                DecimalFormat df = new DecimalFormat("#,###,###");
                String nominall = df.format(nom);
                model.addRow(new Object[]{
                    data.getString("id_jenis"),
                    data.getString("nama_jenis"),
                    nominall
                });

            }
        } catch (SQLException sQLException) {
        }
        tbJenis.setModel(model);
        tbJenis.getColumnModel().removeColumn(tbJenis.getColumnModel().getColumn(0)); // Kolom ID
    }

}
