import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmt {

    // Sample Bogie class (for testing purpose)
    static class Bogie {
        private int capacity;

        public Bogie(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Helper method to create dataset
    private List<Bogie> createBogieList(int size) {
        List<Bogie> bogies = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            bogies.add(new Bogie(random.nextInt(100))); // capacity 0–99
        }
        return bogies;
    }

    // Loop-based filtering
    private List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    private List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(50),
                new Bogie(70),
                new Bogie(80),
                new Bogie(40)
        );

        List<Bogie> result = filterUsingLoop(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie(50),
                new Bogie(70),
                new Bogie(80),
                new Bogie(40)
        );

        List<Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createBogieList(1000);

        List<Bogie> loopResult = filterUsingLoop(bogies);
        List<Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createBogieList(1000);

        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
        System.out.println("Loop Execution Time: " + elapsed + " ns");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = createBogieList(100000);

        List<Bogie> result = filterUsingStream(bogies);

        assertNotNull(result);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }
}