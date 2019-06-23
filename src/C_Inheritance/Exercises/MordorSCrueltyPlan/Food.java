package C_Inheritance.Exercises.MordorSCrueltyPlan;


class Food {
    private static Foods food = Foods.None;

    private enum Foods {
        cram (2),
        lembas (3),
        apple (1),
        melon (1),
        honeycake (5),
        mushrooms (-10),
        EverythingElse (-1),
        None(0);

        protected int points;

        Foods(int points) {
            this.points = points;
        }
    }

    private static void setFood(String foodName) {
        try {
            Food.food = Foods.valueOf(foodName.toLowerCase());

        } catch (IllegalArgumentException e) {

            Food.food = Foods.EverythingElse;
        }
    }

    static int getFoodPoints(String foodName) {
        Food.setFood(foodName);
        return Food.food.points;
    }
}
