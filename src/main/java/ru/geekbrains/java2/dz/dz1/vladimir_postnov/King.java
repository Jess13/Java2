package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

//Король

public class King extends Chess {

	@Override
	boolean isRightMove(String from, String to) {
		if (!isRightCell(from) || !isRightCell(to)) {
			return false;
		}
		if ((Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 1)
				&& (Chess.getCellX(to) == Chess.getCellX(from))
				|| (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 1)
				&& (Chess.getCellY(to) == Chess.getCellY(from))
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 1)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 1)) {
			return true;
		} else {
			return false;
		}

	}
}
