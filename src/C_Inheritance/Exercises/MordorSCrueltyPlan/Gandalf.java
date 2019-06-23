package C_Inheritance.Exercises.MordorSCrueltyPlan;

class Gandalf extends Happiness {
    private int foodPoints;

    Gandalf() {
        super(0);
        this.foodPoints = 0;
    }

    void eatFood(String foodName) {
        this.foodPoints += Food.getFoodPoints(foodName);
        super.setMoods(this.foodPoints);
    }

    int getFoodPoints() {
        return this.foodPoints;
    }

    String getMood() {
        return super.toString();
    }
}
