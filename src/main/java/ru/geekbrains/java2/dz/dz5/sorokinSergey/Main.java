package ru.geekbrains.java2.dz.dz5.sorokinSergey;

public class Main {
	static final int size = 10000000;
	static final int h = size / 2;
	public static float[] a1 = new float[h];
	public static float[] a2 = new float[h];

	public static void main(String[] args) {
		methodOne();
		methodTwo();
		

	}
	
	public static void methodOne() {
		float[] arr = new float[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		long a = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
		System.out.println(System.currentTimeMillis() - a);
	}
	
	public static void methodTwo() 	{
		float[] arr = new float[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		long a = System.currentTimeMillis();
		
		System.arraycopy(arr, 0, a1 , 0, h);
		System.arraycopy(arr, h, a2, 0, h);
		ThreadCalc1 thread1 = new ThreadCalc1();
		ThreadCalc2 thread2 = new ThreadCalc2();
		thread1.start();
		thread2.start();
		System.arraycopy(a1, 0, arr, 0, h);
		System.arraycopy(a2, 0, arr, h ,h);
		
		System.out.println(System.currentTimeMillis() - a);
		
	}

}
