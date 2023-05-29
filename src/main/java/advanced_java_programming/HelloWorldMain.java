package advanced_java_programming;

public class HelloWorldMain {

    public static void main(String[] args) {
        Greeting helloWorldGreeting = () -> System.out.println("Hello world");
        helloWorldGreeting.printMessage();
        Greeting goodMorningGreeting = () -> System.out.println("Good morning");
        goodMorningGreeting.printMessage();
        Greeting goodAfternoonGreeting = () -> System.out.println("Good afternoon");
        goodAfternoonGreeting.printMessage();
    }

}
