/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User.kelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 
 * @author USER
 */
public class koneksi {


    private Connection konekSQL;
    private String host = "37.27.90.134";
    private String db = "w_16sup";
    private String user = "w_16pus";
    private String password = ")bzA4idQj(NPjE4f";
    private String port = "3306";
    private String url = "jdbc:mysql://"+host+":"+port+"/"+db;
    
    public Connection konekDB () throws SQLException{
        try {
            konekSQL = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException sQLException) {
            System.out.println("Koneksi Gagal");
        } 
        return konekSQL;
    
    }
    
}

    
