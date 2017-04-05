package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

//Ладья

public class Castle extends Chess {

	@Override
	boolean isRightMove(String from, String to) {
		if (!isRightCell(from) || !isRightCell(to)) {
			return false;
		}
		if (Chess.getCellX(to) == Chess.getCellX(from)
				|| Chess.getCellY(to) == Chess.getCellY(from)) {
			return true;
		} else {
			return false;
		}

	}

}
