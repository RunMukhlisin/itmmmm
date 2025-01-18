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
//koneksi 
public class Anggota {
    int idAnggota;
    String nama,alamat,noHp,email,nim,nidm,nik;
    
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Anggota() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }
    

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNidm() {
        return nidm;
    }

    public void setNidm(String nidm) {
        this.nidm = nidm;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    
    
    public void tambahAnggota() {
         query = "INSERT INTO anggota (id_anggota,nama,alamat,nohp,email,nim,nidm,nik) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = konek.prepareStatement(query);
            ps.setInt(1, idAnggota);
            ps.setString(2, nama);
            ps.setString(3, alamat);
            ps.setString(4, noHp);
            ps.setString(5, email);
            ps.setString(6, nim);
            ps.setString(7, nidm);
            ps.setString(8, nik);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data anggota berhasil ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data anggota: " + e.getMessage());
        }
    }
    
    public int autoId() {
        int newID = 1;

        try {
            query = "SELECT MAX(ID_Anggota) AS max_id FROM anggota";
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
    
    public boolean hapusAnggota() {
    String query = "DELETE FROM anggota WHERE id_anggota = ?";
    try {
        ps = konek.prepareStatement(query);
        ps.setInt(1, this.idAnggota);
        int rowsAffected = ps.executeUpdate();
        ps.close();
        return rowsAffected > 0; 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menghapus anggota: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
    
    public ResultSet tampilAnggota() {
        
        query = "SELECT * FROM anggota";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
      
    public void ubahAnggota() {

        query = "UPDATE Anggota SET nama = ? "
                + " WHERE id_anggota = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, nama);
            ps.setInt(2, idAnggota);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Anggota Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Anggota Gagal Di Ubah");
        }

    }
    public ResultSet tampilAngka() {
        
        query = "SELECT COUNT(*)AS anggota FROM anggota";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
                        
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
        public ResultSet tampilSearch() {
        
        query = "SELECT * FROM anggota WHERE nim LIKE ? OR nidm LIKE ? OR nik LIKE ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nim);
            ps.setString(2, nidm);
            ps.setString(3, nik);
            
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
}

