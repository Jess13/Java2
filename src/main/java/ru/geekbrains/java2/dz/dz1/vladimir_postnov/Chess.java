package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

public abstract class Chess implements ChessStuff {

	abstract boolean isRightMove(String from, String to);

	static boolean isRightChess(String chess) {
		if (chess == null) {
			return false;
		}
		for (int i = 0; i < CHESSMEN.length; i++) {
			if (chess.equalsIgnoreCase(CHESSMEN[i])) {
				return true;
			}
		}
		System.out.println("Error: Нет такой фигуры");
		return false;
	};

	static boolean isRightCell(String cell) {
		if (cell == null) {
			return false;
		}
		for (int j = 0; j < BOARD.length; j++) {
			for (int i = 0; i < BOARD[j].length; i++) {
				if (cell.equalsIgnoreCase(BOARD[j][i])) {
					return true;
				}
			}
		}
		System.out.println("Error: Нет такой клетки");
		return false;
	};

	static int getCellY(String cell) {
		int cell_y = -1;
		for (int j = 0; j < BOARD.length; j++) {
			for (int i = 0; i < BOARD[j].length; i++) {
				if (cell.equalsIgnoreCase(BOARD[j][i])) {
					cell_y = j;
				}
			}
		}
		return cell_y;
	};

	static int getCellX(String cell) {
		int cell_x = -1;
		for (int j = 0; j < BOARD.length; j++) {
			for (int i = 0; i < BOARD[j].length; i++) {
				if (cell.equalsIgnoreCase(BOARD[j][i])) {
					cell_x = i;
				}
			}
		}
		return cell_x;
	};

}