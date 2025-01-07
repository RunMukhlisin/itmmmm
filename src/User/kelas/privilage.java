
package User.kelas;

import Pembayaran.Kelas.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class privilage {
    String namaPrivilage;
    
        private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public privilage() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public String getNamaPrivilage() {
        return namaPrivilage;
    }

    public void setNamaPrivilage(String namaPrivilage) {
        this.namaPrivilage = namaPrivilage;
    }
    public ResultSet tampilPrivilege() {

        query = "SELECT * FROM privilege";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
}
