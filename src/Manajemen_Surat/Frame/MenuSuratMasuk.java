/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Manajemen_Surat.Frame;

import Manajemen_Surat.Frame.PopUpSuratMasuk;
import java.util.logging.Level;
import java.util.logging.Logger;
import Manajemen_Surat.Kelas.Kategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Manajemen_Surat.Kelas.Surat_Masuk;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Dicky
 */
public class MenuSuratMasuk extends javax.swing.JPanel {

    /**
     * Creates new form MenuSuratMasuk
     */
    public MenuSuratMasuk() {
        initComponents();

        addSearchListener();
        loadTabel();
        blokirtextfieldTanggal();
        cbKategoriSurat();

        cb_KategoriMenu.addActionListener(evt -> {
            try {
                applyFilters();
            } catch (SQLException ex) {
                Logger.getLogger(MenuSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dc_TglAwal.addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                try {
                    applyFilters();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        dc_TglAkhir.addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                try {
                    applyFilters();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void loadTabel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("NO");
        model.addColumn(null);
        model.addColumn("Pengirim");
        model.addColumn("Kategori");
        model.addColumn("Nomor Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");
        model.addColumn("User Login");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID")); // Satu deklarasi dateFormat

        try {
            Surat_Masuk surat = new Surat_Masuk();
            ResultSet data = surat.tampilSurat();

            java.util.Date now = new java.util.Date();
            java.sql.Date startOfMonth = new java.sql.Date(now.getYear(), now.getMonth(), 1);
            java.sql.Date endOfMonth = new java.sql.Date(now.getYear(), now.getMonth() + 1, 0);

            int no = 1;

            while (data.next()) {
                Date tanggalDiterima = data.getDate("tanggal_diterima");
                String formattedDate = (tanggalDiterima != null) ? dateFormat.format(tanggalDiterima) : "N/A";

                model.addRow(new Object[]{
                    no++,
                    data.getString("id_suratmasuk"),
                    data.getString("pengirim"),
                    data.getString("kategori"),
                    data.getString("nomor_surat"),
                    data.getString("perihal"),
                    formattedDate,
                    data.getString("file_data"),
                    data.getString("user_login")
                });
            }
            data.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + sQLException.getMessage());
        }

        tb_SuratMasuk.setModel(model);

        tb_SuratMasuk.getColumnModel().getColumn(1).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(1).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(1).setWidth(0);

        tb_SuratMasuk.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setOpaque(true);
                if (isSelected) {
                    textArea.setBackground(table.getSelectionBackground());
                    textArea.setForeground(table.getSelectionForeground());
                } else {
                    textArea.setBackground(table.getBackground());
                    textArea.setForeground(table.getForeground());
                }
                return textArea;
            }
        });

        tb_SuratMasuk.setRowHeight(40);

        tb_SuratMasuk.getColumnModel().getColumn(0).setPreferredWidth(30);
        tb_SuratMasuk.getColumnModel().getColumn(2).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(3).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(4).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(5).setPreferredWidth(130);
        tb_SuratMasuk.getColumnModel().getColumn(6).setPreferredWidth(130);
        tb_SuratMasuk.getColumnModel().getColumn(7).setPreferredWidth(200);
        tb_SuratMasuk.getColumnModel().getColumn(8).setPreferredWidth(90);

        tb_SuratMasuk.getTableHeader().setReorderingAllowed(false);
        tb_SuratMasuk.getTableHeader().setResizingAllowed(false);
    }

    private void applyFilters() throws SQLException {

        Surat_Masuk srt = new Surat_Masuk();

        String selectedKategori = cb_KategoriMenu.getSelectedItem().toString();
        if (selectedKategori.equals("--Pilih Kategori Surat--")) {
            srt.setKategori(null);
        } else {
            srt.setKategori(selectedKategori);
        }

        srt.setTanggalAwal(dc_TglAwal.getDate());
        srt.setTanggalAkhir(dc_TglAkhir.getDate());

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO");
        model.addColumn(null);
        model.addColumn("Pengirim");
        model.addColumn("Kategori");
        model.addColumn("Nomor Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");
        model.addColumn("User Login");

        try {
            ResultSet data = srt.KodeTampilByFilters();
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));
            int no = 1;
            while (data.next()) {
                String formattedDate = "";
                if (data.getString("tanggal_diterima") != null) {
                    java.util.Date date = java.sql.Date.valueOf(data.getString("tanggal_diterima"));
                    formattedDate = dateFormat.format(date);
                }

                model.addRow(new Object[]{
                    no++,
                    data.getString("id_suratmasuk"),
                    data.getString("pengirim"),
                    data.getString("kategori"),
                    data.getString("nomor_surat"),
                    data.getString("perihal"),
                    formattedDate,
                    data.getString("file_data"),
                    data.getString("user_login")
                });
            }
            data.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tb_SuratMasuk.setModel(model);

        tb_SuratMasuk.getColumnModel().getColumn(1).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(1).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(1).setWidth(0);

        tb_SuratMasuk.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setOpaque(true);
                if (isSelected) {
                    textArea.setBackground(table.getSelectionBackground());
                    textArea.setForeground(table.getSelectionForeground());
                } else {
                    textArea.setBackground(table.getBackground());
                    textArea.setForeground(table.getForeground());
                }
                return textArea;
            }
        });

        tb_SuratMasuk.setRowHeight(40);

        tb_SuratMasuk.getColumnModel().getColumn(0).setPreferredWidth(30);
        tb_SuratMasuk.getColumnModel().getColumn(2).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(3).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(4).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(5).setPreferredWidth(130);
        tb_SuratMasuk.getColumnModel().getColumn(6).setPreferredWidth(130);
        tb_SuratMasuk.getColumnModel().getColumn(7).setPreferredWidth(200);
        tb_SuratMasuk.getColumnModel().getColumn(8).setPreferredWidth(90);

        tb_SuratMasuk.getTableHeader().setReorderingAllowed(false);
        tb_SuratMasuk.getTableHeader().setResizingAllowed(false);
    }

    private void Cari() throws SQLException, ParseException {

        String keyword = tf_Cari.getText().trim();
        if (keyword.isEmpty()) {
            loadTabel();
            return;
        }

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("NO");
        model.addColumn(null);
        model.addColumn("Pengirim");
        model.addColumn("Kategori");
        model.addColumn("Nomor Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");
        model.addColumn("User Login");

        Surat_Masuk suratKeluar = new Surat_Masuk();
        suratKeluar.setKata_kunci(keyword);

        try (ResultSet data = suratKeluar.KodeCari()) {

            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));
            int no = 1;
            while (data.next()) {

                String formattedDate = "";
                java.util.Date date = data.getDate("tanggal_diterima");
                if (date != null) {
                    formattedDate = dateFormat.format(date);
                }

                model.addRow(new Object[]{
                    no++,
                    data.getString("id_suratmasuk"),
                    data.getString("pengirim"),
                    data.getString("kategori"),
                    data.getString("nomor_surat"),
                    data.getString("perihal"),
                    formattedDate,
                    data.getString("file_data"),
                    data.getString("user_login")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        tb_SuratMasuk.setModel(model);

        tb_SuratMasuk.getColumnModel().getColumn(1).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(1).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(1).setWidth(0);

        tb_SuratMasuk.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setOpaque(true);
                if (isSelected) {
                    textArea.setBackground(table.getSelectionBackground());
                    textArea.setForeground(table.getSelectionForeground());
                } else {
                    textArea.setBackground(table.getBackground());
                    textArea.setForeground(table.getForeground());
                }
                return textArea;
            }
        });

        tb_SuratMasuk.setRowHeight(40);

        tb_SuratMasuk.getColumnModel().getColumn(0).setPreferredWidth(30);
        tb_SuratMasuk.getColumnModel().getColumn(2).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(3).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(4).setPreferredWidth(125);
        tb_SuratMasuk.getColumnModel().getColumn(5).setPreferredWidth(130);
        tb_SuratMasuk.getColumnModel().getColumn(6).setPreferredWidth(130);
        tb_SuratMasuk.getColumnModel().getColumn(7).setPreferredWidth(200);
        tb_SuratMasuk.getColumnModel().getColumn(8).setPreferredWidth(90);

        tb_SuratMasuk.getTableHeader().setReorderingAllowed(false);
        tb_SuratMasuk.getTableHeader().setResizingAllowed(false);
    }

    private void addSearchListener() {

        Timer timer = new Timer(500, e -> {
            String keyword = tf_Cari.getText().trim();
            if (keyword.isEmpty()) {
                loadTabel();
            } else {
                try {
                    Cari();
                } catch (SQLException ex) {
                    Logger.getLogger(menuSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(menuSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        timer.setRepeats(false);
        tf_Cari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                timer.restart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                timer.restart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    void cbKategoriSurat() {
        try {
            cb_KategoriMenu.addItem("--Pilih Kategori Surat--");

            Kategori ks = new Kategori();
            ResultSet data = ks.Tampil_CbKategoriSurat();

            while (data.next()) {
                cb_KategoriMenu.addItem(data.getString("kode_kategori") + " - " + data.getString("nama_kategori"));
            }

            cb_KategoriMenu.setSelectedItem("--Pilih Kategori Surat--");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void blokirtextfieldTanggal() {
        if (dc_TglAwal.getDateEditor() instanceof JTextFieldDateEditor) {
            JTextFieldDateEditor editorAwal = (JTextFieldDateEditor) dc_TglAwal.getDateEditor();
            editorAwal.setEditable(false);
            editorAwal.setEnabled(false);
        }

        if (dc_TglAkhir.getDateEditor() instanceof JTextFieldDateEditor) {
            JTextFieldDateEditor editorAkhir = (JTextFieldDateEditor) dc_TglAkhir.getDateEditor();
            editorAkhir.setEditable(false);
            editorAkhir.setEnabled(false);
        }
    }

    public void reset() throws ParseException {
        cb_KategoriMenu.setSelectedIndex(0);
        dc_TglAwal.setCalendar(null);
        dc_TglAkhir.setCalendar(null);
        tf_Cari.setText(null);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_Cari = new javax.swing.JTextField();
        cb_KategoriMenu = new javax.swing.JComboBox<>();
        bTambah = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SuratMasuk = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Menu Surat Masuk");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Filter Tabel");

        jLabel3.setText("Car berdasarkan Pengirim dan Perihal");

        jLabel5.setText("Kategori");

        jLabel6.setText("Tanggal Awal");

        jLabel7.setText("Tanggal Akhir");

        tf_Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CariActionPerformed(evt);
            }
        });

        bTambah.setText("Tambah Surat Masuk");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bReset.setText("Reset Filter");

        tb_SuratMasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_SuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SuratMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SuratMasuk);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_KategoriMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(206, 206, 206)
                                .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bTambah))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(cb_KategoriMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        try {
            PopUpSuratMasuk sk = new PopUpSuratMasuk();
            sk.setVisible(true);
            sk.bEdit.setVisible(false);
            sk.bHapus.setVisible(false);
            sk.bt_Restore.setVisible(false);
            sk.bt_HapusPermanen.setVisible(false);
            sk.otoID();
            sk.tTanggalDiterima.setDate(new Date());
            sk.txtfilepath.setEnabled(false);
            sk.setVisible(true);
        } catch (SQLException sQLException) {
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
         try {
            reset();
        } catch (ParseException ex) {
            Logger.getLogger(MenuSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bResetActionPerformed

    private void tb_SuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SuratMasukMouseClicked
     PopUpSuratMasuk suratMasukFrame = null;
        try {
            suratMasukFrame = new PopUpSuratMasuk();
            suratMasukFrame.setVisible(true);
            suratMasukFrame.bTambah.setVisible(false);
            suratMasukFrame.bt_HapusPermanen.setVisible(false);
            suratMasukFrame.bt_Restore.setVisible(false);
            suratMasukFrame.setLocationRelativeTo(null);
            suratMasukFrame.txtfilepath.setEnabled(false);
            suratMasukFrame.ambilDetail();
        } catch (SQLException sQLException) {
        }

        try {

            Surat_Masuk sur = new Surat_Masuk();

            int baris = tb_SuratMasuk.getSelectedRow();

            sur.setId_surat(tb_SuratMasuk.getValueAt(baris, 1).toString());
            sur.setPengirim(tb_SuratMasuk.getValueAt(baris, 2).toString());
            String kode = tb_SuratMasuk.getValueAt(baris, 3).toString();

            sur.setKategori(tb_SuratMasuk.getValueAt(baris, 3).toString());
            Kategori kat = new Kategori();
            ResultSet dataKat = kat.KonversiKateori();
            if (dataKat.next()) {
                String namaKategori = dataKat.getString("nama_kategori");
                Surat_Masuk.setKategori(kode + " - " + namaKategori);
            }

            sur.setNomor_surat(tb_SuratMasuk.getValueAt(baris, 4).toString());

            sur.setPerihal(tb_SuratMasuk.getValueAt(baris, 5).toString());

            String tanggalDiterimaStr = tb_SuratMasuk.getValueAt(baris, 6).toString();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
            try {
                Date tanggalDiterima = dateFormat.parse(tanggalDiterimaStr);
                sur.setTanggal_diterima(new java.sql.Date(tanggalDiterima.getTime()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            sur.setFile_data(tb_SuratMasuk.getValueAt(baris, 7).toString());

            sur.setUser_login(tb_SuratMasuk.getValueAt(baris, 8).toString());

            suratMasukFrame.ambilDetail();

        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tb_SuratMasukMouseClicked

    private void tf_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_CariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReset;
    private javax.swing.JButton bTambah;
    private javax.swing.JComboBox<String> cb_KategoriMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_SuratMasuk;
    private javax.swing.JTextField tf_Cari;
    // End of variables declaration//GEN-END:variables
                               
}
