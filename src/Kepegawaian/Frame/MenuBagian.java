package Kepegawaian.Frame;

import Kepegawaian.PopUp.PopUpBagian;
import Kepegawaian.PopUp.PopUpKategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lutfi
 */

public class MenuBagian extends javax.swing.JPanel {

    public MenuBagian() {
        initComponents();
        loadTable();
    }
    
    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");

        try {
            Kepegawaian.Kelas.Bagian bg = new Kepegawaian.Kelas.Bagian();
            ResultSet data = bg.tampilBagian();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_bagian"),
                    data.getString("nama_bagian"),});

            }

        } catch (SQLException sQLException) {

        }

        tblBagian.setModel(model);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBagian = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Bagian");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tblBagian.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBagian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBagianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBagian);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnTambah)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        Kepegawaian.PopUp.PopUpBagian bagian = new PopUpBagian();
        bagian.setVisible(true);

        bagian.btnUbah.setVisible(false);
        bagian.btnHapus.setVisible(false);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tblBagianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBagianMouseClicked
        try {
        int baris = tblBagian.rowAtPoint(evt.getPoint());
        if (baris >= 0) { // Pastikan baris valid
            String ID = tblBagian.getValueAt(baris, 0) != null ? tblBagian.getValueAt(baris, 0).toString() : "";
            String Nama = tblBagian.getValueAt(baris, 1) != null ? tblBagian.getValueAt(baris, 1).toString() : "";
           

            // Membuka FrameBarang dan mengirimkan data
            PopUpBagian bg = new PopUpBagian();
            bg.setData(ID, Nama);
            bg.setVisible(true);
            
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
    } finally {
       // isTableSelection = false; // Selesai seleksi dari tabel
    }
    }//GEN-LAST:event_tblBagianMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBagian;
    // End of variables declaration//GEN-END:variables
}
