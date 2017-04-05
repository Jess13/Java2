package ru.geekbrains.java2.dz.dz5.sorokinSergey;

public class ThreadCalc2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < Main.a2.length; i++) {
			Main.a2[i] = (float)(Main.a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
	}
}
