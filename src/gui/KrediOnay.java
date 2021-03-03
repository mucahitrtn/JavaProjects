/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javaapplication1.Musteri;
import javaapplication1.Personel;
import javaapplication1.Yonetici;

/**
 *
 * @author canis
 */
public class KrediOnay extends javax.swing.JInternalFrame {

    private String s;
    private String str= LoginFrame.getLogintckno();
    
    private Musteri musteri;
    private Personel personel;
    private Yonetici yonetici;
    
    private boolean onay;
    private double bakiye, borc;
    
    public KrediOnay(String s) {
        initComponents();
        this.s= s;
        jLabel_tckno.setText(str);
        
        
        if(s=="Musteri"){
            
            musteri = new Musteri(str);
            musteri.kredionaylama();
            musteri.kredionaydurumu();
            musteri.adsoyadgetir();
            ad.setText(musteri.getIsim()+" "+musteri.getSoyisim());
            onay= musteri.isOnay();
            
            
            bakiye= musteri.getBakiye();
            borc= musteri.getKredikartiborc();
            
            if(onay==true){
                
                jLabel_onay.setText("Kredi Çekebilirsiniz.");
                
                if(bakiye-borc>=1000&&bakiye-borc<=10000){
                
                        jLabel_miktar.setText("10000 TL'ye Kadar Kredi Çekebilirsiniz.");
                
                }
                else if(bakiye-borc>=10000&&bakiye-borc<=100000){
                
                        jLabel_miktar.setText("100000 TL'ye Kadar Kredi Çekebilirsiniz.");
                
                }
                else if(bakiye-borc>=100000&&bakiye-borc<=1000000){
                    
                        jLabel_miktar.setText("1000000 TL'ye Kadar Kredi Çekebilirsiniz.");
                    
                }
                else if(bakiye-borc>1000000){
                    
                        jLabel_miktar.setText("Kredi miktarında sınırınız yoktur. Lütfen şubelerimizden bilgi alınız.");
                        
                    
                }
                
            }else{
                
                jLabel_onay.setText("Size Uygun Kredimiz Bulunmamaktadır. Lütfen şubelerimizden bilgi alınız.");
                
            }
            
            
        }
        else if(s=="Personel"){
            
            personel= new Personel(str);
            personel.kredionaylama();
            personel.kredionaydurumu();
            personel.adsoyadgetir();
            ad.setText(personel.getIsim()+" "+personel.getSoyisim());
            onay= personel.isOnay();
            
            bakiye= personel.getBakiye();
            borc= personel.getKredikartiborc();
            
            if(onay==true){
                
                jLabel_onay.setText("Kredi Çekebilirsiniz.");
                
                if(bakiye-borc>=1000&&bakiye-borc<=10000){
                
                        jLabel_miktar.setText("10000 TL'ye Kadar Kredi Çekebilirsiniz.");
                
                }
                else if(bakiye-borc>=10000&&bakiye-borc<=100000){
                
                        jLabel_miktar.setText("100000 TL'ye Kadar Kredi Çekebilirsiniz.");
                
                }
                else if(bakiye-borc>=100000&&bakiye-borc<=1000000){
                    
                        jLabel_miktar.setText("1000000 TL'ye Kadar Kredi Çekebilirsiniz.");
                    
                }
                else if(bakiye-borc>1000000){
                    
                        jLabel_miktar.setText("Kredi miktarında sınırınız yoktur. Lütfen şubelerimizden bilgi alınız.");
                        
                    
                }
                
            }else{
                
                jLabel_onay.setText("Size Uygun Kredimiz Bulunmamaktadır. Lütfen şubelerimizden bilgi alınız.");
                
            }
            
        }
        else if(s=="Yonetici"){
            
            yonetici= new Yonetici(str);
            yonetici.kredionaylama();
            yonetici.kredionaydurumu();
            yonetici.adsoyadgetir();
            ad.setText(yonetici.getIsim()+" "+yonetici.getSoyisim());
            onay= yonetici.isOnay();
            
            bakiye= yonetici.getBakiye();
            borc= yonetici.getKredikartiborc();
            
            if(onay==true){
                
                jLabel_onay.setText("Kredi Çekebilirsiniz.");
                
                if(bakiye-borc>=1000&&bakiye-borc<=10000){
                
                        jLabel_miktar.setText("10000 TL'ye Kadar Kredi Çekebilirsiniz.");
                
                }
                else if(bakiye-borc>=10000&&bakiye-borc<=100000){
                
                        jLabel_miktar.setText("100000 TL'ye Kadar Kredi Çekebilirsiniz.");
                
                }
                else if(bakiye-borc>=100000&&bakiye-borc<=1000000){
                    
                        jLabel_miktar.setText("1000000 TL'ye Kadar Kredi Çekebilirsiniz.");
                    
                }
                else if(bakiye-borc>1000000){
                    
                        jLabel_miktar.setText("Kredi miktarında sınırınız yoktur. Lütfen şubelerimizden bilgi alınız.");
                        
                    
                }
                
            }else{
                
                jLabel_onay.setText("Size Uygun Kredimiz Bulunmamaktadır. Lütfen şubelerimizden bilgi alınız.");
                
            }
            
        }
        
        setVisible(false);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_tckno = new javax.swing.JLabel();
        ad = new javax.swing.JLabel();
        jLabel_onay = new javax.swing.JLabel();
        jLabel_miktar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("KREDİ ONAY DURUMU:");

        jLabel2.setText("Alabileceğiniz Kredi Miktatı:");

        jButton1.setText("KAPAT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel_miktar, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addComponent(jLabel_onay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel_tckno, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_tckno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ad, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_onay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_miktar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_miktar;
    private javax.swing.JLabel jLabel_onay;
    private javax.swing.JLabel jLabel_tckno;
    // End of variables declaration//GEN-END:variables
}
