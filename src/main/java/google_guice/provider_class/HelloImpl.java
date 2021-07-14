package google_guice.provider_class;

import com.google.inject.Inject;

public class HelloImpl implements Hello {

    private String name;

    @Inject
    public HelloImpl(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println(String.format("Hello %s!", name));
    }
}
