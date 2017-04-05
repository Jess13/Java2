package ru.geekbrains.java2.dz.dz1.sorokinSergey;

public class Rook extends Chessman{
	
	@Override
	public boolean isRightMove(String from, String to) {
		if (from.charAt(0) == to.charAt(0)) return true;
		if (from.charAt(1) == to.charAt(1)) return true;
		return false;
	};

}
