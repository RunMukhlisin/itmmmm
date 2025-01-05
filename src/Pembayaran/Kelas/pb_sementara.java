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
 * @author Alxxstrdy
 */
public class pb_sementara {

    String nim, nama, prodi;
    int angkatan;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public pb_sementara() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public ResultSet tampil() {
        query = "SELECT * FROM pb_sementara";
        try {
            ps = konek.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public void tambah() {
        query = "INSERT INTO pb_sementara VALUES(?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(4, prodi);
            ps.setInt(3, angkatan);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }

    public void hapus1() {
        query = "DELETE FROM pb_sementara WHERE nim = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nim);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }
    
        public void hapus() {
        query = "DELETE FROM pb_sementara";
        try {
            ps = konek.prepareStatement(query);  
            ps.executeUpdate();
            ps.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }
}
