package deep_dive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * To make these tests pass, you will need to create a Minion class with the member variables below.
 *
 * <code>
 * private String name;
 * private int eyes;
 * private String color;
 * private String master;
 * </code>
 * <p>
 * Create a constructor, and getters and setters for the member variables. If they’re done right, these tests will pass.
 **/

public class MinionTest {

    @Test
    public void testConstructor() {
        Minion stuart = new Minion("Stuart", 1, "yellow", "");
        assertThat(stuart.getName(), is("Stuart"));
        assertThat(stuart.getEyes(), is(1));
        assertThat(stuart.getColor(), is("yellow"));

        Minion dave = new Minion("Dave", 2, "yellow", "");
        assertThat(dave.getName(), is("Dave"));
        assertThat(dave.getEyes(), is(2));
        assertThat(dave.getColor(), is("yellow"));
    }

    @Test
    public void testSetters() {
        Minion stuart = new Minion("Stuart", 1, "yellow", "");

        stuart.setMaster("T. Rex");
        assertThat(stuart.getMaster(), is("T. Rex"));

        stuart.setMaster("Napoleon");
        assertThat(stuart.getMaster(), is("Napoleon"));
    }

}
