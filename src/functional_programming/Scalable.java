package functional_programming;

public interface Scalable {

    void setScale(double scale);

    double DEFAULT_SCALE = 1.0;

    static boolean isScalable(Object obj) {
        return obj instanceof Scalable;
    }

    default void resetScale() {
        setScale(DEFAULT_SCALE);
    }

}
