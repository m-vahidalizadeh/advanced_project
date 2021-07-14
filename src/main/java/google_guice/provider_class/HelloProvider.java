package google_guice.provider_class;

import com.google.inject.Provider;

public class HelloProvider implements Provider<Hello> {

    @Override
    public Hello get() {
        Hello hello = new HelloImpl("Mohammad");
        return hello;
    }

}
