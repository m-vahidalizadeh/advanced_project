package java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MenuTest {

    public static final String EXPECTED_MENU_FORMATTED_ITEM = "Grilled chicken costs $3.46";

    @Test
    public void testGetFormattedItem() {
        Menu menu = new Menu("Grilled chicken", new BigDecimal(3.45));
        Assertions.assertEquals(EXPECTED_MENU_FORMATTED_ITEM, menu.getFormattedItem());
    }

}
