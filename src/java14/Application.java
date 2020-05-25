package java14;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Test Java 14 instance of
        System.out.println("\nJava 14 instance of:");
        runInstanceOfDemo();
        // Test Java 14 switch
        System.out.println("\nJava 14 switch:");
        runSwitchCaseDemo();
        // Test Java 14 record
        System.out.println("\nJava 14 record:");
        runRecordDemo();
        /*
        Test Java 14 NPE
        run with VM options:
        -XX:+ShowCodeDetailsInExceptionMessages
         */
        System.out.println("\nJava 14 NPE:");
        runNPEDemo();
        /*
        j-package demo:
        1) javac -cp ./src .src/java14/*.java -d ./out/ --enable-preview -source 14
        2) jar -cvmf Application.mf mohammad.jar -C /out/ .
        3) java -jar --enable-preview mohammad.jar
        4) jpackage -i ./ -n mohammad --main-class Application --main-jar mohammad.jar
         */
    }

    private static void runNPEDemo() {
        BigDecimal bd = getNullObject();
        bd.setScale(3, RoundingMode.CEILING);
    }

    private static void runRecordDemo() {
        Menu menu = new Menu("Grilled chicken", new BigDecimal(3.45));
        System.out.println(menu.name());
        System.out.println(menu.getFormattedItem());
    }

    private static void runSwitchCaseDemo() {
        showSwitch(InteractionType.MOHAMMAD);
        showSwitch(InteractionType.MAHNAZ);
    }

    private static void runInstanceOfDemo() {
        Pet cat = new Cat("Maloos", true);
        Pet dog = new Dog("Jimmy", true);
        List<Pet> petsList = List.of(cat, dog);
        showInstanceOf(petsList);
    }

    public static void showInstanceOf(List<Pet> pets) {
        pets.forEach(pet -> {
            String message = pet.getName() + " ";
            if (pet instanceof Dog dog) {
                message = message + (dog.isFollowingYou() ? "is" : "isn't") + " following you.";
            } else if (pet instanceof Cat cat) {
                message = message + (cat.isIgnoringYou() ? "is" : "isn't") + " ignoring you.";
            }
            System.out.println(message);
        });
    }

    public static void showSwitch(InteractionType type) {
        switch (type) {
            case MOHAMMAD -> {
                System.out.println("Your name is Mohammad.");
            }
            case ALI -> {
                System.out.println("Your name is Ali.");
            }
            case MAHNAZ -> {
                System.out.println("Your name is Mahnaz.");
            }
        }
    }

    static BigDecimal getNullObject() {
        return null;
    }

}
