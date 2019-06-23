package C_Inheritance.Exercises.MordorSCrueltyPlan;

class Happiness {
    private Moods moods;

    Happiness(int points) {
        this.setMoods(points);
    }

    void setMoods(int points) {
        if (points < -5)
            this.moods = Moods.Angry;
        else if (points < 0)
            this.moods = Moods.Sad;
        else if (points < 16)
            this.moods = Moods.Happy;
        else
            this.moods = Moods.JavaScript;
    }

    @Override
    public String toString() {
        return moods.toString();
    }
}
