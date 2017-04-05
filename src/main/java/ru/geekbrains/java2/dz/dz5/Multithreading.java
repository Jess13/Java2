package ru.geekbrains.java2.dz.dz5.ShagidullinIldar;

import java.util.Arrays;

public class Multithreading {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }
    private static void methodOne(){
        long timeStart = System.currentTimeMillis() ;
        
        float[] arr = new float[size];
            for (int i = 0; i <size ; i++) {
                arr[i] = 1;
        }
            for (int i = 0; i <size ; i++){
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Время выполнения метода 1:" + (timeEnd-timeStart));
      

         
    }
    private static void methodTwo(){
        long timeStart=System.currentTimeMillis();
        
        float[] arr = new float[size];
            for (int i = 0; i <size ;i++) {
                arr[i] = 1;
        }

        float[] a1 = new  float[h];
        float[] a2 = new  float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        for (int i = 0; i <h ; i++){
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         }
        for (int i = 0; i <h ; i++){
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, 10000000/2, h);

        long timeEnd = System.currentTimeMillis();
        System.out.println("Время выполнения метода 2:" + (timeEnd-timeStart));
    }

}
