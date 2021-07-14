package google_guice.field_injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTester4 {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GreetingModule());
        Greeting greeting = injector.getInstance(Greeting.class);
        greeting.sayHi();
    }

}
