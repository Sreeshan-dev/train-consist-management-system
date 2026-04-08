import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App - UC5 ===");

        // Create LinkedHashSet for train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Duplicate bogie ignored: Sleeper");
        }

        // Display final formation
        System.out.println("Final Train Formation: " + trainFormation);
    }
}