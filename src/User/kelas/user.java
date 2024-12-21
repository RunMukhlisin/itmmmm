package User.kelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class user {

    String userName, password, nama;
    int role, status;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public user() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void tambahUser() {
        query = "INSERT INTO user VALUES(?,?,MD5(?),?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, nama);
            ps.setString(3, password);
            ps.setInt(4, status);
            ps.setInt(5, role);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "user Berhasil Ditambahkan");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "user Gagal Ditambahkan");
        }
    }

    public ResultSet tampilUser() {

        query = "SELECT * FROM user";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public void hapusUser() {
        query = "DELETE FROM user WHERE username = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, userName);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "user Berhasil DiHapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "user Gagal DiHapus");
        }
    }

    public void ubahUser() {
        if (password.equals("")) {
            query = "UPDATE user SET "
                    + " nama = ?,"
                    + " role = ?,"
                    + " status = ?"
                    + " WHERE username = ?";
            try {

                ps = konek.prepareStatement(query);

                ps.setString(1, nama);
                ps.setInt(2, role);
                ps.setInt(3, status);
                ps.setString(4, userName);

                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "User Berhasil Di Ubah");

            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "user Gagal Di Ubah");
            }
        } else {
            query = "UPDATE useradmin SET "
                    + " password = MD5(?),"
                    + " nama = ?,"
                    + " role = ?,"
                    + " status = ?"
                    + " WHERE username = ?";
            try {

                ps = konek.prepareStatement(query);

                ps.setString(1, password);
                ps.setString(2, nama);
                ps.setInt(3, role);
                ps.setInt(4, status);
                ps.setString(5, userName);

                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "user Berhasil Di Ubah");

            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "user Gagal Di Ubah");
            }

        }
    }

    public ResultSet getRoole() {
        query = "SELECT role FROM user WHERE username = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, userName);

            rs = ps.executeQuery();
            System.out.println("data masuk");

        } catch (SQLException SQLException) {
            System.out.println("data tidak masuk");
        }
        return rs;
    }

    public void Login() {
        query = "SELECT * FROM user WHERE username = ? AND password = MD5(?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                sesi.setStatus("Aktif");
                sesi.setNama(rs.getString("nama"));
                sesi.setUsername(rs.getString("username"));
//                sesi.setStatus(String.valueOf(rs.getInt("status")));
            } else {
                sesi.setStatus("Tidak Aktif");
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Login");

        }
    }
}
