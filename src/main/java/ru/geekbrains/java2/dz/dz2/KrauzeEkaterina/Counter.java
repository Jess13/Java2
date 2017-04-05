package ru.geekbrains.java2.dz.dz2.KrauzeEkaterina;

import java.util.Scanner;

public class Counter {

    public static final int COUNT = 4;

    public static void main(String[] args) {
        try {
            double result = count("1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 1");
            System.out.println(result);
        } catch (IllegalArgumentException | NotIntegerException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double count(String string) throws NotIntegerException {
        String[][] matrix = createMatrix(string);

        if (!isMatrixValid(matrix)) {
            throw new IllegalArgumentException("Matrix is not 4x4");
        }

        int sum = 0;

        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = 0; j < matrix[i].length; j +=1) {
                if (!isInteger(matrix[i][j])) {
                    throw new NotIntegerException("Matrix has illegal symbols");
                }
                int x = Integer.parseInt(matrix[i][j]);
                sum += x;
            }
        }

        return sum / 2.0;
    }

    private static String[][] createMatrix(String string) {
        String[] rows = string.split("\n");
        String[][] matrix = new String[rows.length][];

        for (int i = 0; i < rows.length; i += 1) {
            matrix[i] = rows[i].split(" ");
        }

        return matrix;
    }

    private static boolean isMatrixValid(String[][] matrix) {
        if (matrix.length != COUNT) return false;

        for (String[] row : matrix) {
            if (row.length != COUNT) return false;
        }

        return true;
    }

    private static boolean isInteger(String s) {
        Scanner scanner = new Scanner(s);
        if (!scanner.hasNextInt()) return false;
        scanner.nextInt();
        return !scanner.hasNext();
    }
}
