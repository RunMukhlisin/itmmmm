/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Manajemen_Surat.Frame;


import Manajemen_Surat.Kelas.Surat_Masuk;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dickyi
 */
public class MenuLogSuratMasuk extends javax.swing.JPanel {

   public class menuLogSuratMasuk extends javax.swing.JPanel {

    /**
     * Creates new form menuLogBagian
     */
    public menuLogSuratMasuk() throws ParseException {
        initComponents();
        loadTabel();
    }
    
    public void loadTabel() throws ParseException {

        // Model tabel dengan sel yang tidak bisa diedit
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Semua sel tidak dapat diedit
            }
        };

        model.addColumn("User Login");
        model.addColumn("Kolom yang berubah");
        model.addColumn("Nilai lama");
        model.addColumn("Nilai baru");
        model.addColumn("Waktu");
        model.addColumn("Keterangan");

        try {
            Surat_Masuk k = new Surat_Masuk();
            ResultSet data = k.KodeTampilTabelLog();

            // Format waktu: 21:11:16 (newline) 25 Desember 2024
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));

            while (data.next()) {
                String waktu = data.getString("waktu"); // Ambil waktu dari database
                String waktuFormatted = "";
                if (waktu != null) {
                    waktuFormatted = timeFormat.format(originalFormat.parse(waktu)) + "\n"
                            + dateFormat.format(originalFormat.parse(waktu));
                }

                model.addRow(new Object[]{
                    data.getString("user_login"),
                    data.getString("kolom_yang_berubah"),
                    data.getString("nilai_lama"),
                    data.getString("nilai_baru"),
                    waktuFormatted, // Format waktu yang sudah diubah
                    data.getString("keterangan"),});
            }

            data.close();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace(); // Tambahkan log untuk debugging
        }

        tb_LogSuratMasuk.setModel(model);

        // Mengatur word wrap di setiap kolom tabel
        tb_LogSuratMasuk.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        tb_LogSuratMasuk.setRowHeight(70);

        // Mengatur ukuran kolom
        tb_LogSuratMasuk.getColumnModel().getColumn(0).setPreferredWidth(90); // Kolom "User Login"
        tb_LogSuratMasuk.getColumnModel().getColumn(1).setPreferredWidth(80); // Kolom "Kolom yang berubah"
        tb_LogSuratMasuk.getColumnModel().getColumn(2).setPreferredWidth(130); // Kolom "Nilai Lama"
        tb_LogSuratMasuk.getColumnModel().getColumn(3).setPreferredWidth(130); // Kolom "Nilai Baru"
        tb_LogSuratMasuk.getColumnModel().getColumn(4).setPreferredWidth(110); // Kolom "Waktu"
        tb_LogSuratMasuk.getColumnModel().getColumn(5).setPreferredWidth(230); // Kolom "Keterangan"

        // Mengatur agar tabel tidak bisa diubah ukuran kolomnya atau di-geser
        tb_LogSuratMasuk.getTableHeader().setReorderingAllowed(false); // Tidak bisa geser header
        tb_LogSuratMasuk.getTableHeader().setResizingAllowed(false);   // Tidak bisa ubah ukuran kolom
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_LogSuratMasuk = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Menu Log Surat Masuk");

        tb_LogSuratMasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_LogSuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_LogSuratMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_LogSuratMasuk);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 881, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tb_LogSuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_LogSuratMasukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_LogSuratMasukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_LogSuratMasuk;
    // End of variables declaration//GEN-END:variables
}
