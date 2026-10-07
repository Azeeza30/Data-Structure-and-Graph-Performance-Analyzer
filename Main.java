import java.util.Arrays;

/** Main console application: integrates all components through menus. */
public class Main {
    private static final DynamicArray array = new DynamicArray();
    private static final ArrayStack stack = new ArrayStack(10);
    private static final CircularQueue queue = new CircularQueue(10);
    private static final SinglyLinkedList list = new SinglyLinkedList();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            switch (InputHelper.readInt("Enter your choice: ", 1, 9)) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: listMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: PerformanceAnalyzer.run(graph); break;
                case 8: ResultsLog.displayAll(); break;
                default: running = false;
            }
        }
        System.out.println("Goodbye!");
    }

    private static void error(Exception e) {
        System.out.println("  ! " + e.getMessage());
    }

    // ---------------------------------------------------------------- Array
    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (at end)");
            System.out.println("2. Insert at position");
            System.out.println("3. Delete by position");
            System.out.println("4. Delete by value");
            System.out.println("5. Search for a value");
            System.out.println("6. Display");
            System.out.println("7. Fill with random numbers");
            System.out.println("8. Clear");
            System.out.println("9. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 9);
            try {
                switch (c) {
                    case 1:
                        array.insert(InputHelper.readInt("Value: "));
                        System.out.println("  Inserted.");
                        break;
                    case 2: {
                        int pos = InputHelper.readInt("Position (0-" + array.size() + "): ", 0, array.size());
                        array.insertAt(pos, InputHelper.readInt("Value: "));
                        System.out.println("  Inserted.");
                        break;
                    }
                    case 3: {
                        if (array.isEmpty()) { System.out.println("  ! Array is empty. Nothing to delete."); break; }
                        int pos = InputHelper.readInt("Position (0-" + (array.size() - 1) + "): ", 0, array.size() - 1);
                        System.out.println("  Deleted " + array.deleteAt(pos) + ".");
                        break;
                    }
                    case 4: {
                        if (array.isEmpty()) { System.out.println("  ! Array is empty. Nothing to delete."); break; }
                        int idx = array.search(InputHelper.readInt("Value to delete: "));
                        if (idx < 0) System.out.println("  Value not found.");
                        else System.out.println("  Deleted " + array.deleteAt(idx) + " from position " + idx + ".");
                        break;
                    }
                    case 5: {
                        if (array.isEmpty()) { System.out.println("  ! Array is empty."); break; }
                        int v = InputHelper.readInt("Value to search for: ");
                        int idx = array.search(v);
                        System.out.println(idx < 0 ? "  Value not found." : "  Found at position " + idx + ".");
                        break;
                    }
                    case 6: array.display(); break;
                    case 7: {
                        int n = InputHelper.readInt("How many numbers (1-100000)? ", 1, 100000);
                        array.fillRandom(n, 1000);
                        System.out.println("  Array filled with " + n + " random numbers (0-999).");
                        break;
                    }
                    case 8: array.clear(); System.out.println("  Array cleared."); break;
                    default: return;
                }
            } catch (RuntimeException e) {
                error(e);
            }
        }
    }

    // ---------------------------------------------------------------- Stack
    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 5);
            try {
                switch (c) {
                    case 1:
                        stack.push(InputHelper.readInt("Value to push: "));
                        System.out.println("  Pushed.");
                        break;
                    case 2: System.out.println("  Popped " + stack.pop() + "."); break;
                    case 3: System.out.println("  Top element: " + stack.peek()); break;
                    case 4: stack.display(); break;
                    default: return;
                }
            } catch (RuntimeException e) {
                error(e);
            }
        }
    }

    // ---------------------------------------------------------------- Queue
    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 5);
            try {
                switch (c) {
                    case 1:
                        queue.enqueue(InputHelper.readInt("Value to enqueue: "));
                        System.out.println("  Enqueued.");
                        break;
                    case 2: System.out.println("  Dequeued " + queue.dequeue() + "."); break;
                    case 3: System.out.println("  Front element: " + queue.peek()); break;
                    case 4: queue.display(); break;
                    default: return;
                }
            } catch (RuntimeException e) {
                error(e);
            }
        }
    }

    // ---------------------------------------------------------- Linked List
    private static void listMenu() {
        while (true) {
            System.out.println("\n------------- LINKED LIST OPERATIONS -------------");
            System.out.println("1. Insert at head");
            System.out.println("2. Insert at tail");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete by value");
            System.out.println("5. Search for a value");
            System.out.println("6. Display");
            System.out.println("7. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 7);
            try {
                switch (c) {
                    case 1: list.insertAtHead(InputHelper.readInt("Value: ")); System.out.println("  Inserted."); break;
                    case 2: list.insertAtTail(InputHelper.readInt("Value: ")); System.out.println("  Inserted."); break;
                    case 3: {
                        int pos = InputHelper.readInt("Position (0-" + list.size() + "): ", 0, list.size());
                        list.insertAt(pos, InputHelper.readInt("Value: "));
                        System.out.println("  Inserted.");
                        break;
                    }
                    case 4: {
                        if (list.isEmpty()) { System.out.println("  ! List is empty. Nothing to delete."); break; }
                        boolean ok = list.delete(InputHelper.readInt("Value to delete: "));
                        System.out.println(ok ? "  Deleted." : "  Value not found.");
                        break;
                    }
                    case 5: {
                        if (list.isEmpty()) { System.out.println("  ! List is empty."); break; }
                        int idx = list.search(InputHelper.readInt("Value to search for: "));
                        System.out.println(idx < 0 ? "  Value not found." : "  Found at position " + idx + ".");
                        break;
                    }
                    case 6: list.display(); break;
                    default: return;
                }
            } catch (RuntimeException e) {
                error(e);
            }
        }
    }

    // ------------------------------------------------------------ Searching
    private static void searchMenu() {
        while (true) {
            System.out.println("\n------------- SEARCHING OPERATIONS -------------");
            System.out.println("(Searches use the data in the Array component.)");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 4);
            if (c == 4) return;
            if (array.isEmpty()) {
                System.out.println("  ! Array is empty. Use Array Operations (insert or fill random) first.");
                continue;
            }
            int target = InputHelper.readInt("Value to search for: ");
            int[] data = array.toArray();
            int[] sorted = data.clone();
            Arrays.sort(sorted);
            if (c != 1 && !Searching.isSorted(data)) {
                System.out.println("  Note: binary search needs sorted data, so a sorted copy is used (indexes refer to it).");
            }
            if (c == 1 || c == 3) {
                Searching.Result r = Searching.linearSearch(data, target);
                System.out.println("  " + r.describe(target));
                ResultsLog.add("Search | " + r.describe(target));
            }
            if (c == 2 || c == 3) {
                Searching.Result r = Searching.binarySearch(sorted, target);
                System.out.println("  " + r.describe(target));
                ResultsLog.add("Search | " + r.describe(target));
            }
        }
    }

    // ---------------------------------------------------------------- Graph
    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 7);
            try {
                switch (c) {
                    case 1:
                        graph.addVertex(InputHelper.readWord("Vertex name: "));
                        System.out.println("  Vertex added.");
                        break;
                    case 2: {
                        String a = InputHelper.readWord("First vertex: ");
                        String b = InputHelper.readWord("Second vertex: ");
                        graph.addEdge(a, b);
                        System.out.println("  Edge added.");
                        break;
                    }
                    case 3: graph.display(); break;
                    case 4:
                    case 5: {
                        if (graph.isEmpty()) {
                            System.out.println("  ! Graph is empty. Add vertices or load the sample graph first.");
                            break;
                        }
                        String start = InputHelper.readWord("Start vertex: ");
                        Graph.TraversalResult r = (c == 4) ? graph.bfs(start) : graph.dfs(start);
                        System.out.println("  " + r.describe(start));
                        ResultsLog.add("Traversal | " + r.describe(start));
                        break;
                    }
                    case 6:
                        graph.loadSample();
                        System.out.println("  Sample graph loaded (vertices A-F, 7 edges).");
                        break;
                    default: return;
                }
            } catch (RuntimeException e) {
                error(e);
            }
        }
    }
}
