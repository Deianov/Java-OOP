package C_Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

class RandomArrayList extends ArrayList {

    private Random random = new Random();

    Object getRandomElement() {
        int index = this.random.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}
