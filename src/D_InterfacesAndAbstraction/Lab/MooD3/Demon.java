package D_InterfacesAndAbstraction.Lab.MooD3;

public class Demon extends Character<Integer> {
    private static String CHARACTER_TYPE =  "Demon";

    public Demon(String name, int level, Double specialPoints) {
        super(Demon.CHARACTER_TYPE, name, level, specialPoints * level);
        super.setHashedPassword((name.length() + 2) * 217);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
