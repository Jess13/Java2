package ru.geekbrains.java2.dz.dz3.Aristarkhov_Ilya;

import java.util.Comparator;

/**
 * Created by Home-pc on 24.03.2017.
 */
public class ComparatorPas implements Comparator<Passenger> {
    @Override
    public int compare(Passenger o1, Passenger o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
