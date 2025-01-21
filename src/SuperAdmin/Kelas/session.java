/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SuperAdmin.Kelas;

/**
 *
 * @author SayMukhlisin
 */
public class session {
    private static String username, nama, sesi;
    private static int priv_pembayaran, priv_perpustakaan, priv_kepegawaian, priv_surat, priv_bukuInduk, priv_inventaris, level;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        session.username = username;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        session.nama = nama;
    }

    public static String getSesi() {
        return sesi;
    }

    public static void setSesi(String sesi) {
        session.sesi = sesi;
    }

    public static int getPriv_pembayaran() {
        return priv_pembayaran;
    }

    public static void setPriv_pembayaran(int priv_pembayaran) {
        session.priv_pembayaran = priv_pembayaran;
    }

    public static int getPriv_perpustakaan() {
        return priv_perpustakaan; 
    }

    public static void setPriv_perpustakaan(int priv_perpustakaan) {
        session.priv_perpustakaan = priv_perpustakaan;
    }

    public static int getPriv_kepegawaian() {
        return priv_kepegawaian;
    }

    public static void setPriv_kepegawaian(int priv_kepegawaian) {
        session.priv_kepegawaian = priv_kepegawaian;
    }

    public static int getPriv_surat() {
        return priv_surat;
    }

    public static void setPriv_surat(int priv_surat) {
        session.priv_surat = priv_surat;
    }

    public static int getPriv_bukuInduk() {
        return priv_bukuInduk;
    }

    public static void setPriv_bukuInduk(int priv_bukuInduk) {
        session.priv_bukuInduk = priv_bukuInduk;
    }

    public static int getPriv_inventaris() {
        return priv_inventaris;
    }

    public static void setPriv_inventaris(int priv_inventaris) {
        session.priv_inventaris = priv_inventaris;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        session.level = level;
    }
    
    
}
