package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class MathCalc2 implements Runnable {
    @Override
    public void run() {
        float[] arr = new float[Main.MAS_SIZE];
        float[] arr1 = new float[Main.H];
        float[] arr2 = new float[Main.H];
        for (int i=1; i<arr.length; i++) arr[i]=1.00f;
        long a1,a2;

        a1 = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, Main.H);
        System.arraycopy(arr, Main.H, arr2, 0, Main.H);

        Thread thread3 = new Thread(() -> {
            for (int i=1; i<arr1.length; i++) arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        });
        thread3.start();

        Thread thread4 = new Thread(() -> {
            for (int i=1; i<arr2.length; i++) arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        });
        thread4.start();

        System.arraycopy(arr1, 0, arr, 0, Main.H);
        System.arraycopy(arr2, 0, arr, Main.H, Main.H);
        a2 = System.currentTimeMillis();
        System.out.println("MathCalc2 Completed, with: "+(a2 - a1)+" MilliSec");
    }
}
