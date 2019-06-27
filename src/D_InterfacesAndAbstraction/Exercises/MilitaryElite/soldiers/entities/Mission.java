package D_InterfacesAndAbstraction.Exercises.MilitaryElite.soldiers.entities;

public class Mission {
    private static final String STATE_IN_PROGRESS = "inProgress";
    private static final String STATE_FINISHED = "Finished";

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    public void completeMission() {
        this.setState(Mission.STATE_FINISHED);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {
        switch (state) {
            case Mission.STATE_FINISHED:
                this.state = Mission.STATE_FINISHED;
                break;
            case Mission.STATE_IN_PROGRESS:
                this.state = Mission.STATE_IN_PROGRESS;
                break;
            default:
                throw new IllegalArgumentException("Invalid mission");
        }
    }

    public String getCodeName() {
        return this.codeName;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(),
                this.getState()
        );
    }
}
