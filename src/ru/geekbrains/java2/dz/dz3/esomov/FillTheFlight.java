package ru.geekbrains.java2.dz.dz3.esomov;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by spo_admin4 on 23.03.2017.
 */
public class FillTheFlight {
    public static void main(String[] args) {

        List<Passenger> passengers = new ArrayList<Passenger>();
        String input = readInput();
//        Passenger passe = new Passenger(input);
//        passengers.add(passe);
        System.out.println(input);
//
//
//
//
//
//        for (Passenger ps : passengers) System.out.println(ps.getName());
    }

    private static String readInput() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (sc.hasNextLine()) {
                String input = sc.nextLine();
                if (!input.isEmpty()) {
                    return input;
                }
            }
        }
    }
}
