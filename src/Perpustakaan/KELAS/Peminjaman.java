/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Perpustakaan.KELAS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import SuperAdmin.Kelas.koneksi;

/**
 *
 * @author WINDOWS 10
 */
public class Peminjaman {
    int idPeminjam,jumlahPinjam;
    String nimNidn,namaPeminjam,kodeBarang,namaBarang,judul,status;
    java.sql.Date tanggalPinjam,tanggalKembali;
    private static String kembali;
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Peminjaman() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb() ;
    }

    public static String getKembali() {
        return kembali;
    }

    public static void setKembali(String kembali) {
        Peminjaman.kembali = kembali;
    }
    
    public int getIdPeminjam() {
        return idPeminjam;
    }

    public void setIdPeminjam(int idPeminjam) {
        this.idPeminjam = idPeminjam;
    }

    public int getJumlahPinjam() {
        return jumlahPinjam;
    }

    public void setJumlahPinjam(int jumlahPinjam) {
        this.jumlahPinjam = jumlahPinjam;
    }

    public String getNimNidn() {
        return nimNidn;
    }

    public void setNimNidn(String nimNidn) {
        this.nimNidn = nimNidn;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public Connection getKonek() {
        return konek;
    }

    public void setKonek(Connection konek) {
        this.konek = konek;
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
    

    public int autoId() {
        int newID = 1;

        try {
            query = "SELECT MAX(id_peminjam) AS max_id FROM peminjam";
            Statement st = konek.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                String lastNoUrut = rs.getString("max_id");

                if (lastNoUrut != null && !lastNoUrut.isEmpty()) {
                    String numericPart = lastNoUrut.split("\\.")[0];
                    newID = Integer.parseInt(numericPart) + 1;
                }
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghasilkan nomor urut baru!");
            e.printStackTrace();
        }

        return newID;
    }
    
    public ResultSet tampilPeminjaman() {
    ResultSet rs = null; 
    String query = "SELECT * FROM peminjam";
    try {
        // Membuat statement untuk menjalankan query
        st = konek.createStatement();

        // Menjalankan query dan menyimpan hasilnya ke ResultSet
        rs = st.executeQuery(query);
    } catch (SQLException e) {
        // Menampilkan pesan kesalahan dengan informasi lebih spesifik
        JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + e.getMessage());
    }

    // Mengembalikan hasil query
    return rs;
}
    
    public void tambahPeminjaman() {
        query = "INSERT INTO Peminjam (id_peminjam,tanggal_pinjam,tanggal_kembali,nim_nidn,nama_peminjam,kode_barang,nama_barang,judul,jumlah_pinjam,status) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setInt(1, idPeminjam);
            ps.setDate(2, tanggalPinjam);
            ps.setDate(3, tanggalKembali);
            ps.setString(4, nimNidn);
            ps.setString(5, namaPeminjam);
            ps.setString(6, kodeBarang);
            ps.setString(7, namaBarang);
            ps.setString(8, judul);
            ps.setInt(9, jumlahPinjam);
            ps.setString(10, status);
           // ps.setString(10, status);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data peminjaman berhasil ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data peminjaman: " + e.getMessage());
        }
    }
    

    public void hapusPeminjaman() {
        query = "DELETE FROM peminjam WHERE id_peminjam = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, idPeminjam);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Peminjam Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Peminjam Gagal Di Hapus");
        }
    }
    
    public void ubahPeminjaman() {

        query = "UPDATE peminjam SET tanggal_pinjam = ?, tanggal_kembali = ?, nim_nidn = ?, nama_peminjam = ?, kode_barang = ?, nama_barang = ?, judul = ?, jumlah_pinjam, status = ?, = ? WHERE id_peminjam = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, idPeminjam);
            ps.setDate(2, tanggalPinjam);
            ps.setDate(3, tanggalKembali);
            ps.setString(4, nimNidn);
            ps.setString(5, namaPeminjam);
            ps.setString(6, kodeBarang);
            ps.setString(7, namaBarang);
            ps.setString(8, judul);
            ps.setInt(9, jumlahPinjam);
            ps.setString(10, status);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Peminjam Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Peminjam Gagal Di Ubah");
        }

    }
    public ResultSet tampilAngka() {
        
        query = "SELECT COUNT(*)AS peminjam FROM peminjam";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    

}
