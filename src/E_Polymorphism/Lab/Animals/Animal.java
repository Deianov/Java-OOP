package E_Polymorphism.Lab.Animals;

public class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    String explainSelf() {
        return String.format("I am %s and my favorite food is %s", this.name, this.favouriteFood);
    }
}
