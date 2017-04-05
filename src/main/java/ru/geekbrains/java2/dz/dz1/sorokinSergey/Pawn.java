package ru.geekbrains.java2.dz.dz1.sorokinSergey;

public class Pawn extends Chessman {
	
	@Override
	public boolean isRightMove(String from, String to) {
		if (from.charAt(0) != to.charAt(0)) return false;
		if (to.charAt(1) - from.charAt(1) == 1) return true;
		return false;
	};

}
