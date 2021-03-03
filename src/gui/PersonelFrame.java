/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.sql.*;
import java.util.*;
import javaapplication1.Musteri;
import javaapplication1.Personel;
import javaapplication1.Veritabani;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author canis
 */
public class PersonelFrame extends javax.swing.JFrame {
    
    private  DefaultTableModel tablemodel;
    private  DefaultTableModel tablemodel1;
    private  Personel personel ;
    private  Connection connection = null;
    private   Veritabani dbcon= new Veritabani();
    private   Statement statement= null;
    private   PreparedStatement pstatement= null;
    private   Connection con= Veritabani.connectDb();
    private   ResultSet rs;
    private ArrayList<Musteri> musteri=null;
    
    private String str= LoginFrame.getLogintckno();
     static String pbilg= "Personel";
     static String a = "PERSONELBANKABILGILERI";
     static String abilg= "PERSONELOZLUKBILGILERI";
        
    
    public PersonelFrame() {
        initComponents();
        tablemodel = (DefaultTableModel) jTable_MusteriBilgileri.getModel();
        tablemodel1= (DefaultTableModel) jTable_MusteriBankaBilgileri.getModel();
        lblPersonelTC.setText(str);
        personel= new Personel(str);
        personel.adsoyadgetir();
        personel.bakiyevekkborcgetir();
        
        jLabel_ad.setText(personel.getIsim()+" "+personel.getSoyisim());
        
        
        
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

        private ArrayList<Musteri> getMusteriBilgiler() throws SQLException {
        
        try{
            connection= dbcon.connectDb();
            statement= connection.createStatement();
            rs= statement.executeQuery("SELECT * FROM MUCO.MUSTERIOZLUKBILGILERI");
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
    private ArrayList<Musteri> getMusteriHesapBilgileri() throws SQLException {
       
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jDesktopPane_personel = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_MusteriBilgileri = new javax.swing.JTable();
        jTextField_musteriBilgileri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_MusteriBankaBilgileri = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField_musteriHesapBilgileri = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPersonelTC = new javax.swing.JLabel();
        jLabel_ad = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bakiyeborc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sifredegis = new javax.swing.JButton();
        paracek = new javax.swing.JButton();
        parayatir = new javax.swing.JButton();
        paratransferi = new javax.swing.JButton();
        kkborc = new javax.swing.JButton();
        faturaode = new javax.swing.JButton();
        kredionay = new javax.swing.JButton();
        jDesktopPane = new javax.swing.JDesktopPane();
        musteriekle = new javax.swing.JButton();
        musterisil = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jMenuItem1.setText("jMenuItem1");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Müşteri Işlemleri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jTable_MusteriBilgileri.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable_MusteriBilgileri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tckno", "Isim", "Soyisiml"
            }
        ));
        jScrollPane1.setViewportView(jTable_MusteriBilgileri);

        jTextField_musteriBilgileri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_musteriBilgileriKeyReleased(evt);
            }
        });

        jLabel3.setText("Musteri Bilgileri");

        jTable_MusteriBankaBilgileri.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable_MusteriBankaBilgileri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tckno", "Bakiye", "Kredi Onay Durumu", "Kredi Kartı Borç"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_MusteriBankaBilgileri);

        jLabel4.setText("Musteri Hesap Bilgileri");

        jTextField_musteriHesapBilgileri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_musteriHesapBilgileriKeyReleased(evt);
            }
        });

        jLabel5.setText("ARAMA:");

        jLabel6.setText("ARAMA:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField_musteriHesapBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField_musteriBilgileri))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_musteriBilgileri)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_musteriHesapBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Kişisel Bilgiler"), "Kullanıcı Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        lblPersonelTC.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        jLabel_ad.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPersonelTC, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersonelTC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bakiye&Borç"));
        jPanel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        bakiyeborc.setText("Bakiye ve Borç Görüntüle");
        bakiyeborc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bakiyeborcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(bakiyeborc, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bakiyeborc)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hesap Işlemleri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        sifredegis.setText("Şifre Değiştirme");
        sifredegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifredegisActionPerformed(evt);
            }
        });

        paracek.setText("Para Çek");
        paracek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paracekActionPerformed(evt);
            }
        });

        parayatir.setText("Para Yatır");
        parayatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parayatirActionPerformed(evt);
            }
        });

        paratransferi.setText("Para Transferi");
        paratransferi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paratransferiActionPerformed(evt);
            }
        });

        kkborc.setText("Kredi Kartı Borcu Öde");
        kkborc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kkborcActionPerformed(evt);
            }
        });

        faturaode.setText("Fatura Öde");
        faturaode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faturaodeActionPerformed(evt);
            }
        });

        kredionay.setText("Kredi Onay Durumu");
        kredionay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kredionayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kredionay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kkborc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parayatir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paracek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sifredegis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(faturaode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paratransferi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sifredegis, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paracek, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(parayatir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paratransferi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kkborc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(faturaode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kredionay)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jDesktopPane.setForeground(java.awt.SystemColor.activeCaptionBorder);

        musteriekle.setText("MÜŞTERİ EKLE");
        musteriekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriekleActionPerformed(evt);
            }
        });

        musterisil.setText("MÜŞTERİ SİL");
        musterisil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musterisilActionPerformed(evt);
            }
        });

        jDesktopPane.setLayer(musteriekle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(musterisil, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(musteriekle, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(musterisil, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musteriekle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musterisil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(315, Short.MAX_VALUE))
        );

        jDesktopPane_personel.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane_personel.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane_personel.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane_personel.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane_personel.setLayer(jDesktopPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane_personelLayout = new javax.swing.GroupLayout(jDesktopPane_personel);
        jDesktopPane_personel.setLayout(jDesktopPane_personelLayout);
        jDesktopPane_personelLayout.setHorizontalGroup(
            jDesktopPane_personelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane_personelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jDesktopPane_personelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane_personelLayout.setVerticalGroup(
            jDesktopPane_personelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane_personelLayout.createSequentialGroup()
                .addGroup(jDesktopPane_personelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane_personelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane_personelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jDesktopPane_personelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jDesktopPane_personelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane_personel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane_personel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_musteriBilgileriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteriBilgileriKeyReleased
        
        String searchKey= jTextField_musteriBilgileri.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter= 
                new TableRowSorter<DefaultTableModel>(tablemodel);
        jTable_MusteriBilgileri.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
        
        
    }//GEN-LAST:event_jTextField_musteriBilgileriKeyReleased

    private void jTextField_musteriHesapBilgileriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteriHesapBilgileriKeyReleased
        String searchKey= jTextField_musteriHesapBilgileri.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter= 
                 new TableRowSorter<DefaultTableModel>(tablemodel1);
        jTable_MusteriBankaBilgileri.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_jTextField_musteriHesapBilgileriKeyReleased

    private void sifredegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifredegisActionPerformed
        Sifredegis sifredegis= new Sifredegis(abilg);
        jDesktopPane_personel.add(sifredegis);
        sifredegis.setVisible(true);
    }//GEN-LAST:event_sifredegisActionPerformed

    private void musteriekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musteriekleActionPerformed
        MusteriEkle musteriEkle= new MusteriEkle();
        jDesktopPane.add(musteriEkle);
        musteriEkle.setVisible(true);
        
       
    }//GEN-LAST:event_musteriekleActionPerformed

    private void musterisilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musterisilActionPerformed
        MusteriSil musteriSil= new MusteriSil();
        jDesktopPane.add(musteriSil);
        musteriSil.setVisible(true);           
    }//GEN-LAST:event_musterisilActionPerformed

    private void paracekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paracekActionPerformed
         ParaCek paracek= new ParaCek(a);
        jDesktopPane_personel.add(paracek);
        paracek.setVisible(true);
    }//GEN-LAST:event_paracekActionPerformed

    private void parayatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parayatirActionPerformed
       ParaYatir parayatir= new ParaYatir(a);
        jDesktopPane_personel.add(parayatir);
        parayatir.setVisible(true);
    }//GEN-LAST:event_parayatirActionPerformed

    private void paratransferiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paratransferiActionPerformed
        ParaTransfer paratransfer= new ParaTransfer(a);
        jDesktopPane_personel.add(paratransfer);
        paratransfer.setVisible(true);
    }//GEN-LAST:event_paratransferiActionPerformed

    private void kkborcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kkborcActionPerformed
        KrediKartiBorcYatir kredik= new KrediKartiBorcYatir(a);
        jDesktopPane_personel.add(kredik);
        kredik.setVisible(true);
    }//GEN-LAST:event_kkborcActionPerformed

    private void faturaodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faturaodeActionPerformed
       FaturaOde fatura= new FaturaOde(pbilg);
       jDesktopPane_personel.add(fatura);
       fatura.setVisible(true);
       
    }//GEN-LAST:event_faturaodeActionPerformed

    private void bakiyeborcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bakiyeborcActionPerformed
        Bakiyeborc bakiye = new Bakiyeborc(pbilg);
        jDesktopPane_personel.add(bakiye);
        bakiye.setVisible(true);
        
    }//GEN-LAST:event_bakiyeborcActionPerformed

    private void kredionayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kredionayActionPerformed
         KrediOnay kredionay= new KrediOnay(pbilg);
        jDesktopPane_personel.add(kredionay);
        kredionay.setVisible(true);
    }//GEN-LAST:event_kredionayActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bakiyeborc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton faturaode;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JDesktopPane jDesktopPane_personel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_ad;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_MusteriBankaBilgileri;
    private javax.swing.JTable jTable_MusteriBilgileri;
    private javax.swing.JTextField jTextField_musteriBilgileri;
    private javax.swing.JTextField jTextField_musteriHesapBilgileri;
    private javax.swing.JButton kkborc;
    private javax.swing.JButton kredionay;
    private javax.swing.JLabel lblPersonelTC;
    private javax.swing.JButton musteriekle;
    private javax.swing.JButton musterisil;
    private javax.swing.JButton paracek;
    private javax.swing.JButton paratransferi;
    private javax.swing.JButton parayatir;
    private javax.swing.JButton sifredegis;
    // End of variables declaration//GEN-END:variables

    

   
}
