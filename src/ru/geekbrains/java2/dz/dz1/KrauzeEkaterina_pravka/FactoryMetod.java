package ru.geekbrains.java2.dz.dz1.KrauzeEkaterina_pravka;

/**
 * Created by Home-pc on 17.03.2017.
 */
public class FactoryMetod {
    public static MoveCheckable createFigure(String name) {
        MoveCheckable moveCheckable = null;
        switch (name) {
            case "p": moveCheckable = new Pawn(); break;
            case "r": moveCheckable = new Rook(); break;
            case "n": moveCheckable = new Knight(); break;
            case "b": moveCheckable = new Bishop(); break;
            case "q": moveCheckable = new Queen(); break;
            case "k": moveCheckable = new King(); break;
        }
        return moveCheckable;
    }
}
