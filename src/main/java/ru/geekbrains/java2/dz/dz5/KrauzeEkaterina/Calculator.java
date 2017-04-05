package ru.geekbrains.java2.dz.dz5.KrauzeEkaterina;

import java.util.Arrays;

public class Calculator extends Thread {

    private float[] array;

    private Calculator(float[] array) {
        this.array = array;
    }

    private float[] getArray() {
        return array;
    }

    static float[] foreverAlone(float[] array) {
        return calculate(array);
    }

    static float[] multiPulti(float[] array) {
        float[] part1 = Arrays.copyOfRange(array, 0, array.length / 2);
        float[] part2 = Arrays.copyOfRange(array, array.length / 2, array.length);

        Calculator thread1 = new Calculator(part1);
        Calculator thread2 = new Calculator(part2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {}

        part1 = thread1.getArray();
        part2 = thread2.getArray();

        float[] result = new float[part1.length + part2.length];

        System.arraycopy(part1, 0, result, 0, part1.length);
        System.arraycopy(part2, 0, result, part1.length, part2.length);

        return result;
    }

    @Override
    public void run() {
        array = calculate(array);
    }

    private static float[] calculate(float[] array) {
        float[] result = new float[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return result;
    }
}