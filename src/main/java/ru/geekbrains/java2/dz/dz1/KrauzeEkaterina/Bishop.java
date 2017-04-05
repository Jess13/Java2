package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina;

public class Bishop extends Figure {

    @Override
    public boolean isRightMove(String startCell, String finishCell) {
        int x1 = this.getX(startCell);
        int y1 = this.getY(startCell);

        int x2 = this.getX(finishCell);
        int y2 = this.getY(finishCell);

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
