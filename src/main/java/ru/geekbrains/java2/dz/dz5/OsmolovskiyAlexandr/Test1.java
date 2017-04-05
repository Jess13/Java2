package ru.geekbrains.java2.dz.dz5.OsmolovskiyAlexandr;
import static java.lang.System.nanoTime;

public  class Test1 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void Test1() {
        float[] arr = new float[size];
        long start1 = nanoTime();
        for (int i = 0; i <size ; i++) {
            arr[i]=1;
        }
        long finish1 = nanoTime();
        long start2 = nanoTime();
        for (int j = 0; j <size ; j++) {
        arr[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5)
                * Math.cos(0.4f + j / 2));
        }
        long finish2=nanoTime();

        long Diff1= finish1 - start1;
        long Diff2= finish2 - start2;
        long Diff3=Diff1+Diff2;
        //System.out.println("Method 1: Diff1 "+Diff1);
        System.out.println("Method 1: Diff2 "+Diff2);
        //System.out.println("Method 1: Diff3 "+Diff3);

    }


}