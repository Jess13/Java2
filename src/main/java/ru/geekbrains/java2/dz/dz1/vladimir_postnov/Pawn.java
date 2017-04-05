package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

// Пешка

public class Pawn extends Chess {

	@Override
	boolean isRightMove(String from, String to) {
		if (!isRightCell(from) || !isRightCell(to)) {
			return false;
		}
		if (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 1
				&& Chess.getCellX(to) == Chess.getCellX(from)) {
			return true;
		} else {
			return false;
		}

	}

}
