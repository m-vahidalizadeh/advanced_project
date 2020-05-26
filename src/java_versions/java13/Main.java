package java_versions.java13;

public class Main {

    public static void main(String[] args) {
        /*
Practice 1:
mohammadvahidalizadehdizaj@Mohammads-MBP advanced_project % ls
Application.mf          advanced_java.iml       mohammad-1.0.dmg        mohammad.jar            myCommands.java         out                     src                     test
mohammadvahidalizadehdizaj@Mohammads-MBP advanced_project % cd src
mohammadvahidalizadehdizaj@Mohammads-MBP src % ls
deep_dive               functional_programming  java_versions           parallelism
mohammadvahidalizadehdizaj@Mohammads-MBP src % javac java_versions/java13/Main.java
mohammadvahidalizadehdizaj@Mohammads-MBP src % java java_versions.java13.Main
Hello from Java!

Practice 2:
mohammadvahidalizadehdizaj@Mohammads-MBP advanced_project % ls
Application.mf          advanced_java.iml       mohammad-1.0.dmg        mohammad.jar            myCommands.java         out                     src                     test
mohammadvahidalizadehdizaj@Mohammads-MBP advanced_project % cd src
mohammadvahidalizadehdizaj@Mohammads-MBP src % ls
deep_dive               functional_programming  java_versions           parallelism
mohammadvahidalizadehdizaj@Mohammads-MBP src % javac java_versions/java13/Main.java
mohammadvahidalizadehdizaj@Mohammads-MBP src % java java_versions.java13.Main Mohammad
Hello from Java, Mohammad!

         */
        System.out.println("Hello from Java, " + args[0] + "!");
    }

}
