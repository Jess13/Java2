package ru.geekbrains.java2.dz.dz1.sorokinSergey;

public class King extends Chessman {

	@Override
	public boolean isRightMove(String from, String to) {
		if ((Math.abs(to.charAt(1) - from.charAt(1)) == 1) && (Math.abs(to.charAt(0) - from.charAt(0)) == 1)) return true;
		if ((Math.abs(to.charAt(1) - from.charAt(1)) == 0) && (Math.abs(to.charAt(0) - from.charAt(0)) == 1)) return true;
		if ((Math.abs(to.charAt(1) - from.charAt(1)) == 1) && (Math.abs(to.charAt(0) - from.charAt(0)) == 0)) return true;
		return false;
	};
}
