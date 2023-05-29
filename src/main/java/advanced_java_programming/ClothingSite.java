package advanced_java_programming;

import java.util.ArrayList;
import java.util.List;

public class ClothingSite {

    public static void main(String[] args) {
        ShirtItem shirtItem = new ShirtItem();
        ShirtItem shirtItem2 = new ShirtItem();
        List<ShirtItem> clothingItems = new ArrayList<>();
        clothingItems.add(shirtItem);
        clothingItems.add(shirtItem2);
        checkoutAllItems(clothingItems);
    }

    static void checkoutItem(ClothingItem item) {
        System.out.println("Item purchased: " + item.getName() + ", price: " + item.getPrice());
    }

    static void checkoutAllItems(List<? extends ClothingItem> clothingItems) {
        for (ClothingItem clothingItem : clothingItems) checkoutItem(clothingItem);
    }

}
