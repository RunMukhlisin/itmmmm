/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pembayaran.Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author X1 Carbon
 */
public class jenis_pembayaran {

    private static String id_jenis, nama_jenis;
    private static int nominal;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public jenis_pembayaran() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.connectDb();
    }

    public static String getId_jenis() {
        return id_jenis;
    }

    public static void setId_jenis(String id_jenis) {
        jenis_pembayaran.id_jenis = id_jenis;
    }

    public static String getNama_jenis() {
        return nama_jenis;
    }

    public static void setNama_jenis(String nama_jenis) {
        jenis_pembayaran.nama_jenis = nama_jenis;
    }

    public static int getNominal() {
        return nominal;
    }

    public static void setNominal(int nominal) {
        jenis_pembayaran.nominal = nominal;
    }
 public ResultSet tampilComBox() {
        query = "SELECT nama_jenis FROM jenis_pembayaran where deleted = 0";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public ResultSet Konversi() {
        query = "SELECT id_jenis, nominal FROM jenis_pembayaran WHERE nama_jenis = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_jenis);

            rs = ps.executeQuery();
            if (rs.next()) {
                setId_jenis(rs.getString("id_jenis"));
                Pembayaran.setId_jenis(rs.getString("id_jenis"));
                setNominal(rs.getInt("nominal"));
            }
        } catch (SQLException sQLException) {
            System.out.println("gagal");
        }
        return rs;
    }

    public ResultSet Konversi2() {
        query = "SELECT id_jenis FROM jenis_pembayaran WHERE nama_jenis = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_jenis);

            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            System.out.println("gagal");
        }
        return rs;
    }

    public ResultSet tampilJenis() {
        query = "SELECT * FROM jenis_pembayaran where deleted = 0";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public ResultSet autoID() {
        query = "SELECT COUNT(*) AS id FROM jenis_pembayaran WHERE id_jenis = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_jenis);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            System.out.println("gagal");
        }
        return rs;
    }

    public void tambahJenis() {
        query = "INSERT INTO jenis_pembayaran(id_jenis,nama_jenis,nominal,deleted) VALUES(?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_jenis);
            ps.setString(2, nama_jenis);
            ps.setInt(3, nominal);
            ps.setInt(4, 0);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "tambah Berhasil");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "tambah Gagal");
        }
    }

    public void hapusJenis() {
        query = "UPDATE jenis_pembayaran SET deleted = 1 WHERE id_jenis = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_jenis);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "tambah Gagal");
        }
    }
    
    public void updateJenis() {
        query = "UPDATE jenis_pembayaran SET nama_jenis = ?, nominal = ? WHERE id_jenis = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_jenis);
            ps.setInt(2, nominal);
            ps.setString(3, id_jenis);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Berhasil Diubah");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "tambah Gagal");
        }
    }
}
