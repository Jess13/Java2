package ru.geekbrains.java2.dz.dz5.vladimir_postnov;

public class ThreadMultiClass extends Thread implements ThreadSize {
	
	static final int h = size / thread;
	private float[] a;
	private int n = 0;

	ThreadMultiClass (float[] a, int n) {
		this.a = a;
		this.n = n;
	}
	
	public void run() {
			
		for (int i = 0; i < a.length; i++) {
			a[i] = (float)(a[i] * Math.sin(0.2f + (i+n) / 5) * Math.cos(0.2f + (i+n) / 5) * Math.cos(0.4f + (i+n) / 2));
			}				
	}
	
	public float[] getArray() {
		
		return a;
		
	}

}
