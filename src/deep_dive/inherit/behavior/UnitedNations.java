package deep_dive.inherit.behavior;

import java.util.List;

public class UnitedNations {

    public static void main(String[] args) {
        Iran iran = new Iran();
        Turkey turkey = new Turkey();
        Columbia columbia = new Columbia();
        List<Country> countries = List.of(iran, turkey);
        for (Country c : countries) {
            c.dance();
        }
    }

}
