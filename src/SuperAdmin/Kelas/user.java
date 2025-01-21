/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SuperAdmin.Kelas;

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
public class user {

    String id_user, nama_depan, nama_belakang, username, email, password;
    int privillage, priv_pembayaran, priv_perpustakaan, priv_kepegawaian, priv_surat, priv_bukuInduk, priv_inventaris;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public user() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrivillage() {
        return privillage;
    }

    public void setPrivillage(int privillage) {
        this.privillage = privillage;
    }

    public int getPriv_pembayaran() {
        return priv_pembayaran;
    }

    public void setPriv_pembayaran(int priv_pembayaran) {
        this.priv_pembayaran = priv_pembayaran;
    }

    public int getPriv_perpustakaan() {
        return priv_perpustakaan;
    }

    public void setPriv_perpustakaan(int priv_perpustakaan) {
        this.priv_perpustakaan = priv_perpustakaan;
    }

    public int getPriv_kepegawaian() {
        return priv_kepegawaian;
    }

    public void setPriv_kepegawaian(int priv_kepegawaian) {
        this.priv_kepegawaian = priv_kepegawaian;
    }

    public int getPriv_surat() {
        return priv_surat;
    }

    public void setPriv_surat(int priv_surat) {
        this.priv_surat = priv_surat;
    }

    public int getPriv_bukuInduk() {
        return priv_bukuInduk;
    }

    public void setPriv_bukuInduk(int priv_bukuInduk) {
        this.priv_bukuInduk = priv_bukuInduk;
    }

    public int getPriv_inventaris() {
        return priv_inventaris;
    }

    public void setPriv_inventaris(int priv_inventaris) {
        this.priv_inventaris = priv_inventaris;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void tambahUser() {
        query = "INSERT INTO user(id_user,nama_depan,nama_belakang,username,email,privillage,priv_pembayaran, priv_perpustakaan, priv_kepegawaian, "
                + "priv_surat, priv_bukuInduk, priv_inventaris, password)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,MD5(?))";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_user);
            ps.setString(2, nama_depan);
            ps.setString(3, nama_belakang);
            ps.setString(4, username);
            ps.setString(5, email);
            ps.setInt(6, privillage);
            ps.setInt(7, priv_pembayaran);
            ps.setInt(8, priv_perpustakaan);
            ps.setInt(9, priv_kepegawaian);
            ps.setInt(10, priv_surat);
            ps.setInt(11, priv_bukuInduk);
            ps.setInt(12, priv_inventaris);
            ps.setString(13, password);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "User Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "tambah Gagal");
            System.out.println(sQLException);
        }
    }

    public void login() {
        query = "SELECT * FROM user WHERE username = ? AND password = MD5(?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                session.setSesi("Aktif");
                session.setNama(rs.getString("nama_depan"));
                session.setUsername(rs.getString("username"));
                session.setPriv_bukuInduk(rs.getInt("priv_bukuInduk"));
                session.setPriv_inventaris(rs.getInt("priv_Inventaris"));
                session.setPriv_kepegawaian(rs.getInt("priv_kepegawaian"));
                session.setPriv_pembayaran(rs.getInt("priv_pembayaran"));
                session.setPriv_perpustakaan(rs.getInt("priv_perpustakaan"));
                session.setPriv_surat(rs.getInt("priv_surat"));
                session.setLevel(rs.getInt("privillage"));

            } else {
                session.setSesi("Tidak Aktif");
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Login");
        }
    }

    public void logOut() {
        session.setSesi("");
        session.setNama("");
        session.setUsername("");
        session.setPriv_bukuInduk(0);
        session.setPriv_inventaris(0);
        session.setPriv_kepegawaian(0);
        session.setPriv_pembayaran(0);
        session.setPriv_perpustakaan(0);
        session.setPriv_surat(0);
        session.setLevel(0);

    }

}
