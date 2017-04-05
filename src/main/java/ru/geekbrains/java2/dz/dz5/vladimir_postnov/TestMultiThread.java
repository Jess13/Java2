package ru.geekbrains.java2.dz.dz5.vladimir_postnov;

import java.util.ArrayList;

public class TestMultiThread implements ThreadSize {
	
	//!!!! Количество потоков меняется в интерфейсе !!!!!
	
	static final int h = size / thread;

	public static void main(String[] args) {
		
		long v;
		ArrayList<float[]> allArrays = new ArrayList<float[]>();
		ThreadMultiClass[] mpObjg = new ThreadMultiClass[thread];
		Thread[] t = new Thread[thread];
		float[] arr = new float[size];
		
// 		Заполняем массив единицами
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1; }
		
		
// 		Считаем массив как обычно
		v = System.currentTimeMillis();	
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
			}
		
		System.out.println(System.currentTimeMillis() - v);

// 		Заполняем массив единицами
		
		for (int i = 0; i < size; i++) {
			arr[i] = 1; }
		
//		Считаем массив в два или больше потоков.
		
		v = System.currentTimeMillis();

//		Вопрос - если я посылал в ThreadMultiClass на каждой итерации один и тот же массив из единиц,
//		то выходной массив неверно считался. Ну к примеру - я сделал массив a из единиц и посылал каждый раз его в ThreadMultiClass.
//		По-этому пришлось делать каждый раз разные массивы через ArrayList. 
//		Я делал множество тестов. Можете объяснить почему?

	//		float[] mas = new float[h];
	//		for (int i = 0; i < mas.length; i++) {
	//			mas[i] = 1; }
		for (int i = 0; i < thread; i++) {
		allArrays.add(new float[h]);
		System.arraycopy(arr, i*h, allArrays.get(i), 0, h);
		mpObjg[i] = new ThreadMultiClass(allArrays.get(i), i*h);
	//		mpObjg[i] = new ThreadMultiClass(mas, i*h);
		t[i] = new Thread(mpObjg[i]);
		t[i].start();
		}
		
//		Ждём, пока закончаться потоки, чтобы склеить массивы.
		for (int i = 0; i < thread; i++) {
		try {
			t[i].join();
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
		}
		
//		Склеиваем массивы
		for (int i = 0; i < thread; i++) {
			System.arraycopy(mpObjg[i].getArray(), 0, arr, i*h, h);
		}

		System.out.println(System.currentTimeMillis() - v);
		
}

}
