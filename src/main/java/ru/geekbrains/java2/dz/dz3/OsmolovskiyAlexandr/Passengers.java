package ru.geekbrains.java2.dz.dz3.OsmolovskiyAlexandr;

public class Passengers {


    private String Name;
    private int Passport;
    private int FlightNumber;

    private Passengers(String Name, int Passport, int FlightNumber) {
        this.Name = Name;
        this.Passport = Passport;
        this.FlightNumber = FlightNumber;
    }

    @Override
    public String toString() {
        return (Name + " " + Passport + " " + FlightNumber);
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setPassport(int Passport) {
        this.Passport = Passport;
    }

    public int getPassport() {
        return Passport;
    }

    public void setName(int FlightNumber) {
        this.FlightNumber = FlightNumber;
    }

    public int getFlightNumber() {
        return FlightNumber;
    }

//        for (int i = 0; i < 5; i++) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Name " + i);
//        String SetNamei = scan.nextLine();
//        System.out.println("Passport " + i);
//        int SetPassporti = scan.nextInt();
//        System.out.println("FlightNumber" + i);
//        int SetFlightNumberi = scan.nextInt();
//        System.out.println(getName() + " " + getPassport() + " " + getFlightNumber() + " ");
//        return Name; Passport, FlightNumber;




//    }
}



       /* System.out.println("Enter name:");
        Scanner scanner1 = new Scanner(System.in);
        String getName = scanner1.nextLine();

        System.out.println("Enter number of passport:");
        Scanner scanner2 = new Scanner(System.in);
        int getPassport = scanner2.nextInt();

        System.out.println("Enter number of flight:");
        Scanner scanner3 = new Scanner(System.in);
        int getFlightNumber = scanner3.nextInt();


        System.out.println("Name: "+Name);
        System.out.println("Number: "+Number);
        System.out.println("Flight: "+FlightNumber);
*/
      /*  List<Passenger> passengers = new ArrayList<Passenger>();
        TreeMap<Integer, String> treeMap = new TreeMap<Integer , String>();
        treeMap.put(7, "Willis");
        treeMap.put(8, "Schwarzenegger");
        treeMap.put(7, "Chan");
        treeMap.put(3, "Stallone");
        treeMap.put(3, "Norris");

        System.out.println("TreeMap");
        for (Map.Entry<Integer, String> e : treeMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        Map<String, String> treeMap1 = new TreeMap<String, String>();
        treeMap1.put("Bruce", "Willis");
        treeMap1.put("Arnold", "Schwarzenegger");
        treeMap1.put("Jackie", "Chan");
        treeMap1.put("Sylvester", "Stallone");
        treeMap1.put("Chuk", "Norris");

        System.out.println("TreeMap");
        for (Map.Entry<String, String> e : treeMap1.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
*/
