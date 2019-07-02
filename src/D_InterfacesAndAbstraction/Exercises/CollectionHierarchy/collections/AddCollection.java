package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.collections;

import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        int index = super.getItems().size();
        super.getItems().add(item);
        return index;
    }
}
