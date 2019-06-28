package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import java.util.List;

public class MyListImpl extends Collection {
    private final List<String> collection;

    public MyListImpl() {
        super();
        this.collection = super.getItems();
    }

    @Override
    public int getUsed() {
        // TODO: 28.06.2019  
        return 0;
    }

    @Override
    public String remove() {
        // TODO: 28.06.2019  
        return this.collection.remove(this.collection.size() - 1);
    }

    @Override
    public int add(String item) {
        this.collection.add(0, item);
        return 0;
    }
}
