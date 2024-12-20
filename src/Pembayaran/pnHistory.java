package Pembayaran;

import Pembayaran.Kelas.Pembayaran;
import Pembayaran.Kelas.jenis_pembayaran;
import Pembayaran.Kelas.mahasiswa;
//import static UI.MenuMain.pnUtatma;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


public class pnHistory extends javax.swing.JPanel {

   
    public pnHistory() {
        initComponents();
        getData2();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbHistory = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cJenis = new javax.swing.JComboBox<>();
        ttambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tbHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbHistory);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        jLabel1.setText(" HISTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(521, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(546, 546, 546))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("DM Sans SemiBold", 0, 18)); // NOI18N
        jLabel2.setText("History Pembayaran");

        cJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua" }));
        cJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cJenisActionPerformed(evt);
            }
        });

        ttambah.setText("Tambah Pembayaran");
        ttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttambahActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DM Sans", 0, 14)); // NOI18N
        jLabel3.setText("Jenis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ttambah))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttambahActionPerformed
        mahasiswa mhs = new mahasiswa();
        mhs.getMahasiswa();
        if (mahasiswa.getKoneksi().equals("true")) {
//            pnUtatma.removeAll();
//            pnUtatma.add(new PnMahasiswa());
//            pnUtatma.repaint();
//            pnUtatma.revalidate();
//        } else if (mahasiswa.getKoneksi().equals("false")) {
//            pnUtatma.removeAll();
//            pnUtatma.add(new pnNosignal());
//            pnUtatma.repaint();
//            pnUtatma.revalidate();
        }
    }//GEN-LAST:event_ttambahActionPerformed

    private void cJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cJenisActionPerformed
        if (cJenis.getSelectedItem().equals("Semua")) {
            getData2();
        }else if (!cJenis.getSelectedItem().equals("Semua") & !cJenis.getSelectedItem().equals("Pembayaran Lain")) {
            jenis_pembayaran.setNama_jenis(cJenis.getSelectedItem().toString());
            try {
                jenis_pembayaran jp = new jenis_pembayaran();
                ResultSet data = jp.Konversi();
                getData();
            } catch (SQLException sQLException) {
            }
        }else if (cJenis.getSelectedItem().equals("Pembayaran Lain")) {
                    getDataKhusus();
        }
    }//GEN-LAST:event_cJenisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHistory;
    private javax.swing.JButton ttambah;
    // End of variables declaration//GEN-END:variables
void getData2() {
    DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PEMBAYARAN");
        model.addColumn("NIM");
        model.addColumn("NAMA PEMBAYARAN");
        model.addColumn("NOMINAL DIBAYAR");
        model.addColumn("STATUS");
        try {
            Pembayaran pem = new Pembayaran();
            ResultSet data = pem.history();
            
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID Pembayaran"),
                    data.getString("NIM"),
                    data.getString("Nama Jenis"),
                    data.getInt("Nominal Dibayar"),
                    data.getString("Status"),
                });
        
                
            }
        } catch (SQLException sQLException) {
        }
        tbHistory.setModel(model);
        try {
        jenis_pembayaran jp = new jenis_pembayaran();
            ResultSet data = jp.tampilComBox();

            while (data.next()) {
                String isi = data.getString("nama_jenis");
                cJenis.addItem(isi);
            }
            cJenis.addItem("Pembayaran Lain");
    } catch (SQLException sQLException) {
    }
    }
void getData() {
    DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PEMBAYARAN");
        model.addColumn("NIM");
        model.addColumn("NAMA PEMBAYARAN");
        model.addColumn("NOMINAL DIBAYAR");
        model.addColumn("STATUS");

        try {
            Pembayaran pem = new Pembayaran();
            ResultSet data = pem.historyJenis();
            
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID Pembayaran"),
                    data.getString("NIM"),
                    data.getString("Nama Jenis"),
                    data.getInt("Nominal Dibayar"),
                    data.getString("Status"),
                });
        
                
            }
        } catch (SQLException sQLException) {
        }
        tbHistory.setModel(model);

    }
void getDataKhusus() {
     DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID PEMBAYARAN");
        model.addColumn("NIM");
        model.addColumn("NAMA PEMBAYARAN");
        model.addColumn("NOMINAL DIBAYAR");
        model.addColumn("STATUS");

        try {
            Pembayaran pem = new Pembayaran();
            ResultSet data = pem.historyJeniskhu();
            
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID Pembayaran"),
                    data.getString("NIM"),
                    data.getString("Nama Jenis"),
                    data.getInt("Nominal Dibayar"),
                    data.getString("Status"),
                });
        
                
            }
        } catch (SQLException sQLException) {
        }
        tbHistory.setModel(model);

    }
}
