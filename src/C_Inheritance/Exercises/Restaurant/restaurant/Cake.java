package C_Inheritance.Exercises.Restaurant.restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private static final Double CAKE_GRAMS = 250.0;
    private static final Double CAKE_CALORIES = 1000.0;
    private static final BigDecimal CAKE_PRICE = new BigDecimal(5);

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
