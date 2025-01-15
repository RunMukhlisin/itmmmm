package Kepegawaian.Kelas;

import SuperAdmin.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lutfi
 */
public class Bagian {
    private static String id_bagian, nama_bagian;
    int jumlah = 0;
    
    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Bagian() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public static String getId_bagian() {
        return id_bagian;
    }

    public static void setId_bagian(String id_bagian) {
        Bagian.id_bagian = id_bagian;
    }

    public static String getNama_bagian() {
        return nama_bagian;
    }

    public static void setNama_bagian(String nama_bagian) {
        Bagian.nama_bagian = nama_bagian;
    }
    
    public void tambahBagian() {
        query = "INSERT INTO bagian VALUES(?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_bagian);
            ps.setString(2, nama_bagian);
           

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
            System.out.println(sQLException);
        }
    }
    
    public ResultSet tampilBagian() {
        query = "SELECT * FROM bagian";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;
    }
    
    public void hapusBagian() {
        query = "DELETE FROM Bagian WHERE id_bagian = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, id_bagian);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
            System.out.println(sQLException);
        }
    }
    
    public void ubahBagian() {
        query = "UPDATE bagian "
                + "SET nama_bagian = ? "
                + "WHERE id_bagian = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_bagian);
            ps.setString(2, id_bagian);
            

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }
    
    public ResultSet cariBagian(String keyword) {
        query = "SELECT * FROM bagian WHERE "
                + "id_bagian LIKE ? OR "
                + "nama_bagian LIKE ?";

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
    
    public ResultSet tampilComBoxBagian() {
        query = "SELECT nama_bagian FROM bagian";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
    public ResultSet Konversi() {
        query = "SELECT id_bagian FROM bagian WHERE nama_bagian = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_bagian);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Pegawai.setId_bagian(rs.getString("id_bagian"));
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;
    }
    
        public String autoID() {
        String newID = "BGITM00001"; // Default jika tidak ada data
        query = "SELECT id_bagian AS ID FROM bagian ORDER BY id_bagian DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("BGITM")) {
                    int num = Integer.parseInt(lastID.substring(6)); // Ambil angka setelah "DSNITM"
                    num++; // Increment angka
                    newID = String.format("BGITM%05d", num); // Format ke DSNITM00001, DSNITM00002, dst.
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }
        
        public int TampilJumlahBagian() {
        query = "SELECT COUNT(*) AS jumlah FROM bagian";

        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }

            rs.close();
            st.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan: " + sQLException.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return jumlah;
    }
}
