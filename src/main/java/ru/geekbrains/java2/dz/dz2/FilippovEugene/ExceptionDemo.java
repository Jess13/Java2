package ru.geekbrains.java2.dz.dz2.FilippovEugene;


public class ExceptionDemo {

    public static void main(String[] args) {
        String strArray = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        /*вызываем по отдельности все методы
        Matrix test = new Matrix(strArray);
        System.out.println(test.toString());
        int sumArray = test.getSumAllElementMatrix();
        System.out.println("Результат сложения всех элементов матрицы = " + sumArray);
        System.out.println("Результат деления суммы всех элементов матрицы  = " + divNumber(sumArray, 2));*/

        //вызываем все 1 методом
        Matrix test = new Matrix();
        test.executeAll(strArray);
    }

    private static int divNumber(int divisible, int divisor) {
        try {
            return divisible / divisor;
        } catch (ArithmeticException ex) {
            System.out.println("Возникла ошибка: делить на 0 нельзя. Операция не выполнена.");
        }
        return divisible;
    }
}
