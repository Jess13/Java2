package ru.geekbrains.java2.dz.dz1.ShagidullinIldar;

import java.util.Scanner;

public class Chess {
    protected static final int FIELD_SIZE = 8;
    static final char EMPTY_SPACE = '*';
    static final char PAWN_DOT = 'X';
    static final char ROOK_DOT = 'I';


    static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    private static void initField(){
        for (int i = 0; i <field.length ; i++)
            for (int j = 0; j <field[i].length ; j++)
                field[i][j] = EMPTY_SPACE;
    }
    private static void printField() {
        System.out.println("________________");
        for (int i = 0; i < field.length; i++) {
           // System.out.print('|');
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] +  "|");
            }
            System.out.println();
            System.out.println("----------------");
        }
        System.out.println();
    }
    protected static void setXO(int _x, int _y, char _sym) {
        field[_x][_y] = _sym;
    }

    private static void createFigure(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type one of the following; Pawn, Rook");
        String figure_one = sc.nextLine();
        if(figure_one.equals("Pawn")) {
            Pawn p1 = new Pawn("Pawn");
            p1.isRightMove();
        }
        else if (figure_one.equals("Rook")){
            Rook r1 = new Rook("Rook");
            r1.isRightMove();
        }
        sc.close();
    }

    public static void main(String[] args) {
        initField();
        printField();
        createFigure();
        printField();


    }
}