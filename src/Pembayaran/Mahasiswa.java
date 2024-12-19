/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pembayaran;

import Pembayaran.Kelas.Pembayaran;
import Pembayaran.Kelas.mahasiswa;
//import static UI.MenuMain.pnUtatma;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Nrl
 */
public class Mahasiswa extends javax.swing.JPanel {

    /**
     * Creates new form Mahasiswa
     */
    public Mahasiswa() {
        initComponents();
        
    }    
    void loadTabel() {

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.getMahasiswa();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIM");
            model.addColumn("NAMA");
            model.addColumn("JK");
            model.addColumn("PRODI");
            model.addColumn("SEMESTER");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);

                    model.addRow(new Object[]{
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                    tbMahasiswa.setModel(model);
                }
            }
        } catch (Exception e) {
        }
    }

    private void dataTabel() {

        int row = tbMahasiswa.getSelectedRow();

        Pembayaran.setNim(tbMahasiswa.getModel().getValueAt(row, 0).toString());
        mahasiswa.setNama(tbMahasiswa.getModel().getValueAt(row, 1).toString());
        mahasiswa.setProdi(tbMahasiswa.getModel().getValueAt(row, 3).toString());

    }

    void loadAngkatan() {

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.getAngkattan();

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    int angkatan = item.getInt("angkatan");
                    cAngkatan.addItem(String.valueOf(angkatan    ));

                }

            }
        } catch (Exception e) {
        }

    }

    void loadProdi() {

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.getJurusan();

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    String prodi = item.getString("prodi");
                    cProdi.addItem(prodi);

                }
            }
        } catch (Exception e) {
        }
    }

    void tampilSemester() {

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.tampilAngkatan();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIM");
            model.addColumn("NAMA");
            model.addColumn("JK");
            model.addColumn("PRODI");
            model.addColumn("SEMESTER");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);

                    model.addRow(new Object[]{
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                    tbMahasiswa.setModel(model);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void tampilProdi() {

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.tampilJurusan();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIM");
            model.addColumn("NAMA");
            model.addColumn("JK");
            model.addColumn("PRODI");
            model.addColumn("SEMESTER");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);

                    model.addRow(new Object[]{
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                    tbMahasiswa.setModel(model);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void tampilDua() {
        

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.tampilDua();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIM");
            model.addColumn("NAMA");
            model.addColumn("JK");
            model.addColumn("PRODI");
            model.addColumn("SEMESTER");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);

                    model.addRow(new Object[]{
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                    tbMahasiswa.setModel(model);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void tampilSearch() {

        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.search();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NIM");
            model.addColumn("NAMA");
            model.addColumn("JK");
            model.addColumn("PRODI");
            model.addColumn("SEMESTER");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);

                    model.addRow(new Object[]{
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                    tbMahasiswa.setModel(model);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbMahasiswa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cProdi = new javax.swing.JComboBox<>();
        cAngkatan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tbMahasiswa.setBackground(new java.awt.Color(250, 232, 255));
        tbMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMahasiswa);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tSearch.setText("Search...");
        tSearch.setBorder(null);
        tSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tSearchKeyTyped(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FOTO/search-interface-symbol.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua" }));
        cProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProdiActionPerformed(evt);
            }
        });

        cAngkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua" }));
        cAngkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAngkatanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DM Sans SemiBold", 0, 15)); // NOI18N
        jLabel2.setText("Prodi");

        jLabel3.setFont(new java.awt.Font("DM Sans SemiBold", 0, 15)); // NOI18N
        jLabel3.setText("Angkatan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMahasiswaMouseClicked
        dataTabel();
//        pnUtatma.removeAll();
//        pnUtatma.add(new pnTagihan());
//        pnUtatma.repaint();
//        pnUtatma.revalidate();
        
    }//GEN-LAST:event_tbMahasiswaMouseClicked

    private void cAngkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAngkatanActionPerformed
       if (cProdi.getSelectedItem().equals("Semua") && cAngkatan.getSelectedItem().equals("Semua")) {
            loadTabel();
        } else if (!cProdi.getSelectedItem().equals("Semua") && cAngkatan.getSelectedItem().equals("Semua")) {
            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            tampilProdi();
        } else if (cProdi.getSelectedItem().equals("Semua") && !cAngkatan.getSelectedItem().equals("Semua")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilSemester();
        } else if (!cProdi.getSelectedItem().equals("Semua") && !cAngkatan.getSelectedItem().equals("Semua")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());

            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilDua();
        }
    }//GEN-LAST:event_cAngkatanActionPerformed

    private void cProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProdiActionPerformed
        if (cProdi.getSelectedItem().equals("Semua") && cAngkatan.getSelectedItem().equals("Semua")) {
            loadTabel();
        } else if (!cProdi.getSelectedItem().equals("Semua") && cAngkatan.getSelectedItem().equals("Semua")) {
            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            tampilProdi();
        } else if (cProdi.getSelectedItem().equals("Semua") && !cAngkatan.getSelectedItem().equals("Semua")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilSemester();
        } else if (!cProdi.getSelectedItem().equals("Semua") && !cAngkatan.getSelectedItem().equals("Semua")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());

            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilDua();
        }
    }//GEN-LAST:event_cProdiActionPerformed

    private void tSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyTyped
        mahasiswa.setSearch(tSearch.getText());
        tampilSearch();
    }//GEN-LAST:event_tSearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cAngkatan;
    private javax.swing.JComboBox<String> cProdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tbMahasiswa;
    // End of variables declaration//GEN-END:variables
}
