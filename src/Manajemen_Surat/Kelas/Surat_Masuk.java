/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen_Surat.Kelas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import SuperAdmin.Kelas.koneksi;

/**
 *
 * @author Syarah
 */
public class Surat_Masuk {

    int jumlah = 0;
    String filterKategori, kata_kunci;
    java.sql.Date tgl_awal, tgl_akhir;
    public static String id_suratmasuk, kategori, pengirim, perihal, file_data, nomor_surat,
            user_login, status;
    public static java.sql.Date tanggal_diterima;

    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    private List<PerubahanData> listeners = new ArrayList<>();

    public interface PerubahanData {

        void AktifPerubahanData();
    }

    public void TambahPerubahanData(PerubahanData listener) {
        listeners.add(listener);
    }

    public void HapusPerubahanData(PerubahanData listener) {
        listeners.remove(listener);
    }

    public void NotifPerubahanData() {
        for (PerubahanData listener : listeners) {
            listener.AktifPerubahanData();
        }
    }

    
    
    public Surat_Masuk() throws SQLException {
        koneksi koneksi = new koneksi();
        conn = koneksi.connectDb();
    }

    public String getFilterKategori() {
        return filterKategori;
    }

    public void setFilterKategori(String filterKategori) {
        this.filterKategori = filterKategori;
    }

    public String getKata_kunci() {
        return kata_kunci;
    }

    public void setKata_kunci(String kata_kunci) {
        this.kata_kunci = kata_kunci;
    }

    public java.sql.Date getTgl_awal() {
        return tgl_awal;
    }

    public void setTanggalAwal(java.util.Date tanggalAwal) {
        if (tanggalAwal != null) {
            this.tgl_awal = new java.sql.Date(tanggalAwal.getTime());
        }
    }

    public java.sql.Date getTgl_akhir() {
        return tgl_akhir;
    }

    public void setTanggalAkhir(java.util.Date tanggalAkhir) {
        if (tanggalAkhir != null) {
            this.tgl_akhir = new java.sql.Date(tanggalAkhir.getTime());
        }
    }

    public static String getId_surat() {
        return id_suratmasuk;
    }

    public static void setId_surat(String id_surat) {
        Surat_Masuk.id_suratmasuk = id_surat;
    }

    public static String getKategori() {
        return kategori;
    }

    public static void setKategori(String kategori) {
        Surat_Masuk.kategori = kategori;
    }

    public static String getPengirim() {
        return pengirim;
    }

    public static void setPengirim(String pengirim) {
        Surat_Masuk.pengirim = pengirim;
    }

    public static String getPerihal() {
        return perihal;
    }

    public static void setPerihal(String perihal) {
        Surat_Masuk.perihal = perihal;
    }

    public static String getFile_data() {
        return file_data;
    }

    public static void setFile_data(String file_data) {
        Surat_Masuk.file_data = file_data;
    }

    public static String getNomor_surat() {
        return nomor_surat;
    }

    public static void setNomor_surat(String nomor_surat) {
        Surat_Masuk.nomor_surat = nomor_surat;
    }

    public static String getUser_login() {
        return user_login;
    }

    public static void setUser_login(String user_login) {
        Surat_Masuk.user_login = user_login;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Surat_Masuk.status = status;
    }

    public static Date getTanggal_diterima() {
        return tanggal_diterima;
    }

    public static void setTanggal_diterima(Date tanggal_diterima) {
        Surat_Masuk.tanggal_diterima = tanggal_diterima;
    }

    public Connection getconn() {
        return conn;
    }

    public void setconn(Connection konek) {
        this.conn = konek;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void tambahSurat() {
        query = "INSERT INTO surat_masuk(id_suratmasuk,"
                + "pengirim,"
                + "kategori,"
                + "nomor_surat,"
                + "perihal,"
                + "tanggal_diterima,"
                + "file_data,"
                + "user_login,"
                + "status) VALUES(?,?,?,?,?,?,?,?,'1')";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, id_suratmasuk);
            ps.setString(2, pengirim);
            ps.setString(3, kategori);
            ps.setString(4, nomor_surat);
            ps.setString(5, perihal);
            ps.setDate(6, tanggal_diterima);
            ps.setString(7, file_data);
            ps.setString(8, user_login);

            ps.executeUpdate();
            ps.close();
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Surat berhasil ditambahkan!", null, JOptionPane.INFORMATION_MESSAGE, 1000);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ubahSurat() {
        query = "UPDATE surat_masuk SET "
                + "pengirim = ?, "
                + "kategori = ?, "
                + "nomor_surat = ?, "
                + "perihal = ?, "
                + "tanggal_diterima = ?, "
                + "file_data = ?, "
                + "user_login = ?, "
                + "status = '1' "
                + "WHERE id_suratmasuk = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, pengirim);
            ps.setString(2, kategori);
            ps.setString(3, nomor_surat);
            ps.setString(4, perihal);
            ps.setDate(5, new java.sql.Date(tanggal_diterima.getTime())); // Mengasumsikan tanggal_diterima adalah java.util.Date
            ps.setString(6, file_data);
            ps.setString(7, user_login);
            ps.setString(8, id_suratmasuk);

            ps.executeUpdate();
            ps.close();
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Surat berhasil diubah!", null, JOptionPane.INFORMATION_MESSAGE, 1000);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Surat gagal diubah: " + ex.getMessage());
        }
    }

    public ResultSet tampilSurat() {
        query = "SELECT * FROM surat_masuk WHERE status = '1'";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Data gagal ditampilkan", null, JOptionPane.ERROR_MESSAGE, 3000);
        }

        return rs;
    }

    public ResultSet KodeTampilTabelLog() {;
        query = "SELECT * FROM log_suratmasuk ORDER BY waktu DESC";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Data gagal ditampilkan", null, JOptionPane.ERROR_MESSAGE, 3000);
        }

        return rs;
    }

    public ResultSet KodeTampilTabelSampah() {;
        query = "SELECT * FROM surat_masuk WHERE status = '0'";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Data gagal ditampilkan", null, JOptionPane.ERROR_MESSAGE, 3000);
        }

        return rs;
    }

    public void KodeHapus() {
        query = "UPDATE surat_masuk SET user_login = ?, status = '0' WHERE id_suratmasuk = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user_login);
            ps.setString(2, id_suratmasuk);

            ps.executeUpdate();
            ps.close();

            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Surat berhasil dihapus!", null, JOptionPane.INFORMATION_MESSAGE, 1000);

        } catch (SQLException e) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Gagal menghapus surat!: " + e.getMessage(), null, JOptionPane.ERROR_MESSAGE, 30000);
        }
    }

    public void KodeHapusPermanen() {
        query = "DELETE FROM surat_masuk WHERE id_suratmasuk = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, id_suratmasuk);
            ps.executeUpdate();
            ps.close();
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Kategori Surat berhasil dihapus permanen!", null, JOptionPane.INFORMATION_MESSAGE, 1000);
        } catch (Exception e) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Kategori Surat gagal dihapus permanen!", null, JOptionPane.ERROR_MESSAGE, 3000);
        }
    }

    public void KodeRestore() {
        query = "UPDATE surat_masuk SET user_login = ?, status = '1' WHERE id_suratmasuk = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user_login);
            ps.setString(2, id_suratmasuk);

            ps.executeUpdate();
            ps.close();

            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Surat berhasil diRestore!", null, JOptionPane.INFORMATION_MESSAGE, 1000);

        } catch (SQLException e) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Gagal merestore surat!: " + e.getMessage(), null, JOptionPane.ERROR_MESSAGE, 30000);
        }
    }

    public ResultSet KodeTampilByFilters() throws SQLException {
        String query = "SELECT * FROM surat_masuk WHERE status = '1'";

        if (kategori != null && !kategori.isEmpty()) {
            query += " AND kategori = ?";
        }
        if (tgl_awal != null && tgl_akhir != null) {
            query += " AND tanggal_diterima BETWEEN ? AND ? ORDER BY tanggal_diterima ASC";
        }
        PreparedStatement ps = conn.prepareStatement(query);
        int paramIndex = 1;

        if (kategori != null && !kategori.isEmpty()) {
            ps.setString(paramIndex++, kategori);
        }
        if (tgl_awal != null && tgl_akhir != null) {
            ps.setDate(paramIndex++, tgl_awal);
            ps.setDate(paramIndex++, tgl_akhir);
        }
        return ps.executeQuery();
    }

    public ResultSet KodeTampilTabelSampahByFilters() throws SQLException {
        String query = "SELECT * FROM surat_masuk WHERE status = '0'";

        if (kategori != null && !kategori.isEmpty()) {
            query += " AND kategori = ?";
        }
        if (tgl_awal != null && tgl_akhir != null) {
            query += " AND tanggal_diterima BETWEEN ? AND ? ORDER BY tanggal_diterima ASC";
        }
        PreparedStatement ps = conn.prepareStatement(query);
        int paramIndex = 1;

        if (kategori != null && !kategori.isEmpty()) {
            ps.setString(paramIndex++, kategori);
        }
        if (tgl_awal != null && tgl_akhir != null) {
            ps.setDate(paramIndex++, tgl_awal);
            ps.setDate(paramIndex++, tgl_akhir);
        }
        return ps.executeQuery();
    }

    public ResultSet KodeCari() {
        ResultSet rs = null;
        String query = "SELECT * FROM surat_masuk WHERE (perihal LIKE ? OR pengirim LIKE ?) AND status = '1'";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            String keywordPattern = "%" + this.kata_kunci + "%";
            ps.setString(1, keywordPattern);
            ps.setString(2, keywordPattern);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return rs;
    }

    public ResultSet KodeCariTabelSampah() {
        ResultSet rs = null;
        String query = "SELECT * FROM surat_masuk WHERE (perihal LIKE ? OR pengirim LIKE ?) AND status = '0'";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            String keywordPattern = "%" + this.kata_kunci + "%";
            ps.setString(1, keywordPattern);
            ps.setString(2, keywordPattern);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return rs;
    }

    public String otoID() {

        LocalDate today = LocalDate.now();
        String todayFormatted = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String query = "SELECT id_suratmasuk FROM surat_masuk WHERE id_suratmasuk LIKE '" + todayFormatted + "%' ORDER BY id_suratmasuk DESC LIMIT 1";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastId = rs.getString("id_suratmasuk");
                int num = Integer.parseInt(lastId.substring(8)) + 1;
                String newId = todayFormatted + String.format("%03d", num);
                return newId;
            } else {

                return todayFormatted + "001";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to fetch next surat ID: " + ex.getMessage());
            return null;
        }
    }

    public int TampilJumlahSuratMasuk() {
        query = "SELECT COUNT(*) AS jumlah FROM surat_masuk";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }

            rs.close();
            st.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + sQLException.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return jumlah;
    }

    public ResultSet KodeSetUser() {
        try {
            query = "SET @user_login = ?;";
            ps = conn.prepareStatement(query);
            ps.setString(1, user_login);
            ps.executeUpdate();

        } catch (SQLException sQLException) {
            TimeJOption.AutoCloseJOptionPane.showMessageDialog("Data gagal ditampilkan", null, JOptionPane.ERROR_MESSAGE, 3000);
        }

        return rs;
    }

}
