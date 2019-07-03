package C_Inheritance.Exercises.Restaurant.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private static final Double COFFEE_MILLILITERS = 50.0;
    private static final BigDecimal COFFEE_PRICE = new BigDecimal(3.50);
    private Double caffeine;

    public Coffee(String name, Double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public Double getCaffeine() {
        return caffeine;
    }
}
