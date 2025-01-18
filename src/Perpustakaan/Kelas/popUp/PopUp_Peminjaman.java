/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Perpustakaan.Kelas.popUp;

import com.sun.jdi.connect.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import kelas.Peminjaman;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import kelas.Anggota;
import kelas.Item;
import kelas.koneksi;
import menu.menuAnggota;
import static menu.menuAnggota.tAnggotaMahasiswa;
import menu.menuPeminjaman;
import static menu.menuUtama.pnUtama;
import static popUp.PopUp_Peminjaman.id_peminjaman;
import static popUp.PopUp_Peminjaman.tPinjam;
import static popUp.PopUp_Peminjaman.tKembali;
import static popUp.PopUp_Peminjaman.tJumlahPinjam;
import static popUp.PopUp_Peminjaman.tStatus;
import static popUp.PopUp_Peminjaman.NamaPeminjam;
import static popUp.PopUp_Peminjaman.Kode;
import static popUp.PopUp_Peminjaman.nomorinduk;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author WINDOWS 10s
 */
public class PopUp_Peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form PopUp_Peminjaman
     */
    public PopUp_Peminjaman() throws SQLException {
        initComponents();
        loadTabelPeminjaman();
        AutoCompleteDecorator.decorate(tJudul);
        comboBox();
        autoId();
        reset();
    }

    void comboBox() {
        try {
            Item item = new Item();
            ResultSet data = item.Item();
            while (data.next()) {
                tJudul.addItem(data.getString("nama_barang"));
            }
        } catch (SQLException sQLException) {
        }
    }

    void loadTabelPeminjaman() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id_Anggota");
        model.addColumn("nama");
        model.addColumn("alamat");
        model.addColumn("nohp");
        model.addColumn("nim");
        model.addColumn("nidm");
        model.addColumn("nik");

        try {
            Anggota pj = new Anggota();
            ResultSet data = pj.tampilAnggota();
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getInt("id_anggota"),
                    data.getString("nama"),
                    data.getString("alamat"),
                    data.getString("nohp"),
                    data.getString("nim"),
                    data.getString("nidm"),
                    data.getString("nik"),});
            }
            TabelPeminjaman.setModel(model);
        } catch (SQLException sQLException) {
            Logger.getLogger(menuAnggota.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }

    void reset() {

        tPinjam.setDate(null);
        tKembali.setDate(null);
        nomorinduk.setText(null);
        NamaPeminjam.setText(null);
        Kode.setText(null);
        tJudul.setSelectedItem("PILIH");
        tJumlahPinjam.setText(null);
        tStatus.setSelectedItem(null);

    }

    private void autoId() throws SQLException {
        Peminjaman auto = new Peminjaman();
        int newid = auto.autoId();
        id_peminjaman.setText(String.valueOf(newid));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bUbah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Kode = new javax.swing.JTextField();
        hagsg = new javax.swing.JLabel();
        shhs = new javax.swing.JLabel();
        tJumlahPinjam = new javax.swing.JTextField();
        jagfkh = new javax.swing.JLabel();
        khkh = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bHapus = new javax.swing.JButton();
        nomorinduk = new javax.swing.JTextField();
        id_peminjaman = new javax.swing.JLabel();
        tStatus = new javax.swing.JComboBox<>();
        tPinjam = new com.toedter.calendar.JDateChooser();
        tKembali = new com.toedter.calendar.JDateChooser();
        pencarian = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPeminjaman = new javax.swing.JTable();
        NamaPeminjam = new javax.swing.JTextField();
        Almat = new javax.swing.JTextField();
        nomorhp = new javax.swing.JTextField();
        tcari = new javax.swing.JTextField();
        tJudul = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        bUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/refresh.png"))); // NOI18N
        bUbah.setText("UBAH");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/diskette.png"))); // NOI18N
        bSimpan.setText("SIMPAN");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tgl Pinjam");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/back.png"))); // NOI18N
        jButton3.setText("KEMBALI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tgl Kembali");

        Kode.setBackground(new java.awt.Color(102, 204, 255));
        Kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeActionPerformed(evt);
            }
        });

        hagsg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hagsg.setText("NIM/ NIDN/ NIK");

        shhs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        shhs.setText("Nama Peminjam");

        tJumlahPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJumlahPinjamActionPerformed(evt);
            }
        });

        jagfkh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jagfkh.setText("Nomor HP");

        khkh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        khkh.setText("Alamat");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Judul");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Jumlah Pinjam");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Status");

        bHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/bin.png"))); // NOI18N
        bHapus.setText("HAPUS");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        nomorinduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorindukActionPerformed(evt);
            }
        });

        id_peminjaman.setBackground(new java.awt.Color(102, 204, 255));
        id_peminjaman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id_peminjaman.setForeground(new java.awt.Color(102, 204, 255));
        id_peminjaman.setText("PEMINJAMAN");

        tStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sudah Kembali", "Belum Kembali" }));
        tStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tStatusActionPerformed(evt);
            }
        });

        tKembali.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tKembaliAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pencarian.setText("SEARCH");
        pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianActionPerformed(evt);
            }
        });

        TabelPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPeminjaman);

        NamaPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPeminjamActionPerformed(evt);
            }
        });

        Almat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlmatActionPerformed(evt);
            }
        });

        nomorhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorhpActionPerformed(evt);
            }
        });

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        tJudul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        tJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJudulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_peminjaman)
                        .addGap(314, 314, 314)
                        .addComponent(Kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(hagsg)
                                    .addComponent(shhs)
                                    .addComponent(jagfkh)
                                    .addComponent(khkh)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tPinjam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                        .addComponent(tKembali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tJumlahPinjam, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomorinduk, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NamaPeminjam)
                                        .addComponent(Almat)
                                        .addComponent(nomorhp)
                                        .addComponent(tJudul, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton3)
                                        .addComponent(tStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bUbah)
                                .addGap(18, 18, 18)
                                .addComponent(bHapus)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pencarian))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kode, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(id_peminjaman))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hagsg)
                                    .addComponent(nomorinduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shhs)
                            .addComponent(NamaPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jagfkh))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(nomorhp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(khkh)
                            .addComponent(Almat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tJumlahPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pencarian)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan)
                    .addComponent(bUbah)
                    .addComponent(jButton3)
                    .addComponent(bHapus))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        try {
            Peminjaman cty = new Peminjaman();
            cty.setIdPeminjam(Integer.parseInt(id_peminjaman.getText()));
            cty.hapusPeminjaman();
        } catch (SQLException sQLException) {
        }

    }//GEN-LAST:event_bHapusActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        if (!tJudul.getSelectedItem().equals("PILIH")) {
            try {
                Item item = new Item();
                item.setNamaBarang(tJudul.getSelectedItem().toString());
                ResultSet data = item.ubahID();
                if (data.next()) {
                    Kode.setText(data.getString("id_item"));
                }
            } catch (SQLException sQLException) {
            }

        }

        try {
            // Validasi inputan form sebelum disimpan
            if (nomorinduk.getText().isEmpty() || NamaPeminjam.getText().isEmpty()
                    || Kode.getText().isEmpty() || tJudul.getSelectedItem().equals(null)
                    || tJumlahPinjam.getText().isEmpty() || tStatus.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new Peminjaman object
            Peminjaman peminjaman = new Peminjaman();

            // Set the properties from the input fields
             

            // Mengonversi java.util.Date ke java.sql.Date
            java.sql.Date tanggalPinjamSQL = new java.sql.Date(tPinjam.getDate().getTime());
            java.sql.Date tanggalKembaliSQL = new java.sql.Date(tKembali.getDate().getTime());

            peminjaman.setTanggalPinjam(tanggalPinjamSQL);
            peminjaman.setTanggalKembali(tanggalKembaliSQL);

            peminjaman.setNamaPeminjam(NamaPeminjam.getText());
            peminjaman.setJudul(tJudul.getSelectedItem().toString());
            peminjaman.setJumlahPinjam(Integer.parseInt(tJumlahPinjam.getText()));
            peminjaman.setStatus(tStatus.getSelectedItem().toString());
            peminjaman.setNimNidn(nomorinduk.getText());
            peminjaman.setKodeBarang(Kode.getText());
            peminjaman.setNamaBarang(tJudul.getSelectedItem().toString());

            // Validasi tanggal pinjam dan tanggal kembali
            if (tanggalKembaliSQL.before(tanggalPinjamSQL)) {
                JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh sebelum tanggal pinjam!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save the data to the database
            peminjaman.tambahPeminjaman();

            // Show success message
            JOptionPane.showMessageDialog(this, "Data peminjaman berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Reset the form
            reset();
            loadTabelPeminjaman(); // Refresh the table to show the new entry

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid! Pastikan semua data terisi dengan benar.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        pnUtama.removeAll();
        pnUtama.add(new menuPeminjaman());
        pnUtama.repaint();
        pnUtama.revalidate();
    }//GEN-LAST:event_bSimpanActionPerformed

    private void tStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tStatusActionPerformed
        // TODO add your handling code here:
        Object selectedItem = tStatus.getSelectedItem();
        if (selectedItem != null) {
            String value = selectedItem.toString();
            // Lakukan sesuatu
        } else {
            System.out.println("Tidak ada item yang dipilih!");
        }

    }//GEN-LAST:event_tStatusActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        try {
            // Validasi inputan form sebelum disimpan
            if (id_peminjaman.getText().isEmpty() || nomorinduk.getText().isEmpty() || NamaPeminjam.getText().isEmpty()
                    || Kode.getText().isEmpty() || tJudul.getSelectedItem().equals("Pilih")
                    || tJumlahPinjam.getText().isEmpty() || tStatus.getSelectedItem() == null || tPinjam.getDate() == null || tKembali.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Semua data harus diisi dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new Peminjaman object
            Peminjaman peminjaman = new Peminjaman();

            // Set the properties from the input fields
            peminjaman.setIdPeminjam(Integer.parseInt(id_peminjaman.getText()));
            peminjaman.setNimNidn(nomorinduk.getText());
            peminjaman.setNamaPeminjam(NamaPeminjam.getText());
            peminjaman.setKodeBarang(Kode.getText());

            // Mengonversi java.util.Date ke java.sql.Date
            java.sql.Date tglPinjamSQL = new java.sql.Date(tPinjam.getDate().getTime());
            java.sql.Date tglKembaliSQL = new java.sql.Date(tKembali.getDate().getTime());

            peminjaman.setTanggalPinjam(tglPinjamSQL);
            peminjaman.setTanggalKembali(tglKembaliSQL);

            peminjaman.setJudul(tJudul.getSelectedItem().toString());
            peminjaman.setJumlahPinjam(Integer.parseInt(tJumlahPinjam.getText()));
            peminjaman.setStatus(tStatus.getSelectedItem().toString());

            // Validasi tanggal pinjam dan tanggal kembali
            if (tglKembaliSQL.before(tglPinjamSQL)) {
                JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh sebelum tanggal pinjam!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the data in the database
            peminjaman.ubahPeminjaman();

            // Show success message
            JOptionPane.showMessageDialog(this, "Data peminjaman berhasil diubah!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Reset the form
            reset();
            loadTabelPeminjaman(); // Refresh the table to show the updated entry

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid! Pastikan semua data terisi dengan benar.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data di database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bUbahActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tKembaliAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tKembaliAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tKembaliAncestorAdded

    private void nomorindukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorindukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorindukActionPerformed

    private void pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianActionPerformed
        try {
            Anggota ag = new Anggota();
            ag.setNidm("%" + tcari.getText().trim() + "%");
            ag.setNik("%" + tcari.getText().trim() + "%");
            ag.setNim("%" + tcari.getText().trim() + "%");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id_Anggota");
            model.addColumn("nama");
            model.addColumn("alamat");
            model.addColumn("nohp");
            model.addColumn("nim");
            model.addColumn("nidm");
            model.addColumn("nik");

            ResultSet data = ag.tampilSearch();
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getInt("id_anggota"),
                    data.getString("nama"),
                    data.getString("alamat"),
                    data.getString("nohp"),
                    data.getString("nim"),
                    data.getString("nidm"),
                    data.getString("nik"),});
            }
            TabelPeminjaman.setModel(model);

        } catch (SQLException sQLException) {
        }        // TODO add your handling code here:

    }//GEN-LAST:event_pencarianActionPerformed

    private void TabelPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPeminjamanMouseClicked
        int baris = TabelPeminjaman.getSelectedRow();

        // Mengambil data dari tabel dengan prioritas kolom
        String id_Anggota = TabelPeminjaman.getValueAt(baris, 0) != null ? TabelPeminjaman.getValueAt(baris, 0).toString() : "";
        String NamaPeminjam = TabelPeminjaman.getValueAt(baris, 1) != null ? TabelPeminjaman.getValueAt(baris, 1).toString() : "";
        String Kode = TabelPeminjaman.getValueAt(baris, 3) != null ? TabelPeminjaman.getValueAt(baris, 3).toString() : "";
        String NamaBarang = TabelPeminjaman.getValueAt(baris, 2) != null ? TabelPeminjaman.getValueAt(baris, 2).toString() : "";

        // Cek kolom 4, 5, dan 6
        String NimNidn = "";
        if (TabelPeminjaman.getValueAt(baris, 4) != null && !TabelPeminjaman.getValueAt(baris, 4).toString().isEmpty()) {
            NimNidn = TabelPeminjaman.getValueAt(baris, 4).toString();
        } else if (TabelPeminjaman.getValueAt(baris, 5) != null && !TabelPeminjaman.getValueAt(baris, 5).toString().isEmpty()) {
            NimNidn = TabelPeminjaman.getValueAt(baris, 5).toString();
        } else if (TabelPeminjaman.getValueAt(baris, 6) != null && !TabelPeminjaman.getValueAt(baris, 6).toString().isEmpty()) {
            NimNidn = TabelPeminjaman.getValueAt(baris, 6).toString();
        }

        // Mengisi JTextField dan JTextArea
        nomorinduk.setText(NimNidn);  // Mengisi JTextField nimNidnField
        PopUp_Peminjaman.NamaPeminjam.setText(NamaPeminjam);   // Mengisi JTextField namaField
        nomorhp.setText(Kode);        // Mengisi JTextField noHpField
        Almat.setText(NamaBarang);    // Mengisi JTextArea alamatField

    }//GEN-LAST:event_TabelPeminjamanMouseClicked

    private void NamaPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPeminjamActionPerformed

    private void AlmatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlmatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlmatActionPerformed

    private void nomorhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorhpActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tcariActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased

    }//GEN-LAST:event_tcariKeyReleased

    private void tJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJudulActionPerformed

    }//GEN-LAST:event_tJudulActionPerformed

    private void tJumlahPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJumlahPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJumlahPinjamActionPerformed

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
            java.util.logging.Logger.getLogger(PopUp_Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopUp_Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopUp_Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopUp_Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PopUp_Peminjaman().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PopUp_Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Almat;
    public static javax.swing.JTextField Kode;
    public static javax.swing.JTextField NamaPeminjam;
    public static javax.swing.JTable TabelPeminjaman;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bUbah;
    private javax.swing.JLabel hagsg;
    public static javax.swing.JLabel id_peminjaman;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jagfkh;
    private javax.swing.JLabel khkh;
    public static javax.swing.JTextField nomorhp;
    public static javax.swing.JTextField nomorinduk;
    public static javax.swing.JButton pencarian;
    private javax.swing.JLabel shhs;
    private javax.swing.JComboBox<String> tJudul;
    public static javax.swing.JTextField tJumlahPinjam;
    public static com.toedter.calendar.JDateChooser tKembali;
    public static com.toedter.calendar.JDateChooser tPinjam;
    public static javax.swing.JComboBox<String> tStatus;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables

}
