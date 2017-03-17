package dz.dz1.KrauzeEkaterina_pravka;

/**
 * Created by Home-pc on 17.03.2017.
 */
public class Point {
    private int x, y;

    public Point(String s) {
        x = getXString(s);
        y = Character.getNumericValue(s.charAt(1));
        if (x > 8 && x < 1 && y > 8 && y < 1) {
            System.out.println("не верны координаты");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXString(String c) {
        switch (c.charAt(0)) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            case 'h':
                return 8;
        }

        return -1;
    }
}
