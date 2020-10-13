package deep_dive;

public class Disease {
    private String name;
    private boolean curable;

    public Disease(String title, boolean isCurable) {
        this.name = title;
        this.curable = isCurable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurable() {
        return curable;
    }

    public void setCurable(boolean curable) {
        this.curable = curable;
    }
}
