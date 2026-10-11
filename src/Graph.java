import java.util.*;

// Graph component: undirected graph using an adjacency list
public class Graph {
    // Each vertex has a list of its neighbours
    private Map<Integer, List<Integer>> adj = new TreeMap<>();
    private int dfsSteps;

    public boolean hasVertex(int v) {
        return adj.containsKey(v);
    }

    public boolean addVertex(int v) {
        if (adj.containsKey(v)) {
            return false;
        }
        adj.put(v, new ArrayList<>());
        return true;
    }

    // Adds an edge in both directions. Both vertices must already exist.
    public boolean addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b) || a == b) {
            return false;
        }
        if (adj.get(a).contains(b)) {
            return false; // edge already exists
        }
        adj.get(a).add(b);
        adj.get(b).add(a);
        return true;
    }

    public boolean isEmpty() {
        return adj.isEmpty();
    }

    public int getVertexCount() {
        return adj.size();
    }

    public int getFirstVertex() {
        return adj.keySet().iterator().next();
    }

    public void display() {
        if (adj.isEmpty()) {
            System.out.println("Graph is empty!");
            return;
        }
        System.out.println("Graph (vertex -> neighbours):");
        for (int v : adj.keySet()) {
            System.out.println("  " + v + " -> " + adj.get(v));
        }
    }

    // BFS uses a queue. Steps = vertices visited + neighbours checked.
    public int bfs(int start, boolean print) {
        int steps = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();

        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            steps++;
            order.append(current).append(" ");
            for (int neighbour : adj.get(current)) {
                steps++;
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        if (print) {
            System.out.println("BFS order: " + order);
            System.out.println("Steps: " + steps);
        }
        return steps;
    }

    // DFS uses recursion (the call stack). Same step counting as BFS.
    public int dfs(int start, boolean print) {
        dfsSteps = 0;
        Set<Integer> visited = new HashSet<>();
        StringBuilder order = new StringBuilder();
        dfsHelper(start, visited, order);
        if (print) {
            System.out.println("DFS order: " + order);
            System.out.println("Steps: " + dfsSteps);
        }
        return dfsSteps;
    }

    private void dfsHelper(int current, Set<Integer> visited, StringBuilder order) {
        visited.add(current);
        dfsSteps++;
        order.append(current).append(" ");
        for (int neighbour : adj.get(current)) {
            dfsSteps++;
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, order);
            }
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------\n");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Search Vertex");
            System.out.println("7. Return to Main Menu");
            choice = InputHelper.readInt("\nEnter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    int v = InputHelper.readInt("Enter vertex number: ");
                    if (addVertex(v)) {
                        System.out.println("Vertex " + v + " added.");
                    } else {
                        System.out.println("Vertex " + v + " already exists!");
                    }
                    break;
                case 2:
                    int a = InputHelper.readInt("Enter first vertex: ");
                    int b = InputHelper.readInt("Enter second vertex: ");
                    if (!hasVertex(a) || !hasVertex(b)) {
                        System.out.println("Both vertices must exist. Add them first.");
                    } else if (a == b) {
                        System.out.println("A vertex cannot connect to itself.");
                    } else if (addEdge(a, b)) {
                        System.out.println("Edge " + a + " - " + b + " added.");
                    } else {
                        System.out.println("That edge already exists!");
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                case 5:
                    if (isEmpty()) {
                        System.out.println("Graph is empty! Add vertices first.");
                        break;
                    }
                    int start = InputHelper.readInt("Enter start vertex: ");
                    if (!hasVertex(start)) {
                        System.out.println("Vertex " + start + " does not exist!");
                    } else if (choice == 4) {
                        int steps = bfs(start, true);
                        Results.add("BFS from vertex " + start + ": steps = " + steps);
                    } else {
                        int steps = dfs(start, true);
                        Results.add("DFS from vertex " + start + ": steps = " + steps);
                    }
                    break;
                case 6:
                    int target = InputHelper.readInt("Enter vertex to search: ");
                    if (hasVertex(target)) {
                        System.out.println("Vertex " + target + " found. Neighbours: " + adj.get(target));
                    } else {
                        System.out.println("Vertex " + target + " not found.");
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1 to 7.");
            }
        } while (choice != 7);
    }
}
