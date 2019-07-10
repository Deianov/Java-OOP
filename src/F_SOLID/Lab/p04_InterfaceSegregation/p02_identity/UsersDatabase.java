package F_SOLID.Lab.p04_InterfaceSegregation.p02_identity;
import F_SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces.User;
import F_SOLID.Lab.p04_InterfaceSegregation.p02_identity.interfaces.Users;

public class UsersDatabase implements Users {

    @Override
    public Iterable<User> getAllUsersOnline() {
        return null;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }
}
