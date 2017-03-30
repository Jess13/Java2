package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class Main {
    static final int MAS_SIZE = 10000000;
    private static final int H = MAS_SIZE/2;

    public static void main(String[] args) {
        Thread newThread = new Thread (new NewThread());
        newThread.start();

        float[] arr = new float[MAS_SIZE];
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];
        for (int i=1; i<arr.length; i++) arr[i]=1.0f;
        long a1,a2,a3;

        a1 = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);

        Thread subMain1 = new Thread(() -> {
            for (int i=1; i<arr1.length; i++) arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println("subMain1 completed");
        });
        subMain1.start();

        Thread subMain2 = new Thread(() -> {
            for (int i=1; i<arr2.length; i++) arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println("subMain2 completed");
        });
        subMain2.start();

        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);
        a2 = System.currentTimeMillis();
        System.out.println("Main Completed, with: "+(a2 - a1)+" MilliSec");

        if (newThread.isAlive()) {
            try {
                newThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("NewThread might not be completed");

        a3 = System.currentTimeMillis();
        System.out.println("Main was waiting for NewThread: "+(a3 - a2)+" MilliSec");
    }
}
