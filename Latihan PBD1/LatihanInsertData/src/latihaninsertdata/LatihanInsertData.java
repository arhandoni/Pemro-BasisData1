package latihaninsertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rani
 */
public class LatihanInsertData {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/uts";
        String username = "root";
        String password = "jimin13";
        
        try {
            //open connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null){
                System.out.println("Connected to database");
                
            // proses insert data
            String sql = "INSERT INTO dosen (nidn, nama, alamat, jenis_kelamin)"
                        + "VALUES (959595, 'Mr Park', 'jln kasih','Laki-laki')";
                                            
                Statement statement = connection.createStatement();
                int rows = statement.executeUpdate(sql);
                                
                // chek berhasil insert atau tidak
                if (rows > 0) {
                    System.out.println("Data berhasil disimpan!");
                } else {
                    System.out.println ("Data gagal disimpan!");
                }
            }
        }catch (SQLException ex){
        }
    }
}

