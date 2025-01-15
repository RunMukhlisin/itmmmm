package Kepegawaian.Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import SuperAdmin.koneksi;

/**
 *
 * @author Isna
 */
public class Kategori {
    private static String id_kategori, nama_kategori;
    int jumlah = 0;
    
    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Kategori() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public static String getId_kategori() {
        return id_kategori;
    }

    public static void setId_kategori(String id_kategori) {
        Kategori.id_kategori = id_kategori;
    }

    public static String getNama_kategori() {
        return nama_kategori;
    }

    public static void setNama_kategori(String nama_kategori) {
        Kategori.nama_kategori = nama_kategori;
    }
    
    public void tambahKategori() {
        query = "INSERT INTO kategori VALUES(?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_kategori);
            ps.setString(2, nama_kategori);
           

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }
    
    public ResultSet tampilKategori() {
        query = "SELECT * FROM kategori";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;
    }
    
    public void hapusKategori() {
        query = "DELETE FROM kategori WHERE id_kategori = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, id_kategori);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    }
    
    public void ubahKategori() {
        query = "UPDATE kategori "
                + "SET nama_kategori = ? "
                + "WHERE id_kategori = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_kategori);
            ps.setString(2, id_kategori);
            

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }
    
    public String autoID() {
        String newID = "KTITM00001"; // Default jika tidak ada data
        query = "SELECT id_kategori AS ID FROM kategori ORDER BY id_kategori DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("KTITM")) {
                    int num = Integer.parseInt(lastID.substring(6)); // Ambil angka setelah "DSNITM"
                    num++; // Increment angka
                    newID = String.format("KTITM%05d", num); // Format ke DSNITM00001, DSNITM00002, dst.
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }
    
    public ResultSet cariDevisi(String keyword) {
        query = "SELECT * FROM kategori WHERE "
                + "id_kategori LIKE ? OR "
                + "nama_kategori LIKE ?";

        try {
            ps = konek.prepareStatement(query);
            for (int i = 1; i <= 8; i++) { // Ada 8 kolom yang dicari
                ps.setString(i, "%" + keyword + "%"); // Wildcard pencarian untuk semua kolom
            }
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet tampilComBoxKategori() {
        query = "SELECT nama_kategori FROM kategori";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
    public ResultSet Konversi() {
        query = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_kategori);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Pegawai.setId_kategori(rs.getString("id_kategori"));
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;
    }
    
    public int TampilJumlahKategori() {
        query = "SELECT COUNT(*) AS jumlah FROM kategori";

        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }

            rs.close();
            st.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + sQLException.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return jumlah;
    }
}
