package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String input = readInput();

        String[] parts = split(input);
        String name = parts[0];
        String startCell = parts[1];
        String finishCell = parts[2];

        MoveCheckable figure = createFigure(name);

        System.out.println(figure.isRightMove(startCell, finishCell));
    }


    private static String readInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    return input;
                }
            }
        }
    }

    private static String[] split(String input) {
        String[] parts = input.split(" ");
        return parts;
    }

    private static MoveCheckable createFigure(String name) {
        switch (name) {
            case "p": return new Pawn();
            case "r": return new Rook();
            case "n": return new Knight();
            case "b": return new Bishop();
            case "q": return new Queen();
            case "k": return new King();
            default:
                throw new IllegalArgumentException("Invalid figure name: " + name);
        }
    }
}
