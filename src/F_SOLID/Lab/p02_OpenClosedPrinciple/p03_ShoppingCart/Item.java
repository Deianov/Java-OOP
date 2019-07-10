package F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.Interfaces.Sellable;

public class Item implements Sellable {
    private final long barCode;
    private String name;
    private double quantity;
    private double price;
    private boolean isDisabled;

    public Item(long barCode, String name, double quantity, double price) {
        this.barCode = checkEAN13(barCode);
        this.setName(name);
        this.setQuantity(quantity);
        this.setPrice(price);
        this.isDisabled = false;
    }

    @Override
    public boolean isDisabled() {
        return isDisabled;
    }

    public void Disable() {
        this.isDisabled = true;
    }

    @Override
    public long getBarCode() {
        return barCode;
    }

    public static Long checkEAN13(long barCode) {
        // European Article Number or EAN - check
        return barCode;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getQuantity() {
        return this.quantity;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Item : %s, quantity: %.2f, price: %.2f"
                ,this.getName()
                ,this.getQuantity()
                ,this.getPrice()
        );
    }
}
