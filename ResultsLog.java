import java.util.ArrayList;
import java.util.List;

/** Stores results (searches, traversals, performance runs) for "Display All Results". */
public final class ResultsLog {
    private static final List<String> ENTRIES = new ArrayList<>();

    private ResultsLog() { }

    public static void add(String entry) {
        ENTRIES.add(entry);
    }

    public static void displayAll() {
        System.out.println("\n=============================================");
        System.out.println(" ALL RECORDED RESULTS");
        System.out.println("=============================================");
        if (ENTRIES.isEmpty()) {
            System.out.println("No results recorded yet. Run searches, traversals or the performance comparison first.");
        } else {
            for (int i = 0; i < ENTRIES.size(); i++) {
                System.out.println((i + 1) + ". " + ENTRIES.get(i));
            }
        }
        System.out.println("=============================================");
    }
}
