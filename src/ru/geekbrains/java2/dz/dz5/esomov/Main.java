package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class Main {
    static final int MAS_SIZE = 10000000;
    static final int H = MAS_SIZE/2;

    public static void main(String[] args) {
        Thread newThread = new Thread (new NewThread());
        newThread.start();

        float[] arr = new float[MAS_SIZE];
        for (int i=1; i<arr.length; i++) arr[i]=1.0f;
        long a = System.currentTimeMillis();
        for (int i=1; i<arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//            try {
//                Thread.sleep(0,1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.currentTimeMillis();
        System.out.println("Main Completed, with: "+(System.currentTimeMillis() - a)+" MilliSec");
    }
}
