/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Perpustakaan.KELAS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import SuperAdmin.Kelas.koneksi;
/**
 *
 * @author WINDOWS 10
 */
public class Kategori {
     private static int id_kategori;
     private static String nama_kategori;
     
     private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Kategori() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public static int getId_kategori() {
        return id_kategori;
    }

    public static void setId_kategori(int id_kategori) {
        Kategori.id_kategori = id_kategori;
    }


    public static String getNama_kategori() {
        return nama_kategori;
    }

    public static void setNama_kategori(String nama_kategori) {
        Kategori.nama_kategori = nama_kategori;
    }


    
    public int autoId() {
        int newID = 1;

        try {
            query = "SELECT MAX(id_kategori) AS max_id FROM kategori";
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
            JOptionPane.showMessageDialog(null, "Gagal menghasilkan nomor kategori baru!");
            e.printStackTrace();
        }

        return newID;
    }
    
    public void tambahKategori() {
        query = "INSERT INTO kategori (id_kategori,nama_kategori) VALUES (?, ?)";

        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setInt(1, id_kategori);
            ps.setString(2, nama_kategori);
            

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data kategori berhasil ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data kategori: " + e.getMessage());
        }
    }

     public ResultSet tampilKategori() {
        
        query = "SELECT * FROM kategori ";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
     
     public void hapusKategori() {
        query = "DELETE FROM kategori WHERE id_kategori = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, id_kategori);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Kategori Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Kategori Gagal Di Hapus");
        }
    }
     
     public void ubahKategori() {

        query = "UPDATE kategori SET nama_kategori = ? "
                + " WHERE id_kategori = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, nama_kategori);
            ps.setInt(2, id_kategori);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Ketegori Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Kategori Gagal Di Ubah");
        }

    }
     
     public ResultSet tampilComboBox() {
        try {
            query = "SELECT nama_kategori FROM kategori";
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;

    }
     public ResultSet tampilAngka() {
        
        query = "SELECT COUNT(*)AS kategori FROM kategori";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
}
