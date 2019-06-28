package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import java.util.List;

public class AddRemoveCollection extends MyListImpl {
    private final List<String> collection;

    public AddRemoveCollection() {
        this.collection = super.getItems();
    }

    @Override
    public String remove() {
        // TODO: 28.06.2019  
        return this.collection.remove(0);
    }

    @Override
    public int add(String item) {
        this.collection.add(0, item);
        return 0;
    }
}
