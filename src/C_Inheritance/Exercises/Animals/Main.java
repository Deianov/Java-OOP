// 06. Animal
package C_Inheritance.Exercises.Animals;

import C_Inheritance.Exercises.Animals.animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String animalKind;

        while (!"Beast!".equals(animalKind = reader.readLine())) {

            String[] animalData = reader.readLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            Animal animal = null;

            try {
                switch (animalKind) {
                    case "Dog" :
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog" :
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat" :
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten" :
                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat" :
                        animal = new Tomcat(name, age);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (animal != null) {
                System.out.println(animal.toString());
            }
        }
    }
}
