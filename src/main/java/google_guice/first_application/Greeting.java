package google_guice.first_application;

import com.google.inject.Inject;

public class Greeting {
    private Hello hello;

    @Inject
    public Greeting(Hello hello) {
        this.hello = hello;
    }

    public void sayHi() {
        hello.sayHello();
    }
}
