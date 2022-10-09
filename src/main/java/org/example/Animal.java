package org.example;

public class Animal {

    public enum FoodType    {
        PLANT, MEAT, ALL;
    }
    Integer id;
    String species;
    String name;
    FoodType foodType;
    Country countryOfOrgin;

    public Animal(Integer id, String species, String name) {
        this.id = id;
        this.species = species;
        this.name = name;
    }

    public Animal() {

    }

    public void save(DBConnector dbConnector)  {
        String sql = "insert into animal values (";
        sql += this.id + ",";
        sql += "'" + this.species + "',";
        sql += "'" + this.name + "')";
        dbConnector.execute(sql);
        System.out.println("Zapisałem zwierzę " + this.name);
    }

    public static void count(DBConnector dbConnector)  {
        Integer numberOfRows = dbConnector.countRows("animal");
        System.out.println("W tabeli animal jest "+ numberOfRows + " wierszy");
    }

    public static Integer countRowsToInt(DBConnector dbConnector)  {
        Integer numberOfRows = dbConnector.countRows("animal");
        return numberOfRows;
    }

    public static void deleteAll(DBConnector dbConnector) {
        dbConnector.execute("delete from animal");
        System.out.println("Usunąłem wszystkie zwierzęta");
    }
}
