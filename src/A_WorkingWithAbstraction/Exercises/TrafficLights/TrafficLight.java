package A_WorkingWithAbstraction.Exercises.TrafficLights;

class TrafficLight {
    private Lights state;

    TrafficLight(Lights state) {
        this.state = state;
    }

    void update() {
        switch (this.state) {
            case RED:
                this.state = Lights.GREEN;
                break;
            case GREEN:
                this.state = Lights.YELLOW;
                break;
            case YELLOW:
                this.state = Lights.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.state.toString();
    }
}
