import java.util.*;

public class UseCase12TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=== Train Safety Compliance Check - UC12 ===");

        // Create goods bogies list
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Box", "Coal"));
        bogies.add(new GoodsBogie("Box", "Food"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Safety Rule:
        // Cylindrical bogies → ONLY Petroleum allowed

        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        (b.type.equals("Cylindrical") && b.cargo.equals("Petroleum"))
                                ||
                                (!b.type.equals("Cylindrical"))
                );

        // Display result
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }
    }
}

class GoodsBogie {
    String type;   // Cylindrical / Box
    String cargo;  // Petroleum / Coal / Food

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " - " + cargo;
    }
}