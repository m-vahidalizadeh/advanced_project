package java14;

public class Dog extends Pet {

    private boolean followingYou;

    public Dog(String name, boolean followingYou) {
        super(name);
        this.followingYou = followingYou;
    }

    public boolean isFollowingYou() {
        return followingYou;
    }

    public void setFollowingYou(boolean followingYou) {
        this.followingYou = followingYou;
    }
}
