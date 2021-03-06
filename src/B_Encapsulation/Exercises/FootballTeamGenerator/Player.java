package B_Encapsulation.Exercises.FootballTeamGenerator;

class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        this.validateStat("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        this.validateStat("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        this.validateStat("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        this.validateStat("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        this.validateStat("Shooting", shooting);
        this.shooting = shooting;
    }

    private void validateStat(String name, int stat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException( name + " should be between 0 and 100.");
        }
    }

    Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    String getName() { return this.name; }

    double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }
}
