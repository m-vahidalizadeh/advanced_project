package deep_dive;

import java.util.ArrayList;

public class BetterArrayList extends ArrayList {

    public Object pop() {
        return get(size() - 1);
    }

    public void print() {
        for (Object e : this) {
            System.out.print(e.toString() + " ");
        }
        System.out.println();
    }

}
