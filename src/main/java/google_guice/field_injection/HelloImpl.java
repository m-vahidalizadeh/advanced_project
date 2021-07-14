package google_guice.field_injection;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class HelloImpl implements Hello {
    @Inject
    @Named("first_name")
    private String firstName;

    @Override
    public void sayHello() {
        System.out.println(String.format("Hi %s!", firstName));
    }
}
