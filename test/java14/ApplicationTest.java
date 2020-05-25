package java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Test
    public void testGetNullObject() {
        Assertions.assertNull(Application.getNullObject());
    }

}
