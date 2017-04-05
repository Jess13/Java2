package ru.geekbrains.java2.dz.dz3.sorokinSergey;

import java.util.Comparator;

public class Passenger {
	
	private String name = null;
	private String passport = null;
	private int flightNumber = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public static final Comparator<Passenger> COMPARE_BY_NAME = new Comparator<Passenger>() {
        @Override
        public int compare(Passenger lhs, Passenger rhs) {
            return lhs.getName().charAt(0) - rhs.getName().charAt(0);
        }
    };
	
	
	
}
