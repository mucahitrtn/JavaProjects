
package gui;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.Veritabani;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    private static String logintckno;
     
     static String getLogintckno() {
        return logintckno;
    }
   
      
    Connection con= Veritabani.connectDb();
    PreparedStatement pstatement= null;
    ResultSet rset= null;
    
    public LoginFrame() {
        initComponents();
        Veritabani.connectDb();
        logintckno= txtTckno.getText();
        
    }

   
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboUserType = new javax.swing.JComboBox<>();
        txtTckno = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kullanici Tipi Seciniz", "Musteri", "Personel", "Yonetici" }));
        comboUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUserTypeActionPerformed(evt);
            }
        });

        txtTckno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTcknoActionPerformed(evt);
            }
        });

        jLabel1.setText("SIFRE");

        jLabel2.setText("TCKNO");

        buttonLogin.setText("Giris");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("           HOSGELDİNİZ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTckno, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(comboUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(comboUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtTckno))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTcknoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTcknoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTcknoActionPerformed

    ////// LOGİN KISMI
    
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
      
       
      if(comboUserType.getSelectedItem().equals("Musteri")){
           String loginmusteri="SELECT * FROM MUCO.MUSTERIOZLUKBILGILERI WHERE Tckno=? AND Sifre=? ";
          try {
              pstatement=con.prepareStatement(loginmusteri);
              pstatement.setString(1, txtTckno.getText());
              logintckno=txtTckno.getText();
              pstatement.setString(2, txtPassword.getText());
              rset=pstatement.executeQuery();
            if(rset.next()){
                JOptionPane.showMessageDialog(null, "Giriş Başarılı");
                dispose();
                new MusteriFrame(). setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Hatalı kullanıcı adı veya parola!");
            
          } catch (SQLException ex) {
              Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
              System.err.println(ex.getErrorCode());
          }
          
          
      }
      else if(comboUserType.getSelectedItem().equals("Personel")){
          
          String loginmusteri="SELECT * FROM MUCO.PERSONELOZLUKBILGILERI WHERE Tckno=? AND Sifre=? ";
          try {
              pstatement=con.prepareStatement(loginmusteri);
              pstatement.setString(1, txtTckno.getText());
              logintckno=txtTckno.getText();
              pstatement.setString(2, txtPassword.getText());
              rset=pstatement.executeQuery();
            if(rset.next()){
                JOptionPane.showMessageDialog(null, "Giriş Başarılı");
                dispose();
                new PersonelFrame(). setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Hatalı kullanıcı adı veya parola!");
            
          } catch (SQLException ex) {
              Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
              System.err.println(ex.getErrorCode());
          }
           
      }
      else if(comboUserType.getSelectedItem().equals("Yonetici")){
          
           String loginmusteri="SELECT * FROM MUCO.YONETICIOZLUKBILGILERI WHERE Tckno=? AND Sifre=? ";
          try {
              pstatement=con.prepareStatement(loginmusteri);
              pstatement.setString(1, txtTckno.getText());
              logintckno=txtTckno.getText();
              pstatement.setString(2, txtPassword.getText());
              rset=pstatement.executeQuery();
            if(rset.next()){
               JOptionPane.showMessageDialog(null, "Giriş Başarılı");
                dispose();
                new YoneticiFrame(). setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Hatalı kullanıcı adı veya parola!");
            
          } catch (SQLException ex) {
              Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
              System.err.println(ex.getErrorCode());
          }
          
      }
      else{
          JOptionPane.showMessageDialog(null, "Lütfen Kullanıcı Tipi Seçiniz!");
      }
            
            
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void comboUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUserTypeActionPerformed

   ///////LOGİN KISMI
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JComboBox<String> comboUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTckno;
    // End of variables declaration//GEN-END:variables
}
