package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina_pravka;

public class Knight implements MoveCheckable {

    @Override
    public boolean isRightMove(Point startCell, Point finishCell) {
        int x1 = startCell.getX();
        int y1 = startCell.getY();

        int x2 = finishCell.getX();
        int y2 = finishCell.getY();

        if (x2 == x1 + 1 && y2 == y1 + 2) return true;
        if (x2 == x1 + 2 && y2 == y1 + 1) return true;
        if (x2 == x1 + 2 && y2 == y1 - 1) return true;
        if (x2 == x1 + 1 && y2 == y1 - 2) return true;
        if (x2 == x1 - 1 && y2 == y1 - 2) return true;
        if (x2 == x1 - 2 && y2 == y1 - 1) return true;
        if (x2 == x1 - 2 && y2 == y1 + 1) return true;
        if (x2 == x1 - 1 && y2 == y1 + 2) return true;
        return false;
    }
}
