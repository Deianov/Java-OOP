package Q_Exams.Exam11August2019.UnitTesting.blueOrigin;

public class Astronaut {
    private String name;
    private double oxygenInPercentage;

    public Astronaut(String name, double oxygenInPercentage) {
        this.name = name;
        this.oxygenInPercentage = oxygenInPercentage;
    }

    public String getName() {
        return this.name;
    }

    public double getOxygenInPercentage() {
        return this.oxygenInPercentage;
    }
}
