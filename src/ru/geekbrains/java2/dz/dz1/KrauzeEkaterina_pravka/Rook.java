package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina_pravka;

public class Rook implements MoveCheckable {

    @Override
    public boolean isRightMove(Point startCell, Point finishCell) {
        int x1 = startCell.getX();
        int y1 = startCell.getY();

        int x2 = finishCell.getX();
        int y2 = finishCell.getY();

        if (x1 == x2 && y1 != y2) {
            return true;
        } else if (y1 == y2 && x1 != x2) {
            return true;
        }
        return false;
    }
}
