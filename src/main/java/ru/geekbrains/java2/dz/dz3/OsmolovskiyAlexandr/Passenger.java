package ru.geekbrains.java2.dz.dz3.OsmolovskiyAlexandr;
/*Попробывал сделать задание, но ничего не получилось, так отдельные фрагменты.
        Вопросы к заданию:
        1. Какой выбрать ключ(он должет быть уникальным?) к TreeMap?
        По идеи упорядочивать надо по рейсам, делать поиск с выборкой рейсов
        и сохранением в массив рейсов, с последующим выводом на печать
        2. Как вводить и сохранять по три значения(номер рейса, имя и номер паспорта)
        сразу после регистрации пассажира и самое главное в чем(arraylist?)?*/


/*Задание к уроку №3
        Нужно реализовать рассадку пассажиров по рейсам. Каждый пассажир должен сесть на свой
        рейс. Самолет может иметь или не иметь пассажирова.
        Программа должна позволять запрашивать у пользователя ввод пассажиров, для каждого
        пассажира вводится:
        имя;
        номер документа, удовлетворяющего личность;
        номер рейса;
        По окончанию ввода пассажиров в консоль выводится список всех рейсов и отправляющихся на
        нем пассажиров (имя и номер документа). Рейсы должны быть упорядочены по номеру,
        пассажиры - по имени. Для каждого рейса указывается количество пассажиров на нем.
        Ввод данных производится по пассажирам.
        Указания
        При решении задачи нужно использовать интерфейсы List (для хранения пассажировов в рейсе)
        и Map (для сопоставления имени рейса и пассажиров в рейсе). Предположим, что вы
        реализовали класс Passenger, тогда объявления списка пассажиров следует делать следующим
        образом:
        List<Passenger> passengers = new ArrayList<Passenger>();
        Для ввода данных имеет смысл испльзовать класс Scanner следующим образом:
        Scanner scanner = new Scanner(System.in);
        int flightNumber = scanner.nextInt();
        При решение задачи должны быть использована одна (и только одна) TreeMap.
        Класс Passenger должен содержать только private-поля и методы доступа к нему (set/get).
        Используйте generics при объявление переменных с коллекциями:
        Map<Integer,List<Passenger>> passengers = new TreeMap<Integer,List<Passenger>>
        Для перебора элементов в коллекциях используйте for-each вариант for:
        Collection<Passenger> = new ArrayList<Passenger>();
        for (Passenger passenger : passengers) { }*/

import java.util.Scanner;

public class Passenger {
    public static void main(String[] args) {

        /*Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Enter array length: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size]; // Создаём массив int размером в size
        System.out.println("Insert array elements:");
    *//*Пройдёмся по всему массиву, заполняя его*//*
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print ("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();*/
        int ID;
        String Name;
        int Passport;
        int FlightNumber;

        /*Passengers(String Name, int Passport, int FlightNumber) {
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

    public String gettName() {
        return Name;
    }

    public void setPassport(int Passport) {
        this.Passport = Passport;
    }

    public int gettPassport() {
        return Passport;
    }

    public void setName(int FlightNumber) {
        this.FlightNumber = FlightNumber;
    }

    public int gettFlightNumber() {
        return FlightNumber;
    }
}
*/


        for (int i = 0; i < 5; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Name " + i);
            String Namei = scan.nextLine();
            System.out.println("Passport " + i);
            int Passporti = scan.nextInt();
            System.out.println("FlightNumber" + i);
            int FlightNumberi = scan.nextInt();
            System.out.println(Namei + " " + Passporti + " " + FlightNumberi + " ");
//            return Namei; Passporti, FlightNumberi;

        }

        //System.out.println(Name0 + " " + Passport0 + " " + FlightNumber0 + " ");
    }

}




        /*System.out.println("Enter name:");
        Scanner scanner1 = new Scanner(System.in);
        String getName = scanner1.nextLine();
Name=Name(i);
        System.out.println("Enter number of passport:");
        Scanner scanner2 = new Scanner(System.in);
        int getPassport = scanner2.nextInt();

        System.out.println("Enter number of flight:");
        Scanner scanner3 = new Scanner(System.in);
        int getFlightNumber = scanner3.nextInt();*/


       /* System.out.println("Name: "+getName);
        System.out.println("Number: "+getPassport);
        System.out.println("FlightNumber: "+getFlightNumber);*/
//forEach temp(in Passengers)*/





        /*  Map<Integer,  Passengers> map = new TreeMap<>();


        map.put(55, new Passengers("Иннокентий", 350005645, 85));
        map.put(51, new Passengers("Эсмеральда", 301223128, 75));
        map.put(5, new Passengers("Ипохондрий", 12123132, 45));
        map.put(88, new Passengers("Федя", 50005645, 85));
       map.put(98, new Passengers("Вася", 1223128, 75));
       map.put(9, new Passengers("Петр", 2123132, 45));
        map.entrySet().stream().forEach((temp) -> {
            System.out.println(temp.getKey() + " " + temp.getValue().toString());
        });
        ArrayList<String> Passengers = new ArrayList<String>();
        Passengers.add(0,"Иннокентий, 350005645, 85");
        Passengers.add(1,"Эсмеральда, 301223128, 75");
        Passengers.add(2,"Ипохондрий, 12123132, 45");
        Passengers.add(3,"Федя, 50005645, 85");
        Passengers.add(4,"Вася, 01223128, 75");
        Passengers.add(5,"Петр, 2123132, 45");
        System.out.printf("В списке %d элементов \n", Passengers.size());
        for(String state : Passengers){

            System.out.println(state);
        }*/



