package secure_coding;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import secure_coding.data.President;
import secure_coding.data.PresidentDAO;
import secure_coding.util.DatabaseUtil;

import static org.junit.Assert.*;

public class PresidentDAOTest {

    @BeforeClass
    public static void setUp() throws Exception {
        DatabaseUtil.loadFile("sql/schema.sql");
        DatabaseUtil.loadFile("sql/data.sql");
    }

    @Test
    public void getByLastName() {
        PresidentDAO dao = new PresidentDAO();
        List<President> results = dao.getByLastName("Washington");
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("George", results.get(0).getFirstName());
    }

    @Test
    public void getByLastName_Injections(){
        PresidentDAO dao = new PresidentDAO();
        List<President> results = dao.getByLastName("Trump' or '1' = '1");
        assertNotNull(results);
        assertEquals(0, results.size());
    }
}