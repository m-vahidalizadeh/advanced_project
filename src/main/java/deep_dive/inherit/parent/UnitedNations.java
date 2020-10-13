package deep_dive.inherit.parent;

import java.util.List;

public class UnitedNations {

    public static void main(String[] args) {
        Country country = new Country();
        Iran iran = new Iran();
        Turkey turkey = new Turkey();
        Columbia columbia = new Columbia();
        List<Country> countries = List.of(country, iran, turkey);
        for (Country c : countries) {
            c.dance();
        }
    }

}
