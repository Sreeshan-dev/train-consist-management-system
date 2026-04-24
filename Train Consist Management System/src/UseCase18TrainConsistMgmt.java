import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmt {

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        assertTrue(BogieSearch.searchBogieId(bogies, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        assertFalse(BogieSearch.searchBogieId(bogies, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        assertTrue(BogieSearch.searchBogieId(bogies, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        assertTrue(BogieSearch.searchBogieId(bogies, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};

        assertTrue(BogieSearch.searchBogieId(bogies, "BG101"));
    }
}