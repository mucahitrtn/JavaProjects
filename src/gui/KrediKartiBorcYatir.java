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

public class KrediKartiBorcYatir extends javax.swing.JInternalFrame {
    
    private String str= LoginFrame.getLogintckno();
    private Connection con= Veritabani.connectDb();
    private PreparedStatement pstatement= null;
    private PreparedStatement updatest= null;
    private ResultSet rset= null;
    private String isim= null, soyisim=null;
    static  String s;
    private Musteri musteri; 
    private Personel personel;
    private Yonetici yonetici;
    private double a;
    private double b;
    private double asgari;
    
    public KrediKartiBorcYatir(String s) {
        initComponents();
        
        this.s= s;
         
        if(s=="MUSTERIBANKABILGILERI"){
            
            musteri= new Musteri(str);
            jLabel_Tckno.setText(str);
            musteri.bakiyevekkborcgetir();
            a=musteri.getKredikartiborc();
            b=musteri.getKredikartiborc();
            a=a/10;
            
            jLabel_kredik.setText(Double.toString(musteri.getKredikartiborc()));
            jLabel_asgari.setText(Double.toString(a));
            
        }
        else if(s=="PERSONELBANKABILGILERI"){
            personel= new Personel(str);
            jLabel_Tckno.setText(str);
            personel.bakiyevekkborcgetir();
            a=personel.getKredikartiborc();
            b=personel.getKredikartiborc();
            a=a/10;
           
            
            jLabel_kredik.setText(Double.toString(personel.getKredikartiborc()));
            jLabel_asgari.setText(Double.toString(a));
            
        }
        else if(s=="YONECITIBANKABILGILERI"){
            
            yonetici= new Yonetici(str);
            jLabel_Tckno.setText(str);
            yonetici.bakiyevekkborcgetir();
            a=yonetici.getKredikartiborc();
            b=yonetici.getKredikartiborc();
            a=a/10;
            
            
            jLabel_kredik.setText(Double.toString(yonetici.getKredikartiborc()));
            jLabel_asgari.setText(Double.toString(a));
            
        }
        
        
    }
        
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel_tckno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_kredik = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_asgari = new javax.swing.JLabel();
        jTextField_borc = new javax.swing.JTextField();
        jButton_ode = new javax.swing.JButton();
        jButton_iptal = new javax.swing.JButton();
        jLabel_Tckno = new javax.swing.JLabel();

        jLabel_tckno.setText("TCKNO:");

        jLabel1.setText("KREDİ KARTI BORÇ:");

        jLabel2.setText("ÖDEMENİZ GEREKEN ASGARİ TUTAR:");

        jButton_ode.setText("ONAYLA");
        jButton_ode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_odeActionPerformed(evt);
            }
        });

        jButton_iptal.setText("IPTAL");
        jButton_iptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iptalActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel_tckno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel_kredik, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel_asgari, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextField_borc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton_ode, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton_iptal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel_Tckno, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField_borc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_asgari, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton_iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_ode, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_tckno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_kredik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Tckno, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_tckno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Tckno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_kredik, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_asgari, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField_borc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_ode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_odeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_odeActionPerformed
        
        try {
            updatest= con.prepareStatement("update "+s+" set KREDIKARTIBORC = KREDIKARTIBORC - ?, BAKIYE=BAKIYE- ? where TCKNO= ?");
            
            updatest.setDouble(1, Double.parseDouble(jTextField_borc.getText()));
            updatest.setDouble(2, Double.parseDouble(jTextField_borc.getText()));
            updatest.setString(3, str);
            updatest.executeUpdate();
            if(Double.parseDouble(jTextField_borc.getText())<a){
               jLabel_kredik.setText(Double.toString(b-a));
               jLabel_asgari.setText(Double.toString(a - Double.parseDouble(jTextField_borc.getText())));
               JOptionPane.showMessageDialog(null, "ASGARİ TUTARIN ALTINDA ÖDEME YAPTINIZ!");
                
            }
            else{
                jLabel_kredik.setText(Double.toString(b - Double.parseDouble(jTextField_borc.getText()) ));
                asgari = (b - Double.parseDouble(jTextField_borc.getText()))/10 ;
                jLabel_asgari.setText(Double.toString(asgari));
                JOptionPane.showMessageDialog(null, "BORÇ ÖDEME İŞLEMİ BAŞARILI");
            }                        
            
        } catch (SQLException ex) {
            System.err.println(ex.getErrorCode());
        }
      
        setVisible(false);
        dispose();
       
    }//GEN-LAST:event_jButton_odeActionPerformed

    private void jButton_iptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iptalActionPerformed
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jButton_iptalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_iptal;
    private javax.swing.JButton jButton_ode;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Tckno;
    private javax.swing.JLabel jLabel_asgari;
    private javax.swing.JLabel jLabel_kredik;
    private javax.swing.JLabel jLabel_tckno;
    private javax.swing.JTextField jTextField_borc;
    // End of variables declaration//GEN-END:variables

}
