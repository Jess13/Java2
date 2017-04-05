package ru.geekbrains.java2.dz.dz3.KrauzeEkaterina;

import java.util.*;

public class Flights {

    public static void main(String[] args) {
        Map<String, List<Passenger>> flights = readPassengers();
        printInfo(flights);
    }

    private static void printInfo(Map<String, List<Passenger>> flights) {
        for (String key : flights.keySet()) {
            System.out.println("Flight: " + key);
            System.out.println("Passengers:");
            List<Passenger> passengers = flights.get(key);
            Collections.sort(passengers);
            for (Passenger passenger : passengers) {
                System.out.println(passenger);
            }
            System.out.println();
        }
    }

    private static Map<String, List<Passenger>> readPassengers() {
        System.out.println("Name Passport Flight");
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Passenger>> flights = new TreeMap<>();
        while (true) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.isEmpty()) break;
                String[] parts = input.split(" ");
                if (!flights.containsKey(parts[2])) {
                    flights.put(parts[2], new ArrayList<>());
                }
                flights.get(parts[2]).add(new Passenger(parts[0], parts[1]));
            }
        }
        return flights;
    }
}
