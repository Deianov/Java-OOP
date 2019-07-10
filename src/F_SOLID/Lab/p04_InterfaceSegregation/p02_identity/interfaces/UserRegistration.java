package F_SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface UserRegistration {
    boolean getRequireUniqueEmail();
    int getMinRequiredPasswordLength();
    int getMaxRequiredPasswordLength();
    void changePassword(String oldPass, String newPass);
}
