package ru.geekbrains.java2.dz.dz1.vladimir_postnov;

import java.util.Scanner;

public class Runner implements ChessStuff {

	public static void main(String[] args) {

		String chess = null;
		String to = null;
		String from = null;
		Scanner scanner = new Scanner(System.in);

		System.out
				.println("Фигуры - pawn : пешка, bishop : слон, knight : конь, castle : ладья, quenn : ферзь, king : король)");
		System.out
				.println("Введите фигура на английском языке, клетку откуда ходить и клетку куда ходить: ");

		if (scanner.hasNext()) {
			chess = scanner.next();
			to = scanner.next();
			from = scanner.next();
			scanner.close();
			if (Chess.isRightChess(chess) && Chess.isRightCell(to)
					&& Chess.isRightCell(from)) {
				if (chess.equals(CHESSMEN[0])) {
					Pawn pawn = new Pawn();
					System.out.println(pawn.isRightMove(to, from));
				}
				if (chess.equals(CHESSMEN[1])) {
					Bishop bishop = new Bishop();
					System.out.println(bishop.isRightMove(to, from));

				}
				if (chess.equals(CHESSMEN[2])) {
					Knight knight = new Knight();
					System.out.println(knight.isRightMove(to, from));

				}
				if (chess.equals(CHESSMEN[3])) {
					Castle castle = new Castle();
					System.out.println(castle.isRightMove(to, from));

				}
				if (chess.equals(CHESSMEN[4])) {
					Queen queen = new Queen();
					System.out.println(queen.isRightMove(to, from));

				}
				if (chess.equals(CHESSMEN[5])) {
					King king = new King();
					System.out.println(king.isRightMove(to, from));

				}
			}
		} else {
			System.out.println("Вы ничего не ввели");
		}
	}
}