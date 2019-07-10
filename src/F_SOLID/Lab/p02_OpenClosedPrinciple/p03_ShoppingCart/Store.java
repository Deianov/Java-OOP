package F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import java.util.TreeMap;

public class Store {
    private String name;
    private final TreeMap<Long, Item> items;
    private final TreeMap<Long, Double> itemsQuantities;
    private final TreeMap<Integer, Order> orders;
    private final TreeMap<String, Customer> customers;

    public Store(String name) {
        this.setName(name);
        this.items = new TreeMap<>();
        this.itemsQuantities = new TreeMap<>();
        this.orders = new TreeMap<>();
        this.customers = new TreeMap<>();
    }

    public void addItem(long barCode, String name, double quantity, double price) {
        if (!this.items.containsKey(barCode)) {
            this.items.put(barCode, new Item(barCode, name, quantity, price));
        }
    }

    public Item getItem(long barCode) {
        return items.get(barCode);
    }

    public void addQuantities(Long barCode, double quantity) {
        this.itemsQuantities.putIfAbsent(barCode, 0.0);
        this.itemsQuantities.put(barCode, this.itemsQuantities.get(barCode) + quantity);
    }

    public Order addOrder(Customer customer) {
        Order order = new Order(customer);
        orders.put(order.getId(), order);
        return order;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public TreeMap<Long, Item> getItems() {
        return items;
    }

    public TreeMap<Long, Double> getItemsQuantities() {
        return itemsQuantities;
    }

    public TreeMap<Integer, Order> getOrders() {
        return orders;
    }

    public TreeMap<String, Customer> getCustomers() {
        return customers;
    }
}
