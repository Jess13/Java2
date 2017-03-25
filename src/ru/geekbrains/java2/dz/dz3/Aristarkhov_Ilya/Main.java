package ru.geekbrains.java2.dz.dz3.Aristarkhov_Ilya;

import java.util.*;

public class Main {

    private static List<Flight> flights = new ArrayList<>();

    private static void FillPassengers(){
        String name;
        long pasport;
        long bilet;
        int flag = 0;
        Map<Long, List<Passenger>> map = new TreeMap<>();
        while (flag == 0){
           Scanner sc = new Scanner(System.in);
            System.out.print("Введите имя пассажира >>>");
            name = sc.next();
            System.out.print("Введите номер паспорта пассажира >>>");
            pasport = sc.nextLong();
            System.out.print("Введите номер рейса пассажира >>>");
            bilet = sc.nextLong();

            if (!map.containsKey(bilet)) {
                map.put(bilet, new ArrayList<>());
            }
            map.get(bilet).add(new Passenger(name, pasport));

            System.out.print("Это последний пассажир? (0 - нет, 1 - да) >>>");
            flag = sc.nextInt();
        }
        for (long key: map.keySet()) {
            List<Passenger> passengers = map.get(key);
//            Collections.sort(passengers, (o1, o2) -> o1.getName().compareTo(o2.getName()));
            Collections.sort(passengers, new ComparatorPas());
            System.out.println(key + " (всего "+ passengers.size() +" пассажиров) - ↓");
            for (Passenger pas: passengers) {
                pas.printInfo();
            }
        }
    }

    public static void main(String[] args) {
        FillPassengers();
    }

}
