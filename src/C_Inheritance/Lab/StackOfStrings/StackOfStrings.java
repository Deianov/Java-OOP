package C_Inheritance.Lab.StackOfStrings;

import java.util.ArrayList;
import java.util.List;

class StackOfStrings {
    private List<String> data;

    StackOfStrings() {
        this.data = new ArrayList<>();
    }

    void push(String item) {
        this.data.add(item);
    }

    String pop() {
        return this.isEmpty() ? null : this.data.remove(this.data.size() - 1);
    }

    String peek() {
        return this.isEmpty() ? null : this.data.get(this.data.size() - 1);
    }

    boolean isEmpty() {
        return this.data.size() == 0;
    }
}
