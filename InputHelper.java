import java.util.Scanner;

/** Centralised, validated console input. Re-prompts until the user enters valid data. */
public final class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    private InputHelper() { }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!SC.hasNextLine()) {
            System.out.println();
            System.out.println("Input closed. Exiting.");
            System.exit(0);
        }
        return SC.nextLine().trim();
    }

    /** Reads any whole number. */
    public static int readInt(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads a whole number within [min, max]. */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("  Out of range. Enter a number from " + min + " to " + max + ".");
        }
    }

    /** Reads a non-empty single word (used for graph vertex names). */
    public static String readWord(String prompt) {
        while (true) {
            String s = readLine(prompt);
            if (!s.isEmpty() && !s.contains(" ")) {
                return s;
            }
            System.out.println("  Invalid input. Enter a single word with no spaces.");
        }
    }
}
