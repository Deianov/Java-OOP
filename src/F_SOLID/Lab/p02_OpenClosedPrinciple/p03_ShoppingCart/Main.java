package F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("CoolStore");

        store.addItem(3594567890001L, "Atomic", 1.0, 300.0);
        store.addQuantities(3594567890001L, 25);
        store.addItem(3594567890002L, "Fisher", 1.0, 325.0);
        store.addQuantities(3594567890002L, 25);

        Customer customer = new Customer("ivan@ivan.bg");

        Order order = store.addOrder(customer);

        order.addItem(store.getItem(3594567890001L));
        order.addItem(store.getItem(3594567890002L));
        order.checkout();
    }
}
