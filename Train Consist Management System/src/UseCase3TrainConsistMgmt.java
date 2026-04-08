import java.util.HashSet;
import java.util.Set;

public class UseCase3TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App - UC3 ===");

        // Create HashSet for unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs
        System.out.println("Adding bogie IDs...");

        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");

        // Attempt to add duplicate
        boolean isAdded = bogieIds.add("B102");

        if (!isAdded) {
            System.out.println("Duplicate detected: B102 (ignored)");
        }

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs: " + bogieIds);
    }
}