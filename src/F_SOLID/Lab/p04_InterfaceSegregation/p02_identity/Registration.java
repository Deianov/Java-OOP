package F_SOLID.Lab.p04_InterfaceSegregation.p02_identity;

import F_SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces.UserRegistration;

public class Registration implements UserRegistration {
    private boolean requireUniqueEmail;
    private int minRequiredPasswordLength;
    private int maxRequiredPasswordLength;

    @Override
    public boolean getRequireUniqueEmail() {

        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {

        return this.minRequiredPasswordLength;
    }

    @Override
    public int getMaxRequiredPasswordLength() {

        return this.maxRequiredPasswordLength;
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }
}
