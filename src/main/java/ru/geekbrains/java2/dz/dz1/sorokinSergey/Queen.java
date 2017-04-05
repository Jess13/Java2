package ru.geekbrains.java2.dz.dz1.sorokinSergey;

public class Queen extends Chessman {

	@Override
	public boolean isRightMove(String from, String to) {
		if (Math.abs(from.charAt(1) - to.charAt(1)) == Math.abs(from.charAt(0) - to.charAt(0))) return true;
		if (from.charAt(0) == to.charAt(0)) return true;
		if (from.charAt(1) == to.charAt(1)) return true;
		return false;
	};
}
