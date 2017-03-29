package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class Main {
    static final int MAS_SIZE = 10000000;
    static final int H = MAS_SIZE/2;

    public static void main(String[] args) {
        Thread thread1 = new Thread (new MathCalc1());
        thread1.start();
        Thread thread2 = new Thread (new MathCalc2());
        thread2.start();
    }
}
