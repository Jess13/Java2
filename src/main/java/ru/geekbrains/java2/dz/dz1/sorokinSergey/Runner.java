package ru.geekbrains.java2.dz.dz1.sorokinSergey;

import java.util.Scanner;

public class Runner {
	
	public static Scanner scanner = new Scanner(System.in);
	public static String selectedChessman = null;
	public static String from = null;
	public static String to = null;

	public static void main(String[] args) {
		System.out.println("Список фигур: \n пешка \n ладья \n слон \n конь \n ферзь \n король \n");
		System.out.println("Выберите фигуру:");
		
		while (true){
			if (scanner.hasNextLine()) {
				selectedChessman = scanner.nextLine();
				if (!selectedChessman.isEmpty()) {
					if (inputValidationChessman(selectedChessman)) {
						scanner = new Scanner(System.in);
						break;
					}
					else {
						System.out.println("ошибка. нет такой фигуры!");
					}
				}	
			}
			System.out.println("ошибка. введите название фигуры!");
			scanner = new Scanner(System.in);
		}
		
		System.out.println("Шахматная доска по горизонтали имеет координаты от \"a\" до \"h\" а по вертикали от 1 до 8. ");
		System.out.println("Вводите координаты в формате букваЦифра. Подряд. Например d1. Английскими буквами");
		
		while (true) {
			System.out.println("Введите координаты [<откуда ходим> <куда ходим>]:");
			if (scanner.hasNext()) {
				from = scanner.next();
			}
			else {
				System.out.println("[Ошибка] Введены неверные координаты.");
				scanner = new Scanner(System.in);
				continue;
			}
			if (scanner.hasNext()) {
				to = scanner.next();
					if (isFromNormal() && isToNormal()) {
						scanner = new Scanner(System.in);
						break;
					}
					else {
						System.out.println("[Ошибка] Координаты могут быть в пределах от \"a\" до \"h\" и от 1 до 8.");
						scanner = new Scanner(System.in);
					}
					
			}
			else {
				System.out.println("[Ошибка] Введены неверные координаты.");
				scanner = new Scanner(System.in);
				continue;
			}
			
		}
		
			
			switch (selectedChessman) {
				case "пешка": {
					Chessman pawn = new Pawn();
					System.out.println(pawn.isRightMove(from, to));
					break;
				}
				case "ладья": {
					Chessman rook = new Rook();
					System.out.println(rook.isRightMove(from, to));
					break;
				}
				case "конь": {
					Chessman knight = new Knight();
					System.out.println(knight.isRightMove(from, to));
					break;
				}
				case "слон": {
					Chessman bishop = new Bishop();
					System.out.println(bishop.isRightMove(from, to));
					break;
				}
				case "ферзь": {
					Chessman queen = new Queen();
					System.out.println(queen.isRightMove(from, to));
					break;
				}
				case "король": {
					Chessman king = new King();
					System.out.println(king.isRightMove(from, to));
					break;
				}
			}
			
		
	}
	
	public static boolean inputValidationChessman (String value) {
	
		switch (value) {
			case "пешка": {
				return true;
			}
			case "ладья": {
				return true;
			}
			case "конь": {
				return true;
			}
			case "слон": {
				return true;
			}
			case "ферзь": {
				return true;
			}
			case "король": {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isFromNormal () {
		for (int i = 0; i < 8; i++ ) {
			if (from.charAt(0) == Chessman.fieldWords[i]) {
				for (int j = 0; j < 8; j++ ) {
					if (from.charAt(1) == Chessman.fieldNumber[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isToNormal () {
		for (int i = 0; i < 8; i++ ) {
			if (to.charAt(0) == Chessman.fieldWords[i]) {
				for (int j = 0; j < 8; j++ ) {
					if (to.charAt(1) == Chessman.fieldNumber[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}


}
