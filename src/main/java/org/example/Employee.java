package org.example;

import java.util.SortedMap;

public class Employee {

    String firstName;

    public Employee(String firstName) {
        this.firstName = firstName;
    }

    void feedAnimal(Animal animal)   {
        if(animal.foodType == Animal.FoodType.MEAT) {
            System.out.println("Karmienie mięsem");
        } else if(animal.foodType == Animal.FoodType.PLANT) {
            System.out.println("Karmienie roślinami");
        } else {
            System.out.println("Karmienie czymkolwiek");
        }
    }

    @Override
    public String toString()    {
        return "Employee{" + "firstName='" + firstName + '\'' + '}';
    }
}
