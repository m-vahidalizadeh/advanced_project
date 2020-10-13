package deep_dive;

public class Athlete {

    private String name;
    private int speed;
    private static String marathonLocation;
    private int bidNumber;
    private static int runnersInRace;

    public Athlete(String name, int speed) {
        this.name = name;
        this.speed = speed;
        runnersInRace++;
        this.bidNumber = runnersInRace;
    }

    public void setMarathonLocation(String marathonLocation) {
        this.marathonLocation = marathonLocation;
    }

    public static int getRunnersInRace() {
        return runnersInRace;
    }

    @Override
    public String toString() {
        return "Athlete " + name + " is running at " + speed + " kilo meters per hour at " + marathonLocation + " bid " + bidNumber + ".";
    }

}
