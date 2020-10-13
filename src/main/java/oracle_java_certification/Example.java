package oracle_java_certification;

public class Example {

    protected String message2;
    private String message3;

    public Example(String message2) {
        this.message2 = message2;
        this.message3 = message2;
    }

    public String toString() {
        return message3;
    }

}
