package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.collections;

import java.util.ArrayList;

public abstract class Collection{
    private int maxSize = 100;
    private ArrayList<String> items;

    protected Collection() {
        this.items = new ArrayList<>();
    }

    protected ArrayList<String> getItems() {
        return this.items;
    }

    protected int getMaxSize() {
        return maxSize;
    }
}
