package ru.geekbrains.java2.dz.dz3.KrauzeEkaterina;

public class Passenger implements Comparable<Passenger> {
    private String name;
    private String passportNumber;

    public Passenger(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    @Override
    public String toString() {
        return this.getName() + " " + this.getPassportNumber();
    }

    @Override
    public int compareTo(Passenger o) {
        return this.getName().compareTo(o.getName());
    }
}
