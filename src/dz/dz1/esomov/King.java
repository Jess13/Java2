package dz.dz1.esomov;

/**
 * Created by Jess on 16.03.2017.
 */
public class King implements ChessPiece {

    public boolean isRightMove(int x1, int y1, int x2, int y2) {

        boolean ouf = PlayChess.outOfField(x1,y1,x2,y2);
        if (ouf)
            if (Math.abs(x1-x2)==0 && Math.abs(y1-y2)==1 || Math.abs(x1-x2)==1 && Math.abs(y1-y2)==0 || Math.abs(x1-x2)==1 && Math.abs(y1-y2)==1) return true;

        return false;
    }
}
