package google_guice.first_application;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTester1 {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GreetingModule());
        Greeting greeting = injector.getInstance(Greeting.class);
        greeting.sayHi();
    }

}
