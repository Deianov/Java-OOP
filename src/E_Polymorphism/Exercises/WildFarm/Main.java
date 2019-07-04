//03. Wild farm
package E_Polymorphism.Exercises.WildFarm;

import E_Polymorphism.Exercises.WildFarm.animals.*;
import E_Polymorphism.Exercises.WildFarm.foods.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        ArrayList<Animal> animals = new ArrayList<>();

        while (!"End".equals(line = reader.readLine())) {

            String[] animalData = line.split(" ");
            String animalType = animalData[0];
            String animalName = animalData[1];
            double animalWeight = Double.parseDouble(animalData[2]);
            String animalRegion = animalData[3];

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    String breed = animalData[4];
                    animal = new Cat(animalName, "Cat", animalWeight, animalRegion, breed);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, "Mouse", animalWeight, animalRegion);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, "Tiger", animalWeight, animalRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, "Zebra", animalWeight, animalRegion);
                    break;
            }

            String[] foodData = reader.readLine().split(" ");
            String foodType = foodData[0];
            int foodQuantity = Integer.parseInt(foodData[1]);

            Food food = null;

            switch (foodType) {
                case "Meat":
                    food = new Meat(foodQuantity);
                    break;
                case "Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
            }

            if (animal != null && food != null) {
                animal.makeSound();
                animal.eat(food);

                animals.add(animal);
            }
        }
        animals.forEach(System.out::println);
    }
}
