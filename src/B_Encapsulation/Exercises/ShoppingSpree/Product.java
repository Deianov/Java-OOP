package B_Encapsulation.Exercises.ShoppingSpree;

class Product {
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

    Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    double getCost() {
        return this.cost;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
