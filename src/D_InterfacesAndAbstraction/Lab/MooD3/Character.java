package D_InterfacesAndAbstraction.Lab.MooD3;

public abstract class Character<T> implements GameObject<T> {
    private String username;
    private String characterType;
    private int level;
    private Number specialPoints;
    private T hashedPassword;

    public Character(String characterType, String username, int level, Number specialPoints) {
        this.characterType = characterType;
        this.username = username;
        this.level = level;
        this.specialPoints = specialPoints;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public Number getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public T getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public void setHashedPassword(T hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n%s",
                this.getUsername(),
                this.getHashedPassword(),
                this.getCharacterType(),
                this.getSpecialPoints()
        );
    }
}
