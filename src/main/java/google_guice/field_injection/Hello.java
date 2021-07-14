package google_guice.field_injection;

import com.google.inject.ImplementedBy;

@ImplementedBy(HelloImpl.class)
public interface Hello {
    public void sayHello();
}
