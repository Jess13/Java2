package ru.geekbrains.java2.dz.dz3.sorokinSergey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Seating {
	
	private static Scanner scanner = new Scanner(System.in);
	private static String clientWhantNewPassangers = "п";
	private static int countForInput = 0;
	private static List<Passenger> passengers = new ArrayList<Passenger>();
	private static Map<Integer, List<Passenger>> passengersTreeMap = new TreeMap<Integer, List<Passenger>>();
	
	public static void main(String[] args) {
		inputData();
		for (Passenger passenger : passengers) {
			passengersTreeMap.put(passenger.getFlightNumber(), passengers);
		}
		Collections.sort(passengers, Passenger.COMPARE_BY_NAME);
		System.out.println();
		for(Map.Entry eTreeMap : passengersTreeMap.entrySet()){
		    System.out.println("Рейс номер: " + eTreeMap.getKey());
		    int countPassangerInFlight = 0;
		    for (Passenger passenger : passengers) {
		    	if(eTreeMap.getKey() == (Integer)passenger.getFlightNumber() ) {
		        System.out.println("Пассажир: " + passenger.getName() + " Паспортные данные: "
		            + passenger.getPassport());
		    	countPassangerInFlight++;
		    	}
		    }
		    System.out.println("Количество пассажиров на рейсе: " + countPassangerInFlight + "\n");
		    
		}
		
	}
	
	public static void inputData() {
		while(clientWhantNewPassangers.equals("п")) {
			System.out.println("Введите \"п\" если хотите ввести нового пассажира. Введите любое другое значение, чтобы закончить ввод");
			clientWhantNewPassangers = scanner.nextLine();
			if (!clientWhantNewPassangers.equals("п")) break;
			scanner = new Scanner(System.in);
			System.out.println("Пассажир №" + (countForInput+1));
			passengers.add(new Passenger());
	
			while (true){
				System.out.println("Введите имя:");
				if (scanner.hasNextLine()) {
					passengers.get(countForInput).setName(scanner.nextLine());
					if (!passengers.get(countForInput).getName().isEmpty()) {
							scanner = new Scanner(System.in);
							break;
						}
					System.out.println("ошибка. поле пустое");
				}
				System.out.println("ошибка. некорректные данные");
				scanner = new Scanner(System.in);
			}
			
			while (true){
				System.out.println("Введите номер документа, удостоверяющего личность:");
				if (scanner.hasNextLine()) {
					passengers.get(countForInput).setPassport(scanner.nextLine());
					if (!passengers.get(countForInput).getPassport().isEmpty()) {
							scanner = new Scanner(System.in);
							break;
						}
					System.out.println("ошибка. поле пустое");
				}
				System.out.println("ошибка. некорректные данные");
				scanner = new Scanner(System.in);
			}
			
			
			while (true){
				System.out.println("Введите номер рейса:");
				if (scanner.hasNextInt()) {
					passengers.get(countForInput).setFlightNumber(scanner.nextInt());
					if (passengers.get(countForInput).getFlightNumber() != 0) {
							scanner = new Scanner(System.in);
							break;
						}
					System.out.println("ошибка. поле пустое");
				}
				System.out.println("ошибка. некорректные данные");
				scanner = new Scanner(System.in);
			}

			countForInput++;

		}
		
		scanner.close();
	}

}
