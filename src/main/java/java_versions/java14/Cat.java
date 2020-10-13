package java_versions.java14;

public class Cat extends Pet {

    private boolean ignoringYou;

    public Cat(String name, boolean ignoringYou) {
        super(name);
        this.ignoringYou = ignoringYou;
    }

    public boolean isIgnoringYou() {
        return ignoringYou;
    }

    public void setIgnoringYou(boolean ignoringYou) {
        this.ignoringYou = ignoringYou;
    }
}
