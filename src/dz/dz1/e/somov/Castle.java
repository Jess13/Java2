package dz.dz1.e.somov;

/**
 * Created by Jess on 16.03.2017.
 */
public class Castle implements ChessPiece {

    public boolean isRightMove(int x1, int y1, int x2, int y2) {

        boolean ouf = PlayChess.outOfField(x1,y1,x2,y2);
        if (ouf == true)
            if (x1 == x2 || y1 == y2) return true;

        return false;
    }
}
