
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


abstract public class Kullanici implements HesapIslemleri, BankaIslemleri, KrediKartiveFaturaInterface, ParaislemleriInterface{

    
    
    Connection con= Veritabani.connectDb();
    PreparedStatement pstatement= null;
    PreparedStatement updatest= null;
    ResultSet rset= null;
    
    private String tckno, isim, soyisim,sifre;
    private double bakiye, Kredikartiborc;
    private boolean onay;
  
    
    public String getTckno() {
        return tckno;
    }

    public void setTckno(String tckno) {
        this.tckno = tckno;
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

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
  
    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public double getKredikartiborc() {
        return Kredikartiborc;
    }

    public void setKredikartiborc(double Kredikartiborc) {
        this.Kredikartiborc = Kredikartiborc;
    }

    public boolean isOnay() {
        return onay;
    }

    public void setOnay(boolean onay) {
        this.onay = onay;
    }
    

}
