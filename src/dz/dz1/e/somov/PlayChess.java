package dz.dz1.e.somov;

import java.util.Scanner;

/**
 * Created by Jess on 16.03.2017.
 */
public class PlayChess {

//    float abs(float i) {
//        return (i<0) ? -i : i;
//    }

//    char[] x_field = new char[8];
//    int[] y_field = new int[8];

    private Castle castle = new Castle();
    private Knight knight = new Knight();
    private Bishop bishop = new Bishop();

    static boolean outOfField(int x1, int y1, int x2, int y2) {
        if ((x1>=1 && x1<=8) && (y1>=1 && y1<=8) && (x2>=1 && x2<=8) && (y2>=1 && y2<=8)) return true;
        return false;
    }

    static Scanner sc = new Scanner(System.in);

    void playerTurn() {
        System.out.println("Выбирете фигуру: 1-Castle, 2-Knight, 3-Bishop");
        int numfig = sc.nextInt();
        System.out.println("Выберите координаты начала хода, введя букву и цифру в каждой строке");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println("Выберите координаты конца хода, введя букву и цифру в каждой строке");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        sc.close();

//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; j < 7; j++) {
//                field[i][i] = 1;
//            }
//        }

        if (numfig == 1) { boolean cas = castle.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход был castle " +  cas); }
        if (numfig == 2) { boolean kng = knight.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход был knight " +  kng); }
        if (numfig == 3) { boolean bsp = bishop.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход был bishop " +  bsp); }
    }
}
