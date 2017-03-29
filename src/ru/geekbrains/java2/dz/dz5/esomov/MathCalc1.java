package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class MathCalc1 implements Runnable {
    @Override
    public void run() {
        float[] arr = new float[Main.MAS_SIZE];
        for (int i=1; i<arr.length; i++) arr[i]=1.00f;
        long a = System.currentTimeMillis();
        for (int i=1; i<arr.length; i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.currentTimeMillis();
        System.out.println("MathCalc1 Completed!");
        System.out.println(System.currentTimeMillis() - a);
    }
}
