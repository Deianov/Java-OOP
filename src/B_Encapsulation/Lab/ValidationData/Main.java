//03. Validation Data
package B_Encapsulation.Lab.ValidationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        ArrayList<Person> people = new ArrayList<>();

        while (lines-- > 0) {
            String[] data = reader.readLine().split(" ");

            try {
                Person person = new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
