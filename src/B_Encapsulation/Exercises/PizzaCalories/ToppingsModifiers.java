package B_Encapsulation.Exercises.PizzaCalories;

enum ToppingsModifiers {
    Meat (1.2),
    Veggies (0.8),
    Cheese (1.1),
    Sauce (0.9);

    private double value;

    ToppingsModifiers(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
