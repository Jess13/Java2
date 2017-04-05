package ru.geekbrains.java2.dz.dz1.esomov;

import ru.geekbrains.java2.dz.dz1.esomov.ChessPiece;

/**
 * Created by Jess on 16.03.2017.
 */
public class Queen implements ChessPiece {

    public boolean isRightMove(int x1, int y1, int x2, int y2) {

        boolean ouf = PlayChess.outOfField(x1,y1,x2,y2);
        if (ouf)
            if (x1 == x2 || y1 == y2 || Math.abs(x1-x2) == Math.abs(y1-y2)) return true;

        return false;
    }
}
