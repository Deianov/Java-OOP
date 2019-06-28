package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import java.util.List;

public class AddCollection extends MyListImpl {
    private final List<String> collection;

    public AddCollection() {
        this.collection = super.getItems();
    }

    @Override
    public int add(String item) {
        int index = this.collection.size();
        this.collection.add(item);
        return index;
    }
}
