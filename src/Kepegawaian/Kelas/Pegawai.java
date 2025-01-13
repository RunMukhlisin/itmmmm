package Kepegawaian.Kelas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Revaldo
 */
public class Pegawai {
    private static String nik, nama, id_kategori, id_bagian, id_jabatan, nidn, jenis_kelamin, email, telepon, alamat, status; 
    private static Date tanggal_masuk;
    int jumlah = 0;
    
    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Pegawai() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public static String getNik() {
        return nik;
    }

    public static void setNik(String nik) {
        Pegawai.nik = nik;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Pegawai.nama = nama;
    }

    public static String getId_kategori() {
        return id_kategori;
    }

    public static void setId_kategori(String id_kategori) {
        Pegawai.id_kategori = id_kategori;
    }

    public static String getId_bagian() {
        return id_bagian;
    }

    public static void setId_bagian(String id_bagian) {
        Pegawai.id_bagian = id_bagian;
    }

    public static String getId_jabatan() {
        return id_jabatan;
    }

    public static void setId_jabatan(String id_jabatan) {
        Pegawai.id_jabatan = id_jabatan;
    }

    public static String getNidn() {
        return nidn;
    }

    public static void setNidn(String nidn) {
        Pegawai.nidn = nidn;
    }

    public static String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public static void setJenis_kelamin(String jenis_kelamin) {
        Pegawai.jenis_kelamin = jenis_kelamin;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Pegawai.email = email;
    }

    public static String getTelepon() {
        return telepon;
    }

    public static void setTelepon(String telepon) {
        Pegawai.telepon = telepon;
    }

    public static String getAlamat() {
        return alamat;
    }

    public static void setAlamat(String alamat) {
        Pegawai.alamat = alamat;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Pegawai.status = status;
    }

    public static Date getTanggal_masuk() {
        return tanggal_masuk;
    }

    public static void setTanggal_masuk(Date tanggal_masuk) {
        Pegawai.tanggal_masuk = tanggal_masuk;
    }

    public void tambahPegawai() {
        query = "INSERT INTO pegawai VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nik);
            ps.setString(2, nama);
            ps.setString(3, id_kategori);
            ps.setString(4, id_bagian);
            ps.setString(5, id_jabatan);
            ps.setString(6, nidn);
            ps.setString(7, jenis_kelamin);
            ps.setString(8, email);
            ps.setString(9, telepon);
            ps.setString(10, alamat);
            ps.setDate(11, tanggal_masuk);
            ps.setString(12, status);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
         
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
            System.out.println(sQLException);
        }
    }
    
    public ResultSet tampilPegawai() {
        query = "SELECT p.nik, p.nama, p.nidn, p.jenis_kelamin, p.email, p.telepon, p.alamat, p.tanggal_masuk, p.status, "+
                 "k.nama_kategori, b.nama_bagian, j.nama_jabatan "+
                 "FROM pegawai p "+
                 "JOIN kategori k ON p.id_kategori = k.id_kategori "+
                 "JOIN bagian b ON p.id_bagian = b.id_bagian "+
                 "JOIN jabatan j ON p.id_jabatan = j.id_jabatan ";
                System.out.println(query);
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            System.out.println("tampil");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
            System.out.println(sQLException);
        }

        return rs;
    }
    
    public void hapusPegawai() {
        query = "DELETE FROM pegawai WHERE nik = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, nik);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    }
    
    public void ubahPegawai() {
        query = "UPDATE pegawai "
                + "SET nama = ?, "
                + "id_kategori = ?, "
                + "id_bagian = ?, "
                + "id_jabatan = ?, "
                + "nidn = ?, "
                + "jenis_kelamin = ?, "
                + "email = ?, "
                + "telepon = ?, "
                + "alamat = ?, "
                + "tanggal_masuk = ?, "
                + "status = ? "
                + "WHERE nik = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama);
            ps.setString(2, id_kategori);
            ps.setString(3, id_bagian);
            ps.setString(4, id_jabatan);
            ps.setString(5, nidn);
            ps.setString(6, jenis_kelamin);
            ps.setString(7, email);
            ps.setString(8, telepon); 
            ps.setString(9, alamat);
            ps.setDate(10, tanggal_masuk);
            ps.setString(11, status);
            ps.setString(12, nik);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");
            

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            System.out.println(sQLException);
        }

    }
    
    public ResultSet cariPegawai(String keyword) {
        query = "SELECT * FROM pegawai WHERE "
                + "nama LIKE ?";
                
        try {
            ps = konek.prepareStatement(query);
            for (int i = 1; i <= 1; i++) { // Ada 8 kolom yang dicari
                ps.setString(i, "%" + keyword + "%"); // Wildcard pencarian untuk semua kolom
            }
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
        }
        return rs;
    }
    
    public int TampilJumlahPegawai() {
        query = "SELECT COUNT(*) AS jumlah FROM pegawai";

        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }

            rs.close();
            st.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan: " + sQLException.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return jumlah;
    }
    
}
