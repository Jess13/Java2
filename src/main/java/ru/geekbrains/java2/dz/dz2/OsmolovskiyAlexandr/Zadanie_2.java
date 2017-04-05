//Задание 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную
//        сумму на 2, и вернуть результат;

package ru.geekbrains.java2.dz.dz2.OsmolovskiyAlexandr;

import java.util.Arrays;

public class Zadanie_2 {

      public static void main(String[] args) {
        //Иницилизируем массив String
        String[][] massive = new String[][]{{"1", "3", "1", "2"}, {"2", "3", "2", "2"}, {"5", "6", "7", "1"}, {"3", "3", "1", "0"}};

//Иницилизируем массив int
        int numArr[][] = new int[4][4];

        for (int i = 0; i <= 3; i++) {
             for (int j = 0; j <= 3; j++)
            { numArr[i][j] = Integer.parseInt(massive[i][j]);}
                  }
         int sum=0;
          for (int i = 0; i <= 3; i++) {
               for (int j = 0; j <= 3; j++)
                  sum +=numArr[i][j];
          }
          System.out.println("Сумма элементов массива: "+sum);
          System.out.println("Половина суммы элементов массива: "+sum/2);

                  System.out.println(Arrays.deepToString(numArr));
    }
}

