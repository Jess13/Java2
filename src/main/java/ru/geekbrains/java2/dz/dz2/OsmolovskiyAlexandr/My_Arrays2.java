package ru.geekbrains.java2.dz.dz2.OsmolovskiyAlexandr;
/*Задание 1. Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)
        1 3 1 2
        2 3 2 2
        5 6 7 1
        3 3 1 0
        Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в
        двумерный массив типа String[][];*/



import java.util.Arrays;
public class My_Arrays2 {
    public static String[] [] MakeArray(String textMassage) {
        //Иницилизируем строку
        String textMessage = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        // Делим нашу строку на 4 String массива по разделителю "\n"
        String[] arrayMessage = textMessage.split("\n");
        //Получаем 4 одномерных String массива, выводим на печать
        //System.out.println(arrayMessage[0]);
        //System.out.println(arrayMessage[1]);
        //System.out.println(arrayMessage[2]);
        //System.out.println(arrayMessage[3]);

        String[]  arrayMessage0=arrayMessage[0].split(" ");
        String[]  arrayMessage1=arrayMessage[1].split(" ");
        String[]  arrayMessage2=arrayMessage[2].split(" ");
        String[]  arrayMessage3=arrayMessage[3].split(" ");

        System.out.println(arrayMessage[0].toString());
        System.out.println(arrayMessage[1].toString());
        System.out.println(arrayMessage[2].toString());
        System.out.println(arrayMessage[3].toString());


        String [] [] arrayMessage22;
        arrayMessage22 = new String[4][4];
        for (int i=0; i<=3;i++)
        {
            arrayMessage22[0] [i] =arrayMessage0[i];
            arrayMessage22[1] [i]=arrayMessage1[i];
            arrayMessage22[2] [i]=arrayMessage2[i];
            arrayMessage22[3] [i]=arrayMessage3[i];
        }

        for (int h = 0; h <= 3; h++) {
            System.out.print(" \n");
            for (int j = 0; j <= 3; j++) {
                System.out.print(" "+arrayMessage22[h][j]);
            }
        }
        System.out.print(" \n");
        System.out.println(" \n"+ Arrays.deepToString(arrayMessage22));

        return arrayMessage22;
    }

    public static void main(String[] args) {



        String textMessage = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        MakeArray(textMessage);
        // System.out.println(arrayMessage);
    }
}