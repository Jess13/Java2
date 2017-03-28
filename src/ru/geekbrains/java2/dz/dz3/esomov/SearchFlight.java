package ru.geekbrains.java2.dz.dz3.esomov;

import java.util.*;

/**
 * Created by spo_admin4 on 23.03.2017.
 */
public class    SearchFlight {
    public static void main(String[] args) {

        Integer flightNumber = readFlightNumber(); //Считывание рейса из сканера
        List<Passenger> requestFlight, p1, p2, listOnFlight;
        p1 = fillThePass(); //Произвольно созданный список пассажиров
        p2 = fillThePass(p1);
        List<Flight> f = fillTheFlight(); //Произвольно созданный список рейсов
        //p.sort(Collections.reverseOrder());
        //Вывод всех списков пассажиров и рейсов
        System.out.println("СПИСОК 1");
        for (Passenger ps1 : p1) System.out.print(ps1.getName()+" "+ps1.getPassport()+" ");
        System.out.println("|| Кол-во пассажиров - "+p1.size());
        System.out.println("СПИСОК 2");
        for (Passenger ps2 : p2) System.out.print(ps2.getName()+" "+ps2.getPassport()+" ");
        System.out.println("|| Кол-во пассажиров - "+p2.size());
        System.out.println("РЕЙСЫ");
        for (Flight fl : f) System.out.print(fl.getFlightNum()+" ");
        System.out.println();
        System.out.println("----------------------------------------------");
        // Произвольное распределение списка пассажиров по рейсам
        Map<Integer, List<Passenger>> passengers = new TreeMap<Integer, List<Passenger>>();
        passengers.put(f.get(0).getFlightNum(), p1);
        passengers.put(f.get(1).getFlightNum(), p2);
        passengers.put(f.get(2).getFlightNum(), null);
        // Не получается отсортировать по имени ((((
        for (Map.Entry m : passengers.entrySet()) {
            listOnFlight = passengers.get(m.getKey()); System.out.print("РЕЙС: "+m.getKey()+" ПАССАЖИРЫ: ");
            if (listOnFlight != null)
                for (Passenger lp : listOnFlight) {
                System.out.print(lp.getName()+" "+lp.getPassport()+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");

        // Поиск пассажиров на введенном рейсе
        requestFlight = passengers.get(flightNumber);
        if (requestFlight != null) {
            System.out.print("РЕЙС: "+flightNumber+" ПАССАЖИРЫ: ");
            for (Passenger rf : requestFlight) System.out.print(rf.getName()+" "+rf.getPassport()+" ");
        }
        else System.out.println("НЕ НАЙДНО ПАССАЖИРОВ НА ЭТОМ РЕЙСЕ: "+flightNumber);

    }

    private static int readFlightNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер рейса");
            if (scanner.hasNextInt()) {
                int flightNumber = scanner.nextInt();
                return flightNumber;
            }
        }
    }

    private static List<Passenger> fillThePass() {
        List<Passenger> passengers = new ArrayList<Passenger>();
        Passenger p1 = new Passenger("Вася", "79854");
        Passenger p2 = new Passenger("Петя", "84765");
        Passenger p3 = new Passenger("Ваня", "18754");
        Passenger p4 = new Passenger("Женя", "65878");
        Passenger p5 = new Passenger("Лиля", "74745");
        passengers.add(p1);
        passengers.add(p2);
        passengers.add(p3);
        passengers.add(p4);
        passengers.add(p5);
        return passengers;
    }
    private static List<Passenger> fillThePass(List<Passenger> p1) {
       p1  = fillThePass();
       p1.remove(0);
       p1.remove(1);
       Passenger p6 = new Passenger("Юля", "11111");
       p1.add(p6);
       return p1;
    }

    private static List<Flight> fillTheFlight() {
        List<Flight> flights = new ArrayList<Flight>();
        Flight f1 = new Flight(151);
        Flight f2 = new Flight(152);
        Flight f3 = new Flight(153);
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        return flights;
    }
}
