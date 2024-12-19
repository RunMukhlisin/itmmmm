/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pembayaran.Kelas;

/**
 *
 * @author SayMukhlisin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Pembayaran {
private static String id_pembayaran, nim, id_jenis, nama_jenis, keterangan;
    private static int nominal_pembayaran, status, nominal_jenis;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Pembayaran() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.connectDb();
    }

    public static String getId_pembayaran() {
        return id_pembayaran;
    }

    public static void setId_pembayaran(String id_pembayaran) {
        Pembayaran.id_pembayaran = id_pembayaran;
    }

    public static String getNim() {
        return nim;
    }

    public static void setNim(String nim) {
        Pembayaran.nim = nim;
    }

    public static String getId_jenis() {
        return id_jenis;
    }

    public static void setId_jenis(String id_jenis) {
        Pembayaran.id_jenis = id_jenis;
    }

    public static String getKeterangan() {
        return keterangan;
    }

    public static void setKeterangan(String keterangan) {
        Pembayaran.keterangan = keterangan;
    }

    public static int getNominal_pembayaran() {
        return nominal_pembayaran;
    }

    public static void setNominal_pembayaran(int nominal_pembayaran) {
        Pembayaran.nominal_pembayaran = nominal_pembayaran;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        Pembayaran.status = status;
    }

    public static String getNama_jenis() {
        return nama_jenis;
    }

    public static void setNama_jenis(String nama_jenis) {
        Pembayaran.nama_jenis = nama_jenis;
    }

    public static int getNominal_jenis() {
        return nominal_jenis;
    }

    public static void setNominal_jenis(int nominal_jenis) {
        Pembayaran.nominal_jenis = nominal_jenis;
    }

    
        public ResultSet history() {
        query = "SELECT p.id_pembayaran AS 'ID Pembayaran', p.nim AS 'NIM', COALESCE(j.nama_jenis, p.nama_jenis) AS 'Nama Jenis', p.nominal_pembayaran AS 'Nominal Dibayar',p.tanggal AS 'Tanggal', CASE WHEN p.status = 1 THEN 'LUNAS' ELSE 'BELUM LUNAS' END AS 'Status' FROM pembayaran p LEFT JOIN jenis_pembayaran j ON p.id_jenis = j.id_jenis ORDER BY p.tanggal DESC";
        try {
            ps = konek.prepareStatement(query);
            rs = ps.executeQuery();
//            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }
        
                public ResultSet historyIni() {
        query = "SELECT p.id_pembayaran AS 'ID Pembayaran', p.nim AS 'NIM', COALESCE(j.nama_jenis, p.nama_jenis) AS 'Nama Jenis', p.nominal_pembayaran AS 'Nominal Dibayar',p.tanggal AS 'Tanggal', CASE WHEN p.status = 1 THEN 'LUNAS' ELSE 'BELUM LUNAS' END AS 'Status' FROM pembayaran p LEFT JOIN jenis_pembayaran j ON p.id_jenis = j.id_jenis ORDER BY p.tanggal DESC LIMIT 10";
        try {
            ps = konek.prepareStatement(query);
            rs = ps.executeQuery();
//            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public ResultSet tampilUt() {
        query = "SELECT p.id_pembayaran AS 'ID Pembayaran', COALESCE(j.nama_jenis, p.nama_jenis) AS 'Nama Jenis', p.nominal_pembayaran AS 'Nominal Dibayar',COALESCE(j.nominal, p.nominal_jenis) AS 'Nominal',p.keterangan AS 'Keterangan',CASE WHEN p.status = 1 THEN 'LUNAS' ELSE 'BELUM LUNAS' END AS 'Status' FROM pembayaran p LEFT JOIN jenis_pembayaran j ON p.id_jenis = j.id_jenis WHERE p.nim = ? ";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nim);

            rs = ps.executeQuery();
            System.out.println("data utama masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public void tambahPemUt() {
        query = "INSERT INTO pembayaran(id_pembayaran,nim,id_jenis,nominal_pembayaran,status,keterangan) VALUES(?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_pembayaran);
            ps.setString(2, nim);
            ps.setString(3, id_jenis);
            ps.setInt(4, nominal_pembayaran);
            ps.setInt(5, status);
            ps.setString(6, keterangan);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Pembayaran Gagal");
        }
    }

    public void tambahPemKhu() {
        query = "INSERT INTO pembayaran(id_pembayaran,nim,nama_jenis,nominal_jenis,nominal_pembayaran,status,keterangan) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_pembayaran);
            ps.setString(2, nim);
            ps.setString(3, nama_jenis);
            ps.setInt(4, nominal_jenis);
            ps.setInt(5, nominal_pembayaran);
            ps.setInt(6, status);
            ps.setString(7, keterangan);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Pembayaran Gagal");
            System.out.println(sQLException);
        }
    }

    public void bayarCicilan() {

        query = "UPDATE pembayaran set nominal_pembayaran = ?, keterangan = ?, status = ?, tanggal = current_timestamp() WHERE id_pembayaran = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setInt(1, nominal_pembayaran);
            ps.setString(2, keterangan);
            ps.setInt(3, status);
            ps.setString(4, id_pembayaran);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
        } catch (SQLException sQLException) {
            System.out.println("gagal");
        }
    }


    public ResultSet autoID() {
        query = "SELECT id_pembayaran FROM pembayaran ORDER BY id_pembayaran DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
        public ResultSet TampilMhs() {
        query = "SELECT COUNT(DISTINCT nim) AS 'NIM' FROM pembayaran";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
        
        public ResultSet TampilHariIni() {
        query = "SELECT SUM(nominal_pembayaran) AS 'Hari Ini'  FROM pembayaran WHERE DATE(tanggal) = CURDATE(); ";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
        
        public ResultSet tampilTotal() {
        query = "SELECT SUM(nominal_pembayaran) AS 'Total' FROM pembayaran";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
}
