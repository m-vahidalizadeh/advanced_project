package deep_dive;

public class Marathon {

    public static void main(String[] args) {
        Athlete mohammad = new Athlete("Mohammad", 7);
        Athlete mahnaz = new Athlete("Mahnaz", 10);
        mohammad.setMarathonLocation("New York");
        mahnaz.setMarathonLocation("Tehran");
        System.out.println(mohammad);
        System.out.println(mahnaz);
        System.out.println("Runners in race: " + Athlete.getRunnersInRace());
    }

}
