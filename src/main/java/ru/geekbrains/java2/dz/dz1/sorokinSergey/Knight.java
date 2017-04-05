package ru.geekbrains.java2.dz.dz1.sorokinSergey;

public class Knight extends Chessman{

	@Override
	public boolean isRightMove(String from, String to) {
		if (to.charAt(0) + 1 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) + 2) return true;
		if (to.charAt(0) - 1 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) + 2) return true;
		if (to.charAt(0) + 2 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) + 1) return true;
		if (to.charAt(0) - 2 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) + 1) return true;
		if (to.charAt(0) + 1 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) - 2) return true;
		if (to.charAt(0) - 1 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) - 2) return true;
		if (to.charAt(0) + 2 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) - 1) return true;
		if (to.charAt(0) - 2 == from.charAt(0) &&  to.charAt(1) == from.charAt(1) - 1) return true;
		return false;
	};
}
