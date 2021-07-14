package google_guice.first_application;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }
}
