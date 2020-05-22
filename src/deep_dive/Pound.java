package deep_dive;

public class Pound {

    public static void main(String[] args) {
        String me = "Mohammad";
        //<type> <name> = new <type>()
        Duck mobyDuck = new Duck("Moby", 90 / 3, "celery");
        Duck wolfgangDuck = new Duck("Wolfgang", 60 / 3, "cheeseburgers");
        wolfgangDuck.waddle();
        System.out.println(mobyDuck);
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        mobyDuck.waddle();
        System.out.println(mobyDuck);
    }

}
