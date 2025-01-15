package Inventaris.Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import SuperAdmin.koneksi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Barang {

    int jumlah;

    String id_barang, id_vendor, id_kategori, nama_barang, merk, status, jenis;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Barang() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.connectDb();
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(String id_vendor) {
        this.id_vendor = id_vendor;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void tambahBarang() {
        query = "INSERT INTO barang VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_barang);
            ps.setString(2, nama_barang);
            ps.setString(3, merk);
            ps.setString(4, id_vendor);
            ps.setString(5, id_kategori);
            ps.setString(6, status);
            ps.setString(7, jenis);
            ps.setInt(8, jumlah);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }


    public ResultSet tampilBarang() {
        query = "SELECT "
                + "b.id_barang AS ID, "
                + "b.nama_barang AS Nama, "
                + "b.merk AS Merk, "
                + "v.nama_vendor AS Vendor, "
                + "k.nama_kategori AS Kategori, "
                + "b.status AS Status, "
                + "b.jenis AS Jenis, "
                + "b.jumlah AS Jumlah, "
                + "CASE "
                + "    WHEN SUM(p.jumlah) > 0 THEN CONCAT('Dipinjam : ', SUM(p.jumlah)) "
                + "    ELSE 'Tersedia' "
                + "END AS Kondisi "
                + "FROM barang b "
                + "JOIN vendor v ON b.id_vendor = v.id_vendor "
                + "JOIN kategori k ON b.id_kategori = k.id_kategori "
                + "LEFT JOIN peminjaman p ON b.id_barang = p.id_barang AND p.status = 'Dipinjam' "
                + "GROUP BY b.id_barang, b.nama_barang, b.merk, v.nama_vendor, k.nama_kategori, b.status, b.jenis, b.jumlah";

        try {
            System.out.println("Query: " + query);
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            System.out.println(sQLException);
        }
        return rs;
    }

    public void hapusBarang() {
        query = "DELETE FROM barang WHERE id_barang = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_barang);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }

    public void ubahBarang() {

        query = "UPDATE barang "
                + "SET nama_barang = ?, "
                + "merk = ?, "
                + "id_vendor = ?, "
                + "id_kategori = ?, "
                + "status = ?, "
                + "jenis = ?, "
                + "jumlah = ? "
                + "WHERE id_barang = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_barang);
            ps.setString(2, merk);
            ps.setString(3, id_vendor);
            ps.setString(4, id_kategori);
            ps.setString(5, status);
            ps.setString(6, jenis);
            ps.setInt(7, jumlah);
            ps.setString(8, id_barang);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }

    public String getVendorID(String vendorName) {
        String vendorID = "";
        query = "SELECT id_vendor FROM vendor WHERE nama_vendor = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, vendorName);
            rs = ps.executeQuery();
            if (rs.next()) {
                vendorID = rs.getString("id_vendor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendorID;
    }

    public String getKategoriID(String kategoriName) {
        String kategoriID = "";
        query = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, kategoriName);
            rs = ps.executeQuery();
            if (rs.next()) {
                kategoriID = rs.getString("id_kategori");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategoriID;
    }

    public String generateAutoID() {
        String autoID = "";
        query = "SELECT MAX(id_barang) AS maxID FROM barang";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String maxID = rs.getString("maxID");
                if (maxID == null) {
                    autoID = "001"; // ID pertama
                } else {
                    int id = Integer.parseInt(maxID.substring(maxID.length() - 3)) + 1;
                    autoID = String.format("%03d", id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autoID;
    }

    public String generateFullID(String vendorName, String kategoriName) {
        String vendorID = getVendorID(vendorName);
        String kategoriID = getKategoriID(kategoriName);
        String autoID = generateAutoID(); // Generate ID baru untuk penambahan barang
        return vendorID + kategoriID + autoID;
    }

    public ResultSet tampilComBoxBarang() {
        query = "SELECT nama_barang FROM barang WHERE jenis = 'Boleh Dipinjam'";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return rs;
    }

    public ResultSet KonversiBarang() {
        query = "SELECT id_barang FROM barang WHERE nama_barang = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_barang);

            rs = ps.executeQuery();
            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public int getJumlahBarang(String namaBarang) throws SQLException {
        query = "SELECT jumlah FROM barang WHERE nama_barang = ?";
        int stok = 0;

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, namaBarang);
            rs = ps.executeQuery();

            if (rs.next()) {
                stok = rs.getInt("jumlah");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return stok;
    }

    public ResultSet cariBarang(String keyword) {
        query = "SELECT b.id_barang, b.nama_barang, b.merk, b.status, b.jenis, b.jumlah, "
                + "v.nama_vendor, k.nama_kategori "
                + "FROM barang b "
                + "JOIN vendor v ON b.id_vendor = v.id_vendor "
                + "JOIN kategori k ON b.id_kategori = k.id_kategori "
                + "WHERE b.id_barang LIKE ? OR "
                + "b.nama_barang LIKE ? OR "
                + "b.merk LIKE ? OR "
                + "b.status LIKE ? OR "
                + "b.jenis LIKE ? OR "
                + "v.nama_vendor LIKE ? OR "
                + "k.nama_kategori LIKE ?";

        try {
            ps = konek.prepareStatement(query);

            // Mengisi parameter pencarian dengan keyword untuk semua kolom
            for (int i = 1; i <= 7; i++) {
                ps.setString(i, "%" + keyword + "%");
            }

            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
        }
        return rs;
    }


    public DefaultTableModel getLaporanBarang(String keyword) {
    DefaultTableModel model = new DefaultTableModel();

    // Menambahkan kolom ke tabel model
    model.addColumn("Nama Barang");
    model.addColumn("Total Barang");
    model.addColumn("Sedang Dipinjam");
    model.addColumn("Sisa Barang");

    try {
        String query = """
            SELECT 
                b.nama_barang, 
                b.jumlah AS total_barang, 
                COALESCE(SUM(p.jumlah), 0) AS sedang_dipinjam,
                (b.jumlah - COALESCE(SUM(p.jumlah), 0)) AS sisa_barang
            FROM 
                barang b
            LEFT JOIN 
                peminjaman p ON b.id_barang = p.id_barang AND p.status = 'Dipinjam'
            WHERE 
                b.jenis = 'Boleh Dipinjam' 
                AND b.nama_barang LIKE ? -- Tambahkan filter nama barang
            GROUP BY 
                b.id_barang, b.nama_barang, b.jumlah
        """;

        PreparedStatement ps = konek.prepareStatement(query);
        ps.setString(1, "%" + keyword + "%"); // Gunakan wildcard untuk pencarian
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String namaBarang = rs.getString("nama_barang");
            int totalBarang = rs.getInt("total_barang");
            int sedangDipinjam = rs.getInt("sedang_dipinjam");
            int sisaBarang = rs.getInt("sisa_barang");

            // Menambahkan data ke model tabel
            model.addRow(new Object[]{namaBarang, totalBarang, sedangDipinjam, sisaBarang});
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return model;
}


    public int TampilJumlahBarangBaru() {
    int jumlah = 0;
    String query = "SELECT SUM(jumlah) AS total_jumlah FROM barang WHERE status = 'Baru'";

    try {
        st = konek.createStatement();
        rs = st.executeQuery(query);

        if (rs.next()) {
            jumlah = rs.getInt("total_jumlah");
        }

        rs.close();
        st.close();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + sQLException.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    return jumlah;
}


    public int TampilJumlahBarangSecond() {
    String query = "SELECT SUM(jumlah) AS total_jumlah FROM barang WHERE status = 'Bekas'";
    int jumlah = 0;

    try {
        st = konek.createStatement();
        rs = st.executeQuery(query);

        if (rs.next()) {
            jumlah = rs.getInt("total_jumlah");
        }

        rs.close();
        st.close();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + sQLException.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    return jumlah;
}


    public int TampilJumlahBarang() {
    int jumlah = 0;
    String query = "SELECT SUM(jumlah) AS total_jumlah FROM barang";  // Menggunakan SUM untuk menghitung total kuantitas barang

    try {
        st = konek.createStatement();
        rs = st.executeQuery(query);

        if (rs.next()) {
            jumlah = rs.getInt("total_jumlah");
        }

        rs.close();
        st.close();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + sQLException.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    return jumlah;
}


    public int getStokBrg(String namaBarang) {
        String query = "SELECT jumlah FROM barang WHERE nama_barang = ?";
        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setString(1, namaBarang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("jumlah");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan stok barang: " + ex.getMessage());
        }
        return 0; // Default jika data tidak ditemukan
    }

    public int getTotalBarangDipinjam(String namaBarang) {
        String query = "SELECT SUM(jumlah) AS totalDipinjam FROM peminjaman "
                + "WHERE id_barang = (SELECT id_barang FROM barang WHERE nama_barang = ?) "
                + "AND status = 'Dipinjam'";
        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setString(1, namaBarang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalDipinjam");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan total barang dipinjam: " + ex.getMessage());
        }
        return 0; // Default jika data tidak ditemukan
    }

}
