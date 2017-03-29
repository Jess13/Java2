package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,8,5,7,83,54,9,7};
        int[] a1 = new int[arr.length/2];
        System.arraycopy(arr,5,a1,0,2);
        for (int i=0; i<a1.length; i++) System.out.println(a1[i]);
    }
}
