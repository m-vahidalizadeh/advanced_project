package google_guice.provider_class;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTester3 {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GreetingModule());
        Greeting greeting = injector.getInstance(Greeting.class);
        greeting.sayHi();
    }

}
