package ru.geekbrains.java2.dz.dz5.PeterKalashnikov;


public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE/4;
    static float[] arr = new float[SIZE];
    static long timeWork;

    static void arrInit() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        arrInit();
        System.out.println("Work in single thread:");
        singleThread();
        arrInit();
        System.out.println("Work in multithread:");
        multiThread();
    }

    static void singleThread() {
        timeWork = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i]*Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        printInfo();
    }

    static void multiThread() throws InterruptedException {
        float[] arrA1, arrA2, arrA3, arrA4;
        arrA1 = new float[H];
        arrA2 = new float[H];
        arrA3 = new float[H];
        arrA4 = new float[H];

        timeWork = System.currentTimeMillis();
        System.arraycopy(arr, 0, arrA1, 0, H);
        System.arraycopy(arr, H, arrA2, 0, H);
        System.arraycopy(arr, 2*H, arrA3, 0, H);
        System.arraycopy(arr, 3*H, arrA4, 0, H);



        ArrThreadWork arrThreadWork1 = new ArrThreadWork(arrA2);
        arrThreadWork1.start();
        arrA2 = arrThreadWork1.getArr();

        ArrThreadWork arrThreadWork2 = new ArrThreadWork(arrA3);
        arrThreadWork2.start();
        arrA3 = arrThreadWork2.getArr();

        ArrThreadWork arrThreadWork3 = new ArrThreadWork(arrA4);
        arrThreadWork3.start();
        arrA4 = arrThreadWork3.getArr();

        System.out.println("Main thread.");
        for (int i = 0; i < arrA1.length; i++) {
            arrA1[i] = (float) (arrA1[i]*Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }

        arrThreadWork1.join();
        arrThreadWork2.join();
        arrThreadWork3.join();
        System.arraycopy(arrA1, 0, arr, 0, H);
        System.arraycopy(arrA2, 0, arr, H, H);
        System.arraycopy(arrA3, 0, arr, 2*H, H);
        System.arraycopy(arrA4, 0, arr, 3*H, H);
        printInfo();
    }

    static void printInfo () {
        System.out.println("Time: " + (System.currentTimeMillis()-timeWork) + " msec.\n");
    }
}
