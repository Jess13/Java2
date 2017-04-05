package ru.geekbrains.java2.dz.dz1.sorokinSergey;

public class Bishop extends Chessman {

	@Override
	public boolean isRightMove(String from, String to) {
		if (Math.abs(from.charAt(1) - to.charAt(1)) == Math.abs(from.charAt(0) - to.charAt(0))) return true;
		return false;
	};
}
