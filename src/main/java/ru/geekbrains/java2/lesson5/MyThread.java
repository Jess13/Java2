package ru.geekbrains.java2.lesson5;

import static ru.geekbrains.java2.lesson5.MainClass.sum;

/**
 * Created by Админ on 27.03.17.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start Thread");
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("stop Thread");
    }
}
