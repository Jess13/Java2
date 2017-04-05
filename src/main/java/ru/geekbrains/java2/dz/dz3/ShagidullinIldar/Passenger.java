package ru.geekbrains.java2.dz.dz3.ShagidullinIldar;

public class Passenger {
    private String name;
    private int id_num;
    private int flight_num;

    public Passenger(String name, int id_num, int flight_num){
        this.name = name;
        this.id_num = id_num;
        this.flight_num = flight_num;
    }

    public String setName() {
        return name;
    }

    public int setId_num() {
        return id_num;
    }

    public int setFlight_num() {
        return flight_num;
    }

    public String getName() {
        return name;
    }

    public int getId_num() {
        return id_num;
    }

    public int getFlight_num() {
        return flight_num;
    }
         @Override
   public String toString() {
        return ("Name: "+this.getName()+ " Passport number: " + this.getId_num() +
       " Flight number: " + this.getFlight_num());
   }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (id_num != passenger.id_num) return false;
        if (flight_num != passenger.flight_num) return false;
        return name != null ? name.equals(passenger.name) : passenger.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id_num;
        result = 31 * result + flight_num;
        return result;
    }    
}
