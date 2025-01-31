/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pembayaran.template;
import Pembayaran.Kelas.Pembayaran;
import Pembayaran.Kelas.jenis_pembayaran;
import Pembayaran.Kelas.mahasiswa;
import Pembayaran.popUp.PopMahasiswaHistory;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Alxxstrdy
 */
public class History extends javax.swing.JPanel {

    /**
     * Creates new form pnHome
     */
    public History() {
        initComponents();
        loadData();
        
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
        tbHistory = new javax.swing.JTable();
        cJenis = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        bDetail = new javax.swing.JButton();

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

        tbHistory.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
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

        cJenis.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        cJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis -" }));
        cJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cJenisActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        jLabel1.setText("Pilih Jenis Pembayaran");

        bDetail.setBackground(new java.awt.Color(173, 217, 216));
        bDetail.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        bDetail.setText("Detail Pembayaran");
        bDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDetail))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bDetail)
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDetailActionPerformed
        boolean closable = true;
        PopMahasiswaHistory mhs = new PopMahasiswaHistory(null, closable);
        mhs.setVisible(true);
    }//GEN-LAST:event_bDetailActionPerformed

    private void cJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cJenisActionPerformed
        if (cJenis.getSelectedItem().equals("- Pilih Jenis -")) {
            loadData();
        }else if (!cJenis.getSelectedItem().equals("- Pilih Jenis -") & !cJenis.getSelectedItem().equals("- Pilih Jenis -")) {
            jenis_pembayaran.setNama_jenis(cJenis.getSelectedItem().toString());
            try {
                jenis_pembayaran jp = new jenis_pembayaran();
                ResultSet data = jp.Konversi();
                loadData2();
            } catch (SQLException sQLException) {
            }
        }
    }//GEN-LAST:event_cJenisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDetail;
    private javax.swing.JComboBox<String> cJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHistory;
    // End of variables declaration//GEN-END:variables
void loadData() {
    try {
        // Ambil data dari database
        Pembayaran pb = new Pembayaran();
        ResultSet data = pb.history();

        // Model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Nama Jenis");
        model.addColumn("Nominal Dibayar");
        model.addColumn("Status");

        // List untuk menyimpan data
        List<String[]> allData = new ArrayList<>();

        while (data.next()) {
            // Data dari database
            String id = data.getString("ID Pembayaran");
            String tanggal = data.getString("Tanggal");
            String nim = data.getString("NIM");
            String namaJenis = data.getString("Nama Jenis");
            int nominal = data.getInt("Nominal Dibayar");
            String status = data.getString("Status");

            // Ambil data tambahan dari API berdasarkan NIM
            mahasiswa.setNim(nim);
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.getBayar();

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);

            String nama = "Tidak Ditemukan"; // Default jika data tidak ada di API
            String prodi = "Tidak Ditemukan";

            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    if (item.getString("mhs_nim").equals(nim)) {
                        nama = item.getString("mhs_nama");
                        prodi = item.getString("prodi");
                        break; // Berhenti jika ditemukan
                    }
                }
            }

            // Tambahkan data ke list
            allData.add(new String[]{
                id, tanggal, nim, nama, namaJenis, String.valueOf(nominal), status
            });
        }

        // Masukkan data ke tabel
        for (String[] rowData : allData) {
            model.addRow(rowData);
        }

        // Set model ke tabel tbHistory
        tbHistory.setModel(model);
        jenis_pembayaran jp = new jenis_pembayaran();
            ResultSet dta = jp.tampilComBox();

            while (dta.next()) {
                String isi = dta.getString("nama_jenis");
                cJenis.addItem(isi);
            }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

void loadData2() {
    try {
        // Ambil data dari database
        Pembayaran pb = new Pembayaran();
        ResultSet data = pb.historyJenis();

        // Model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Nama Jenis");
        model.addColumn("Nominal Dibayar");
        model.addColumn("Status");

        // List untuk menyimpan data
        List<String[]> allData = new ArrayList<>();

        while (data.next()) {
            // Data dari database
            String id = data.getString("ID Pembayaran");
            String tanggal = data.getString("Tanggal");
            String nim = data.getString("NIM");
            String namaJenis = data.getString("Nama Jenis");
            int nominal = data.getInt("Nominal Dibayar");
            String status = data.getString("Status");

            // Ambil data tambahan dari API berdasarkan NIM
            mahasiswa.setNim(nim);
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.getBayar();

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);

            String nama = "Tidak Ditemukan"; // Default jika data tidak ada di API
            String prodi = "Tidak Ditemukan";

            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    if (item.getString("mhs_nim").equals(nim)) {
                        nama = item.getString("mhs_nama");
                        prodi = item.getString("prodi");
                        break; // Berhenti jika ditemukan
                    }
                }
            }

            // Tambahkan data ke list
            allData.add(new String[]{
                id, tanggal, nim, nama, namaJenis, String.valueOf(nominal), status
            });
        }

        // Masukkan data ke tabel
        for (String[] rowData : allData) {
            model.addRow(rowData);
        }

        // Set model ke tabel tbHistory
        tbHistory.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
