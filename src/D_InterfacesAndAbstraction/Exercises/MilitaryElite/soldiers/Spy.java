package D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.models.SoldierImpl;

public class Spy extends SoldierImpl {
    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);

    }

    public String getCodeNumber() {
        return this.codeNumber;
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s%nCode Number: %s",
                this.getFirstName(),
                this.getLastName(),
                this.getId(),
                this.getCodeNumber()
        );
    }
}
