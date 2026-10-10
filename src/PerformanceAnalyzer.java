// Performance comparison: Linear vs Binary search, BFS vs DFS
public class PerformanceAnalyzer {

    public void run() {
        // ----- Search test: sorted array 0..9999, search for a value that is NOT there (worst case) -----
        int n = 10000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int key = -5;

        SearchOperations searcher = new SearchOperations();

        long start = System.nanoTime();
        searcher.linearSearch(arr, n, key);
        long linearTime = System.nanoTime() - start;
        int linearSteps = searcher.getSteps();

        start = System.nanoTime();
        searcher.binarySearch(arr, n, key);
        long binaryTime = System.nanoTime() - start;
        int binarySteps = searcher.getSteps();

        // ----- Graph test: 500 vertices, each connected to the next one and the one after that -----
        Graph graph = new Graph();
        int vertices = 500;
        for (int i = 0; i < vertices; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < vertices - 1; i++) {
            graph.addEdge(i, i + 1);
            if (i + 2 < vertices) {
                graph.addEdge(i, i + 2);
            }
        }

        start = System.nanoTime();
        int bfsSteps = graph.bfs(0, false);
        long bfsTime = System.nanoTime() - start;

        start = System.nanoTime();
        int dfsSteps = graph.dfs(0, false);
        long dfsTime = System.nanoTime() - start;

        // ----- Print the table -----
        System.out.println("\n=============================================");
        System.out.println("           PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.println("Search test: " + n + " sorted numbers, searching for a missing value");
        System.out.println("Graph test : " + vertices + " vertices, traversal from vertex 0");
        System.out.println();
        System.out.printf("%-17s %-15s %-8s %-12s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-17s %-15s %-8d %-12d%n", "Search", "Linear Search", linearSteps, linearTime);
        System.out.printf("%-17s %-15s %-8d %-12d%n", "Search", "Binary Search", binarySteps, binaryTime);
        System.out.printf("%-17s %-15s %-8d %-12d%n", "Graph Traversal", "BFS", bfsSteps, bfsTime);
        System.out.printf("%-17s %-15s %-8d %-12d%n", "Graph Traversal", "DFS", dfsSteps, dfsTime);
        System.out.println("=============================================");
        System.out.println("Why are the results different?");
        System.out.println("- Linear search is O(n): it may check every item.");
        System.out.println("- Binary search is O(log n): it halves the data each step.");
        System.out.println("- BFS and DFS are both O(V + E): they visit every vertex and edge once,");
        System.out.println("  so their step counts are almost the same.");
        System.out.println("(Time in ns can change on every run, steps stay the same.)");

        Results.add("Performance (n=" + n + "): Linear steps = " + linearSteps + ", Binary steps = " + binarySteps);
        Results.add("Performance (" + vertices + " vertices): BFS steps = " + bfsSteps + ", DFS steps = " + dfsSteps);
    }
}
