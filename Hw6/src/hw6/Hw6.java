/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;
import java.util.Scanner;

interface Odeme{
    double maasHesapla();
}
 abstract class Calisan implements Odeme{
    private String ad;
    private String soyad;
    private String sskno;
    Calisan(String ad, String soyad, String sskno) {
        this.ad = ad;
        this.sskno = sskno;
        this.soyad = soyad;
    }

    public String getAd() {
        return this.ad;
    }

    public String getSoyad() {
        return this.soyad;
    }

    public String getSskno() {
        return this.sskno;
    }
}


class MaasliCalisan extends Calisan{
    private double haftalikmaas;

    MaasliCalisan(double haftalikmaas, String ad, String soyad, String sskno){
        super(ad, soyad, sskno);
        this.haftalikmaas= haftalikmaas;
    }
       
    @Override
    public double maasHesapla() {
        double maas= haftalikmaas *4;

        System.out.print( this.getAd()+" "+this.getSoyad()+", SSK Numaraniz: "+this.getSskno()+", Maas: ");
        return maas;
    } 
}


class SaatliCalisan extends Calisan{
    private double  saatlikucret;
    private double calismasaati;

    SaatliCalisan(double saatlikucret, double calismasaati, String ad, String soyad, String sskno){
        super(ad, soyad, sskno);
        this.saatlikucret=saatlikucret;
        this.calismasaati=calismasaati;
    }

    @Override
    public double maasHesapla() {
        double maas;
        if(calismasaati <40){
        maas= saatlikucret * calismasaati;
        }
        else{
            double temp;
            temp= calismasaati -40;
            maas= saatlikucret * calismasaati + ((saatlikucret *3)/2)*temp;
        }
        System.out.print( this.getAd()+" "+this.getSoyad()+", SSK Numaraniz: "+this.getSskno()+", Maas: ");
        return maas;
    }

}


class PrimliCalisan extends Calisan{
    private double prim;
    private double satissayisi;

    PrimliCalisan(double prim, double satissayisi, String ad, String soyad, String sskno){
        super(ad, soyad, sskno);

        this.prim=prim;
        this.satissayisi=satissayisi;

    }
    @Override
    public double maasHesapla() {
        double maas;
        maas= prim * satissayisi;
        System.out.print( this.getAd()+" "+this.getSoyad()+", SSK Numaraniz: "+this.getSskno()+", Maas: ");
        return maas;
    }


}


class CalisanGir{
    
    private Calisan[] calisanArray= new Calisan[3];
    Scanner scanner= new Scanner(System.in);
    
    void calisanaGirCalistir(){
    
        for(int i=0; i<3; i++){
            System.out.print("Maasli Calisan Eklemek Icin 1, Saatlik Ucret ile Calisan Isci Eklemek Icin 2, Prim ile Calisan Eklemek Icin 3'e Basiniz. ");
            int tercih= scanner.nextInt();

            switch (tercih){
                case 1:
                    System.out.println("Ad: ");
                    String isim= scanner.next();
                    System.out.println("Soyad: ");
                    String soyisim= scanner.next();
                    System.out.println("SSK Numaraniz: ");
                    String id= scanner.next();
                    System.out.println("Haftalik Ucretiniz: ");
                    double haftalik= scanner.nextDouble();
                    calisanArray[i]= new MaasliCalisan(haftalik,isim,soyisim,id);
                    break;
                case 2:
                    System.out.println("Ad: ");
                    String isim1= scanner.next();
                    System.out.println("Soyad: ");
                    String soyisim1= scanner.next();
                    System.out.println("SSK Numaranİz: ");
                    String id1= scanner.next();
                    System.out.println("Saatlik ucretiniz: ");
                    double saatlik= scanner.nextDouble();
                    System.out.println("Kac Saat Calistiniz: ");
                    double calismasaati= scanner.nextDouble();
                    calisanArray[i]= new SaatliCalisan(saatlik,calismasaati,isim1,soyisim1,id1);
                    break;
                case 3:
                    System.out.println("Ad: ");
                    String isim2= scanner.next();
                    System.out.println("Soyad: ");
                    String soyisim2= scanner.next();
                    System.out.println("SSK Numaraniz: ");
                    String id2= scanner.next();
                    System.out.println("Satis Basina Aldiginiz Prim: ");
                    double prim= scanner.nextDouble();
                    System.out.println("Kac Satis Yaptiniz: ");
                    double satis= scanner.nextDouble();
                    calisanArray[i]= new PrimliCalisan(prim,satis,isim2,soyisim2,id2);
                    break;    
                default: 
                    System.out.println("Gecersiz numara!");
                    i--;
                    break;

            }
        }
        for(int i=0; i<3; i++){

            System.out.println(calisanArray[i].maasHesapla());
        }
        
    }
}
public class Hw6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalisanGir calisangir= new CalisanGir();
        calisangir.calisanaGirCalistir();
    }
    
}
