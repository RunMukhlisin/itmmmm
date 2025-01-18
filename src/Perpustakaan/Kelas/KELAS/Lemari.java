/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Perpustakaan.Kelas.KELAS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS 10
 */
public class Lemari {
    String id_lemari,lemari,rak,judul,tahun_terbit,jumlah;
    
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Lemari() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }

    public String getId_lemari() {
        return id_lemari;
    }

    public void setId_lemari(String id_lemari) {
        this.id_lemari = id_lemari;
    }

    public String getLemari() {
        return lemari;
    }

    public void setLemari(String lemari) {
        this.lemari = lemari;
    }

    public String getRak() {
        return rak;
    }

    public void setRak(String rak) {
        this.rak = rak;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(String tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    
    
    public void tambahLemari() {
        query = "INSERT INTO lemari (id_lemari,lemari,rak,judul,jumlah,tahun_terbit) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setString(1, id_lemari);
            ps.setString(2, lemari);
            ps.setString(3, rak);
            ps.setString(4, judul);
            ps.setString(5, jumlah);
            ps.setString(6, tahun_terbit);
            

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data lemari berhasil ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data lemari: " + e.getMessage());
        }
    }
    
    public int autoId() {
        int newID = 1;

        try {
            String query = "SELECT MAX(id_lemari) AS max_id FROM lemari";
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
    
    public ResultSet tampilLemari() {
        
        query = "SELECT * FROM lemari ";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
    public void hapusLemari() {
        query = "DELETE FROM lemari WHERE id_lemari = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, id_lemari);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Lemari Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Lemari Gagal Di Hapus");
        }
    }
    
    public void ubahLemari() {

        query = "UPDATE lemari SET rak = ? "
                + " WHERE id_lemari = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, lemari);
            ps.setString(2, rak);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Lemari Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Lemari Gagal Di Ubah");
        }

    }
    public ResultSet tampilAngka() {
        
        query = "SELECT COUNT(*)AS lemari FROM lemari";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
}
