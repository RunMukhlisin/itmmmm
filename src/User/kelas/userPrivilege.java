package User.kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class userPrivilege {

    String username;
    int idPrivilege;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public userPrivilege() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdPrivilege() {
        return idPrivilege;
    }

    public void setIdPrivilege(int idPrivilege) {
        this.idPrivilege = idPrivilege;
    }

    public void tambahUserPrivilege() {
        query = "INSERT INTO userprivilege (id_privilege,username) VALUES(?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setInt(1, idPrivilege);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "user Berhasil Ditambahkan");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "user Gagal Ditambahkan");
            System.out.println(sQLException);
        }
    }

    public ResultSet loadUserPrivilege() {

            query = "SELECT p.nama_privilege FROM userprivilege up JOIN privilege p ON up.id_privilege = p.id_privilege WHERE up.username = ?";
             try {
            ps = konek.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();
            System.out.println("data masuk");

        } catch (SQLException SQLException) {
            System.out.println("data tidak masuk");
        }
        return rs;
    }

}
