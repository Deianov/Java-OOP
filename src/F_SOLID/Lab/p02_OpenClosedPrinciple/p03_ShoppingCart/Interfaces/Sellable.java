package F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.Interfaces;

public interface Sellable {
    long getBarCode();
    String getName();
    double getQuantity();
    double getPrice();
    boolean isDisabled();
}
