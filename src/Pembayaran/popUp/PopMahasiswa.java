/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Pembayaran.popUp;

import Pembayaran.Kelas.Pembayaran;
import Pembayaran.Kelas.mahasiswa;
import Pembayaran.Kelas.pb_sementara;
import static Pembayaran.template.Main.pnKonten;
import Pembayaran.template.pnPembayaran;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Alxxstrdy
 */
public class PopMahasiswa extends javax.swing.JDialog {

    /**
     * Creates new form PopMahasiswa
     */
    public PopMahasiswa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadAngkatan();
        loadProdi();
        loadData();
        cAngkatan.setSelectedItem("- Pilih -");
        cProdi.setSelectedItem("- Pilih -");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMahasiswa = new javax.swing.JTable();
        cAngkatan = new javax.swing.JComboBox<>();
        cProdi = new javax.swing.JComboBox<>();
        tSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbMahasiswa.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
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

        cAngkatan.setFont(new java.awt.Font("DM Sans 18pt SemiBold", 0, 12)); // NOI18N
        cAngkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -" }));
        cAngkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAngkatanActionPerformed(evt);
            }
        });

        cProdi.setFont(new java.awt.Font("DM Sans 18pt SemiBold", 0, 12)); // NOI18N
        cProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -" }));
        cProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProdiActionPerformed(evt);
            }
        });

        tSearch.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        tSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        jLabel1.setText("Angkatan");

        jLabel2.setFont(new java.awt.Font("DM Sans 24pt Medium", 0, 12)); // NOI18N
        jLabel2.setText("Prodi");

        jPanel2.setBackground(new java.awt.Color(173, 217, 216));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(38, 222, 129));
        jButton1.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("DM Sans 18pt Medium", 0, 12)); // NOI18N
        jCheckBox1.setText("Select All");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cAngkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAngkatanActionPerformed
        if (cProdi.getSelectedItem().equals("- Pilih -") && cAngkatan.getSelectedItem().equals("- Pilih -")) {

        } else if (!cProdi.getSelectedItem().equals("- Pilih -") && cAngkatan.getSelectedItem().equals("- Pilih -")) {
            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            tampilProdi();

        } else if (cProdi.getSelectedItem().equals("- Pilih -") && !cAngkatan.getSelectedItem().equals("- Pilih -")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilSemester();
        } else if (!cProdi.getSelectedItem().equals("- Pilih -") && !cAngkatan.getSelectedItem().equals("- Pilih -")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());

            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilDua();
        }

        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_cAngkatanActionPerformed

    private void cProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProdiActionPerformed
        if (cProdi.getSelectedItem().equals("- Pilih -") && cAngkatan.getSelectedItem().equals("- Pilih -")) {

        } else if (!cProdi.getSelectedItem().equals("- Pilih -") && cAngkatan.getSelectedItem().equals("- Pilih -")) {
            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            tampilProdi();
        } else if (cProdi.getSelectedItem().equals("- Pilih -") && !cAngkatan.getSelectedItem().equals("- Pilih -")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilSemester();
        } else if (!cProdi.getSelectedItem().equals("- Pilih -") && !cAngkatan.getSelectedItem().equals("- Pilih -")) {
            int semester = Integer.parseInt(cAngkatan.getSelectedItem().toString());

            mahasiswa.setProdi(cProdi.getSelectedItem().toString());
            mahasiswa.setAngkatan(semester);
            tampilDua();
        }
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_cProdiActionPerformed

    private void tSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyReleased
        mahasiswa.setSearch(tSearch.getText());
        tampilSearch();
    }//GEN-LAST:event_tSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbMahasiswa.getModel();
        int rowCount = model.getRowCount();

        StringBuilder selectedData = new StringBuilder("Data yang dicentang:\n");
        boolean hasSelected = false; // Flag untuk memastikan ada data yang dipilih

        for (int i = 0; i < rowCount; i++) {
            boolean isSelected = (boolean) model.getValueAt(i, 0); // Kolom checkbox
            if (isSelected) {
                hasSelected = true;
                String nim = model.getValueAt(i, 1).toString();
                String nama = model.getValueAt(i, 2).toString();
                String jk = model.getValueAt(i, 3).toString();
                String prodi = model.getValueAt(i, 4).toString();
                int angkatan = (int) model.getValueAt(i, 5);

                try {
                    pb_sementara pn = new pb_sementara();
                    pn.setAngkatan(angkatan);
                    pn.setNama(nama);
                    pn.setNim(nim);
                    pn.setProdi(prodi);
                    pn.tambah();
                } catch (SQLException sQLException) {
                }

            }
        }
        dispose();
        pnKonten.removeAll();
        pnKonten.add(new pnPembayaran());
        pnKonten.repaint();
        pnKonten.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMahasiswaMouseClicked

    }//GEN-LAST:event_tbMahasiswaMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) tbMahasiswa.getModel();
            int rowCount = model.getRowCount(); // Jumlah baris dalam tabel

            for (int i = 0; i < rowCount; i++) {
                model.setValueAt(true, i, 0); // Centang checkbox pada kolom pertama
            }
        } else {
            DefaultTableModel model = (DefaultTableModel) tbMahasiswa.getModel();
            int rowCount = model.getRowCount(); // Jumlah baris dalam tabel

            for (int i = 0; i < rowCount; i++) {
                model.setValueAt(false, i, 0); // Centang checkbox pada kolom pertama
            }
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        UIManager.put("TableHeader.background", new Color(2, 131, 145));
        UIManager.put("TableHeader.foreground", Color.WHITE);
        UIManager.put("Table.selectionBackground", new Color(0, 153, 153));
        UIManager.put("Table.alternateRowColor", new Color(240, 240, 240));
        UIManager.put("Component.focusedBorderColor", new Color(0, 153, 153));

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopMahasiswa dialog = new PopMahasiswa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cAngkatan;
    private javax.swing.JComboBox<String> cProdi;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tbMahasiswa;
    // End of variables declaration//GEN-END:variables
void loadData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("SELECT");
        model.addColumn("NIM");
        model.addColumn("NAMA");
        model.addColumn("JK");
        model.addColumn("PRODI");
        model.addColumn("SEMESTER");
        jCheckBox1.setEnabled(false);
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
                    cAngkatan.addItem(String.valueOf(angkatan));

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
        jCheckBox1.setEnabled(true);
        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.tampilAngkatan();

            // Buat model tabel dengan checkbox
            DefaultTableModel model = new DefaultTableModel(new Object[]{"SELECT",
                "NIM",
                "NAMA",
                "JK",
                "PRODI",
                "SEMESTER"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class; // Kolom pertama adalah checkbox
                    }
                    return String.class; // Kolom lainnya adalah string
                }
            };

            // Ambil data dari JSON
            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);

            // Tambahkan data ke model tabel
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    model.addRow(new Object[]{
                        false, // Checkbox default tidak dicentang
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                }
            }

            // Set model ke tabel
            tbMahasiswa.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tampilProdi() {
        jCheckBox1.setEnabled(true);
        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.tampilJurusan();

            // Buat model tabel dengan checkbox
            DefaultTableModel model = new DefaultTableModel(new Object[]{"SELECT",
                "NIM",
                "NAMA",
                "JK",
                "PRODI",
                "SEMESTER"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class; // Kolom pertama adalah checkbox
                    }
                    return String.class; // Kolom lainnya adalah string
                }
            };

            // Ambil data dari JSON
            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);

            // Tambahkan data ke model tabel
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    model.addRow(new Object[]{
                        false, // Checkbox default tidak dicentang
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                }
            }

            // Set model ke tabel
            tbMahasiswa.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tampilDua() {
        jCheckBox1.setEnabled(true);
        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.tampilDua();

            // Buat model tabel dengan checkbox
            DefaultTableModel model = new DefaultTableModel(new Object[]{"SELECT",
                "NIM",
                "NAMA",
                "JK",
                "PRODI",
                "SEMESTER"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class; // Kolom pertama adalah checkbox
                    }
                    return String.class; // Kolom lainnya adalah string
                }
            };

            // Ambil data dari JSON
            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);

            // Tambahkan data ke model tabel
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    model.addRow(new Object[]{
                        false, // Checkbox default tidak dicentang
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                }
            }

            // Set model ke tabel
            tbMahasiswa.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tampilSearch() {
        try {
            mahasiswa mhs = new mahasiswa();
            JSONObject obj = mhs.search();

            // Buat model tabel dengan checkbox
            DefaultTableModel model = new DefaultTableModel(new Object[]{"SELECT",
                "NIM",
                "NAMA",
                "JK",
                "PRODI",
                "SEMESTER"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class; // Kolom pertama adalah checkbox
                    }
                    return String.class; // Kolom lainnya adalah string
                }
            };

            // Ambil data dari JSON
            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);

            // Tambahkan data ke model tabel
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    model.addRow(new Object[]{
                        false, // Checkbox default tidak dicentang
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getString("prodi"),
                        item.getInt("angkatan")
                    });
                }
            }

            // Set model ke tabel
            tbMahasiswa.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
