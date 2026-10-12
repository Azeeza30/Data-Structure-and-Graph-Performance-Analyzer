/** Queue component (FIFO) backed by a circular array. */
public class CircularQueue {
    private final int[] data;
    private int front = 0;
    private int size = 0;

    public CircularQueue(int capacity) {
        data = new int[capacity];
    }

    public boolean isEmpty() { return size == 0; }

    public boolean isFull() { return size == data.length; }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue overflow: the queue is full (capacity " + data.length + ").");
        }
        data[(front + size) % data.length] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow: cannot dequeue from an empty queue.");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty: nothing at the front.");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  FRONT -> ");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append(" | ");
        }
        sb.append(" <- REAR   (size = ").append(size).append(")");
        System.out.println(sb);
    }
}
