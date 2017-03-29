package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class MathCalc2 implements Runnable {
    @Override
    public void run() {
        float[] arr = new float[Main.MAS_SIZE];
        float[] a1 = new float[Main.H];
        float[] a2 = new float[Main.H];
        for (int i=1; i<arr.length; i++) arr[i]=1.00f;
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, Main.H);
        System.arraycopy(arr, Main.H, a2, 0, Main.H);
        for (int i=1; i<a1.length; i++) a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        for (int i=1; i<a2.length; i++) a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.currentTimeMillis();
        System.out.println("MathCalc2 Completed!");
        System.out.println(System.currentTimeMillis() - a);
    }
}
