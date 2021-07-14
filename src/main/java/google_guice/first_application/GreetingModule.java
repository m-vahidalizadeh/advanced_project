package google_guice.first_application;

import com.google.inject.AbstractModule;

public class GreetingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Hello.class).to(HelloImpl.class);
    }
}
