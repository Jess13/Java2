package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class NewThread implements Runnable {
    @Override
    public void run() {
        float[] arr = new float[Main.MAS_SIZE];
        for (int i=1; i<arr.length; i++) arr[i]=1.0f;
        long a = System.currentTimeMillis();
        for (int i=1; i<arr.length; i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.currentTimeMillis();
        System.out.println("NewThread Completed, with: "+(System.currentTimeMillis() - a)+" MilliSec");
    }
}
