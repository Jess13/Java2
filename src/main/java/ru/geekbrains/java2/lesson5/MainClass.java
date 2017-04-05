package ru.geekbrains.java2.lesson5;

/**
 * Created by Home-pc on 01.09.2016.
 */
public class MainClass {
    StringBuffer stringBuffer;
    private static int i = 0;
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread thread1 = new Thread(myRun);
        thread1.setPriority(10);
        thread1.start();
        MyThread thread2 = new MyThread();
        thread2.start();
        System.out.println("start main");
        for (int i = 0; i < 10; i++) {
            System.out.println("main " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("stop main");
    }

    public static synchronized void sum () {

        System.out.println(i++);
    }

}
