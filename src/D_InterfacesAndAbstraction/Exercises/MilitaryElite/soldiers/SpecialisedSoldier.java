package D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers;

import D_InterfacesAndAbstraction.Exercises.MilitaryElite.models.PrivateImpl;

public class SpecialisedSoldier extends PrivateImpl {
    private static final String CORPS_AIRFORCES = "Airforces";
    private static final String CORPS_MARINES = "Marines";
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    protected String getCorps() {
        return corps;
    }

    private void setCorps(String corps) {
        if(corps == null) {
            this.corps = null;
            return;
        }

        switch (corps) {
            case SpecialisedSoldier.CORPS_AIRFORCES:
                this.corps = SpecialisedSoldier.CORPS_AIRFORCES;
                break;
            case SpecialisedSoldier.CORPS_MARINES:
                this.corps = SpecialisedSoldier.CORPS_MARINES;
                break;
            default:
                throw new IllegalArgumentException("Invalid corps");
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f",
                this.getFirstName(),
                this.getLastName(),
                this.getId(),
                this.getSalary()
        );
    }
}
