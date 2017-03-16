package dz.dz1.e.somov;

/**
 * Created by Jess on 16.03.2017.
 */
public class Knight implements ChessPiece{

    public boolean isRightMove(int x1, int y1, int x2, int y2) {

        if (x2 == (x1 - 2) && y2 == (y1 - 1) || x2 == (x1 - 2) && y2 == (y1 + 1)) return true;

        return false;
    }
}
