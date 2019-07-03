//02. Zoo
package C_Inheritance.Exercises.Zoo;

public class Main {
    public static void main(String[] args) {

        Animal lizard = new Lizard("Pesho");
        Animal bear = new Bear("Gosho");

        System.out.println(lizard.getName());
        System.out.println(bear.getName());
    }
}
