package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina;

public class Rook extends Figure {

    @Override
    public boolean isRightMove(String startCell, String finishCell) {
        int x1 = this.getX(startCell);
        int y1 = this.getY(startCell);

        int x2 = this.getX(finishCell);
        int y2 = this.getY(finishCell);

        if (x1 == x2 && y1 != y2) {
            return true;
        } else if (y1 == y2 && x1 != x2) {
            return true;
        }
        return false;
    }
}
