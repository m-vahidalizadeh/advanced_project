package java17;

public class PatternMatchingSwitchClass {

    public static void displayObjectType(Object object) {
        switch (object) {
            case Integer i -> System.out.println("It's an integer.");
            case String s -> System.out.println("It's a string.");
            case null -> System.out.println("The object is null.");
            default -> System.out.println("It's none of these types");
        }
    }

    public static void displayObjectInformation(Object object) {
        switch (object) {
            case Integer i -> System.out.println("It's an integer.");
            case String s -> System.out.println("It's a string containing l." + s);
            case null -> System.out.println("The object is null.");
            default -> System.out.println("It's none of these types");
        }
    }

    public static void main(String[] args) {
        displayObjectInformation("Mohammad");
        displayObjectInformation(3);
        displayObjectInformation(null);
        displayObjectInformation('l');
    }

}
