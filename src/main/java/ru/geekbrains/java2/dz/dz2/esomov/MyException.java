package ru.geekbrains.java2.dz.dz2.esomov;

/**
 * Created by Jess on 19.03.2017.
 */
public class MyException {

    //Преобразование строки в массив типа String, приведение к типу Int и арифметические вычисления
    private static int str2mas(String str) {
        int sum = 0; //подсчет суммы всех элементов массива
        String[] mas1 = str.split("\n"); //массив из строки, разделенной "\n"
        String[][] mas2 = new String[mas1.length][]; //массив из массива строк, разделенные " "
        int[][] mas3; //массив из чисел, нельзя инициировать new int[mas1.length][], выдаст ошибку пустого индекса

        if (mas1.length != 4) throw new ArrayIndexOutOfBoundsException("Размер матрицы не равен 4Х4");
        for (int i=0; i<mas1.length; i++){
            mas2[i] = mas1[i].split(" ");
            if (mas2[i].length != 4) throw new ArrayIndexOutOfBoundsException("Размер матрицы не равен 4Х4");
            mas3 = new int[mas1.length][mas2[i].length]; //инициируем mas3

            for (int j=0; j<mas2[i].length; j++) {
                try {
                    mas3[i][j] = Integer.parseInt(mas2[i][j]);
                    sum += mas3[i][j];
                }catch (NumberFormatException e) {
                    //e.printStackTrace();
                    System.out.println("Введено не число! "+e);
                    return 0;
                }
//                System.out.print(mas2[i][j]+" ");
            }
        }
        return sum/2;
    }

    public static void main(String[] args) {
//        for (String element: str1){ System.out.println(element); }
        String str = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        int res = str2mas(str);
        System.out.println("resultat="+res);
    }
}
