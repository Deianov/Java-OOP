package D_InterfacesAndAbstraction.Exercises.MilitaryElite.models;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.interfaces.Isoldier;

public abstract class SoldierImpl implements Isoldier {
    private String id;
    private String firstName;
    private String lastName;

    protected SoldierImpl(String id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
