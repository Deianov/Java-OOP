package B_Encapsulation.Exercises.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsCount;

    private void setName(String name) {
        String testName = name.replaceAll("[\\s]", "");

        if (testName.length() == 0 || testName.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = testName;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int count) {
        if (count < 0 || count > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount = count;
    }

    public Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.setToppings(toppingsCount);
        this.dough = null;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public String getName() { return this.name; }
    public Dough getDough() { return this.dough; }
    public List<Topping> getToppings() { return this.toppings; }
    public int getToppingsCount() { return this.toppingsCount; }

    public double getOverallCalories() {
        double calories = 0;
        calories += this.dough.calculateCalories();

        for (Topping toping : this.getToppings()) {
            calories += toping.calculateCalories();
        }
        return calories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
