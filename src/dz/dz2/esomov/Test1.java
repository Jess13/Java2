package dz.dz2.esomov;

/**
 * Created by Jess on 20.03.2017.
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0 4 e 5";
        String[] mas1, mas2;
        String[][] mas3;
        mas1 = str.split("\n");
        for (int i=0; i<mas1.length; i++){
            mas2 = mas1[i].split(" ");
            if (mas1.length != 4 || mas2.length != 4) throw new ArrayIndexOutOfBoundsException("Размер матрицы не равен 4Х4");
            for (int j=0; j<mas2.length; j++) {
                //mas3[i][j] = mas2[j];
                System.out.print(mas2[j]+" ");
            }
        }


//        for (int i=0; i<4; i++) {
//            for (int j=0; j<4; j++) {
//                System.out.print(mas2[i][j]+"   ");
//            }
//        }
    }
}
