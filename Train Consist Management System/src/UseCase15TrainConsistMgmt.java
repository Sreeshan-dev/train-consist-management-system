import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmt {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo()); // should not be assigned
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // unsafe
        bogie2.assignCargo("Grain");     // safe

        assertNull(bogie1.getCargo());
        assertEquals("Grain", bogie2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // We can't directly assert finally block execution,
        // but we ensure method completes without crash
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}