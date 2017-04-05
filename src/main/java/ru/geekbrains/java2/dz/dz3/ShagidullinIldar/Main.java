package ru.geekbrains.java2.dz.dz3.ShagidullinIldar;

import java.util.*;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {
        fillPassangers();

    }
    private static void fillPassangers()
    {
        ArrayList<Passenger> passengers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int passanger_num = 0;
        while (true)
        {
            passanger_num++;
            System.out.println("Enter name of passanger " + passanger_num);
                String nama2 = scanner.nextLine();
                
            System.out.println("Enter passport ID of passanger " + passanger_num);
                int id_num2 = scanner.nextInt();
                
            System.out.println("Enter flight number of passanger " + passanger_num);
                int flight_num2 = scanner.nextInt();
                
            Passenger passenger= new Passenger(nama2, id_num2, flight_num2);
            passengers.add(passenger);
            
            System.out.println("More paassangers? Type No to quit");
            
            String ans = scanner.nextLine(); // !!!почему-то пропускает строчку и выход из цикла невозможен
            ans = scanner.nextLine();       // при дублировании из цикла выходит, иначе цикличность
            
            if (ans.equalsIgnoreCase("no")){break;}
        }
            Collections.sort(passengers, comparing(Passenger::getName));
            for (Passenger passenger : passengers) 
                System.out.println(passenger);
             
            TreeMap<Integer, ArrayList<Passenger>> flightTable = new TreeMap<Integer, ArrayList<Passenger>>();
        for(Passenger K : passengers)
    {
            int key = K.getFlight_num();
            if(flightTable.get(key) !=null)
            {
                 ArrayList<Passenger> passengers1 = flightTable.get(key);
                 passengers1.add(K);
                 flightTable.put(key, passengers1);
            }   
                    else
            {
                ArrayList<Passenger> passengers1 = new ArrayList<Passenger>();
                 passengers1.add(K);
                 flightTable.put(key, passengers1);
            }
    }
       System.out.println("flightTable:" + flightTable);
    }
    
}