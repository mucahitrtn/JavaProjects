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
import java.sql.Statement;
import java.util.ArrayList;
import javaapplication1.Personel;
import javaapplication1.Veritabani;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author canis
 */
public class PersonelBilgilerYonetici extends javax.swing.JInternalFrame {

    
    private String str= LoginFrame.getLogintckno();
        
        DefaultTableModel tablemodel;
        DefaultTableModel tablemodel1;
        Connection connection = null;
        Statement statement= null;
        Veritabani dbcon= new Veritabani();
        PreparedStatement pstatement= null;
        Connection con= Veritabani.connectDb();
        private ArrayList<Personel> personel;
        ResultSet rs;
        
    public PersonelBilgilerYonetici() {
        initComponents();
        tablemodel = (DefaultTableModel) jTable_personelisim.getModel();
        tablemodel1= (DefaultTableModel) jTable_personelbanka.getModel();
        
       try{
            ArrayList<Personel> personeller=personelBilgiler();
            for(Personel personel: personeller){
                
                Object[] row= { personel.getTckno(),personel.getIsim(), personel.getSoyisim()};
                tablemodel. addRow(row);
                
            }
            
           
       }catch( SQLException ex){
           
           System.err.print(ex.getErrorCode());
           
       }
       
       try{
            ArrayList<Personel> personelhesap=personelHesapBilgileri();
            
            for(Personel personel: personelhesap){
                
                Object[] row= {personel.getTckno(), personel.isOnay()};
                tablemodel1. addRow(row);
                
            }
            
           
       }catch( SQLException ex){
           
           System.err.print(ex.getErrorCode());
           
       }
        
    }
    
    public ArrayList<Personel> personelBilgiler() throws SQLException{
        
       try{
            connection= dbcon.connectDb();
            statement= connection.createStatement();
            rs= statement.executeQuery("SELECT TCKNO, ISIM, SOYISIM FROM MUCO.PERSONELOZLUKBILGILERI");
            personel= new ArrayList();
                while(rs.next()){
                    personel.add(new Personel(rs.getString("TCKNO"),rs.getString("ISIM"),rs.getString("SOYISIM")));
                                                                                                                              
                }
            
        }catch(SQLException e){
            System.err.println("ERROR CODE: "+ e.getErrorCode());
        }
        finally {
            statement.close();
            connection.close();
        }
        
        return personel;
    }
    
    public ArrayList<Personel> personelHesapBilgileri() throws SQLException{
        
         try{
            connection= dbcon.connectDb();
            statement= connection.createStatement();
            rs= statement.executeQuery("SELECT * FROM MUCO.PERSONELBANKABILGILERI");
            personel= new ArrayList();
                while(rs.next()){
                    personel.add(new Personel(rs.getString("TCKNO"),rs.getDouble("BAKIYE"),rs.getBoolean("KREDIONAYDURUMU"),rs.getDouble("KREDIKARTIBORC")));
                                                                                                                              
                }
            
        }catch(SQLException e){
            System.err.println("ERROR CODE: "+ e.getErrorCode());
        }
        finally {
            statement.close();
            connection.close();
        }
        
        return personel;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_personelisim = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_personelbanka = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldpersoneloz = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable_personelisim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TCKNO", "ISIM", "SOYISIM"
            }
        ));
        jScrollPane1.setViewportView(jTable_personelisim);

        jTable_personelbanka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TCKNO", "KREDİ ONAY DURUMU"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_personelbanka);

        jLabel1.setText("ARA:");

        jTextFieldpersoneloz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldpersonelozKeyReleased(evt);
            }
        });

        jLabel2.setText("ARA:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton2.setText("PERSONEL SİL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("PERSONEL EKLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("İPTAL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldpersoneloz, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldpersoneloz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PersonelEkle personelEkle= new PersonelEkle();
        jDesktopPane1.add(personelEkle);        
        personelEkle.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            setVisible(false);
            dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PersonelSil personelsil= new PersonelSil();
        jDesktopPane1.add(personelsil);
        personelsil.setVisible(true);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldpersonelozKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldpersonelozKeyReleased
        String searchKey= jTextFieldpersoneloz.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter= 
                 new TableRowSorter<DefaultTableModel>(tablemodel1);
        jTable_personelisim.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_jTextFieldpersonelozKeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String searchKey= jTextField2.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter= 
                 new TableRowSorter<DefaultTableModel>(tablemodel1);
        jTable_personelbanka.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_personelbanka;
    private javax.swing.JTable jTable_personelisim;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldpersoneloz;
    // End of variables declaration//GEN-END:variables
}
