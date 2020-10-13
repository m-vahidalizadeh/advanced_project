package deep_dive;

public class Duck {

    // member variables: data, encapsulation
    private String name;
    private int lifeExpectancy;
    private String favoriteFood;

    public Duck(String name, int lifeExpectancy, String favoriteFood) {
        this.name = name;
        this.lifeExpectancy = lifeExpectancy;
        this.favoriteFood = favoriteFood;
    }

    // methods: functionality
    void waddle() {
        lifeExpectancy++;
        System.out.println(this.name + " is waddling.");
    }

    void quack() {
        System.out.println("quack quack");
    }

    @Override
    public String toString() {
        return "Name: " + name + " Favorite food: " + favoriteFood + " life expectancy " + lifeExpectancy;
    }

}
