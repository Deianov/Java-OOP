package B_Encapsulation.Exercises.ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    private void setName(String name) {
        String testName = name.replaceAll("[\\s]", "");
        if (testName.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = testName;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public double getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
