package F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import F_SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart.Interfaces.Person;

public class Customer implements Person {
    private String email;

    public Customer(String email) {
        this.setEmail(email);
    }

    @Override
    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}
