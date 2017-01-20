package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by johnflanigan on 11/29/16.
 */
public class ShortestPathsInDAG {

    Stack<Integer> stack;
    boolean[] visited;
    Graph graph;

    public void shortestPathsInDAG() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_sdag.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int V, E;
        V = s.nextInt();
        E = s.nextInt();

        graph = new Graph(V, E);

        int src, dest, weight;
        for (int i = 0; i < E; i++) {
            src = s.nextInt() - 1;
            dest = s.nextInt() - 1;
            weight = s.nextInt();
            graph.addEdge(src, dest, weight);
        }

        visited = new boolean[V];
        stack = new Stack<Integer>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(graph, i);
            }
        }

        int[] distance = new int[V];
        int current, adjacent;

        Graph reversedGraph = graph.reverseGraph();

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[0] = 0;
        while (!stack.isEmpty()) {
            current = stack.pop();

            if (distance[current] != Integer.MAX_VALUE) {
                for (int i = 0; i < graph.adj[current].size(); i++) {
                    adjacent = graph.adj[current].get(i).dest;
                    weight = graph.adj[current].get(i).weight;
                    if (distance[adjacent] > distance[current] + weight) {
                        distance[adjacent] = distance[current] + weight;
                    }
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.print("x ");
            } else {
                System.out.print(distance[i] + " ");
            }
        }
    }

    public void DFS(Graph graph, int u) {
        visited[u] = true;
        int v;
        for (int i = 0; i < graph.adj[u].size(); i++) {
            v = graph.adj[u].get(i).dest;
            if (!visited[v]) {
                DFS(graph, v);
            }
        }
        stack.push(u);
    }
}