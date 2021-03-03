/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.util.Scanner;

//Kordinatların alındığı sınıfın oluşturulması
class Point {
     private double x1,x2,x3,x4,y1,y2,y3,y4;

    Point (double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        this.x1=x1; this.y1=y1;
        this.x2=x2; this.y2=y2;
        this.x3=x3; this.y3=y3;
        this.x4=x4; this.y4=y4;   
    }

    public double getX1() {return this.x1;}
    public double getX2() {return this.x2;}    
    public double getY1() {return this.y1;}   
    public double getY2() {return this.y2;}    
    public double getX3() {return this.x3;}    
    public double getX4() {return this.x4;}    
    public double getY3() {return this.y3;}    
    public double getY4() {return this.y4;}    
    
}
// üst sınıf olan dortgen sınıfı oluşturuldu
// alan metodu oluşturuldu ve kare ve dikdortgen için alan hesaplama methodu yazıldı
class Dortgen {

    private Point point;
    private double result;
    private double diff1,diff2,diff3,diff4;
    
    
    Dortgen(Point point){
    this.point=point;
    }

    void alan(){
        //x1y1-x2y2 ve x1y1-x3y3 arasındaki mesafeyi hesapladık
        diff1=Math.sqrt(Math.pow(Math.abs(point.getX1()-point.getX2()),2)+Math.pow(Math.abs(point.getY1()-point.getY2()),2));
        diff2=Math.sqrt(Math.pow(Math.abs(point.getX2()-point.getX3()),2)+Math.pow(Math.abs(point.getY2()-point.getY3()),2));      
        diff3=Math.sqrt(Math.pow(Math.abs(point.getX1()-point.getX4()),2)+Math.pow(Math.abs(point.getY1()-point.getY4()),2));
        diff4=Math.sqrt(Math.pow(Math.abs(point.getX4()-point.getX3()),2)+Math.pow(Math.abs(point.getY4()-point.getY3()),2));
        result= getDiff1()*getDiff2();
    }

        public double getResult() {
            return this.result;
        }          
        public double getDiff1() {
        return diff1;
        }
        public double getDiff2() {
        return diff2;
        }
        public double getDiff3() {
        return diff3;
        }
        public double getDiff4() {
        return diff4;
        }

    }
// dikdortgen sınıfı oluşturuldu dortgen sınıfından miras alarak alanı dortgen sınıfındaki alan() methodundan hesaplandı
class Dikdortgen extends Dortgen{

    Dikdortgen(Point point) {
        super(point);
    }

    
    void alan() {
        super.alan();
        // Girilen kordinatların bir dikdortgene ait olup olmadığı hesaplandı 
        if(getDiff1()== getDiff2() && getDiff3()==getDiff4()){            
            System.out.println("Dikdortgenin alanı: "+ getResult());
            }
            else
            System.out.println("Belirttiğiniz kordinatlar bir dikdortgene ait değildir! ");
    }
}

// Paralelkenar sınıfı oluşturuldu Dortgen sınıfıyla miras ilişkisi kuruldu
// kendi alan() fonksiyonu yazılarak override edildi
class Paralelkenar extends Dortgen {

   private Point point;

    Paralelkenar( Point point) {
        super(point);
        this.point=point;
    }
    @Override
     void alan(){
         // ALAN HESABINDA DORTGEN İKİ ÜÇGEN OLARAK BÖLÜNEREK MATRİSLER ARACILIĞIYLA HESAPLANDI
        double tempX12= point.getX2()-point.getX1();  double tempX14= point.getX4()-point.getX1();
        double tempY12= point.getY2()-point.getY1();  double tempY14= point.getY4()-point.getY1();
        double tempX32= point.getX2()-point.getX3();  double tempX34= point.getX4()-point.getX3();
        double tempY32= point.getY2()-point.getY3();  double tempY34= point.getY4()-point.getY3();

        double alanP1= tempX12*tempY32- tempX32*tempY12;
        alanP1= Math.abs(alanP1/2);
        double alanP2= tempX14*tempY34- tempX34*tempY14;
        alanP2= Math.abs(alanP2/2);
      //  System.out.println(alanP1+alanP2);
        double m1=(tempY12/tempX12);
        double m2=(tempY34/tempX34);
        // PARALELKENARIN ÖZELLİKLERİNDEN DOLAYI EĞER KENARLARIN PARALELLİĞİ KONTROL EDİLDİ VE EĞER PARALEL DEĞİLLERSE ALAN HESAPLANMADI
        // PARALELLİK  EĞİMLERİN EŞİTLİĞİNDEN HESAPLANDI
            if(m1==m2) {
            System.out.println("Paralelkenarın alanı: " + (alanP1+alanP2));
            }
         else{
            System.out.println("Belirttiğiniz kordinatlar bir paralelkenara ait değildir!");
            }
    }
}

class Kare   extends  Dortgen{

        Kare(Point point) {
            super(point);
        }

        void alan() {
            super.alan();
            if(getDiff1()!= getDiff2()){
            System.out.println("Belirttiğiniz kordinatlar bir kareye ait değildir! ");
            }
            else
            System.out.println("Karenin alanı: "+ getResult());
        }
}
    class Yamuk extends Dortgen{

        private Point point;

        Yamuk(Point point) {
            super(point);
            this.point=point;
        }
    @Override
        void alan(){
        double tempX12= point.getX2()-point.getX1();  double tempX14= point.getX4()-point.getX1();
        double tempY12= point.getY2()-point.getY1();  double tempY14= point.getY4()-point.getY1();
        double tempX32= point.getX2()-point.getX3();  double tempX34= point.getX4()-point.getX3();
        double tempY32= point.getY2()-point.getY3();  double tempY34= point.getY4()-point.getY3();

        double alanP1= tempX12*tempY32- tempX32*tempY12;
        alanP1= Math.abs(alanP1/2);
        double alanP2= tempX14*tempY34- tempX34*tempY14;
        alanP2= Math.abs(alanP2/2);

        double m1=(tempY12/tempX12);
        double m2=(tempY34/tempX34);
            if(m1==m2) {
            System.out.println("Yamuğun alanı: "+alanP1+alanP2);
            }
         else{
            System.out.println("Belirttiğiniz kordinatlar bir yamuğa ait değildir!");
            }
        
    }
}
public class Hw5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);
        
        System.out.println("k1  ----------  k2");
        System.out.println("   |----------|   ");
        System.out.println("   |----------|   ");
        System.out.println("k4 |__________| k3");
        System.out.println("Lütfen kordinatları belirtilen düzende giriniz. ");System.out.println();
        //DORTGENİN ÇEŞİDİNİN nextLine() METHODUYLA ALINARAK İŞLEMLERİN YAPILMASI
        System.out.println("Lütfen istediğiniz geometrik cismin (kare, dikdortgen, paralelkenar,yamuk) alanını hesaplatmak için küçük harfle yazınız: ");
        String s = scanner.nextLine();
        
        if(s.equals("kare")||s.equals("yamuk")||s.equals("paralelkenar")||s.equals("dikdortgen")){
        System.out.println("Kordinatları giriniz: ");
        }
        else{
            System.out.println("Geçersiz komut, Lütfen tekrar giriniz.");
            s = scanner.nextLine();
        }
        //KORDİNATLARIN KULLANICIDAN ALINMASI
        double x1,x2,x3,x4,y1,y2,y3,y4;
        System.out.println("k1(x1,y1) Kordinatlarını sırasıyla x ve ye olacak şekilde giriniz:"); x1=scanner.nextDouble();y1=scanner.nextDouble();
        System.out.println("k2(x2,y2) Kordinatlarını sırasıyla x ve ye olacak şekilde giriniz:"); x2=scanner.nextDouble();y2=scanner.nextDouble();
        System.out.println("k3(x3,y3) Kordinatlarını sırasıyla x ve ye olacak şekilde giriniz:"); x3=scanner.nextDouble();y3=scanner.nextDouble();
        System.out.println("k4(x4,y4) Kordinatlarını sırasıyla x ve ye olacak şekilde giriniz:"); x4=scanner.nextDouble();y4=scanner.nextDouble();
        Point point = new Point(x1,y1,x2,y2,x3,y3,x4,y4);

        Dortgen dortgen=new Kare(point);
        Dortgen drtg = new Dikdortgen(point);
        Dortgen prlkenar= new Paralelkenar(point);
        Dortgen yamuk= new Yamuk(point);

        if(s.equals("kare")){ 
            dortgen.alan(); 
        }
        else if( s.equals("dikdortgen") ){ 
            drtg.alan();
        }
        else if(s.equals( "paralelkenar")){
            prlkenar.alan();
        }
        else if(s.equals( "yamuk")){ 
            yamuk.alan(); 
        }
    }
    
}
