package dz.dz1.e.somov;

import java.util.Scanner;

/**
 * Created by Jess on 16.03.2017.
 */
public class PlayChess {

    private Castle castle = new Castle();
    private Knight knight = new Knight();
    private Bishop bishop = new Bishop();
    private King king = new King();
    private Queen queen = new Queen();
    private Pawn pawn = new Pawn();

    static boolean outOfField(int x1, int y1, int x2, int y2) {
        if ((x1>=1 && x1<=8) && (y1>=1 && y1<=8) && (x2>=1 && x2<=8) && (y2>=1 && y2<=8)) return true;
        return false;
    }

    static Scanner sc = new Scanner(System.in);

    void playerTurn() {
        System.out.println("Выбирете фигуру: 1-Castle, 2-Knight, 3-Bishop, 4-King, 5-Queen, 6-Pawn");
        int numfig = sc.nextInt();
        System.out.println("Выберите координаты начала хода, введя малую лат. букву и цифру в одном слове");

        String c1 = sc.next();
        int y1 = c1.charAt(0)-96;
        int x1 = c1.charAt(1)-48;
        System.out.println("Выберите координаты конечного хода, введя малую лат. букву и цифру в одном слове");

        String c2 = sc.next();
        int y2 = c2.charAt(0)-96;
        int x2 = c2.charAt(1)-48;
        sc.close();

        if (numfig == 1) { boolean cas = castle.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход фигурой castle " +  cas); }
        if (numfig == 2) { boolean kng = knight.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход фигурой knight " +  kng); }
        if (numfig == 3) { boolean bsp = bishop.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход фигурой bishop " +  bsp); }
        if (numfig == 4) { boolean kng = king.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход фигурой king " +  kng); }
        if (numfig == 5) { boolean que = queen.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход фигурой queen " +  que); }
        if (numfig == 6) { boolean pwn = pawn.isRightMove(x1, y1, x2, y2);
            System.out.println("Ход фигурой pawn " +  pwn); }
    }
}
