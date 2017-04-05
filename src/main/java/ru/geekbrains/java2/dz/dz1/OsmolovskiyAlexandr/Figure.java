package ru.geekbrains.java2.dz.dz1.OsmolovskiyAlexandr;
import java.io.*;
import java.util.Scanner;
import static java.lang.Math.abs;



public abstract class Figure {
    public static void main(String[] args) {
        int x1=0;
        int x2=0;
        String p = null;
        String m = null;
        System.out.println("Enter 1 field(example e5:from a to h and digit from 1 to 8):");
        Scanner sc = new Scanner(System.in);
        String s1;
        s1 = sc.nextLine();
        String Str1 = s1;
        int y1=Integer.parseInt(Str1.substring(1,2));
        y1=9-y1;
        p=Str1.substring(0,1);

        switch (p){
            case  "a":
                x1=1;
                break;

            case  "b":
                x1=2;
                break;

            case  "c":
                x1=3;
                break;

            case  "d":
                x1=4;
                break;

            case  "e":
                x1=5;
                break;

            case  "f":
                x1=6;
                break;

            case  "g":
                x1=7;
                break;

            case  "h":
                x1=8;
                break;

            default: p="No field";
                break;
        }
        System.out.println("Enter 2 field:(example e5:from a to h and digit from 1 to 8)");
        Scanner sc2 = new Scanner(System.in);
        String s2;
        s2 = sc.nextLine();
        String Str2 = s2;
        int y2=Integer.parseInt(Str2.substring(1,2));
        y2=9-y2;
        String l=null;
        l=Str2.substring(0,1);
        switch (l){
            case  "a":
                x2=1;
                break;

            case  "b":
                x2=2;
                break;

            case  "c":
                x2=3;
                break;

            case  "d":
                x2=4;
                break;

            case  "e":
                x2=5;
                break;

            case  "f":
                x2=6;
                break;

            case  "g":
                x2=7;
                break;

            case  "h":
                x2=8;
                break;

            default: p="No field";
                break;
        }
        System.out.println("X1 = "+x1);
        System.out.println("X2 = "+x2);
        System.out.println("Y1 = "+y1);
        System.out.println("Y2 = "+y2);


        System.out.println("Enter chess figure(Pawn, Rook, Officer, Knight, King, Queen):");
        Scanner s = new Scanner(System.in);
        String s3;
        s3 = sc.nextLine();
        boolean z=false;
        switch (s3){
            case  "Pawn":
                if((x1==x2&&Math.abs(y2-y1)==1)||((x1==x2)&&((y1==2)||(y1==7))&&(Math.abs(y2-y1)==2)))
                {z=true;}
                break;

            case  "Rook":
                if((x2-x1)==0||((y2-y1)==0))
                {z=true;}
                break;

            case  "Officer":
                if( (y2+x2)==(y1+x1)||(Math.abs(y2-x2)==1&&Math.abs(y1-x1)==1))
                {z=true;}
                break;

            case  "Knight":
                if( ((Math.abs(y2-y1)==1)&&(Math.abs(x2-x1)==2))||((Math.abs(y2-y1)==2)&&(Math.abs(x2-x1)==1)))
                {z=true;}
                break;

            case  "King":
                if( (Math.abs(y2-y1)<=1)&&(Math.abs(x2-x1)<=1))
                {z=true;}
                break;

            case  "Queen":
                if(((y2+x2)==(y1+x1))||((Math.abs(y2-x2)==1)&&(Math.abs(y1-x1)==1))||((x2-x1)==0||(y2-y1)==0))
                {z=true;}
                break;

            default: s3="No field";
                System.out.println("This is not chess figure");
                break;
        }

        System.out.println("figure is "+s3);
        System.out.println("Field is "+z);
    }
}

//pawn пешка
// rook ладья
//officer офицер
// knight конь
//king король
//queen королева

/*
   Перевод букв в цифры
1	2	3	4	5	6	7	8
A	B	C	D	E	F	F	H
Y=9-Y

   пешка
       x1=x2,Math.abs(y2-y1)=1)||(x1=x2,y=2||y=7)&&Math.abs(y2-y1)=2)

        ладья
        ((x2-x1)=0||(y2-y1)=0)

        слон
        (y2+x2)=(y1+x1)||(Math.abs(y2-x2)=Math.abs(y1-x1)=1)

        ферзь
        ((y2+x2)=(y1+x1))||(Math.abs(y2-x2)=Math.abs(y1-x1)=1)||((x2-x1)=0||(y2-y1)=0)

        Король
        (Math.abs(y2-y1)<=1)&&(Math.abs(x2-x1)<=1)

        Конь
        (Math.abs(y2-y1)=1)&&(Math.abs(x2-x1)=2)||(Math.abs(y2-y1)=2)&&(Math.abs(x2-x1)=1)
*/