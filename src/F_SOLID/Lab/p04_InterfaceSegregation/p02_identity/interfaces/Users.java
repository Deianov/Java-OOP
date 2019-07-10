package F_SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface Users {
    Iterable<User> getAllUsersOnline();
    Iterable<User> getAllUsers();
    User getUserByName(String name);
}
