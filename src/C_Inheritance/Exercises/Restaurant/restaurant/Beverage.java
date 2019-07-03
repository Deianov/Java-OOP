package C_Inheritance.Exercises.Restaurant.restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {
    private Double milliliters;

    public Beverage(String name, BigDecimal price, Double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public Double getMilliliters() {
        return milliliters;
    }
}
