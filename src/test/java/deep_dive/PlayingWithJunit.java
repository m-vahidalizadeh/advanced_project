package deep_dive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayingWithJunit {

    @Test
    public void testName() {
        assertThat(Calculator.add(2, 2), is(4));
    }

}
