package D_InterfacesAndAbstraction.Exercises.MilitaryElite.models;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.interfaces.Isoldier;

public abstract class PrivateImpl extends SoldierImpl implements Isoldier {
    private double salary;

    protected PrivateImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    protected double getSalary() {
        return this.salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }
}
