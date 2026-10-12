/** Stack component (LIFO) backed by a fixed-size array. */
public class ArrayStack {
    private final int[] data;
    private int top = -1;

    public ArrayStack(int capacity) {
        data = new int[capacity];
    }

    public boolean isEmpty() { return top == -1; }

    public boolean isFull() { return top == data.length - 1; }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack overflow: the stack is full (capacity " + data.length + ").");
        }
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: cannot pop from an empty stack.");
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty: nothing to peek.");
        }
        return data[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Stack is empty.");
            return;
        }
        System.out.println("  TOP");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + data[i] + " |");
        }
        System.out.println("  BOTTOM   (size = " + (top + 1) + ")");
    }
}
