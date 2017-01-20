package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by johnflanigan on 11/30/16.
 */
public class HamiltonianPathInDAG {

    Stack<Integer> stack;
    boolean[] visited;
    Graph graph;

    public void hamiltonianPathInDAG() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_hdag.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGraphs = s.nextInt();
        for (int k = 0; k < numberOfGraphs; k++) {
            int V, E;
            V = s.nextInt();
            E = s.nextInt();

            graph = new Graph(V, E);

            int src, dest, weight;
            for (int i = 0; i < E; i++) {
                src = s.nextInt() - 1;
                dest = s.nextInt() - 1;
                graph.addEdge(src, dest);
            }

            visited = new boolean[V];
            stack = new Stack<Integer>();

            Graph reversedGraph = graph.reverseGraph();

            // Find source node
            int source = 0;
            for (int i = 0; i < reversedGraph.adj.length; i++) {
                if (reversedGraph.adj[i].isEmpty()) {
                    source = i;
                    break;
                }
            }
            // Begin recursive DFS at source node
            DFS(graph, source);

            int current, next;
            boolean connected = false;
            for (int i = 0; i < stack.size() - 1; i++) {
                current = stack.get(i);
                next = stack.get(i + 1);

                connected = false;
                for (int j = 0; j < reversedGraph.adj[current].size(); j++) {
                    if (reversedGraph.adj[current].get(j).dest == next) {
                        connected = true;
                    }
                }
                if (!connected) {
                    break;
                }
            }

            // If the stack contains all vertices, the graph contains a Hamiltonian path
            if (connected) {
                System.out.print("1 ");
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + 1 + " ");
                }
                System.out.print("\n");
            } else {
                System.out.print("-1\n");
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
