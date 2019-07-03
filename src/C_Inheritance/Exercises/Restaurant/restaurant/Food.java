package C_Inheritance.Exercises.Restaurant.restaurant;

import java.math.BigDecimal;

public class Food extends Product {
    private Double grams;

    protected Food(String name, BigDecimal price, Double grams) {
        super(name, price);
        this.grams = grams;
    }

    public Double getGrams() {
        return grams;
    }
}
