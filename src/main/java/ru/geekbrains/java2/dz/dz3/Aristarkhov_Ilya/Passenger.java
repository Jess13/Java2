package ru.geekbrains.java2.dz.dz3.Aristarkhov_Ilya;


class Passenger {
    private String name;
    private long numberOfDocument;

    Passenger(String name, long numberOfDocument){
        this.name = name;
        this.numberOfDocument = numberOfDocument;

    }

    public String getName() {
        return name;
    }

    void printInfo(){
        System.out.println("Имя: "+name + " номер паспорта:" + numberOfDocument );
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", numberOfDocument=" + numberOfDocument +
                '}';
    }
}
