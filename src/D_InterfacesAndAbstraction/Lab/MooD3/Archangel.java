package D_InterfacesAndAbstraction.Lab.MooD3;

public class Archangel extends Character<String> {
    private static String CHARACTER_TYPE =  "Archangel";

    public Archangel(String name, int level, Integer specialPoints) {
        super(Archangel.CHARACTER_TYPE, name, level, specialPoints * level);
        super.setHashedPassword(new StringBuilder(name)
                .reverse()
                .append((name.length() + 2) * 21)
                .toString()
        );
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
