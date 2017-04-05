package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina;

public class Knight extends Figure {

    @Override
    public boolean isRightMove(String startCell, String finishCell) {
        int x1 = this.getX(startCell);
        int y1 = this.getY(startCell);

        int x2 = this.getX(finishCell);
        int y2 = this.getY(finishCell);

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
