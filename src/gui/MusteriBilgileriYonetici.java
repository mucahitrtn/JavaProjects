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
import javaapplication1.Musteri;
import javaapplication1.Veritabani;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author canis
 */
public class MusteriBilgileriYonetici extends javax.swing.JInternalFrame {

        DefaultTableModel tablemodel;
        DefaultTableModel tablemodel1;
        Connection connection = null;
        Statement statement= null;
        Veritabani dbcon= new Veritabani();
        PreparedStatement pstatement= null;
        Connection con= Veritabani.connectDb();
        ResultSet rs;
        private ArrayList<Musteri> musteri=null;
    
        private String str= LoginFrame.getLogintckno();
   
    public MusteriBilgileriYonetici() {
        initComponents();
        tablemodel = (DefaultTableModel) jTable_MusteriBilgileri.getModel();
        tablemodel1= (DefaultTableModel) jTable_MusteriBankaBilgileri.getModel();
        /////////////////////////////////////////////////////////////
        //OZLUK BİLGİLERİ TABLOYA EKLEMEK İÇİN
        try {
            ArrayList<Musteri> musteriler= getMusteriBilgiler();
            for(Musteri musteri: musteriler){
                
                Object[] row= {musteri.getTckno(), musteri.getIsim(),musteri.getSoyisim() };
                tablemodel. addRow(row);
            }
            
        } catch (SQLException ex) {
          
           System.err.print(ex.getErrorCode());
        }
        ////////////////////////////////////////////////////////////
        //MUSTERİ BANNKA BİLGİLERİ(BAKİYE VS.)
        try {
                ArrayList<Musteri> musterihesapbilgileri= getMusteriHesapBilgileri();
            for(Musteri musteri: musterihesapbilgileri){
                
                Object[] row= {musteri.getTckno(),musteri.getBakiye(), musteri.isOnay(),musteri.getKredikartiborc()};
                tablemodel1. addRow(row);
            }
            
        } catch (SQLException ex) {
          
           System.err.print(ex.getErrorCode());
        }       
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MÜŞTERİ BİLGİLERİNİN TABLOLARA ATANMASI

    public ArrayList<Musteri> getMusteriBilgiler() throws SQLException {
        
        try{
            connection= dbcon.connectDb();
            statement= connection.createStatement();
            rs= statement.executeQuery("SELECT TCKNO, ISIM, SOYISIM FROM MUCO.MUSTERIOZLUKBILGILERI");
            musteri= new ArrayList();
                while(rs.next()){
                    musteri.add(new Musteri(rs.getString("TCKNO"),rs.getString("ISIM"),rs.getString("SOYISIM")));
                                                                                                                              
                }
            
        }catch(SQLException e){
            System.err.println("ERROR CODE: "+ e.getErrorCode());
        }
        finally {
            statement.close();
            connection.close();
        }
        
        return musteri;
   }
        
    public ArrayList<Musteri> getMusteriHesapBilgileri() throws SQLException {
       
        try{
            connection= dbcon.connectDb();
            statement= connection.createStatement();
            rs= statement.executeQuery("SELECT * FROM MUCO.MUSTERIBANKABILGILERI");
            musteri= new ArrayList();
                while(rs.next()){
                    musteri.add(new Musteri(rs.getString("TCKNO"),rs.getDouble("BAKIYE"),rs.getBoolean("KREDIONAYDURUMU"),rs.getDouble("KREDIKARTIBORC")));
                                                                                                                              
                }
            
        }catch(SQLException e){
            System.err.println("ERROR CODE: "+ e.getErrorCode());
        }
        finally {
            statement.close();
            connection.close();
        }
        
        return musteri;
        
   }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_MusteriBilgileri = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_MusteriBankaBilgileri = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField_musteriBilgileri = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_musteriHesapBilgileri = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable_MusteriBilgileri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TCKNO", "AD", "SOYAD"
            }
        ));
        jScrollPane2.setViewportView(jTable_MusteriBilgileri);

        jTable_MusteriBankaBilgileri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TCKNO", "BAKİYE", "KREDİ ONAY DURUMU", "KREDİ KARTI BORÇ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_MusteriBankaBilgileri);

        jLabel1.setText("ARA:");

        jTextField_musteriBilgileri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_musteriBilgileriActionPerformed(evt);
            }
        });
        jTextField_musteriBilgileri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_musteriBilgileriKeyReleased(evt);
            }
        });

        jLabel2.setText("ARA:");

        jTextField_musteriHesapBilgileri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_musteriHesapBilgileriActionPerformed(evt);
            }
        });
        jTextField_musteriHesapBilgileri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_musteriHesapBilgileriKeyReleased(evt);
            }
        });

        jButton1.setText("MÜŞTERİ EKLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("MÜŞTERİ SİL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("IPTAL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_musteriBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_musteriHesapBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_musteriBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_musteriHesapBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_musteriBilgileriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_musteriBilgileriActionPerformed
        
    }//GEN-LAST:event_jTextField_musteriBilgileriActionPerformed

    private void jTextField_musteriHesapBilgileriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_musteriHesapBilgileriActionPerformed
        
    }//GEN-LAST:event_jTextField_musteriHesapBilgileriActionPerformed

    private void jTextField_musteriBilgileriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteriBilgileriKeyReleased
        String searchKey= jTextField_musteriBilgileri.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter= 
                new TableRowSorter<DefaultTableModel>(tablemodel);
        jTable_MusteriBilgileri.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_jTextField_musteriBilgileriKeyReleased

    private void jTextField_musteriHesapBilgileriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteriHesapBilgileriKeyReleased
        String searchKey= jTextField_musteriBilgileri.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter= 
                 new TableRowSorter<DefaultTableModel>(tablemodel1);
        jTable_MusteriBankaBilgileri.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_jTextField_musteriHesapBilgileriKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MusteriEkle musteriEkle= new MusteriEkle();
        jDesktopPane1.add(musteriEkle);
        musteriEkle.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MusteriSil musteriSil= new MusteriSil();
        jDesktopPane1.add(musteriSil);
        musteriSil.setVisible(true);          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_MusteriBankaBilgileri;
    private javax.swing.JTable jTable_MusteriBilgileri;
    private javax.swing.JTextField jTextField_musteriBilgileri;
    private javax.swing.JTextField jTextField_musteriHesapBilgileri;
    // End of variables declaration//GEN-END:variables
}