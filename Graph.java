import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Graph component: undirected, unweighted graph stored as an adjacency list. */
public class Graph {

    /** Result of a BFS or DFS traversal. */
    public static final class TraversalResult {
        public final String algorithm;
        public final List<String> order;
        public final long steps;
        public final long nanos;

        TraversalResult(String algorithm, List<String> order, long steps, long nanos) {
            this.algorithm = algorithm;
            this.order = order;
            this.steps = steps;
            this.nanos = nanos;
        }

        public String describe(String start) {
            return algorithm + " from " + start + ": " + String.join(" -> ", order)
                    + " (steps: " + steps + ", time: " + nanos + " ns)";
        }
    }

    private final Map<String, List<String>> adj = new LinkedHashMap<>();

    public boolean isEmpty() { return adj.isEmpty(); }

    public boolean hasVertex(String v) { return adj.containsKey(v); }

    public int vertexCount() { return adj.size(); }

    public int edgeCount() {
        int total = 0;
        for (List<String> n : adj.values()) total += n.size();
        return total / 2;
    }

    public String firstVertex() { return adj.keySet().iterator().next(); }

    public void addVertex(String v) {
        if (adj.containsKey(v)) {
            throw new IllegalArgumentException("Vertex '" + v + "' already exists.");
        }
        adj.put(v, new ArrayList<>());
    }

    public void addEdge(String a, String b) {
        if (!adj.containsKey(a) || !adj.containsKey(b)) {
            throw new IllegalArgumentException("Both vertices must exist before adding an edge.");
        }
        if (a.equals(b)) {
            throw new IllegalArgumentException("Self-loops are not allowed.");
        }
        if (adj.get(a).contains(b)) {
            throw new IllegalArgumentException("Edge " + a + " - " + b + " already exists.");
        }
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public void display() {
        if (adj.isEmpty()) {
            System.out.println("  Graph is empty.");
            return;
        }
        System.out.println("  Adjacency list:");
        for (Map.Entry<String, List<String>> e : adj.entrySet()) {
            System.out.println("    " + e.getKey() + " -> " + e.getValue());
        }
        System.out.println("  Vertices: " + vertexCount() + ", Edges: " + edgeCount());
    }

    /** Breadth-first search using a queue. O(V + E). Steps = vertices visited + edges examined. */
    public TraversalResult bfs(String start) {
        requireVertex(start);
        long t0 = System.nanoTime();
        long steps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            steps++;
            order.add(cur);
            for (String next : adj.get(cur)) {
                steps++;
                if (visited.add(next)) {
                    queue.add(next);
                }
            }
        }
        return new TraversalResult("BFS", order, steps, System.nanoTime() - t0);
    }

    /** Depth-first search using a stack. O(V + E). Steps = vertices visited + edges examined. */
    public TraversalResult dfs(String start) {
        requireVertex(start);
        long t0 = System.nanoTime();
        long steps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (!visited.add(cur)) continue;
            steps++;
            order.add(cur);
            List<String> neighbours = adj.get(cur);
            // Push in reverse so neighbours are visited in insertion order.
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                steps++;
                if (!visited.contains(neighbours.get(i))) {
                    stack.push(neighbours.get(i));
                }
            }
        }
        return new TraversalResult("DFS", order, steps, System.nanoTime() - t0);
    }

    /** Replaces the graph with a small sample for quick demonstrations. */
    public void loadSample() {
        adj.clear();
        for (String v : new String[] {"A", "B", "C", "D", "E", "F"}) addVertex(v);
        String[][] edges = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"C", "D"}, {"C", "E"}, {"D", "F"}, {"E", "F"}};
        for (String[] e : edges) addEdge(e[0], e[1]);
    }

    private void requireVertex(String v) {
        if (!adj.containsKey(v)) {
            throw new IllegalArgumentException("Vertex '" + v + "' does not exist.");
        }
    }
}
