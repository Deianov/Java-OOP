package A_WorkingWithAbstraction.Exercises.GreedyTimes;

class Item {
    private ItemType type;
    private String name;
    private int amount;

    Item(String name, int amount, ItemType type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    static ItemType getItemType(String name) {
        if (name == null || name.length() < 3) {
            return null;
        } else if (name.length() == 3) {
            return ItemType.Cash;
        } else if (name.toLowerCase().endsWith("gem")) {
            return ItemType.Gem;
        } else if (name.equalsIgnoreCase("Gold")) {
            return ItemType.Gold;
        }
        return null;
    }

    void  addAmount(int value) {
        this.amount += value;
    }


    ItemType getType() { return type; }
    String getName() { return name; }
    int getAmount() { return amount; }

    @Override
    public String toString() {
        return String.format("##%s - %d", this.name, this.amount);
    }
}
