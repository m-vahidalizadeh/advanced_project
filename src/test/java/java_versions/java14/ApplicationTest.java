package java_versions.java14;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApplicationTest {

    @Test
    public void testGetNullObject() {
        assertThat(Application.getNullObject(), nullValue());
    }

}
