package ru.geekbrains.java2.dz.dz5.esomov;

/**
 * Created by spo_admin4 on 29.03.2017.
 */
public class Main {
    static final int MAS_SIZE = 10000000;
    private static final int H = MAS_SIZE/2;

    public static void main(String[] args) {
        Thread newThread = new Thread (new NewThread()); //2-й поток newThread для расчета arr
        newThread.start();

        float[] arr = new float[MAS_SIZE]; //основной массив
        float[] arr1 = new float[H]; //массивы для разбиения и склеивания основного
        float[] arr2 = new float[H];
        for (int i=1; i<arr.length; i++) arr[i]=1.0f; //заполнения массива 1-ми
        long a1,a2,a3; // переменные для подсчета времени

        a1 = System.currentTimeMillis(); // Время от начала  деления массива
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);

        Thread subMain1 = new Thread(() -> { //Рассчет поделенного массива в отдельном потоке
            for (int i=1; i<arr1.length; i++) arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println("subMain1 completed");
        });
        subMain1.start();
        if (subMain1.isAlive()) {
            try {subMain1.join();} catch (InterruptedException e) { e.printStackTrace(); }
        }

        Thread subMain2 = new Thread(() -> { //Рассчет поделенного массива в отдельном потоке
            for (int i=1; i<arr2.length; i++) arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println("subMain2 completed");
        });
        subMain2.start();
        if (subMain2.isAlive()) {
            try {subMain2.join();} catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.arraycopy(arr1, 0, arr, 0, H); //Склеивание массива
        System.arraycopy(arr2, 0, arr, H, H);
        a2 = System.currentTimeMillis(); //Время работы Main от начала разбения до склеивания массива
        System.out.println("Main Completed, with: "+(a2 - a1)+" MilliSec");

        if (newThread.isAlive()) { //Проверка не завершился ли 2-й поток
            try {
                newThread.join(); //Ожидание работы newThread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("NewThread might not be completed");

        a3 = System.currentTimeMillis(); //Время работы Main после ожидания 2-го потока newThread
        System.out.println("Main was waiting for NewThread: "+(a3 - a2)+" MilliSec");
    }
}
