package ru.geekbrains.java2.dz.dz1.ShagidullinIldar;
import java.util.Scanner;

import static ru.geekbrains.java2.dz.dz1.ShagidullinIldar.Chess.PAWN_DOT;
import static ru.geekbrains.java2.dz.dz1.ShagidullinIldar.Chess.setXO;

public class Pawn extends Figure implements Movable{
    public Pawn(String type){
        super("Pawn");
    }

    @Override
    public void isRightMove() {
        Scanner sc = new Scanner(System.in);
        int x1;
        int x2;
        int y1;
        int y2;
        System.out.print("Enter coordinates to place Pawn in X Y ( 1-8> ");
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        System.out.print("Enter coordinates to move Pawn X Y ( 1-8> ");
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        if ((x1 > 0 && x1 < 9) && (x2 > 0 && x2 < 9) && (y1 > 0 && y1 < 9)&& (y2 > 0 && y2 < 9)) {
            if (x2 - x1 <= 2 && y1 - y2 == 0) {
                setXO(x2 - 1, y2 - 1, PAWN_DOT);
            }
            else if (x2 - x1 >= -2 && x2 - x1 < 0 && y1 - y2 == 0){
                setXO(x2 - 1, y2 - 1, PAWN_DOT);}
            else cantMove();
        }
        else cantMove();
        sc.close();
    }

}
