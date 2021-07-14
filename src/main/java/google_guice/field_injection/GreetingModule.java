package google_guice.field_injection;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class GreetingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("first_name")).toInstance("Mohammad");
    }
}
