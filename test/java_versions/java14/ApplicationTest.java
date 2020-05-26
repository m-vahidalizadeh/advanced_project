package java_versions.java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java_versions.java14.Application;

public class ApplicationTest {

    @Test
    public void testGetNullObject() {
        Assertions.assertNull(Application.getNullObject());
    }

}
