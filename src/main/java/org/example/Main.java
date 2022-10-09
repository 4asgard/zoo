package org.example;

import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Animal elephant = new Animal(8, "Elephant", "Mariola2");
        elephant.countryOfOrgin = Country.INDIA;
        elephant.foodType = Animal.FoodType.PLANT;

        switch (elephant.countryOfOrgin)    {
            case INDIA: System.out.println("Słoń indyjski");
            case EGYPT: System.out.println("Słoń afryński");
            default: System.out.println("Słoń z zoo");
        }

        Animal giraffe = new Animal(9, "giraffe", "Adrian");

        Employee wladek = new Employee("Włodek");
        wladek.feedAnimal(elephant);

        Employee mietek = new Employee("Mietek");

        System.out.println(elephant);
        System.out.println(elephant.foodType);
        System.out.println(elephant.countryOfOrgin);
        System.out.println(elephant.countryOfOrgin.continent);

        Map<Animal, Employee> zoo = new HashMap<>();
        zoo.put(elephant, wladek);
        zoo.put(giraffe, wladek);

        Map<Country, String> religions = new HashMap<>();
        religions.put(Country.POLAND, "Catholic");
        religions.put(Country.INDIA, "Hindu");

        Map<String, List<Country>> countriesByReligion = new HashMap<>();


        System.out.println(zoo.get(giraffe));

        DBConnector dbConnector = new DBConnector();
        boolean connected = dbConnector.connect();

        if(connected)   {
            elephant.save(dbConnector);
        } else  {
            System.out.println("Nie udało się połączyć z bazą danych");
        }

// zajęcia 20221008

//    public static void main(String[] args) {
//
//        DBConnector dbConnector = new DBConnector();
//        boolean connected = dbConnector.connect();
//        if(connected)   {
//
//            Scanner scanner =  new Scanner(System.in);
//            System.out.println("Podaj opcję: 1 - dodanie nowego zwierzęcia, 2 - usuwanie wszystkich zwierząt, 3 - liczenie zwierząt");
//            String choosedOption = scanner.nextLine();
//            System.out.println("Wybrałeś: " + choosedOption);
//
//            switch (choosedOption) {
//                case "1":
//                    Animal animalNew = new Animal();
//                    System.out.println("Podaj gatunek: ");
//                    animalNew.species = scanner.nextLine();
//                    System.out.println("Podaj imię: ");
//                    animalNew.name = scanner.nextLine();
//                    animalNew.id = Animal.countRowsToInt(dbConnector) + 1;
//                    System.out.println("Podałeś dane: " + animalNew.species + ", " + animalNew.name);
//                    animalNew.save(dbConnector);
//                    break;
//                case "2":
//                    Animal.deleteAll(dbConnector);
//                    break;
//                case "3":
//                    Animal.count(dbConnector);
//                    break;
//                default:
//                    System.out.println("Spoko, ale nic nie wykonam");
//            }
// wersja prev
//            //Animal dog = new Animal(6, "dog", "Szarik");
//            //dog.save(dbConnector);
//        }
//        else  {
//            System.out.println("Nie udało się połączyć z bazą danych");
//        }
//
//    }

    }
}