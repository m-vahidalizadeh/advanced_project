package deep_dive;

import java.util.HashMap;
import java.util.Map;

public class Smurf {

    private String name;
    private static Map<String, Smurf> smurfs = new HashMap<>();

    public static Smurf createSmurf(String name) {
        if (smurfs.containsKey(name)) {
            System.out.println("Smurf " + name + " has been already created!");
            return smurfs.get(name);
        }
        System.out.println("Creating " + name + " Smurf");
        Smurf newSmurf = new Smurf(name);
        smurfs.put(name, newSmurf);
        return newSmurf;
    }

    private Smurf(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("My name is " + name + " Smurf.");
    }

    public void eat() {
        System.out.println(name + " Smurf is eating smurf-berries.");
    }

}
