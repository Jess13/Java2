package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina;

public abstract class Figure implements MoveCheckable {

    public int getY(String c) {
        return Character.getNumericValue(c.charAt(1));
    }

    public int getX(String c) {
        switch (c.charAt(0)) {
            case 'a': return 1;
            case 'b': return 2;
            case 'c': return 3;
            case 'd': return 4;
            case 'e': return 5;
            case 'f': return 6;
            case 'g': return 7;
            case 'h': return 8;
        }

        return -1;
    }
}
