package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina_pravka;

public class Bishop implements MoveCheckable {

    @Override
    public boolean isRightMove(Point startCell, Point finishCell) {
        int x1 = startCell.getX();
        int y1 = startCell.getY();

        int x2 = finishCell.getX();
        int y2 = finishCell.getY();

        int tempX = x1 + 1;
        int tempY = y1 + 1;
        while (tempX <= 8 && tempY <= 8) {
            if (x2 == tempX && y2 == tempY) {
                return true;
            }
            tempX += 1;
            tempY += 1;
        }

        tempX = x1 + 1;
        tempY = y1 - 1;
        while (tempX <= 8 && tempY >= 1) {
            if (x2 == tempX && y2 == tempY) {
                return true;
            }
            tempX += 1;
            tempY -= 1;
        }

        tempX = x1 - 1;
        tempY = y1 - 1;
        while (tempX >= 1 && tempY >= 1) {
            if (x2 == tempX && y2 == tempY) {
                return true;
            }
            tempX -= 1;
            tempY -= 1;
        }

        tempX = x1 - 1;
        tempY = y1 + 1;
        while (tempX >= 1 && tempY <= 8) {
            if (x2 == tempX && y2 == tempY) {
                return true;
            }
            tempX -= 1;
            tempY += 1;
        }

        return false;
    }
}
