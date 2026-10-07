/** Performance / complexity demonstration for searching and graph traversal. */
public final class PerformanceAnalyzer {

    private PerformanceAnalyzer() { }

    public static void run(Graph graph) {
        int n = InputHelper.readInt("Dataset size for the search test (10 - 1000000): ", 10, 1000000);

        // Sorted dataset of even numbers, so odd values are guaranteed to be missing.
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = i * 2;

        int[][] cases = {{data[0], 0}, {data[n / 2], 1}, {data[n - 1], 2}, {-1, 3}};
        String[] caseNames = {"Best (first element)", "Middle element", "Worst (last element)", "Not found"};

        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON  (n = " + n + ")");
        System.out.println("=============================================");
        System.out.printf("%-16s%-16s%-24s%10s%14s%n", "Operation", "Algorithm", "Case", "Steps", "Time (ns)");
        System.out.println("-------------------------------------------------------------------------------");

        for (int[] c : cases) {
            Searching.Result lin = Searching.linearSearch(data, c[0]);
            Searching.Result bin = Searching.binarySearch(data, c[0]);
            printRow("Search", lin.algorithm, caseNames[c[1]], lin.steps, lin.nanos);
            printRow("Search", bin.algorithm, caseNames[c[1]], bin.steps, bin.nanos);
        }

        if (graph.isEmpty()) {
            System.out.println("\n(Graph rows skipped: the graph is empty. Add vertices or use 'Load Sample Graph'.)");
        } else {
            String start = graph.firstVertex();
            String label = "start=" + start + " V=" + graph.vertexCount() + " E=" + graph.edgeCount();
            Graph.TraversalResult bfs = graph.bfs(start);
            Graph.TraversalResult dfs = graph.dfs(start);
            printRow("Graph Traversal", "BFS", label, bfs.steps, bfs.nanos);
            printRow("Graph Traversal", "DFS", label, dfs.steps, dfs.nanos);
        }
        System.out.println("=============================================");

        System.out.println("Why the results differ:");
        System.out.println(" - Linear search is O(n): in the worst case it checks all " + n + " elements.");
        System.out.println(" - Binary search is O(log n): it halves the range each step (about "
                + (int) Math.ceil(Math.log(n + 1) / Math.log(2)) + " steps at most), but needs sorted data.");
        System.out.println(" - BFS and DFS are both O(V + E): each vertex and edge is processed once,");
        System.out.println("   so their step counts are similar; they differ in visiting order (queue vs stack).");
        System.out.println("Note: times are single runs and vary between executions; step counts are exact.");
    }

    private static void printRow(String op, String algo, String caseName, long steps, long nanos) {
        System.out.printf("%-16s%-16s%-24s%10d%14d%n", op, algo, caseName, steps, nanos);
        ResultsLog.add(String.format("Performance | %s | %s | %s | steps=%d | time=%d ns",
                op, algo, caseName, steps, nanos));
    }
}
