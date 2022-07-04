package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rani
 */
public class KoneksiDB {
    
        /**Creates a new instance of KoneksiDB */
        public KoneksiDB() {}
    
        public Connection openConnection() {
            Connection connection = null;

            //Define Connection
            String jdbcURL = "jdbc:mysql://localhost:3306/uts";
            String username = "root";
            String password = "jimin13";
        
            try {
                //open connection
                connection = DriverManager.getConnection(jdbcURL, username, password);

                //check apakah koneksi berhasil
                if (connection != null) {
                    System.out.println("Connected to database");
                    return connection;
                } else {
                    System.out.println("Gagal koneksi ke database!");
                    return null;
                }
            } catch (SQLException ex){
                ex.printStackTrace();
            }
            return null;
    }
}
