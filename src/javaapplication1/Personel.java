/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author canis
 */
public class Personel extends Kullanici{
    
    Connection con= Veritabani.connectDb();
    PreparedStatement pstatement= null;
    PreparedStatement updatest= null;
    ResultSet rset= null;
    
    private String tckno;
    private String sifre;
    private String isim;
    private String soyisim;
    private double bakiye;
    private boolean onay;
    private double kredikartiborc;
    private String fatura;
    
    public Personel(String tckno, String sifre, String isim, String soyisim){
        this.isim= isim;
        this.sifre=sifre;
        this.soyisim=soyisim;
        this.tckno=tckno;
    }
    public Personel(String tckno, double bakiye, boolean onay, double kredikartiborc){
        this.tckno= tckno;
        this.bakiye= bakiye;
        this.onay=onay;
        this.kredikartiborc=kredikartiborc;
        
    }

    public Personel(String tckno) {
        
        this.tckno= tckno;
        
    }
    
      public Personel(String tckno, String isim, String soyisim) {
        this.isim= isim;
        this.soyisim=soyisim;
        this.tckno=tckno;
    }

    public Personel(String tckno, boolean onay) {
        this.tckno= tckno;
        this.onay=onay;
        
    }
      
    
    
    

    public String getTckno() {
        return tckno;
    }

    public void setTckno(String tckno) {
        this.tckno = tckno;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
  
    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public boolean isOnay() {
        return onay;
    }

    public void setOnay(boolean onay) {
        this.onay = onay;
    }

    public double getKredikartiborc() {
        return kredikartiborc;
    }

    public void setKredikartiborc(double kredikartiborc) {
        this.kredikartiborc = kredikartiborc;
    }
    
    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    

    @Override
    public void hesapekle() {
   
        
        try{
            
            pstatement= con.prepareStatement("insert into PERSONELOZLUKBILGILERI(TCKNO, SIFRE,ISIM,SOYISIM) values (?,?,?,?) ");
            pstatement.setString(1, tckno);
            pstatement.setString(2,"123456");
            pstatement.setString(3, isim);
            pstatement.setString(4,soyisim);
            pstatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "HESAP OLUŞTURULDU");
            
        }catch(SQLException ex){
            
            System.err.println("HATA KODU: "+ ex.getErrorCode());
            
        }
        
    }

    @Override
    public void hesapsil() {
       
          try{
            
            pstatement= con.prepareStatement("DELETE FROM PERSONELOZLUKBILGILERI WHERE TCKNO=? ");
            pstatement.setString(1, tckno);
            pstatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "HESAP SİLİNDİ");
            
        }catch(SQLException ex){
            
            System.err.println("HATA KODU: "+ ex.getErrorCode());
            
        }
        
    }

    @Override
    /////DATABASEYE BANKA BİLGİLERİNİ EKLEME METODU
    public void hesapolustur() {
        
         try{
            pstatement= con.prepareStatement("insert into PERSONELBANKABILGILERI(TCKNO, BAKIYE, KREDIONAYDURUMU, KREDIKARTIBORC) values (?,?,?,?) ");
            pstatement.setString(1, tckno);
            pstatement.setDouble(2, 0.0 );
            pstatement.setBoolean(3, false );
            pstatement.setDouble(4, 0.0);
            pstatement.executeUpdate();
            
            
        }catch(SQLException ex){
            
            System.err.println("HATA KODU: "+ ex.getErrorCode());
            
        }
        
    }

    @Override
    public void bankabilgisihesapsil() {
       
         try{
            
            pstatement= con.prepareStatement("DELETE FROM PERSONELBANKABILGILERI WHERE TCKNO=? ");
            pstatement.setString(1, tckno);
            pstatement.executeUpdate();
            
            
        }catch(SQLException ex){
            
            System.err.println("HATA KODU: "+ ex.getErrorCode());
            
        }
        
    }

    @Override
    public void bakiyevekkborcgetir() {
       try{
            pstatement=con.prepareStatement("select BAKIYE, KREDIKARTIBORC from PERSONELBANKABILGILERI where TCKNO= ?");
            pstatement.setString(1, tckno);
            rset= pstatement.executeQuery();
            if(rset.next()){
                this.bakiye= rset.getDouble("BAKIYE");
                this.kredikartiborc=rset.getDouble("KREDIKARTIBORC");
            }
            
                    
        }catch(SQLException ex){
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
    }

    @Override
    public void adsoyadgetir() {
        try{
            pstatement=con.prepareStatement("select ISIM, SOYISIM from PERSONELOZLUKBILGILERI where TCKNO= ?");
            pstatement.setString(1, tckno);
            rset= pstatement.executeQuery();
            if(rset.next()){
                isim= rset.getString("ISIM");
                soyisim= rset.getString("SOYISIM");
            }
            
                    
        }catch(SQLException ex){
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
    }



    @Override
    public void faturabilgisi() {
        try {
            pstatement= con.prepareStatement("select FATURABORC from FATURA where TCKNO=? ");
            pstatement.setString(1, tckno);
            rset=pstatement.executeQuery();
            if(rset.next()){
                
                fatura= rset.getString("FATURABORC");
                
            }
            
            
        } catch (SQLException ex) {
           
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
    }

    @Override
    public void faturaode() {
         try{
            pstatement=con.prepareStatement("update  FATURA set FATURABORC=0 where TCKNO= ?");
            pstatement.setString(1, tckno);
          
            pstatement.executeUpdate();
            
                    
        }catch(SQLException ex){
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
    }

   
  
  

    @Override
    public void paracek(double sayi) {
        try {
            pstatement= con.prepareStatement("update PERSONELBANKABILGILERI set BAKIYE= BAKIYE- ? where TCKNO=?");
            pstatement.setDouble(1, sayi);
            pstatement.setString(2, tckno);
           
            pstatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
                
    }

    @Override
    public void parayatir(double sayi) {
        try {
            pstatement= con.prepareStatement("update PERSONELBANKABILGILERI set BAKIYE= BAKIYE+ ? where TCKNO=?");
            pstatement.setDouble(1, sayi);
            pstatement.setString(2, tckno);
           
            pstatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
    }

    
    @Override
    public void kredionaylama() {
        
        try{
            pstatement=con.prepareStatement("select BAKIYE, KREDIKARTIBORC from PERSONELBANKABILGILERI where TCKNO= ?");
            pstatement.setString(1, tckno);
            rset= pstatement.executeQuery();
            if(rset.next()){
                this.bakiye= rset.getDouble("BAKIYE");
                this.kredikartiborc=rset.getDouble("KREDIKARTIBORC");
            }                   
        }catch(SQLException ex){
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
       
        try {
            pstatement= con.prepareStatement("update PERSONELBANKABILGILERI set KREDIONAYDURUMU=? where TCKNO=?");
            pstatement.setString(2, tckno);
            if(bakiye-kredikartiborc>=1000){
                
                pstatement.setBoolean(1, true);
                
            }
            else{
                
                pstatement.setBoolean(1, false);
                
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
        
    }

    
    @Override
    public void kredionaydurumu() {
         try{
            pstatement=con.prepareStatement("select KREDIONAYDURUMU from PERSONELBANKABILGILERI where TCKNO= ?");
            pstatement.setString(1, tckno);
            rset= pstatement.executeQuery();
            if(rset.next()){
                
                this.onay= rset.getBoolean("KREDIONAYDURUMU");
                
            }     
           
        }catch(SQLException ex){
            System.err.println(ex. getErrorCode());
            System.err.println(ex. getMessage());
        }
    }
    
}
