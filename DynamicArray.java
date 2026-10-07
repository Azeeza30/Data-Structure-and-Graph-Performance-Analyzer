import java.util.Arrays;
import java.util.Random;

/** Array component: a resizable int array with insert, delete, search and display. */
public class DynamicArray {
    private int[] data = new int[10];
    private int size = 0;

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    /** Appends a value at the end. O(1) amortised. */
    public void insert(int value) {
        insertAt(size, value);
    }

    /** Inserts at an index, shifting later elements right. O(n). */
    public void insertAt(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Position must be between 0 and " + size + ".");
        }
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    /** Deletes the element at an index, shifting later elements left. O(n). */
    public int deleteAt(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty. Nothing to delete.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Position must be between 0 and " + (size - 1) + ".");
        }
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    /** Linear search. Returns the first index of value, or -1. O(n). */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /** Returns a copy of the current contents. */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void clear() {
        size = 0;
    }

    /** Replaces contents with n random numbers in [0, bound). */
    public void fillRandom(int n, int bound) {
        Random rnd = new Random();
        data = new int[Math.max(10, n)];
        size = 0;
        for (int i = 0; i < n; i++) {
            data[size++] = rnd.nextInt(bound);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  [");
        int shown = Math.min(size, 50);
        for (int i = 0; i < shown; i++) {
            sb.append(data[i]);
            if (i < shown - 1) sb.append(", ");
        }
        if (size > shown) sb.append(", ... (").append(size - shown).append(" more)");
        sb.append("]  size = ").append(size);
        System.out.println(sb);
    }
}
