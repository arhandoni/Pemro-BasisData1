package latihanupdatedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rani
 */
public class LatihanUpdateData {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/uts";
        String username ="root";
        String password ="jimin13";
        
        try{
            //open connection
            Connection connection =DriverManager.getConnection(jdbcURL, username, password);
            //cek connection berhasil
            if (connection !=null){
                System.out.println("connected to Database");
                
                //update data
                String sql = "Update dosen SET alamat = 'jl cinta' WHERE nidn = 959595";
                Statement statement = connection.createStatement();
                int rows = statement.executeUpdate(sql);
                
                //cek berhasil atau tidak
                if (rows >0) {
                    System.out.println("data berhasil diupdate");
                }else{
                   System.out.println("data gagal diupdate!") ;
                }
            
                connection.close();
                } 
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }  
}
