package ru.geekbrains.java2.dz.dz2.FilippovEugene;

public class Matrix {
    private String[][] matrix;

    Matrix(int row, int col) {
        this.matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.matrix[i][j] = "";
            }
        }
    }

    Matrix() {
        this(4,4);
    }


    Matrix(String strArray) {
        this(4, 4);
        try {
            String[] firstArray = strArray.split("\n");
            for (int i = 0; i < ((this.matrix.length < firstArray.length) ? firstArray.length : this.matrix.length); i++) {
                String[] temp = firstArray[i].split(" ");
                for (int j = 0; j < ((this.matrix[0].length < temp.length) ? temp.length : this.matrix[0].length); j++) {
                    this.matrix[i][j] = temp[j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException strEx) {
            System.out.println("Возникла ошибка: неверное количество элементов, код ошибки - " + strEx);
        } catch (Exception ex) {
            System.out.println("Возникла ошибка: ошибка, которую забыли обработать - " + ex);
        }
    }

    public void executeAll(String array) {
        String[] firstArray = array.split("\n");
        int Sum = 0;
        try {
            for (int i = 0; i < ((matrix.length < firstArray.length) ? firstArray.length : matrix.length); i++) {
                String[] temp = firstArray[i].split(" ");
                for (int j = 0; j < ((matrix[0].length < temp.length) ? temp.length : matrix[0].length); j++) {
                    matrix[i][j] = temp[j];
                    Sum += Integer.parseInt(matrix[i][j]);
                }
            }
            System.out.println("Результат деления суммы элементов созданной матрицы = " + Sum / 2);
        } catch (ArrayIndexOutOfBoundsException strEx) {
            System.out.println("Возникла ошибка: неверное количество элементов, код ошибки - " + strEx);
        } catch (NumberFormatException exNumber) {
            System.out.println("При попытке преобразовать один из элементов  возникла ошибка: " + exNumber);
        } catch (ArithmeticException ex) {
            System.out.println("Возникла ошибка: делить на 0 нельзя. Операция не выполнена.");
        } catch (Exception ex) {
            System.out.println("Возникла ошибка: ошибка, которую забыли обработать - " + ex);
        }
    }

    public int getSumAllElementMatrix() {
        int Sum = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                try {
                    Sum += Integer.parseInt(this.matrix[i][j]);
                } catch (NumberFormatException ex) {
                    System.out.println("При попытке преобразовать элемент [ " + (i + 1) + " ; " + (j + 1) + " ] возникла ошибка: " + ex);
                    return 0;
                }
            }
        }
        return Sum;
    }

    @Override
    public String toString() {
        String outString = "";
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                outString = outString.concat(this.matrix[i][j]).concat(" ");
            }
            if (i != this.matrix.length - 1) outString = outString.trim().concat("\n");
        }
        return outString;
    }
}
