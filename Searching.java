/** Searching component: linear and binary search that count steps and time. */
public final class Searching {

    /** Result of one search run. */
    public static final class Result {
        public final String algorithm;
        public final int index;
        public final long steps;
        public final long nanos;

        Result(String algorithm, int index, long steps, long nanos) {
            this.algorithm = algorithm;
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }

        public String describe(int target) {
            String outcome = index >= 0 ? "found at index " + index : "not found";
            return algorithm + ": " + target + " " + outcome + " (steps: " + steps + ", time: " + nanos + " ns)";
        }
    }

    private Searching() { }

    /** Checks each element in turn. Worst case O(n). */
    public static Result linearSearch(int[] a, int target) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == target) {
                found = i;
                break;
            }
        }
        return new Result("Linear Search", found, steps, System.nanoTime() - start);
    }

    /** Halves the search range each step. Requires sorted input. Worst case O(log n). */
    public static Result binarySearch(int[] sorted, int target) {
        long start = System.nanoTime();
        long steps = 0;
        int low = 0, high = sorted.length - 1, found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sorted[mid] == target) {
                found = mid;
                break;
            } else if (sorted[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new Result("Binary Search", found, steps, System.nanoTime() - start);
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }
}
