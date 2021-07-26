/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import view.dataBarang;
import view.loginStudent;

/**
 *
 * @author Faa
 */
public class mainKoneksi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        koneksi con = new koneksi();
        Connection koneksi = con.getKoneksi();
        
        dataBarang barang = new dataBarang();
        barang.setVisible(true);
        

    }
    
}
