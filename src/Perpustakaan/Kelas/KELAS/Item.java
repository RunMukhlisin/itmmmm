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
public class Item {
    int idItem,tahunTerbit,jumlah;
    String kategori,lemari,namaBarang,penulis,file;
    
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Item() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getLemari() {
        return lemari;
    }

    public void setLemari(String lemari) {
        this.lemari = lemari;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    
    
    public int autoId() {
        int newID = 1;

        try {
            query = "SELECT MAX(id_item) AS max_id FROM menu_item";
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
    
    public void hapusItem() {
        query = "DELETE FROM menu_item WHERE id_item = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, idItem);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Item Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Item Gagal Di Hapus");
        }
    }
    
    public void tambahItem() {
        query = "INSERT INTO menu_item (id_item, nama_kategori, lemari, nama_barang, penulis, tahun_terbit, jumlah, file) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setInt(1, idItem);
            ps.setString(2, kategori);
            ps.setString(3, lemari);
            ps.setString(4, namaBarang);
            ps.setString(5, penulis);
            ps.setInt(6, tahunTerbit);
            ps.setInt(7, jumlah);
            ps.setString(8, file);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data item berhasil ditambahkan");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
     public ResultSet tampilItem() {
    query = "SELECT * from menu_item"; // Sesuaikan kolom penghubung
    try {
        st = konek.createStatement();
        rs = st.executeQuery(query);
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
    }
    return rs;
}

    
    public void ubahItem() {

        query = "UPDATE menu_item SET nama_barang = ? "
                + " WHERE id_item = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, namaBarang);
            ps.setInt(2, idItem);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "item Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "item Gagal Di Ubah");
        }

    }
    public ResultSet tampilAngka() {
        
        query = "SELECT COUNT(*)AS item FROM menu_item";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
    public ResultSet Item() {
        
        query = "SELECT nama_barang FROM menu_item";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
        public ResultSet ubahID(){
        
        query = "SELECT id_item FROM menu_item WHERE nama_barang = ?";
        try{
            ps = konek.prepareStatement(query);
            ps.setString(1, namaBarang);
            rs = ps.executeQuery();
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return rs;
    }

   }
