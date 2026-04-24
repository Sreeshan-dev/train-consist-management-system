import java.util.*;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App - UC9 ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 60, "Passenger"));
        bogies.add(new Bogie("First Class", 24, "Passenger"));
        bogies.add(new Bogie("Cargo", 0, "Goods"));
        bogies.add(new Bogie("Parcel", 0, "Goods"));

        // Group bogies by type
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // Display grouped result
        System.out.println("Grouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
        }
    }
}

class Bogie {
    String name;
    int capacity;
    String type; // Passenger / Goods

    Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}