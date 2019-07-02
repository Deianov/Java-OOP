package E_Polymorphism.Lab.Animals;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("%s%nMEEOW", super.explainSelf());
    }
}
