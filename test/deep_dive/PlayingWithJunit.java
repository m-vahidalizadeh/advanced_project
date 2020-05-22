package deep_dive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayingWithJunit {

    @Test
    public void testName() {
        assertEquals(4, Calculator.add(2, 2));
    }

}
