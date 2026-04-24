import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmt {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            BogieSearchWithValidation.searchBogieId(bogies, "BG101");
        });

        assertEquals("No bogies available in train consist for search operation", ex.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};

        assertDoesNotThrow(() -> {
            BogieSearchWithValidation.searchBogieId(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        assertTrue(BogieSearchWithValidation.searchBogieId(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        assertFalse(BogieSearchWithValidation.searchBogieId(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};

        assertTrue(BogieSearchWithValidation.searchBogieId(bogies, "BG101"));
    }
}