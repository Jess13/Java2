package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina_pravka;

public class Queen extends Bishop {
    private Rook rook;

    @Override
    public boolean isRightMove(Point startCell, Point finishCell) {
        rook = new Rook();

        return super.isRightMove(startCell, finishCell) || rook.isRightMove(startCell, finishCell);
    }
}
