/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaapplication1.Musteri;
import javaapplication1.Personel;
import javaapplication1.Veritabani;
import javaapplication1.Yonetici;
import javax.swing.JOptionPane;

/**
 *
 * @author canis
 */
public class ParaTransfer extends javax.swing.JInternalFrame {

    private String str= LoginFrame.getLogintckno();
    private Connection con= Veritabani.connectDb();
    private PreparedStatement pstatement= null;
    private PreparedStatement updatest= null;
    private ResultSet rset= null;
    private String isim= null, soyisim=null;
    double bakiye;
    double result;
    static String s;
    private Musteri musteri; 
    private Personel personel;
    private Yonetici yonetici;
    
    public ParaTransfer(String s) {
        initComponents();
         jLabel_tckno.setText(str);
         this.s= s;
         
        if(s=="MUSTERIBANKABILGILERI"){
            
            musteri= new Musteri(str);
            jLabel_tckno.setText(str);
            
            
           
            musteri.adsoyadgetir();
            musteri.bakiyevekkborcgetir();
            bakiye = musteri.getBakiye();
            
            jLabel_ad.setText(musteri.getIsim()+" "+musteri.getSoyisim());
            jLabel_bakiye.setText(Double.toString(musteri.getBakiye()));
        }
        else if(s=="PERSONELBANKABILGILERI"){
            
            personel= new Personel(str);
            jLabel_tckno.setText(str);
            
            
            personel.adsoyadgetir();
            personel.bakiyevekkborcgetir();
            bakiye = personel.getBakiye();
            
            jLabel_ad.setText(personel.getIsim()+" "+personel.getSoyisim());
            jLabel_bakiye.setText(Double.toString(personel.getBakiye()));
            
        }
        else if(s=="YONECITIBANKABILGILERI"){
            
            yonetici= new Yonetici(str);
            jLabel_tckno.setText(str);
            bakiye = yonetici.getBakiye();
            
            yonetici.adsoyadgetir();
            yonetici.bakiyevekkborcgetir();
            bakiye = yonetici.getBakiye();
           
            jLabel_ad.setText(yonetici.getIsim()+" "+yonetici.getSoyisim());
            jLabel_bakiye.setText(Double.toString(yonetici.getBakiye()));
            
        }
        
        
        
    }

 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel_tckno = new javax.swing.JLabel();
        jLabel_ad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_bakiye = new javax.swing.JLabel();
        jLabel_transfer = new javax.swing.JLabel();
        jTextField_transfertckno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_tutar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Müşteri Bilgileri"));

        jLabel_tckno.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        jLabel_ad.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_tckno, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel_tckno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Bakiye:");

        jLabel_bakiye.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        jLabel_transfer.setText("Transfer Yapacağınız Hesabı Giriniz:");

        jLabel2.setText("Transfer Edeceğiniz Meblağ:");

        jButton1.setText("ONAYLA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("IPTAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_bakiye, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_transfer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_transfertckno)
                            .addComponent(jTextField_tutar))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_bakiye, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_transfertckno, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jLabel_transfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_tutar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        try {
            if(bakiye>=0){
              if(bakiye - Double.parseDouble(jTextField_tutar.getText())<0){
                    
                    JOptionPane.showMessageDialog(null, "Bakiyenizde bu miktarda para yok! Lütfen daha az bir tutar girin veya hesabınıza para yatırın.");
                    
                }
                else{
                    
                
                updatest= con.prepareStatement("update  "+s+" set BAKIYE = BAKIYE - ? where TCKNO= ?");               
                updatest.setDouble(1, Double.parseDouble(jTextField_tutar.getText()));
                updatest.setString(2, str);
            
            
                updatest.executeUpdate();
                JOptionPane.showMessageDialog(null, "TRANSFER İŞLEMİ BAŞARILI!");
                
            }
                    
                    
                }
            
        } catch (SQLException ex) {
            System.err.println(ex.getErrorCode());
            System.err.println(ex.getMessage());
        }
        try {
                updatest= con.prepareStatement("update  "+s+" set BAKIYE = BAKIYE + ? where TCKNO= ?");
                
                updatest.setDouble(1, Double.parseDouble(jTextField_tutar.getText()));
                updatest.setString(2, jTextField_transfertckno.getText());
            
            
            updatest.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getErrorCode());
             System.err.println(ex.getMessage());
        }
        
        
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_ad;
    private javax.swing.JLabel jLabel_bakiye;
    private javax.swing.JLabel jLabel_tckno;
    private javax.swing.JLabel jLabel_transfer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_transfertckno;
    private javax.swing.JTextField jTextField_tutar;
    // End of variables declaration//GEN-END:variables
}
