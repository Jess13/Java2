package dz.dz1.KrauzeEkaterina_pravka;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String input = readInput();

        String[] parts = split(input);
        String name = parts[0];
        Point startCell = new Point(parts[1]);
        Point finishCell = new Point(parts[2]);

        MoveCheckable figure = FactoryMetod.createFigure(name);
        if (figure != null) {
            System.out.println(figure.isRightMove(startCell, finishCell));
        } else {
            System.out.println("Invalid figure name: " + name);
        }
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


}
