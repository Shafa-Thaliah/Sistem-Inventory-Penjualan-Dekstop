/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import helper.koneksi;
import view.MenuBarang;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Faa
 */
public class DataPemesanan extends javax.swing.JFrame {
public Connection con;
public Statement sttm;
public ResultSet rs;
public DefaultTableModel model;

    /**
     * Creates new form DataPemesanan
     */
    public DataPemesanan() {
        initComponents();
        koneksi.getKoneksi();
     //   totalnya();
        
        //Meletakkan frame di tengah layar
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
       
        int x = d.width/2 - this.getSize().width/2;
        int y = d.height/2 - this.getSize().height/2;
        
        this.setLocation(x, y);
        
        //Memberi Nama pada Tabel
        String[] header = {"ID Transaksi","ID Barang","Nama Barang","Harga","Jumlah","Total Harga"};
        model = new DefaultTableModel(header,0);
        keranjang.setModel(model);
        tampilData();
  
    
    }
    
    public void tampilData (){
        String procedures = "CALL `total_harga`()";
        
        koneksi koneksi = new koneksi();
        int jumlahrow = keranjang.getRowCount();
        for (int n=0;n<jumlahrow;n++){
            model.removeRow(0);
        }
        
        try{
            con = koneksi.getKoneksi();
            sttm = con.createStatement();
            rs = sttm.executeQuery("SELECT * FROM transaksi");
            while(rs.next()){
                String[] row ={rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                model.addRow(row);
                
            }
            keranjang.setModel(model);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
           
    
    private void clear(){
        txt_idtransaksi.setText(null);
        txt_idbarang.setText(null);
        txt_namabarang.setText(null);
        txt_harga.setText(null);
        txt_jumlah.setText(null);
        txt_totalhargabarang.setText(null);
    }
    
    private void tambahData (){
           
        String transaksi = txt_idtransaksi.getText();
        String id = txt_idbarang.getText();
        String nama = txt_namabarang.getText();
        String harga = txt_harga.getText();
        String jumlah = txt_jumlah.getText();
        String total = txt_totalhargabarang.getText();
      
         koneksi koneksi = new koneksi();
        try{
            con = koneksi.getKoneksi();
            sttm = con.createStatement();
            sttm.execute("INSERT INTO transaksi VALUES('"+transaksi+"','"+id+"','"+nama+"','"+harga+"','"+jumlah+"','"+total+"')");
            JOptionPane.showMessageDialog(null,"Data Berhasil Ditambahkan","Alert",JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Data Gagal Ditambahkan","ERROR",JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
            
       }finally{
            
            tampilData();
            clear();
            
        }
    //    totalnya();
    
    }

    public void hapusData (){
                String id = txt_idbarang.getText();
        try{
            sttm.executeUpdate("DELETE FROM transaksi WHERE id_barang='"+id+"' ");
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil","Alert",JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Hapus Data Gagal", "Alert",JOptionPane.ERROR_MESSAGE);
        }
        tampilData();
      //  totalnya();
    }
    
 public void hapusTabel (){
     try{
            sttm.executeUpdate("DELETE FROM transaksi ");
            System.out.println("Simpan Sukses");
            
        }catch (SQLException ex){
            System.out.println("");
        }
 }
    
    public void total (){
         String harga = txt_harga.getText();
        String jumlah = txt_jumlah.getText();
        
        int hargaa = Integer.parseInt(harga);
        try{
        int jumlahh = Integer.parseInt(jumlah);
        
        int total = hargaa * jumlahh;
        String total_harga = Integer.toString(total);
        
        txt_totalhargabarang.setText(total_harga);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Only Number");
            txt_jumlah.setText(null);
        }
    }
    


//    private void totalnya(){
//        String procedures = "CALL `total_harga`()";
//        
//        try{
//            Connection connect = koneksi.getKoneksi();//memanggil koneksi
//            Statement sttmnt = connect.createStatement();//membuat statement
//            ResultSet rslt = sttmnt.executeQuery(procedures);//menjalanakn query\
//                while(rslt.next()){
//                    txt_totalharga.setText(rslt.getString(1));
//                }
//                
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKembali = new javax.swing.JLabel();
        txt_totalhargabarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keranjang = new javax.swing.JTable();
        txt_totalharga = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        txt_namabarang = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txt_idbarang = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        txt_idtransaksi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button kembali.png"))); // NOI18N
        btnKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKembaliMouseClicked(evt);
            }
        });
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        txt_totalhargabarang.setEditable(false);
        txt_totalhargabarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_totalhargabarangMouseReleased(evt);
            }
        });
        txt_totalhargabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalhargabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_totalhargabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 140, 30));

        jLabel8.setText("Total Harga");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        keranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(keranjang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 660, 90));

        txt_totalharga.setEditable(false);
        txt_totalharga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_totalhargaMouseReleased(evt);
            }
        });
        txt_totalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalhargaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_totalharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 210, 50));

        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        getContentPane().add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Total");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 50, 50));

        jLabel4.setText("ID Transaksi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 30));

        jLabel5.setText("Harga");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel7.setText("Jumlah Pesanan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        txt_harga.setEditable(false);
        getContentPane().add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 210, 30));

        txt_namabarang.setEditable(false);
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 210, 30));

        jButton3.setText("PRINT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, -1, 30));

        hapus.setText("DELETE");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/simpan.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        jButton6.setText("ADD");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 70, 30));

        Nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Nama.setText("USERNAME");
        getContentPane().add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, 20));

        txt_idbarang.setEditable(false);
        txt_idbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 560, 30));

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/SEARCH.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 30, 50));
        getContentPane().add(txt_idtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 210, 30));

        jLabel6.setText("Nama Barang");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/FORM PEMESANANA.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 550));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 680, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
             
            try {
            
            HashMap param = new HashMap();
            param.put("total_pembayaran",txt_totalharga.getText()); 
            
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/report/struk.jasper"),param,koneksi.getKoneksi());
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // delete button
        hapusData();
    }//GEN-LAST:event_hapusActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // add button
        tambahData();
        
     //   totalnya();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_idbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idbarangActionPerformed

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked
        // ke halaman login murid
         loginStudent start = new loginStudent ();
         start.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnKembaliMouseClicked

    private void txt_totalhargabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalhargabarangActionPerformed
        // TODO add your handling code here:
        total();
    
    }//GEN-LAST:event_txt_totalhargabarangActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
                new MenuBarang().setVisible(true);
//        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_searchMouseClicked

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        // TODO add your handling code here:
        //total();
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_totalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalhargaActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_txt_totalhargaActionPerformed

    private void txt_totalhargabarangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_totalhargabarangMouseReleased
        // TODO add your handling code here:
        total();
        
    }//GEN-LAST:event_txt_totalhargabarangMouseReleased

    private void txt_totalhargaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_totalhargaMouseReleased
        // TODO add your handling code here:
               int totalnya = 0;
        for (int i = 0; i <keranjang.getRowCount(); i++){
            int amount = Integer.parseInt((String) keranjang.getValueAt(i, 5));
            totalnya += amount;
        }
            txt_totalharga.setText(""+totalnya);
    
    }//GEN-LAST:event_txt_totalhargaMouseReleased

    private void keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keranjangMouseClicked
        // TODO add your handling code here:
        int row = keranjang.getSelectedRow();
        hapus.setEnabled(true);

        String transaksi = keranjang.getValueAt(row, 0).toString();
        String id = keranjang.getValueAt(row, 1).toString();
        String nama = keranjang.getValueAt(row, 2).toString();
        String harga = keranjang.getValueAt(row, 3).toString();
        String jumlah = keranjang.getValueAt(row, 4).toString();
        String total = keranjang.getValueAt(row, 5).toString();
        
        txt_idtransaksi.setText(transaksi);
        txt_idbarang.setText(id);
        txt_namabarang.setText(nama);
        txt_harga.setText(harga);
        txt_jumlah.setText(jumlah);
        txt_totalhargabarang.setText(total);
    }//GEN-LAST:event_keranjangMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Data Transaksi Tersimpan");
        hapusTabel();
        clear();
    }//GEN-LAST:event_jLabel9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new DataPemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static final javax.swing.JLabel Nama = new javax.swing.JLabel();
    private javax.swing.JLabel btnKembali;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private static final javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable keranjang;
    private javax.swing.JLabel search;
    javax.swing.JTextField txt_harga;
    javax.swing.JTextField txt_idbarang;
    private javax.swing.JTextField txt_idtransaksi;
    private javax.swing.JTextField txt_jumlah;
    javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_totalharga;
    private javax.swing.JTextField txt_totalhargabarang;
    // End of variables declaration//GEN-END:variables
  static class dispose {

        public dispose() {
        }
    }
}
