package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.MyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collection implements MyList {
    protected static final int MAX_SIZE = 100;
    protected static List<String> items = new ArrayList<>();

    protected Collection() {
    }

    protected int getMAX_SIZE() {
        return Collection.MAX_SIZE;
    }

    protected List<String> getItems() {
        return Collections.unmodifiableList(Collection.items);
    }

    public static void addItems(List<String> list) {
        if (list.size() > Collection.MAX_SIZE) {
            throw new IllegalArgumentException("MAX_SIZE");
        }
        Collection.items.addAll(list);
    }
}
