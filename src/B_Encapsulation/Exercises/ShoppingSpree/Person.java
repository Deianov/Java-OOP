package B_Encapsulation.Exercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private double money;
    private final List<Product> products;

    private void setName(String name) {
        String testName = name.replaceAll("[\\s]", "");
        if (testName.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = testName;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" - ");
        if (this.products.size() > 0) {
            stringBuilder.append(String.join(", ", this.products.stream().map(Product::getName).collect(Collectors.toUnmodifiableList())));
        } else {
            stringBuilder.append("Nothing bought");
        }
        return stringBuilder.toString();
    }
}
