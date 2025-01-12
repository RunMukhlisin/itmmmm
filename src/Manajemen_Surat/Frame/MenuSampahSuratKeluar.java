/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Manajemen_Surat.Frame;

import Manajemen_Surat.Kelas.Bagian;
import Manajemen_Surat.Kelas.Kategori;
import Manajemen_Surat.Kelas.Surat_Keluar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rizan
 */
public class MenuSampahSuratKeluar extends javax.swing.JPanel implements Surat_Keluar.PerubahanData {

    /**
     * Creates new form MenuSampahSuratKeluar
     */
    private Surat_Keluar sk;

    public MenuSampahSuratKeluar() throws SQLException, ParseException {
        try {
            initComponents();
            ListenerCari();
            sk = new Surat_Keluar();
            sk.TambahPerubahanData(this);

            BlokJDate();

            // Mengatur Locale ke bahasa Indonesia
            dc_tglAwal.setLocale(new Locale("id"));
            dc_tglAkhir.setLocale(new Locale("id"));

            // Mengatur format tanggal ke "dd MMMM yyyy"
            dc_tglAwal.setDateFormatString("dd MMMM yyyy");
            dc_tglAkhir.setDateFormatString("dd MMMM yyyy");

            loadTabel();
            cbBagianSurat();
            cbKategoriSurat();

            cb_SampahSampah.addActionListener(evt -> {
                try {
                    applyFilters();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            cb_BagianSampah.addActionListener(evt -> {
                try {
                    applyFilters();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            dc_tglAwal.addPropertyChangeListener(evt -> {
                if ("date".equals(evt.getPropertyName())) {
                    try {
                        applyFilters();
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            dc_tglAkhir.addPropertyChangeListener(evt -> {
                if ("date".equals(evt.getPropertyName())) {
                    try {
                        applyFilters();
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (ParseException ex) {
            Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cbKategoriSurat() {
        try {
            cb_SampahSampah.addItem("--Pilih Kategori Surat--");

            Kategori ks = new Kategori();
            ResultSet data = ks.Tampil_CbKategoriSurat();

            while (data.next()) {
                cb_SampahSampah.addItem(data.getString("kode_kategori") + " - " + data.getString("nama_kategori"));
            }

            cb_SampahSampah.setSelectedItem("--Pilih Kategori Surat--");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void cbBagianSurat() {
        try {
            cb_BagianSampah.addItem("--Pilih Bagian Surat--");

            Bagian bg = new Bagian();
            ResultSet data = bg.Tampil_CbBagianSurat();

            while (data.next()) {
                cb_BagianSampah.addItem(data.getString("kode_bagian") + " - " + data.getString("nama_bagian"));
            }

            cb_BagianSampah.setSelectedItem("--Pilih Bagian Surat--");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTabel() throws ParseException {
        // Model tabel dengan sel yang tidak bisa diedit
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Semua sel tidak dapat diedit
            }
        };

        model.addColumn(null);
        model.addColumn("Bagian");
        model.addColumn("Kategori");
        model.addColumn("Nomor");
        model.addColumn("Tanggal");
        model.addColumn("Perihal");
        model.addColumn("Tujuan");
        model.addColumn("Nama File");
        model.addColumn("User");

        try {
            Surat_Keluar k = new Surat_Keluar();
            ResultSet data = k.KodeTampilTabelSampah();

            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));

            while (data.next()) {

                String formattedDate = "";
                if (data.getString("tanggal_dibuat") != null) {
                    java.util.Date date = java.sql.Date.valueOf(data.getString("tanggal_dibuat"));
                    formattedDate = dateFormat.format(date);
                }

                model.addRow(new Object[]{
                    data.getString("id_suratkeluar"), // ID
                    data.getString("bagian"),
                    data.getString("kategori"),
                    data.getString("no_surat"),
                    formattedDate,
                    data.getString("perihal"),
                    data.getString("tujuan"),
                    data.getString("nama_file"),
                    data.getString("user_login"),});
            }

            data.close();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace(); // Tambahkan log untuk debugging
        }

        tb_SampahSuratKeluar.setModel(model);
        // Sembunyikan kolom ID
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setWidth(0);

        // Mengatur word wrap di setiap kolom tabel
        tb_SampahSuratKeluar.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
                textArea.setLineWrap(true); // Aktifkan pembungkusan teks
                textArea.setWrapStyleWord(true); // Bungkus berdasarkan kata
                textArea.setOpaque(true); // Pastikan background sel sesuai
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
        // Mengatur tinggi baris agar sesuai dengan konten
        tb_SampahSuratKeluar.setRowHeight(40);

        // Mengatur ukuran kolom
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setPreferredWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(1).setPreferredWidth(100); // Kolom "Bagian"
        tb_SampahSuratKeluar.getColumnModel().getColumn(2).setPreferredWidth(125); // Kolom "Kategori"
        tb_SampahSuratKeluar.getColumnModel().getColumn(3).setPreferredWidth(125); // Kolom "Nomor Surat"
        tb_SampahSuratKeluar.getColumnModel().getColumn(4).setPreferredWidth(120); // Kolom "Tanggal dibuat"
        tb_SampahSuratKeluar.getColumnModel().getColumn(5).setPreferredWidth(150); // Kolom "Perihal"
        tb_SampahSuratKeluar.getColumnModel().getColumn(6).setPreferredWidth(150); // Kolom "Tujuan"
        tb_SampahSuratKeluar.getColumnModel().getColumn(7).setPreferredWidth(160); // Kolom "Nama File"
        tb_SampahSuratKeluar.getColumnModel().getColumn(8).setPreferredWidth(90);  // Kolom "User Login"

        // Mengatur agar tabel tidak bisa diubah ukuran kolomnya atau di-geser
        tb_SampahSuratKeluar.getTableHeader().setReorderingAllowed(false); // Tidak bisa geser header
        tb_SampahSuratKeluar.getTableHeader().setResizingAllowed(false);   // Tidak bisa ubah ukuran kolom
    }

    private void applyFilters() throws SQLException {

        Surat_Keluar suratKeluar = new Surat_Keluar();

        // Set nilai filter dari komponen UI
        if (!cb_SampahSampah.getSelectedItem().toString().equals("--Pilih Kategori Surat--")) {
            suratKeluar.setKategori(cb_SampahSampah.getSelectedItem().toString().split(" - ")[0]);
        }

        if (!cb_BagianSampah.getSelectedItem().toString().equals("--Pilih Bagian Surat--")) {
            suratKeluar.setBagian(cb_BagianSampah.getSelectedItem().toString().split(" - ")[0]);
        }

        suratKeluar.setTanggalAwal(dc_tglAwal.getDate());
        suratKeluar.setTanggalAkhir(dc_tglAkhir.getDate());

        // Ambil data berdasarkan filter
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(null);
        model.addColumn("Bagian");
        model.addColumn("Kategori");
        model.addColumn("Nomor");
        model.addColumn("Tanggal");
        model.addColumn("Perihal");
        model.addColumn("Tujuan");
        model.addColumn("Nama File");
        model.addColumn("User");

        try {
            ResultSet data = suratKeluar.KodeTampilByFiltersSampah();
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));

            while (data.next()) {
                String formattedDate = "";
                if (data.getString("tanggal_dibuat") != null) {
                    java.util.Date date = java.sql.Date.valueOf(data.getString("tanggal_dibuat"));
                    formattedDate = dateFormat.format(date);
                }

                model.addRow(new Object[]{
                    data.getString("id_suratkeluar"),
                    data.getString("bagian"),
                    data.getString("kategori"),
                    data.getString("no_surat"),
                    formattedDate,
                    data.getString("perihal"),
                    data.getString("tujuan"),
                    data.getString("nama_file"),
                    data.getString("user_login"),});
            }
            data.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tb_SampahSuratKeluar.setModel(model);

        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setWidth(0);

        // Mengatur word wrap di setiap kolom tabel
        tb_SampahSuratKeluar.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
                textArea.setLineWrap(true); // Aktifkan pembungkusan teks
                textArea.setWrapStyleWord(true); // Bungkus berdasarkan kata
                textArea.setOpaque(true); // Pastikan background sel sesuai
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

        // Mengatur tinggi baris agar sesuai dengan konten
        tb_SampahSuratKeluar.setRowHeight(40);

        // Mengatur ukuran kolom
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setPreferredWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(1).setPreferredWidth(100); // Kolom "Bagian"
        tb_SampahSuratKeluar.getColumnModel().getColumn(2).setPreferredWidth(125); // Kolom "Kategori"
        tb_SampahSuratKeluar.getColumnModel().getColumn(3).setPreferredWidth(125); // Kolom "Nomor Surat"
        tb_SampahSuratKeluar.getColumnModel().getColumn(4).setPreferredWidth(120); // Kolom "Tanggal dibuat"
        tb_SampahSuratKeluar.getColumnModel().getColumn(5).setPreferredWidth(150); // Kolom "Perihal"
        tb_SampahSuratKeluar.getColumnModel().getColumn(6).setPreferredWidth(150); // Kolom "Tujuan"
        tb_SampahSuratKeluar.getColumnModel().getColumn(7).setPreferredWidth(160); // Kolom "Nama File"
        tb_SampahSuratKeluar.getColumnModel().getColumn(8).setPreferredWidth(90);  // Kolom "User Login"

        // Mengatur agar tabel tidak bisa diubah ukuran kolomnya atau di-geser
        tb_SampahSuratKeluar.getTableHeader().setReorderingAllowed(false); // Tidak bisa geser header
        tb_SampahSuratKeluar.getTableHeader().setResizingAllowed(false);   // Tidak bisa ubah ukuran kolom

    }

    private void Cari() throws SQLException, ParseException {
        // Ambil teks dari text field
        String keyword = tf_Cari.getText().trim();
        if (keyword.isEmpty()) {
            loadTabel(); // Jika kosong, reset tabel
            return;
        }

        // Model tabel dengan sel yang tidak bisa diedit
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Semua sel tidak dapat diedit
            }
        };

        // Tambahkan kolom ke model
        model.addColumn(null); // Kolom untuk ID
        model.addColumn("Bagian");
        model.addColumn("Kategori");
        model.addColumn("No Surat");
        model.addColumn("Tanggal Dibuat");
        model.addColumn("Perihal");
        model.addColumn("Tujuan");
        model.addColumn("Nama File");
        model.addColumn("User Login");

        // Set kata kunci pencarian di objek Surat_Keluar
        Surat_Keluar suratKeluar = new Surat_Keluar();
        suratKeluar.setKata_kunci(keyword); // Set kata kunci menggunakan setter

        // Jalankan query dan ambil data
        try (ResultSet data = suratKeluar.KodeTampilByPerihalTujuanSampah()) {
            // Format tanggal
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));

            while (data.next()) {
                // Format tanggal
                String formattedDate = "";
                java.util.Date date = data.getDate("tanggal_dibuat");
                if (date != null) {
                    formattedDate = dateFormat.format(date);
                }

                // Tambahkan baris ke model
                model.addRow(new Object[]{
                    data.getString("id_suratkeluar"),
                    data.getString("bagian"),
                    data.getString("kategori"),
                    data.getString("no_surat"),
                    formattedDate,
                    data.getString("perihal"),
                    data.getString("tujuan"),
                    data.getString("nama_file"),
                    data.getString("user_login"),});
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log error untuk debugging
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Set model ke tabel
        tb_SampahSuratKeluar.setModel(model);

        // Sembunyikan kolom ID
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SampahSuratKeluar.getColumnModel().getColumn(0).setWidth(0);

        // Custom renderer untuk word wrap
        tb_SampahSuratKeluar.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

        // Atur tinggi baris
        tb_SampahSuratKeluar.setRowHeight(40);

        // Atur lebar kolom
        tb_SampahSuratKeluar.getColumnModel().getColumn(1).setPreferredWidth(100); // Bagian
        tb_SampahSuratKeluar.getColumnModel().getColumn(2).setPreferredWidth(125); // Kategori
        tb_SampahSuratKeluar.getColumnModel().getColumn(3).setPreferredWidth(125); // No Surat
        tb_SampahSuratKeluar.getColumnModel().getColumn(4).setPreferredWidth(120); // Tanggal Dibuat
        tb_SampahSuratKeluar.getColumnModel().getColumn(5).setPreferredWidth(150); // Perihal
        tb_SampahSuratKeluar.getColumnModel().getColumn(6).setPreferredWidth(150); // Tujuan
        tb_SampahSuratKeluar.getColumnModel().getColumn(7).setPreferredWidth(160); // Nama File
        tb_SampahSuratKeluar.getColumnModel().getColumn(8).setPreferredWidth(90);  // User Login

        // Atur header tabel
        tb_SampahSuratKeluar.getTableHeader().setReorderingAllowed(false);
        tb_SampahSuratKeluar.getTableHeader().setResizingAllowed(false);
    }

    private void ListenerCari() {
        // Timer dengan delay 300ms
        Timer timer = new Timer(500, e -> {
            String keyword = tf_Cari.getText().trim();
            if (keyword.isEmpty()) {
                try {
                    loadTabel(); // Jika text field kosong, reset tabel
                } catch (ParseException ex) {
                    Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Cari(); // Jika tidak kosong, lakukan pencarian
                } catch (SQLException ex) {
                    Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Pastikan timer tidak otomatis dijalankan
        timer.setRepeats(false);

        // Tambahkan DocumentListener ke text field
        tf_Cari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                timer.restart(); // Restart timer setiap kali teks berubah
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                timer.restart(); // Restart timer setiap kali teks dihapus
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak diperlukan untuk JTextField
            }
        });
    }

    public void reset() throws ParseException {
        cb_SampahSampah.setSelectedIndex(0);
        cb_BagianSampah.setSelectedIndex(0);
        dc_tglAwal.setCalendar(null);
        dc_tglAkhir.setCalendar(null);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_Cari = new javax.swing.JTextField();
        cb_BagianSampah = new javax.swing.JComboBox<>();
        cb_SampahSampah = new javax.swing.JComboBox<>();
        dc_tglAwal = new com.toedter.calendar.JDateChooser();
        dc_tglAkhir = new com.toedter.calendar.JDateChooser();
        bt_Reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SampahSuratKeluar = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Menu Sampah Surat Keluar");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Filter Tabel");

        jLabel3.setText("Car berdasarkan Perihal dan Tujuan");

        jLabel4.setText("Bagian");

        jLabel5.setText("Kategori");

        jLabel6.setText("Tanggal Awal");

        jLabel7.setText("Tanggal Akhir");

        bt_Reset.setText("Reset Filter");
        bt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetActionPerformed(evt);
            }
        });

        tb_SampahSuratKeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_SampahSuratKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SampahSuratKeluarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SampahSuratKeluar);

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
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_BagianSampah, 0, 200, Short.MAX_VALUE)
                                    .addComponent(cb_SampahSampah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dc_tglAwal, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(dc_tglAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(bt_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 400, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cb_BagianSampah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dc_tglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cb_SampahSampah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dc_tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bt_Reset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        try {
            reset();
        } catch (ParseException ex) {
            Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void tb_SampahSuratKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SampahSuratKeluarMouseClicked
        try {
            int baris = tb_SampahSuratKeluar.getSelectedRow();
            if (baris != -1 && tb_SampahSuratKeluar.getValueAt(baris, 0) != null) {

                String Id = tb_SampahSuratKeluar.getValueAt(baris, 0) != null ? tb_SampahSuratKeluar.getValueAt(baris, 0).toString() : "";
                String Bagian = tb_SampahSuratKeluar.getValueAt(baris, 1) != null ? tb_SampahSuratKeluar.getValueAt(baris, 1).toString() : "";
                String Kategori = tb_SampahSuratKeluar.getValueAt(baris, 2) != null ? tb_SampahSuratKeluar.getValueAt(baris, 2).toString() : "";
                String Nomor = tb_SampahSuratKeluar.getValueAt(baris, 3) != null ? tb_SampahSuratKeluar.getValueAt(baris, 3).toString() : "";
                String Tanggal = tb_SampahSuratKeluar.getValueAt(baris, 4) != null ? tb_SampahSuratKeluar.getValueAt(baris, 4).toString() : "";
                String Perihal = tb_SampahSuratKeluar.getValueAt(baris, 5) != null ? tb_SampahSuratKeluar.getValueAt(baris, 5).toString() : "";
                String Tujuan = tb_SampahSuratKeluar.getValueAt(baris, 6) != null ? tb_SampahSuratKeluar.getValueAt(baris, 6).toString() : "";
                String File = tb_SampahSuratKeluar.getValueAt(baris, 7) != null ? tb_SampahSuratKeluar.getValueAt(baris, 7).toString() : "";

                PopUpSuratKeluar pusk = new PopUpSuratKeluar(null, true, sk, true);

                pusk.bt_Tambah.setVisible(false);
                pusk.bt_Ubah.setVisible(false);
                pusk.bt_Hapus.setVisible(false);
                pusk.bt_Lihat.setVisible(false);
                pusk.bt_Upload.setVisible(false);

                pusk.isInitializing = true; // Set flag sebelum pengisian data
                pusk.lb_Id.setText(Id);

                for (int i = 0; i < pusk.cb_Bagian.getItemCount(); i++) {
                    String item = pusk.cb_Bagian.getItemAt(i);
                    if (item.startsWith(Bagian + " -")) {
                        pusk.cb_Bagian.setSelectedIndex(i);
                        break;
                    }
                }

                pusk.cb_Bagian.setEditable(false);

                for (int i = 0; i < pusk.cb_Kategori.getItemCount(); i++) {
                    String item = pusk.cb_Kategori.getItemAt(i);
                    if (item.startsWith(Kategori + " -")) {
                        pusk.cb_Kategori.setSelectedIndex(i);
                        break;
                    }
                }

                pusk.tf_NoSurat.setText(Nomor);

                if (Tanggal != null && !Tanggal.isEmpty()) {
                    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));
                    java.util.Date date = formatter.parse(Tanggal);
                    pusk.dc_Tgl.setDate(date);
                }

                pusk.tf_Perihal.setText(Perihal);
                pusk.tf_Tujuan.setText(Tujuan);
                pusk.ta_File.setText(File);

                pusk.isInitializing = false; // Selesai inisialisasi
                pusk.setVisible(true);
            }
        } catch (SQLException | java.text.ParseException ex) {
            Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_SampahSuratKeluarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Reset;
    private javax.swing.JComboBox<String> cb_BagianSampah;
    private javax.swing.JComboBox<String> cb_SampahSampah;
    private com.toedter.calendar.JDateChooser dc_tglAkhir;
    private com.toedter.calendar.JDateChooser dc_tglAwal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_SampahSuratKeluar;
    private javax.swing.JTextField tf_Cari;
    // End of variables declaration//GEN-END:variables

    public void BlokJDate() {
        blokirEditor(dc_tglAwal);
        blokirEditor(dc_tglAkhir);
    }

    private void blokirEditor(JDateChooser dateChooser) {
        if (dateChooser.getDateEditor() instanceof JTextFieldDateEditor) {
            JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
            editor.setEditable(false);
        }
    }

    @Override
    public void AktifPerubahanData() {
        try {
            loadTabel();
        } catch (ParseException ex) {
            Logger.getLogger(MenuSampahSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
