package User.kelas;

import Pembayaran.Kelas.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userPrivilege {

    String username;
    int idPrivilege;

    private Connection konek;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public userPrivilege() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.connectDb();
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

        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
    }
    public void ubahUserPrivilege() {
        query = "UPDATE userprivilege SET id_privilege = ? WHERE username = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setInt(1, idPrivilege);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
    }
    


    public ResultSet loadUserPrivilege() {

            query = "SELECT p.nama_privilege FROM userprivilege up JOIN privilege p ON up.id_privilege = p.id_privilege WHERE up.username = ?";
             try {
            ps = konek.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();
            System.out.println("data masuk userPrivilege");

        } catch (SQLException SQLException) {
            System.out.println("data tidak masuk userPrivilege");
        }
        return rs;
    }

}
