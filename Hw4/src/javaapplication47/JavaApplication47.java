/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication47;

import java.util.Scanner;

/**
 *
 * @author canis
 */
public class JavaApplication47 {

   
    public static int sifrelisayiyazdirma(int sifrelisayi){
        if(sifrelisayi<1000||sifrelisayi>9999){
        System.out.println("GİRDİGİNİZ SAYİ SİFRELENEMEZ!");
        anamenu();
        }
        int[] array; array= new int[4];
        int temp;  int mod;  int k=0;
        while(sifrelisayi>0){
            mod=sifrelisayi%10;
            array[k]=mod;
            sifrelisayi=sifrelisayi/10;
            k++;
        }
        for(int i=0; i<array.length/2; i++){
            temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
        for(int i=0; i<4; i++){
            array[i]= (array[i]+6)%10;
        }
        int firstthird; int secondfourth;
        firstthird=array[0];  secondfourth=array[1];
        array[0]=array[2];    array[1]=array[3];
        array[2]=firstthird;  array[3]= secondfourth;

        System.out.print("SİFRELENMİS SAYİ: ");
        for(int i=0; i<4; i++){
            System.out.print(array[i]);
        }
        int tamlama=0;
        for(int i=0; i<4; i++ ){

            tamlama= tamlama*10 + array[i];

        }
        System.out.println();System.out.println();
        anamenu();
        return tamlama;
   
    }
    public static int sifrecozme(int sifrelisayi){
        int[] array; array= new int[4];
        int temp;  int mod;  int k=0;
        while(sifrelisayi>0){
            mod=sifrelisayi%10;
            array[k]=mod;
            sifrelisayi=sifrelisayi/10;
            k++;
        }
        for(int i=0; i<array.length/2; i++){
            temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
        int sayi1; int sayi2;
        sayi1=array[0]; sayi2=array[1];
        array[0]=array[2]; array[1]=array[3];
        array[2]=sayi1; array[3]=sayi2;
        for(int i=0; i<4; i++){
            array[i]= (array[i]+4)%10;
        }
        if(array[0]==0){
            System.out.print("SİFRELİ HALİNİ GİRDİGİNİZ VERİ 3 BASAMAKLİ OLDUGUNDAN COZUMLENME YAPİLAMAZ!");System.out.println();    
        }
        else
        System.out.println(); System.out.print("SİFRELENMİS SAYİ: "+array[0]+array[1]+array[2]+array[3]);System.out.println();System.out.println();         
        anamenu();
        return 0;
    }    
    public static void anamenu(){
        Scanner input= new Scanner(System.in);
        System.out.println("VERİYİ SİFRELEMEK İÇİN 1'E BASİNİZ");
        System.out.println("SİFRELİ VERİYİ COZUMLEMEK İÇİN 2'YE BASİNİZ");
        System.out.println("CIKIŞ YAPMAK İÇİN 3'E BASİNİZ");
        System.out.println("-------------------------------------------------------------------------");
        int one_or_two= input.nextInt();
      
        switch (one_or_two){
            case 1:
                System.out.print(" SİFRELEMEK İSTEDİGİNİZ SAYİYİ GİRİNİZ: ");
                int sayi= input.nextInt();
                sifrelisayiyazdirma(sayi);
                break;
            case 2:
                System.out.print("COZUMLEMEK İSTEDİĞİNİZ SİFRELENMİS SAYİYİ GİRİN: ");   
                int sifrelenmissayi= input.nextInt();
                sifrecozme(sifrelenmissayi);
                break;
            case 3:
                break;
            default:
                System.out.println("GECERSİZ RAKAM. LUTFEN TEKRAR DENEYİNİZ. ");
                anamenu();
                break;
        }       
    }    
    public static void main(String[] args) {
        anamenu();
    }
    
}
