package Kepegawaian.Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Yusron
 */
public class Jabatan {
    private static String id_jabatan, nama_jabatan;
    int jumlah = 0;
    
    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Jabatan() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public static String getId_jabatan() {
        return id_jabatan;
    }

    public static void setId_jabatan(String id_jabatan) {
        Jabatan.id_jabatan = id_jabatan;
    }

    public static String getNama_jabatan() {
        return nama_jabatan;
    }

    public static void setNama_jabatan(String nama_jabatan) {
        Jabatan.nama_jabatan = nama_jabatan;
    }
    
    public void tambahJabatan() {
        query = "INSERT INTO jabatan VALUES(?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_jabatan);
            ps.setString(2, nama_jabatan);
           

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }
    
    public ResultSet tampilJabatan() {
        query = "SELECT * FROM jabatan";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;
    }
    
    public void hapusJabatan() {
        query = "DELETE FROM jabatan WHERE id_jabatan = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, id_jabatan);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
        }
    }
    
    public void ubahJabatan() {

        query = "UPDATE jabatan "
                + "SET nama_jabatan = ? "
                + "WHERE id_jabatan = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_jabatan);
            ps.setString(2, id_jabatan);
            

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }
    
    public ResultSet tampilComBoxJabatan() {
        query = "SELECT nama_jabatan FROM jabatan";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    
    public ResultSet Konversi() {
        query = "SELECT id_jabatan FROM jabatan WHERE nama_jabatan = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_jabatan);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Pegawai.setId_jabatan(rs.getString("id_jabatan"));
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;
    }
    
        public String autoID() {
        String newID = "JBITM00001"; // Default jika tidak ada data
        query = "SELECT id_jabatan AS ID FROM jabatan ORDER BY id_jabatan DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("JBITM")) {
                    int num = Integer.parseInt(lastID.substring(6)); // Ambil angka setelah "DSNITM"
                    num++; // Increment angka
                    newID = String.format("JBITM%05d", num); // Format ke DSNITM00001, DSNITM00002, dst.
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }
        
    public int TampilJumlahJabatan() {
        query = "SELECT COUNT(*) AS jumlah FROM jabatan";

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
