package advanced_java_programming;

public class ShirtItem extends ClothingItem {

    @Override
    int getPrice() {
        return 10;
    }

    @Override
    String getName() {
        return "Shirt";
    }

}
