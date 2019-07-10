package F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private static int currentID = 1;
    private final List<Item> cart;
    private final List<Item> paid;
    private boolean isFinished;
    private final Customer customer;

    protected Order(Customer customer) {
        this.id = currentID++;
        this.cart = new ArrayList<>();
        this.paid = new ArrayList<>();
        this.isFinished = false;
        this.customer = customer;
    }

    public void addItem(Item newItem) {
        cart.add(newItem);
    }
    
    public void removeItem(Item removeItem) {
        cart.removeIf(item -> item.getBarCode() == removeItem.getBarCode());
    }

    public int getId() {
        return id;
    }

    public List<Item> getCart() {
        return this.cart;
    }

    public List<Item> getPaid() {
        return this.paid;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double totalAmount() {
        return paid.stream().mapToDouble(Item::getPrice).sum();
    }

    public void checkout() {
        for (Item item: cart) {
            paid.add(new Item(item.getBarCode(), item.getName(), item.getQuantity(), item.getPrice()));
        }

        if (cart.size() > 0) {
            cart.subList(0, cart.size()).clear();
        }
        this.isFinished = true;
        System.out.println( this.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Order: ").append(this.id);

        for (Item item : paid) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(item.toString());
        }
        stringBuilder
                .append(System.lineSeparator())
                .append(String.format("Total Amount: %.2f", this.totalAmount()));

        return stringBuilder.toString();
    }
}
