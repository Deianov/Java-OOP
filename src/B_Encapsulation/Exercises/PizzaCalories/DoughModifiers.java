package B_Encapsulation.Exercises.PizzaCalories;

enum DoughModifiers {
    White (1.5),
    Wholegrain (1.0),
    Crispy (0.9),
    Chewy (1.1),
    Homemade (1.0);

    private double value;

    DoughModifiers(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
