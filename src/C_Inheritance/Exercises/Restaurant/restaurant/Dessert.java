package C_Inheritance.Exercises.Restaurant.restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {
    private Double calories;

    public Dessert(String name, BigDecimal price, Double grams, Double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public Double getCalories() {
        return calories;
    }
}
