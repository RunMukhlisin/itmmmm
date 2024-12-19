
package Pembayaran.Kelas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
     private Connection connect_db;
   private String host = "localhost";
   private String db = "SistemPembayaran";
   private String user = "root";
   private String password = "Gotwice7";
   private String port = "3306";
   private String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
   
   public Connection connectDb() throws SQLException{
       
       try {
           connect_db = DriverManager.getConnection(url, user, password);
       } catch (SQLException sQLException) {
           System.out.println("Request TimeOut");
       }
       
       return connect_db;
   }
}
