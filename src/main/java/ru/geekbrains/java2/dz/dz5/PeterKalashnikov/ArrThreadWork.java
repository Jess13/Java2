package ru.geekbrains.java2.dz.dz5.PeterKalashnikov;


public class ArrThreadWork extends Thread{
    private float[] arr;

    public ArrThreadWork(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println("Sub thread.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i]*Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
    }

    public float[] getArr() {
        return arr;
    }
}
