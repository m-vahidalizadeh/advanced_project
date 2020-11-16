package java_versions.java14;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MenuTest {

    public static final String EXPECTED_MENU_FORMATTED_ITEM = "Grilled chicken costs $3.46";

    @Test
    public void testGetFormattedItem() {
        Menu menu = new Menu("Grilled chicken", new BigDecimal(3.45));
        assertThat(menu.getFormattedItem(), is(EXPECTED_MENU_FORMATTED_ITEM));
    }

}
