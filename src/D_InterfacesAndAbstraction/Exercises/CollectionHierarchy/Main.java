//07. Collection Hierarchy
package D_InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.collections.AddCollection;
import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.collections.AddRemoveCollection;
import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.collections.MyListImpl;
import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.AddRemovable;
import D_InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.Addable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        System.out.println(collectionAddAll(addCollection, input));
        System.out.println(collectionAddAll(addRemoveCollection, input));
        System.out.println(collectionAddAll(myList, input));

        int removeElementsCount = Integer.parseInt(reader.readLine());

        System.out.println(collectionRemove(addRemoveCollection, removeElementsCount));
        System.out.println(collectionRemove(myList, removeElementsCount));
    }

    private static String collectionAddAll (Addable collection, String[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : arr) {
            stringBuilder.append(collection.add(item)).append(" ");
        }
        return stringBuilder.toString();
    }

    private static String collectionRemove (AddRemovable collection, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(collection.remove()).append(" ");
        }
        return stringBuilder.toString();
    }
}
