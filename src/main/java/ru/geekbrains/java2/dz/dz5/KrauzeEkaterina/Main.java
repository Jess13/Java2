package ru.geekbrains.java2.dz.dz5.KrauzeEkaterina;

import java.util.concurrent.TimeUnit;

public class Main {
    private final static int SIZE = 10 * 1000 * 1000;

    public static void main(String[] args) {
        float[] array1 = new float[SIZE];
        float[] array2 = new float[SIZE];
        long start, finish;

        for (int i = 0; i < SIZE; i++) {
            array1[i] = 1;
            array2[i] = 1;
        }

        start = System.currentTimeMillis();
        Calculator.foreverAlone(array1);
        finish = System.currentTimeMillis();

        printTime(start, finish);

        start = System.currentTimeMillis();
        Calculator.multiPulti(array2);
        finish = System.currentTimeMillis();

        printTime(start, finish);
    }

    private static void printTime(long start, long finish) {
        long duration = finish - start;
        long s = TimeUnit.MILLISECONDS.toSeconds(duration);
        long ms = duration - TimeUnit.SECONDS.toMillis(s);

        System.out.println(s + "s " + ms + "ms");
    }
}