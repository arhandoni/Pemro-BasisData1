package latihankoneksidb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


/**
 *
 * @author Rani
 */
public class LatihanKoneksiDB {

    public static void main(String[] args) {
        // Define Connection
          String jdbcURL = "jdbc:mysql://localhost:3306/uts";
          String username = "root";
          String password = "jimin13";
          
          int nidn = 951013;
          String nama = "Mr min";
          String alamat = "jl sayang";
          String jeniskelamin = "Laki-laki";
          
          try {
              // open connection
              Connection connection = DriverManager.getConnection(jdbcURL, username, password);
              if (connection != null) {
                  System.out.println("Connection to database");
                  
                  //Proses Insert Data
                  String sql = "INSERT INTO dosen (nidn, nama, alamat, jenis_kelamin)" + 
                          "VALUES (?, ?, ?, ?)";
                  
                  PreparedStatement statement = connection.prepareStatement(sql);
                  statement.setString(1, Integer.toString(nidn));
                  statement.setString(2, nama);
                  statement.setString(3, alamat);
                  statement.setString(4, jeniskelamin);
                  
                  int rows = statement.executeUpdate();
                  
                  if (rows > 0) {
                      System.out.println("Data Berhasil Disimpan..!!");
                  }
                  
                  //Tutup Connection
                  connection.close();
              }
          } catch (SQLException ex){
              ex.printStackTrace();
          }
    } 
}