package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

/**
 *
 * @author Rani
 */
public class CRUD {
    KoneksiDB koneksiDB;
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String sql;
    
    public CRUD(){
        koneksiDB = new KoneksiDB();
    }
    
    public HashMap getDataDosenByNidn(int nidn) {
        HashMap data = new HashMap();
        String sql = "SELECT * FROM dosen where nidn = ?";
        
        try {
            //open connection
            connection = koneksiDB.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nidn);
            
            ResultSet result = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData =result.getMetaData();
            
            //untuk mengambil jumlah kolom
            int jumlahKolom = resultSetMetaData.getColumnCount();
            
            while (result.next()) {
                for(int i = 1; i <= jumlahKolom; i++){
                    data.put(resultSetMetaData.getColumnName(i), result.getString(i));
                }
            }
            
            //check apakah data anda atau tidak
            if (data.isEmpty()){
                throw new Error("Data tidak ditemukan!");
            }
            
            //close connection
            connection.close();
            preparedStatement.close();
            
            //end of get data
        } catch (Exception e) {
            System.out.println("Error getDataDosenByNidn(): " + e);
            e.printStackTrace();
        }
        
        return data;
    } 
    
    public void deleteDataDosenById(int id) {
        String sql = "DELETE FROM dosen WHERE id = ?";
        
        try {
            //open connection
            connection = koneksiDB.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            //execute query
            int rows = preparedStatement.executeUpdate();
            
            //check berhasil delete data atau tidak
            if (rows > 0) {
                System.out.println("Data berhasil dihapus");
            } else {
                throw new Error("Data gagal dihapus!");
            }
            
            //close connection
            connection.close();
            preparedStatement.close();
            
            //end of get data
        } catch (Exception e) {
            System.out.println("Error deleteDataDosenById(): " + e);
            e.printStackTrace();
        }
    }

    public void insertDataDosen(int id) {
        int nidn = 131313;
        String nama = "Mr Park";
        String alamat = "jl kasih";
        String jeniskelamin = "Laki-laki";
          
        try {
            //open connection
            connection = koneksiDB.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nidn);
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
                  
                int rows = preparedStatement.executeUpdate();
                  
                if (rows > 0) {
                    System.out.println("Data Berhasil Disimpan..!!");
                } else {
                    throw new Error("Data gagal disimpan!");
                }
                  
                //Tutup Connection
                connection.close();
                preparedStatement.close();
            }
        } catch (Exception e){
            System.out.println("Error insertDataDosenById(): " + e);
            e.printStackTrace();
        }
    }
    
    public void updateDataDosen(int id) {
        String sql = "UPDATE dosen SET alamat = 'jl cinta' WHERE nidn = 1313135";
          
        try {
            // open connection
            connection = koneksiDB.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            int rows = preparedStatement.executeUpdate(sql);
                
            //check berhasil update data atau tidak
            if (rows > 0) {
                System.out.println("Data Berhasil Diupdate..!!");
            } else {
                throw new Error("Data gagal diupdate!");
            }
            //end proses update data
                  
            //Tutup Connection
            connection.close();
            preparedStatement.close();
        } catch (Exception e){
            System.out.println("Error updateDataDosenById(): " + e);
            e.printStackTrace();
        }
    }
}
