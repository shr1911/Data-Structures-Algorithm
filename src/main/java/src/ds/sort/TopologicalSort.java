package src.ds.sort;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6; // number of vertices (0 to 5)
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example DAG:
        // 5 -> 2, 0
        // 4 -> 0, 1
        // 2 -> 3
        // 3 -> 1

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println(adj);

        dfsTopoSort(V, adj);
        kahnTopoSort(V, adj);
    }

    // Kahn's Algorithm (BFS-based)

    // Time Complexity: O(V + E)
    //Each node is processed once. Each edge is visited once when decreasing indegree.

    // Space Complexity: O(V)
    //Queue to store nodes with indegree 0 → O(V)
    //Indegree array → O(V)
    //Result list → O(V)
    public static void kahnTopoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        System.out.println("Topological Sort (Kahn's):");
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS-based Topological Sort
    // Time Complexity: O(V + E)
    //Each node is visited once. Each edge is explored once during DFS.
    //
    // Space Complexity: O(V)
    // Stack to store result → O(V)
    //Visited array → O(V)
    //Recursion call stack (in worst case, depth = V) → O(V)
    public static void dfsTopoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        System.out.println("Topological Sort (DFS):");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }
        stack.push(node);
    }



}
