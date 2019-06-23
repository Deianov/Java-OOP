// Mordor's Cruelty Plan
package C_Inheritance.Exercises.MordorSCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Gandalf gandalf = new Gandalf();

        for (String food : reader.readLine().split("\\s+")) {
            gandalf.eatFood(food);
        }

        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
