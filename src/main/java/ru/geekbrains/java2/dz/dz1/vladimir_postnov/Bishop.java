package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

//Слон

public class Bishop extends Chess {

	@Override
	boolean isRightMove(String from, String to) {
		if (!isRightCell(from) || !isRightCell(to)) {
			return false;
		}
		if ((Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 1)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 1)
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 2)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 2)
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 3)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 3)
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 4)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 4)
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 5)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 5)
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 6)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 6)
				|| (Math.abs((Chess.getCellY(to) - Chess.getCellY(from))) == 7)
				&& (Math.abs((Chess.getCellX(to) - Chess.getCellX(from))) == 7)) {
			return true;
		} else {
			return false;
		}

	}

}
