package A_WorkingWithAbstraction.Exercises.GreedyTimes;

import java.util.*;
import java.util.stream.Collectors;

public class Bag {
    private long capacity;
    private long totalAmount;
    private LinkedHashMap<String, Item> items;
    private LinkedHashMap<String, Long> amounts;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.totalAmount = 0;
        this.items = new LinkedHashMap<>();
        this.amounts = new LinkedHashMap<>();
    }

    public void add(Item item) {
        if (isValid(item)) {

            String name = item.getName();
            int amount = item.getAmount();
            String type = item.getType().name();

            if (this.items.containsKey(name)) {
                this.items.get(name).addAmount(amount);
            } else {
                this.items.put(name, item);
            }

            this.totalAmount += amount;

            this.amounts.putIfAbsent(type, 0l);
            this.amounts.put(type, this.amounts.get(type) + amount);
        }
    }

    private boolean isValid(Item item) {
        if (item == null)
            return false;

        if (totalAmount + item.getAmount() > capacity)
            return false;

        if (item.getType().equals(ItemType.Gem)) {
            long goldAmount = getAmount(ItemType.Gold);
            long gemAmount = getAmount(ItemType.Gem);

            // The gold amount in your bag should always be more than or equal to the gem amount at any time
            if (goldAmount < gemAmount + item.getAmount()) {
                return false;
            }
        }

        if (item.getType().equals(ItemType.Cash)) {
            long cashAmount = getAmount(ItemType.Cash);
            long gemAmount = getAmount(ItemType.Gem);

            // The gem amount should always be more than or equal to the cash amount at any time
            if (gemAmount < cashAmount + item.getAmount()) {
                return false;
            }
        }
        return true;
    }

    private long getAmount(ItemType type) {
        if (type != null) {
            if (this.amounts.containsKey(type.toString())) {
                return
                        this.amounts.get(type.toString());
            }
        }
        return 0;
    }

    private ArrayList<Item> getItems(ItemType type) {
        return this.items.values().stream()
                .filter(e -> e.getType().equals(type))
                .sorted(Comparator.comparing(Item::getName).reversed().thenComparingLong(Item::getAmount))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void print() {
        this.amounts.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(entry -> {
                    ItemType type = ItemType.valueOf(entry.getKey());

                    System.out.println(String.format("<%s> $%d", type, entry.getValue()));
                    getItems(type)
                            .forEach(item -> System.out.println(item.toString()));
                });

    }
}
