package dz.dz2.esomov;

import java.util.Scanner;

/**
 * Created by Jess on 19.03.2017.
 */
public class MyException {

    //Преобразование строки в массив типа String
    private static String[][] str2mas(String str) {
        String[] mas1 = str.split("\n");
        String[][] mas2 = new String[mas1.length][];
        for (int i=0; i<mas1.length; i++){
            mas2[i] = mas1[i].split(" ");
        }
        if (mas1.length != 4 || mas2.length != 4) throw new ArrayIndexOutOfBoundsException("Размер матрицы не равен 4Х4");
        return mas2;
    }

    //Преобразование массива типа String в тип Int
    private static int str2int (String[][] mas) {
        int[][] mas3 = new int[mas.length][mas.length];
        //TODO Переработать перебор массива в цикле!!!
        int sum = 0;
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                mas3[i][j] = Integer.parseInt(mas[i][j]);
                System.out.print(mas3[i][j]+"   ");
                sum += mas3[i][j];
            }
        }
        System.out.println(sum/2);
        return sum/2;
    }

    public static void main(String[] args) {

//        for (String element: str1){ System.out.println(element); }
        String str = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0 1 1 4 5 3 5 v d t e";
        String[][] mas = str2mas(str);
        str2int(mas);
    }
}
