package ru.geekbrains.java2.dz.dz5.Aristarkhov_Ilya;


public class Main {
    private static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static void oneThread(){

        System.out.println("Начинается однопоточное заполнение массива");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis();
        System.out.println("Однопоточное заполнение массива заняло " + (end-start)/1000 + " секунд. \n\n");
    }

    static void twoThread(){

        System.out.println("Начинается двухпоточное заполнение массива");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        FillerThread fill_1 = new FillerThread(a1);
        fill_1.start();

        FillerThread fill_2 = new FillerThread(a2);
        fill_2.start();

        try {
            fill_1.join();
            fill_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h ,h);
        long end = System.currentTimeMillis();
        System.out.println("Двухпоточное заполнение массива заняло " + (end-start)/1000 + " секунд.");
    }

    public static void main(String[] args) {
        oneThread();

        twoThread();


    }

}
