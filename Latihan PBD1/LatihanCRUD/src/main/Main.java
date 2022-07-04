package main;

import controller.CRUD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Rani
 */
public class Main {

    public static void main(String[] args) {
        try {
            //menjalankan controller
            Main obj = new Main();
            obj.controller(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //instance variables here
    public void controller (String[] args) throws Exception {
        //memanggil class CRUD
        CRUD crud = new CRUD();
        
        //memanggil class BufferedReader untuk menginput data
        BufferedReader objekInput = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            //mencetak tulisan input nidn
            System.out.print("input nidn: ");
            //fungsi inputan
            int nidn = Integer.parseInt(objekInput.readLine());
            
            //mengambil data dosen berdasarkan nidn
            HashMap dataDosen = crud.getDataDosenByNidn(nidn);
            /*mengambil id dari dataDosen, kemudian diubah ke type data integer
            *sebelumnya dataDosen berbentuk objek
            *kemudian diubah ke dalam type data string terlebih dahulu
            */
            int idDataDosen = Integer.parseInt(dataDosen.get("id").toString());
            
            //menghapus data dosen menggunakan id
            crud.deleteDataDosenById(idDataDosen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
