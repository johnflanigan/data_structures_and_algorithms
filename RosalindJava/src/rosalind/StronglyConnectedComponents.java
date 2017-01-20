package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by johnflanigan on 11/29/16.
 */
public class StronglyConnectedComponents {

    Stack<Integer> stack;
    boolean[] visited;
    Graph graph;

    public void stronglyConnectedComponents() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_scc.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int V, E;
        V = s.nextInt();
        E = s.nextInt();

        graph = new Graph(V, E);

        int src, dest;
        for (int i = 0; i < E; i++) {
            src = s.nextInt() - 1;
            dest = s.nextInt() - 1;
            graph.addEdge(src, dest);
        }

        visited = new boolean[V];
        stack = new Stack<Integer>();

        int current = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(graph, i);
            }
        }

        Graph reversedGraph = graph.reverseGraph();
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int count = 0;
        for (int i = 0; i < stack.size(); i++) {
            while (!stack.isEmpty()) {
                current = stack.pop();
                if (!visited[current]) {
                    count++;
                    DFSUtil(reversedGraph, current);
                }
            }
        }
        System.out.print(count);

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

    public void DFSUtil(Graph graph, int u) {
        if (!visited[u]) {
            visited[u] = true;
            int v;
            for (int i = 0; i < graph.adj[u].size(); i++) {
                v = graph.adj[u].get(i).dest;
                DFSUtil(graph, v);
            }
        }
    }
}
