package D_InterfacesAndAbstraction.Exercises.MilitaryElite.models;


import D_InterfacesAndAbstraction.Exercises.MilitaryElite.interfaces.Isoldier;

import java.util.Comparator;
import java.util.TreeMap;

public abstract class LeutenantGeneralImpl extends PrivateImpl {

    protected final TreeMap<String, Isoldier> specialisedSoldiers;

    protected LeutenantGeneralImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.specialisedSoldiers = new TreeMap<>(Comparator.reverseOrder());
    }
}
