package ru.geekbrains.java2.dz.dz5.OsmolovskiyAlexandr;
import java.util.Arrays;
import static java.lang.System.nanoTime;

public class MyThread implements Runnable {
    private boolean isActive;

    void disable() {
        isActive = false;
    }

    MyThread() {
        isActive = true;
    }

    public void run() {

        // System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (isActive) {
            // System.out.println("Цикл " + counter++);
            try {
                Thread.sleep (0);
            } catch (InterruptedException e) {
                System.out.println ("Поток прерван");
            }
        }
        //System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
    }

    public static void MyTread() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        long start1 = nanoTime ();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy (arr, 0, a1, 0, h);
        System.arraycopy (arr, h, a2, 0, h);

        MyThread myThread1 = new MyThread ();
        MyThread myThread2 = new MyThread ();
        new Thread (myThread1, "MyThread1").start ();
        new Thread (myThread2, "MyThread2").start ();
        try {
            for (int i = 0; i < h; i++) {
                a1[i] = 1.0f;
            }
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (a1[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5)
                        * Math.cos (0.4f + i / 2));
            }
            Thread.sleep (0);
        } catch (InterruptedException e) {
            System.out.println ("Поток прерван");
        }
        try {
            for (int i = 0; i < h; i++) {
                a2[i] = 1.0f;
            }
            for (int i = 0; i < h; i++) {

                a2[i] = (float) (a2[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5)
                        * Math.cos (0.4f + i / 2));
            }
             Thread.sleep (0);
        } catch (InterruptedException e) {
            System.out.println ("Поток прерван");
        }
        myThread1.disable ();
        myThread2.disable ();
        System.arraycopy (a1, 0, arr, 0, h);
        System.arraycopy (a2, 0, arr, h, h);

        long finish1 = nanoTime ();
        long diff1 = finish1 - start1;
        System.out.println ("Method 2: Diff1 " + diff1);
     }
}