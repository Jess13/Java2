package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

public class Knight extends Chess {
	@Override
	boolean isRightMove(String from, String to) {
		if (!isRightCell(from) || !isRightCell(to)) {
			return false;
		}
		if (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 1
				&& Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 2
				|| Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 2
				&& Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 1) {
			return true;
		} else {
			return false;
		}

	}
}
