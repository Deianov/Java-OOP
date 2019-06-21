package B_Encapsulation.Exercises.PizzaCalories;


public class Topping {
    private String toppingType;
    private double weight;

    private void setToppingType(String toppingType) {
        try {
            // throw IllegalArgumentException
            String type = ToppingsModifiers.valueOf(toppingType).name();
            this.toppingType = type;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() { return this.toppingType; }
    public double getWeight() { return this.weight; }

    public double calculateCalories() {

        return 2 * this.weight * ToppingsModifiers.valueOf(this.getToppingType()).getValue();
    }
}
