package google_guice.provider_class;

import com.google.inject.AbstractModule;

public class GreetingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Hello.class).toProvider(HelloProvider.class);
    }
}
