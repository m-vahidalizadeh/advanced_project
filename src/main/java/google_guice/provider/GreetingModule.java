package google_guice.provider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class GreetingModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    public Hello provideHello() {
        Hello hello = new HelloImpl("Mohammad");
        return hello;
    }
}
