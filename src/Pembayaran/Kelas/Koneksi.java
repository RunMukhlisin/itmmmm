
package Pembayaran.Kelas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
     private Connection connect_db;
   private String host = "37.27.90.134";
   private String db = "w_16sup";
   private String user = "w_16pus";
   private String password = ")bzA4idQj(NPjE4f";
   private String port = "3306";
   private String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
      private static int status;

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        Koneksi.status = status;
    }
   public Connection connectDb() throws SQLException{
       
       try {
           connect_db = DriverManager.getConnection(url, user, password);
           setStatus(1);
       } catch (SQLException sQLException) {
           System.out.println("Request TimeOut");
           setStatus(0);
       }
       
       return connect_db;
   }
}
